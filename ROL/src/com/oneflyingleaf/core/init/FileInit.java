package com.oneflyingleaf.core.init;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oneflyingleaf.core.util.ConfigUtils;
import com.oneflyingleaf.core.util.FileUtils;
import com.oneflyingleaf.core.util.SpringUtils;

/**
 * ��Ҫ�����ļ�js��css�ļ��ĺϲ�
 * @author Administrator
 *
 */
public class FileInit {
	Log log = LogFactory.getLog(FileInit.class);
	
	public void init(){
		log.info("�ļ���ʼ��");
		
		//�ϲ�Js
		this.margeJs();
		//�ϲ�Css
		this.margeCss();
	}
	
	
	/**
	 * �ϲ�js�ļ���js�������js�ļ�����
	 */
	private void margeJs(){
		String jsGroup[] = ConfigUtils.getGroupName("js");
		for(String s:jsGroup){
			String jsPackage = ConfigUtils.getJsPackage(s);
			String []js = ConfigUtils.getJsName(s);
			try {
				FileUtils.readAndWriteFile(SpringUtils.getRealPath(jsPackage), js,SpringUtils.getRealPath( jsPackage), s+".js","js");
				log.info(s+".js�ļ��ϲ���ɣ�");
			} catch (Exception e) {
				log.error(s+".js�ļ��ϲ�ʧ��");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �ϲ�css�ļ���a.css�������css�ļ�����
	 */
	private void margeCss(){
		String cssGroup[] = ConfigUtils.getGroupName("css");
		for(String s: cssGroup){
			String cssPackage = ConfigUtils.getCssPackage(s);
			String []css = ConfigUtils.getCssName(s);
			try {
				FileUtils.readAndWriteFile(SpringUtils.getRealPath(cssPackage), css, SpringUtils.getRealPath(cssPackage), s+".css","css");
				log.info(s+".css�ļ��ϲ���ɣ�");
			} catch (Exception e) {
				log.error(s+".css�ļ��ϲ�ʧ�ܣ�");
				e.printStackTrace();
			}
		}
	}
	
	
}
