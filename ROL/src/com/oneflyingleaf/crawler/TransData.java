package com.oneflyingleaf.crawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * 从网上爬下来的内容，由于有些字符有转码问题，会显示????，而恰好，显示这个内容是正是换行时，所以将????转化为换行
 * @author Administrator
 *
 */
public class TransData {
	
	/**
	 * 将文件内容中的????换成换行
	 * @param src
	 * @param target
	 * @throws Exception
	 */
	public static void transFile(File src,File target) throws Exception{
		FileReader fr = new FileReader(src);
		BufferedReader br = new BufferedReader(fr);
		String lineStr = null;
		
		FileWriter fw = new FileWriter(target);
		BufferedWriter bw = new BufferedWriter(fw);
		while((lineStr = br.readLine()) != null){
			bw.write(lineStr.replaceAll("\\?\\?\\?\\?", "\r\n"));
			bw.flush();
		}
		close(fr,br,fw,bw);
	}
	
	
	
	
	/**
	 * 迭代转换
	 * @param f
	 * @return
	 * @throws Exception 
	 */
	public static void transFiles(File src,File target) throws Exception{
		if(src == null){
			return;
		}
		if(src.isDirectory() && !target.exists()){
			target.mkdir();
		}
		
		
		if(src.isDirectory()){
			File []files = src.listFiles();
			for(File f : files){
				try{
					transFiles(f,new File(target.getAbsoluteFile()+"\\"+f.getName()));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}else{
			
			transFile(src,target);
		}
	}
	

	/**
	 * 关闭流
	 */
	private static void close(FileReader fr, BufferedReader br, FileWriter fw,
			BufferedWriter bw) {
		if(br != null){
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(fr != null){
					try {
						fr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}finally{
						if(bw != null){
							try {
								bw.close();
							} catch (IOException e) {
								e.printStackTrace();
							}finally{
								if(fw != null){
									try {
										fw.close();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
		}
		
	}

	
	@Test
	public void testTransFile(){
		try {
			transFile(new File("F:\\book\\book\\dsxs\\班花\\463章.txt"),new File("D:\\test.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransFile2(){
		try {
			System.out.println("????".replaceAll("\\?\\?\\?\\?","\r\n"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testTransFile3(){
		try {
			transFiles(new File("F:\\book\\book"),new File("D:\\book\\book"));
			System.out.println("--------------------------------------------------------");
			System.out.println("-----------------------转换完成-------------------------");
			System.out.println("--------------------------------------------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testTransFile4(){
		System.out.println(new File("D:\\book\\book\\test\\qer").isDirectory());
	}
}
