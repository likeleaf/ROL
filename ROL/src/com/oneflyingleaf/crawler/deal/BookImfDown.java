package com.oneflyingleaf.crawler.deal;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.oneflyingleaf.core.ho.data.BookDetail;
import com.oneflyingleaf.core.ho.data.Menu;
import com.oneflyingleaf.core.util.PinYinUtils;
import com.oneflyingleaf.crawler.constant.CrawlerConstant;
import com.oneflyingleaf.crawler.util.FileUtils;

/**
 * 采集数据
 * @author leaf
 */
public class BookImfDown {
	

	public BookDetail downBookDetail(String url){
		BookDetail bookDetail = new BookDetail();
		try {
			Document doc = Jsoup.connect(url).get();
			Element intro = doc.select("#detail-box .box_intro").first();
			//图片地址
			try{
				
				bookDetail.setPicturePath(intro.select(".pic img[src]").first().attr("src"));
				//作者
				bookDetail.setAuth(intro.select(".box_info .ui_tb1 td").first().select("p a[href]").first().text());
				//最后更新时间
				bookDetail.setTime(intro.select(".box_info .ui_tb1 tr").eq(2).select("td div").first().text().split("：")[1]);
				//标签
				bookDetail.setBookLab(intro.select(".box_info .ui_tb1 td").first().select("p").eq(1).select("a").first().text());
			}catch(Exception e){
				
			}
			
			
			//目录路径
			bookDetail.setMenuPath(intro.select(".option .btopt a").first().attr("href"));
			
			downBookMenu(bookDetail);
			return bookDetail;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 下载书籍目录（章节相关的信息）
	 * @param bookDetail
	 */
	public void downBookMenu(BookDetail bookDetail){
		if(StringUtils.isBlank(bookDetail.getMenuPath())){
			throw new NullPointerException("书籍目录地址为空");
		}
		//读取目录页
		try {
			Document doc = Jsoup.connect(bookDetail.getMenuPath()).get();
			Element content = doc.select("#header .warpper .mu_contain").first();
			//书名
			bookDetail.setBookName(content.select(" .mu_h1 h1").first().text().replace("全文阅读", ""));
			//书籍描述
			bookDetail.setIntro(content.select("p").first().text());
			Elements menus = doc.select(".mulu_list li");
			//存放章节
			List<Menu> list = new ArrayList<Menu>();
			Menu m = null;
			Element temp = null;
			//读取章节
			for (int i = 0; i < menus.size(); i++) {
				m = new Menu();
				temp = menus.get(i).select("a[href]").first();
				if(temp == null )continue;
				m.setMenuIndex(i);
				m.setPath(temp.absUrl("href"));
				m.setTitle(temp.text());
				list.add(m);
			}
			bookDetail.setMenu(list);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 处理图片
	 * @param bookDetail
	 */
	public void dealPic(BookDetail bookDetail){
		if(StringUtils.isBlank(bookDetail.getPicturePath())) return;
		try {
			URL url = new URL(bookDetail.getPicturePath());
			
			URLConnection uc = url.openConnection();
			InputStream is = uc.getInputStream();
			//保存文件
			String str = PinYinUtils.getPinYinHeadChar(bookDetail.getBookLab());
			String path = CrawlerConstant.BOOK_IMG+"\\"+str;
			File f = new File(path);
			if(!f.exists()){
				f.mkdir();
			}
			String imgName = (System.currentTimeMillis()+"").substring(8)+(new Random().nextInt(900)+100)+".jpg";
			File target = new File(path+"\\"+imgName);
			
			bookDetail.setPicLocalPath(target.getAbsolutePath());
			
			FileUtils.saveFile(is, target);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 处理章节
	 * @param bookDetail
	 */
	public void dealCha(Menu menu,String bookName,String bookLab){
		try {
			Document doc = Jsoup.connect(menu.getPath()).get();
			doc.select(".ad00").remove();
			doc.select(".chapter_Turnpage").remove();
			
			String bookContent = doc.select("#htmlContent").first().text();
			
			//保存文件
			String str = PinYinUtils.getPinYinHeadChar(bookLab);
			String path = CrawlerConstant.BOOK_PATH+"\\"+str;
			
			//赶时间，不封装方法
			//标签地址
			File f = new File(path);
			if(!f.exists()){
				f.mkdir();
			}
			//书籍地址
			String path2 = path+"\\"+bookName; 
			File f2 = new File(path2);
			if(!f2.exists()){
				f2.mkdir();
			}
			
			
			File target = new File(path2+"\\"+menu.getTitle().split(" ")[0]+".txt");
			
			menu.setLocalPath(target.getAbsolutePath());
			
			FileUtils.saveFile(bookContent, target);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BookDetail downBookFull(String url){
		BookDetail bookDetail = downBookDetail(url);
		dealPic(bookDetail);
		for(Menu m :bookDetail.getMenu()){
			dealCha(m, bookDetail.getBookName(), bookDetail.getBookLab());
		}
		return bookDetail;
	}
	
	
	@Test
	public void testDownBookDetail(){
		BookImfDown bid = new BookImfDown();
		bid.downBookFull("http://www.ybdu.com/xiazai/14/14301/");
	}
}
