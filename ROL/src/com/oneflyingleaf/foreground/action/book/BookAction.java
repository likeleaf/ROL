package com.oneflyingleaf.foreground.action.book;

import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.oneflyingleaf.core.action.BasicAction;
import com.oneflyingleaf.core.constant.PermissionCon;
import com.oneflyingleaf.core.constant.SessionEnum;
import com.oneflyingleaf.core.ho.data.Book;
import com.oneflyingleaf.core.ho.data.BookChaper;
import com.oneflyingleaf.core.ho.data.User;
import com.oneflyingleaf.core.util.JsonUtils;
import com.oneflyingleaf.foreground.service.permission.IPermissionService;

public class BookAction extends BasicAction{

	private static final long serialVersionUID = 3400257322070493464L;
	
	@Resource(name="permissionService")
	private IPermissionService ps;
	
	public void bookShow(){
		
	}
	
	/**
	 * 检查权限
	 */
	public void checkPermission(){
		String bookId = this.getParameter("bookId");
		if(StringUtils.isBlank(bookId)){
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:书籍id出错，请刷新重试！"));
		}
		
		User user = (User) this.getSessionAttribute(SessionEnum.USER.toString());

		//未登录
		if(user == null){
			try{
				
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:10"));
			return ;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		//权限检查
		if(ps.getPersmision(user.getUserId(), PermissionCon.VIP0_DOWNLOAD)){
			this.setSessionAttribute(SessionEnum.DOWNLOADBOOKID.toString(), bookId);
			this.outPut(JsonUtils.toJsonString("stat:suc,msg:suc"));
		}else{
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:当前下载数量已超出显示，建议提升会员等级"));
		}
	}
	
	/**
	 * 下载书籍
	 */
	public void downloadBook(){
		String bookId = this.getSessionAttribute(SessionEnum.DOWNLOADBOOKID.toString())+"";
		
		if(StringUtils.isBlank(bookId) || "null".equals(bookId)){
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:下载失败,请重试"));
			
		}
		
		Book book = this.basicService.findOne("from Book where bookId = ?", new Object[]{bookId});
		HttpServletResponse response = this.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/x-msdownload");
         try {
			response.setHeader("Content-Disposition", "attachment; filename=" + new String(book.getBookName().getBytes("utf-8"),"iso-8859-1") + ".txt");
			
			ServletOutputStream os = this.getOutputStream();
			
			List<BookChaper> list = this.basicService.find("from BookChaper where bookId = ? order by bookChaIndex ", new Object[]{bookId});
			
			String charCode = "utf-8";
			for(BookChaper bc : list){
				os.write(bc.getBookChaTitle().getBytes(charCode));
				os.write("\r\n".getBytes(charCode));
				os.write(bc.getText2().getBytes(charCode));
				os.flush();
			}
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:下载失败"));
			
		}
	}
	
	/**
	 * 书籍删除，逻辑删除
	 */
	public void deleteBook(){
		String bookId = this.getParameter("bookId");
		User u = (User) this.getSessionAttribute(SessionEnum.USER.toString());
		
		Book book = this.basicService.findOne("from Book where bookId = ?", new Object[]{bookId});
		
		if(u == null){
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:删除失败！请刷新并重新登录！"));
			return ;
		}
		if(!u.getPermission().equals(User.USER_AUTHOR)){
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:删除失败！您没有相关权限！"));
			return ;
		}
		
		if(book == null){
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:删除失败！该书不存在！"));
			return ;
		}
		if(!book.getAuthName().equals(u.getUserName())){
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:删除失败！您不是该书的作者！"));
			return ;
		}

		book.setBookStat("20");
		this.basicService.update(book);
		this.outPut(JsonUtils.toJsonString("stat:suc,msg:suc"));
	}
	
	/**
	 * ajax更新书籍的某些属性
	 */
	public void updateBookProperties(){
		String type = this.getParameter("type");
		String bookId = this.getParameter("bookId");
		//需要更新属性的值
		String value = this.getParameter(type);
		User user  = (User) this.getSessionAttribute(SessionEnum.USER.toString());
		if(user == null){
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:更新失败，请重新登录！"));
			return ;
		}
		if(!user.getPermission().equals(User.USER_AUTHOR)){
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:更新失败，您不是作者，没有权限更新该项目！"));
			return;
		}
		
		
		Book book = this.basicService.findOne("from Book where bookId = ?",new Object[]{bookId});

		if(!user.getUserName().equals(book.getAuthName())){
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:更新失败，您不是该书的作者，没有权限更新该项目！"));
			return;
		}
		
		Class<Book> clazz = Book.class;
		try {
			Method method = clazz.getMethod("set"+type.toUpperCase().substring(0, 1)+type.substring(1), String.class);
			method.invoke(book, value);
			this.basicService.update(book);
			this.outPut(JsonUtils.toJsonString("stat:suc,msg:更新成功"));
		} catch (Exception e) {
			e.printStackTrace();
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:更新失败，请联系管理员！"));
		}
	}


	public IPermissionService getPs() {
		return ps;
	}


	public void setPs(IPermissionService ps) {
		this.ps = ps;
	}

}
