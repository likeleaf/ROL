package com.oneflyingleaf.core.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtils {
	
	private static Log log = LogFactory.getLog(FileUtils.class);
	
	
	
	
	
	/**
	 * 读取若干文件并将其写入相关的一个文件中（使用Reader和Writer流），主要用于js和css在系统初始化时的合并
	 * @param readDir
	 * @param readFileNames
	 * @param writeDir
	 * @param writeFileNames
	 * @param containCom 合并文件时是否包含公共类库的文件
	 * @throws Exception 
	 */
	public static void readAndWriteFile(String readDir,String []readFileNames,String writeDir,String writeFileNames,String mod) throws Exception{
		List<String> modContent = null ; 
		if("js".equals(mod)){
			modContent = getFileContent(SpringUtils.getRealPath(ConfigUtils.getCommonPackage("js")), ConfigUtils.getCommonName("js"));
		}
		if("css".equals(mod)){
			modContent = getFileContent(SpringUtils.getRealPath(ConfigUtils.getCommonPackage("css")), ConfigUtils.getCommonName("css"));
		}
		
		List<String> fileContent = getFileContent(readDir, readFileNames);
		
		//合并common文件到其他文件上,common在前
		if(fileContent != null && modContent != null){
			modContent.addAll(fileContent);
			fileContent = modContent;
		}else if(fileContent == null){
			fileContent = modContent;
		}
		setFileContent(writeDir, writeFileNames, fileContent);
	}
	
	/**
	 * 读取若干文件并将其写入相关的一个文件中（使用Reader和Writer流），
	 * @param readDir
	 * @param readFileNames
	 * @param writeDir
	 * @param writeFileNames
	 * @throws Exception 
	 */
	public static void readAndWriteFile(String readDir,String []readFileNames,String writeDir,String writeFileNames) throws Exception{
		readAndWriteFile(readDir, readFileNames, writeDir, writeFileNames,null);
	}
	
	/**
	 * 通过文件路径，将其中的相关内容读取到list中
	 * @param dir dir为null时，相对位置为项目位置
	 * @param fileNames
	 * @return
	 * @throws Exception 
	 */
	public static List<String> getFileContent(String dir,String[] fileNames) throws Exception{
		
		if(dir == null) 
			dir = "";
		if(fileNames == null) return null;
		
		List<String> f = new ArrayList<String>();
		BufferedReader br = null;
		String s = null;
		InputStreamReader isr = null;
		
		try {
			for(String fn :fileNames){
				if(StringUtils.isBlank(fn)) continue;
				
				isr = new InputStreamReader(new FileInputStream(new File(dir,fn)),"UTF-8");
				br = new BufferedReader(isr);
				while((s = br.readLine()) != null){
					f.add(s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("文件读取失败："+e.getMessage());
			throw new Exception();
		}finally{
			try {
				if(br != null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(isr != null)
						isr.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return f;
	}
	
	
	/**
	 * 将content的内容取出写入对应的文件中
	 * @param dir
	 * @param fileNames
	 * @param content
	 * @throws Exception 
	 */
	public static void setFileContent(String dir,String fileNames,List<String> content) throws Exception{
		if(StringUtils.isBlank(dir))dir = "";
		if(StringUtils.isBlank(fileNames)) return ;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			osw = new OutputStreamWriter(new FileOutputStream(new File(dir,fileNames)), "UTF-8");
			bw = new BufferedWriter(osw);
			for(String s : content){
				bw.append(s);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.error("文件写入失败："+e.getMessage());
			throw new IOException();
			
		}finally{
			try {
				if(bw != null){
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(osw != null);
						osw.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
	}
	
	public static StringBuilder getFileContent(File f){
		StringBuilder sb = new StringBuilder();
		if(f == null || f.isDirectory() || !f.canRead()){
			return sb;
		}
		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String temp = null;
			while((temp = br.readLine())!= null){
				sb.append(temp).append("<br>");
			}
			return sb;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(fr, br, null, null);
		}
		return sb;
	}
	
	public static StringBuilder getFileContent2(File f){
		StringBuilder sb = new StringBuilder();
		if(f == null || f.isDirectory() || !f.canRead()){
			return sb;
		}
		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String temp = null;
			while((temp = br.readLine())!= null){
				sb.append(temp).append("\r\n");
			}
			return sb;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(fr, br, null, null);
		}
		return sb;
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
}
