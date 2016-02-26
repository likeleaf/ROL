package com.oneflyingleaf.core.init;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oneflyingleaf.core.util.ConfigUtils;
import com.oneflyingleaf.core.util.FileUtils;
import com.oneflyingleaf.core.util.SpringUtils;

/**
 * 主要处理文件js和css文件的合并
 * @author Administrator
 *
 */
public class FileInit {
	Log log = LogFactory.getLog(FileInit.class);
	
	public void init(){
		log.info("文件初始化");
		
		//合并Js
		this.margeJs();
		//合并Css
		this.margeCss();
	}
	
	
	/**
	 * 合并js文件成js，存放在js文件夹下
	 */
	private void margeJs(){
		String jsGroup[] = ConfigUtils.getGroupName("js");
		for(String s:jsGroup){
			String jsPackage = ConfigUtils.getJsPackage(s);
			String []js = ConfigUtils.getJsName(s);
			try {
				FileUtils.readAndWriteFile(SpringUtils.getRealPath(jsPackage), js,SpringUtils.getRealPath( jsPackage), s+".js","js");
				log.info(s+".js文件合并完成！");
			} catch (Exception e) {
				log.error(s+".js文件合并失败");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 合并css文件成a.css，存放在css文件夹下
	 */
	private void margeCss(){
		String cssGroup[] = ConfigUtils.getGroupName("css");
		for(String s: cssGroup){
			String cssPackage = ConfigUtils.getCssPackage(s);
			String []css = ConfigUtils.getCssName(s);
			try {
				FileUtils.readAndWriteFile(SpringUtils.getRealPath(cssPackage), css, SpringUtils.getRealPath(cssPackage), s+".css","css");
				log.info(s+".css文件合并完成！");
			} catch (Exception e) {
				log.error(s+".css文件合并失败！");
				e.printStackTrace();
			}
		}
	}
	
	
}
