package com.oneflyingleaf.core.tag.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oneflyingleaf.core.tag.bean.AjaxBean;
import com.oneflyingleaf.core.tag.service.TagService;
import com.oneflyingleaf.core.tag.utils.ClassUtils;
import com.oneflyingleaf.core.util.SpringUtils;

public class ListDeal {
	
	Log log = LogFactory.getLog(ListDeal.class);
	private AjaxBean jb;
	
	private TagService tagService ;
	
	
	public ListDeal(AjaxBean jb){
		this.jb = jb;
		try {
			if(jb.isCheckClass()){
				this.jb.setClazz(ClassUtils.getClass(jb.getName(),jb.getPackageName()));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �õ���Ӧ��list
	 */
	public <T> List<T> getList(){
		tagService = SpringUtils.getBean("tagService");
		List<T> list = null;
		
		String str = getQueryString();

		if(jb.isHqlLan()){
			list = tagService.list(str,jb.getPageNow(),jb.getPageCount());
		}else{
			try {
				if(jb.isCheckClass()){
					list = (List<T>) tagService.listBySql(str,jb.getClazz().newInstance());
				}else{
					list = (List<T>) tagService.listBySql(str,null);
				}
					
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		log.info("ǰ̨����:" + str);
		
		return list;
	}
	
	/**
	 * ���ַ���ֵ
	 * @return null ��ʾ���� ���isHqlΪtrue���򷵻�һ��hql��䣬���isHqlΪfalse�����ʾ����sql��䣬isHqlĬ��Ϊtrue;
	 */
	
	private String getQueryString(){
		if(StringUtils.isNotBlank(jb.getType())){
			if("hql".equals(jb.getType())){
				return jb.getHql();
			}else if("sql".equals(jb.getType())){
				jb.setHqlLan(false) ;
				return jb.getSql();
			}
			return null;
		}else{//û��hql��sql��䣬ֱ��ͨ����ص����Դ����ֵ����ƴ�յõ�hql���
			StringBuffer sb = new StringBuffer();
			sb.append("from "+ jb.getName() + " ");
			
			//ƴ��where���
			if(StringUtils.isNotBlank(jb.getLimit()) || StringUtils.isNotBlank(jb.getLikeLimit()) || StringUtils.isNotBlank(jb.getOtherCon())){
				sb.append("where ");
				//ƴ�Ͼ�ȷ��ѯ���
				if(jb.isLimitCheck() && StringUtils.isNotBlank(getLimit())){
					sb.append(" "+getLimit()+" and ");
				}else if(StringUtils.isNotBlank(jb.getLimit())){
					sb.append(" "+jb.getLimit()+" and ");
				}
				
				//ֱ�ӽ���Ӧ�����ݷ���where��
				if(StringUtils.isNotBlank(jb.getOtherCon())){
					sb.append(" "+jb.getOtherCon() +" and ");
				}
				//ƴ��ģ����ѯ���
				if(StringUtils.isNotBlank(getLikeLimit())){
					sb.append(" "+getLikeLimit()+" and ");
				}
				//�����յ�where�Ӿ䴫��sb��
				sb = new StringBuffer(sb.substring(0, sb.length()-4));
			}
			
			//ƴ��order by�Ӿ�
			if(StringUtils.isNotBlank(jb.getOrder())){
				sb.append(" order by " + jb.getOrder());
			}
			
			return sb.toString();
		}
	}
	
	/**
	 * ����likelimit�õ���ص�sql����hql
	 * @return null ��ʾû��likeLimit�������ַ�����ʾ��ص�ģ����ѯ���
	 */
	public String getLikeLimit() {
		if(StringUtils.isNotBlank(jb.getLikeLimit())){
				
				StringBuffer sb = new StringBuffer();
				
				String [] str = jb.getLikeLimit().split("=");
				for (int i = 0; i < str.length; i++) {
					
					
					//����Ϊvalue��ż��Ϊname
					if(i % 2 == 0){
						sb.append(str[i]);
					}else{
						String s = str[i].replaceAll("\'", "").replaceAll("\"", "").trim();
						sb.append(" like '%"+s+"%' and ");
					}
				}
				return sb.substring(0, sb.length()-4);
			}
			
			return null;
	}
	
	
	/**
	 * �õ���ȷ����������
	 * @return
	 */
	public String getLimit() {
		if(StringUtils.isNotBlank(jb.getLimit())){
			StringBuffer sb = new StringBuffer();
			//�õ�name = value
			String[] andSplit = jb.getLimit().split("and");

			for (int i = 0; i < andSplit.length; i++) {
				//�õ�name �� value
				String [] equSplit = andSplit[i].split("=");
				
				for (int j = 0; j < equSplit.length; j++) {
					//����Ϊvalue,ֻ��value��ֵʱ���ŰѸò�ѯ��ӽ�ȥ
					if(j % 2 == 1){
						if(StringUtils.isNotBlank(equSplit[j].trim())){
							sb.append(" " + equSplit[j-1] + "=" +equSplit[j] + " and ");
						}
					}
				}
			}
			
			return sb.substring(0, sb.length()-4);
		}
		return null;
	}
	
}

