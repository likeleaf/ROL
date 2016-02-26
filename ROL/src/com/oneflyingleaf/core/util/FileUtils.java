package com.oneflyingleaf.core.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
	 * ��ȡ�����ļ�������д����ص�һ���ļ��У�ʹ��Reader��Writer��������Ҫ����js��css��ϵͳ��ʼ��ʱ�ĺϲ�
	 * @param readDir
	 * @param readFileNames
	 * @param writeDir
	 * @param writeFileNames
	 * @param containCom �ϲ��ļ�ʱ�Ƿ�������������ļ�
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
		
		//�ϲ�common�ļ��������ļ���,common��ǰ
		if(fileContent != null && modContent != null){
			modContent.addAll(fileContent);
			fileContent = modContent;
		}else if(fileContent == null){
			fileContent = modContent;
		}
		setFileContent(writeDir, writeFileNames, fileContent);
	}
	
	/**
	 * ��ȡ�����ļ�������д����ص�һ���ļ��У�ʹ��Reader��Writer������
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
	 * ͨ���ļ�·���������е�������ݶ�ȡ��list��
	 * @param dir dirΪnullʱ�����λ��Ϊ��Ŀλ��
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
			log.error("�ļ���ȡʧ�ܣ�"+e.getMessage());
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
	 * ��content������ȡ��д���Ӧ���ļ���
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
			log.error("�ļ�д��ʧ�ܣ�"+e.getMessage());
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
}
