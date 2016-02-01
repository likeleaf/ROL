package com.oneflyingleaf.core.init;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oneflyingleaf.core.util.ConfigUtils;
import com.oneflyingleaf.core.util.FileUtils;

/**
 * ��Ҫ�����ļ�js��css�ļ��ĺϲ�
 * @author Administrator
 *
 */
public class FileInit {
	Log log = LogFactory.getLog(FileInit.class);
	public FileInit(){
	}
	
	
	public void init(){
		log.info("�ļ���ʼ��");
		
		//�ϲ�Js
		this.margeJs();
		//�ϲ�Css
		this.margeCss();
	}
	
	
	/**
	 * �ϲ�js�ļ���a.js�������js�ļ�����
	 */
	private void margeJs(){
		String jsPackage = ConfigUtils.getJsPackage();
		String []js = ConfigUtils.getJsName();
		FileUtils.readAndWriteFile(jsPackage, js, jsPackage, "a.js");
	}
	
	/**
	 * �ϲ�css�ļ���a.css�������css�ļ�����
	 */
	private void margeCss(){
		String cssPackage = ConfigUtils.getCssPackage();
		String []css = ConfigUtils.getCssName();
		FileUtils.readAndWriteFile(cssPackage, css, cssPackage, "b.css");
	}
	
	
	
}
