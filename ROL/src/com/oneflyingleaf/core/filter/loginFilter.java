package com.oneflyingleaf.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oneflyingleaf.core.constant.SessionEnum;
import com.oneflyingleaf.core.ho.data.User;
import com.oneflyingleaf.core.util.SpringUtils;

/**
 * ��¼Ȩ�޵�У��
 */
public class loginFilter implements Filter {
	
	Log log = LogFactory.getLog(loginFilter.class);
	private final String login = "";
	
    public loginFilter() {
    }

	public void destroy() {
		log.info("��¼����������...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		req.setCharacterEncoding("utf-8");
		//Ȩ�޵ļ��
		if(checkPermission(req)){
			String oldUrl = (String) req.getSession().getAttribute(SessionEnum.OLDURL.toString());
			//���ص�¼ǰ����ַ
			if(StringUtils.isNotBlank(oldUrl)){
				req.getSession().removeAttribute(SessionEnum.OLDURL.toString());
				res.sendRedirect(oldUrl);
				return ;
			}
			chain.doFilter(request, response);
		}else{
			//�������url���棬ʹ�ñ���ע����ߵ�½��ֱ����ת����Ҫ����Ľ���
			String oldUrl = req.getRequestURL().toString();
			if(StringUtils.isNotBlank(login)){
				if(login.equals(oldUrl.trim()))
				req.getSession().setAttribute(SessionEnum.OLDURL.toString(), oldUrl);
			}
			res.sendRedirect(login);
		}
	}
	
	/**
	 * ����Ƿ�ӵ�н��������ҳ��Ȩ��
	 * @param req
	 * @return ���ӵ��Ȩ���򷵻�true��û�з���false
	 */
	private boolean checkPermission(HttpServletRequest req){
		HttpSession session =req.getSession();
		String id = (String)session.getAttribute(SessionEnum.USERID.toString());
		
		if(StringUtils.isNotBlank(id)){
			User user = SpringUtils.getBaseService().get(User.class, id);
			//��ֹ���ֲ�����ͻ����www.oneflyingleaf.com/author/*.html?/auther/=...�����
			String url = req.getRequestURL().toString().split("?")[0];
			//����
			if(User.USER_AUTHOR.equals(user.getPermission()) && url.contains("/author/")){
				return true;
			}
			//����Ա
			if(User.USER_MANAGER.equals(user.getPermission()) && !url.contains("/author/")){
				return true;
			}
			//��������Ա
			if(User.USER_SUPER_MANAGER.equals(user.getPermission())){
				return true;
			}
			//��ͨ�û�
			if(User.USER_NOR.equals(user.getPermission()) && url.contains("/normal/")){
				return true;
			}
		}
		return false;
	}

	public void init(FilterConfig fConfig) throws ServletException {
		log.info("��¼������ ��ʼ��...");
	}

}
