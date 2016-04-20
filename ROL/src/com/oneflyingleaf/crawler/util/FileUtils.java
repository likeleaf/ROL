package com.oneflyingleaf.crawler.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
	
	
	
	/**
	 * 通过字节流保存想应的文件
	 * @param is
	 * @param f
	 * @return
	 */
	public static boolean saveFile(InputStream is,File f){
		BufferedInputStream bs = new BufferedInputStream(is);
		OutputStream os = null;
		BufferedOutputStream bos = null;
		try {
			os = new FileOutputStream(f);
			bos = new BufferedOutputStream(os);
			
			byte[] b = new byte[1024*2];
			int len = 0;
			while((len = bs.read(b)) != -1){
				bos.write(b, 0, len);
			}
			bos.flush();
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bos != null){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(bs != null){
						try {
							bs.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally{
							if(os!=null){
								try {
									os.close();
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
		
		return false;
	}

	
	/**
	 * 将字符保存到相关的文件
	 * @param str
	 * @param f
	 * @return
	 */
	public static boolean saveFile(String str,File f){
		FileWriter fw = null;
		BufferedWriter bw = null;
		str = str.replaceAll("\\?\\?\\?\\?", "\\r\\n");
		System.out.println(str);
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			bw.write(str);			
			bw.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if( bw!= null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
		
		return false;
	}

}
