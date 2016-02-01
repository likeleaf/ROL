package com.oneflyingleaf.core.init;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oneflyingleaf.core.util.ConfigUtils;
import com.oneflyingleaf.core.util.FileUtils;

/**
 * 主要处理文件js和css文件的合并
 * @author Administrator
 *
 */
public class FileInit {
	Log log = LogFactory.getLog(FileInit.class);
	public FileInit(){
	}
	
	
	public void init(){
		log.info("文件初始化");
		
		//合并Js
		this.margeJs();
		//合并Css
		this.margeCss();
	}
	
	
	/**
	 * 合并js文件成a.js，存放在js文件夹下
	 */
	private void margeJs(){
		String jsPackage = ConfigUtils.getJsPackage();
		String []js = ConfigUtils.getJsName();
		FileUtils.readAndWriteFile(jsPackage, js, jsPackage, "a.js");
	}
	
	/**
	 * 合并css文件成a.css，存放在css文件夹下
	 */
	private void margeCss(){
		String cssPackage = ConfigUtils.getCssPackage();
		String []css = ConfigUtils.getCssName();
		FileUtils.readAndWriteFile(cssPackage, css, cssPackage, "b.css");
	}
	
	
	
}
