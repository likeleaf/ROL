package com.oneflyingleaf.crawler.main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import javax.sound.midi.SysexMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oneflyingleaf.core.ho.data.BookDetail;
import com.oneflyingleaf.core.ho.data.Menu;
import com.oneflyingleaf.core.service.BaseService;
import com.oneflyingleaf.crawler.constant.CrawlerConstant;
import com.oneflyingleaf.crawler.deal.BookImfDown;

public class DealBooks {
	static BlockingQueue  <String> queue = new LinkedBlockingQueue<String>();
	static boolean stop = false;
	
	public void excute() {  
		 ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10); 
		 ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		 BaseService baseService = (BaseService) ac.getBean("baseService");
		 for(int i = 0;i<20;i++){
			 fixedThreadPool.execute(new Runnable() {  
				 public void run() {
					 BookImfDown bid = new BookImfDown();
					 String str = null;
					 while(!stop){
						 str = queue.poll();
						 BookDetail bookDetail = null;
						if(str != null){
							try {
								bookDetail = bid.downBookFull(queue.poll());
								
								try{
									baseService.save(bookDetail);
									for(Menu m :bookDetail.getMenu()){
										m.setBookDetailId(bookDetail.getBookDetailId());
										baseService.save(m);
									}
								}catch(Exception e){
									e.printStackTrace();
								}
								
							} catch (Exception e) {
								//采集文章出错
								//e.printStackTrace();
							}
							
							
							
							
							
						}else{
							stop = true;
							System.out.println("完成");
							System.exit(0);
						}
					 }
				 }  
			 });  
		 }
	 }
	 
	 
	 //执行
	 public static void main(String[] args) {
		
		 //10000到11941左右采集完毕  12500到13500采集完毕
		 int start = 13501;
		int end = 14500;
		for(int i = start;i <end ;i++ ){
			queue.add(CrawlerConstant.CRAWLER_URL+i+"//");
			System.out.println(CrawlerConstant.CRAWLER_URL+i+"//");
		}
		
		new DealBooks().excute();
	}
	
}
