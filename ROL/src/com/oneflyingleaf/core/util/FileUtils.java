package com.oneflyingleaf.core.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtils {
	
	private static Log log = LogFactory.getLog(FileUtils.class);
	
	
	
	
	
	/**
	 * 读取若干文件并将其写入相关的一个文件中（使用Reader和Writer流）
	 * @param readDir
	 * @param readFileNames
	 * @param writeDir
	 * @param writeFileNames
	 */
	public static void readAndWriteFile(String readDir,String []readFileNames,String writeDir,String writeFileNames){
		
	}
	
	/**
	 * 通过文件路径，将其中的相关内容读取到list中
	 * @param dir
	 * @param fileNames
	 * @return
	 */
	public static List<String> getFileContent(String dir,String[] fileNames){
		List<String> f = new ArrayList<String>();
		FileReader fr = null;
		BufferedReader br = null;
		String s = null;
		
		String forLog = null;
		try {
			for(String fn :fileNames){
				forLog = fn;
				fr = new FileReader(dir+fn);
				br = new BufferedReader(fr);
				while((s = br.readLine()) != null){
					f.add(s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("文件读取失败："+dir+forLog+e.getMessage());
			return f;
		}finally{
			try {
				if(br != null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(fr != null);
						fr.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return f;
	}
	
	
	/**
	 * 将content的内容取出放入对应的文件中
	 * @param dir
	 * @param fileNames
	 * @param content
	 */
	public static void setFileContent(String dir,String fileNames,List<String> content){
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw =  new FileWriter(dir+fileNames);
			bw = new BufferedWriter(fw);
			for(String s : content){
				bw.append(s);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.error("文件写入失败："+dir+fileNames+e.getMessage());
			
		}finally{
			try {
				if(bw != null){
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(fw != null);
						fw.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
	}
}
