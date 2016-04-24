package com.oneflyingleaf.foreground.action.book;

import java.io.File;
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
import com.oneflyingleaf.core.ho.data.Vip;
import com.oneflyingleaf.core.util.JsonUtils;
import com.oneflyingleaf.core.util.PinYinUtils;
import com.oneflyingleaf.crawler.constant.CrawlerConstant;
import com.oneflyingleaf.crawler.util.FileUtils;
import com.oneflyingleaf.foreground.service.permission.IPermissionService;

public class BookAction extends BasicAction{

	private static final long serialVersionUID = 3400257322070493464L;
	
	@Resource(name="permissionService")
	private IPermissionService ps;
	
	private String bookId;
	
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
	
	/**
	 * 书籍插入
	 * 漏洞：1.未验证用户
	 * 		 2.短时间内无限访问，造成崩溃
	 * @return
	 */
	public String addBookCha(){
		String title = this.getParameter("title");
		String content = this.getParameter("content");
		BookChaper bc = new BookChaper();
		String bookId = this.getParameter("bookId");

		
		if(StringUtils.isBlank(title)){
			return ERROR;
		}
		if(StringUtils.isBlank(content)){
			return ERROR;
		}
		if(StringUtils.isBlank(bookId)){
			return ERROR;
		}
		Object obj = this.basicService.findOne("select max(bookChaIndex) from BookChaper bc where bc.bookId = ?", new Object[]{bookId});
		Book book  = this.basicService.findOne("from Book where bookId = ?",new Object[]{bookId});
		
		int index = obj == null?0:Integer.parseInt(String.valueOf(obj));
		
		bc.setBookChaIndex(index+1);
		bc.setBookChaTitle(title);
		bc.setBookId(bookId);
		String path =  CrawlerConstant.BOOK_PATH+"\\"+PinYinUtils.getPinYinHeadChar(book.getBookType())+"\\"+book.getBookName()+"\\"+title+".txt";
		//保存
		FileUtils.saveFile(content,new File(path));
		
		bc.setBookChaCon(path);
		this.basicService.save(bc);
		
		this.bookId = bookId;
		
		return "save_success";
	
	}
	
	/**
	 * 编辑章节内容
	 * @return
	 */
	public String editBookCha(){
		String title = this.getParameter("title");
		String content = this.getParameter("content");
		String bookChaId = this.getParameter("bookChaId");
		String bookId = this.getParameter("bookId");

		
		if(StringUtils.isBlank(title)){
			return ERROR;
		}
		if(StringUtils.isBlank(content)){
			return ERROR;
		}
		if(StringUtils.isBlank(bookId)){
			return ERROR;
		}
		if(StringUtils.isBlank(bookChaId)){
			return ERROR;
		}
		BookChaper bc = this.basicService.findOne("from BookChaper bc where bc.bookChaId = ?", new Object[]{Integer.parseInt(bookChaId)});
	//	Book book  = this.basicService.findOne("from Book where bookId = ?",new Object[]{bookId});
		
		bc.setBookChaTitle(title);
		
		String path = bc.getBookChaCon();
		
		File file = new File(path);
		
		file.deleteOnExit();
		
		//保存
		FileUtils.saveFile(content,new File(path));
		
		this.basicService.update(bc);
		
		this.bookId = bookId;
		
		return "save_success";
	}
	
	/**
	 * 打赏作品
	 */
	public void rewardBook(){
		String bookId = this.getParameter("bookId");
		
		User user = (User) this.getSessionAttribute(SessionEnum.USER.toString());
		if(user == null){
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:打赏失败，请重新登录！"));
			return;
		}

		if(StringUtils.isBlank(bookId)){
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:打赏失败，请刷新新重试！"));
			return;
		}
		
		Book book = this.basicService.findOne("from Book where bookId = ?", new Object[]{bookId});
		if(book == null){
			this.outPut(JsonUtils.toJsonString("stat:fal,msg:打赏失败，该书不存在！"));
			return;	
		}
		
			
		
	}
	
	
	
	
	
	
	/**************************************************工具******************************************************/
	
	
	private String getVipLevel(User user){
		if(user == null){
			throw new NullPointerException();
		} 
		
		String per = user.getPermission();
		
		//普通用户
		if(User.USER_NOR.equals(per)){
			return "VIP0";
		}else if(User.USER_VIP.equals(per) || User.USER_AUTHOR.equals(per)){//vip和作者，作者默认为vip
			Vip v = this.basicService.findOne("from Vip where userId = ? and vipStat = '20'", new Object[]{user.getUserId()});
			Integer level = v.getLevel();
			return "VIP"+level;
			
		}else if(User.USER_MANAGER.equals(per) || User.USER_SUPER_MANAGER.equals(per)){//管理员和超级管理员的职责不体现在这里
			return "manager";
		}
		return null;
		
	}

	public IPermissionService getPs() {
		return ps;
	}


	public void setPs(IPermissionService ps) {
		this.ps = ps;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

}
