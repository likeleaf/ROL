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
 * 登录权限的校验
 */
public class loginFilter implements Filter {
	
	Log log = LogFactory.getLog(loginFilter.class);
	private final String login = "";
	
    public loginFilter() {
    }

	public void destroy() {
		log.info("登录拦截器销毁...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		req.setCharacterEncoding("utf-8");
		//权限的检查
		if(checkPermission(req)){
			String oldUrl = (String) req.getSession().getAttribute(SessionEnum.OLDURL.toString());
			//返回登录前的网址
			if(StringUtils.isNotBlank(oldUrl)){
				req.getSession().removeAttribute(SessionEnum.OLDURL.toString());
				res.sendRedirect(oldUrl);
				return ;
			}
			chain.doFilter(request, response);
		}else{
			//将进入的url保存，使得保存注册或者登陆后直接跳转到需要到达的界面
			String oldUrl = req.getRequestURL().toString();
			if(StringUtils.isNotBlank(login)){
				if(login.equals(oldUrl.trim()))
				req.getSession().setAttribute(SessionEnum.OLDURL.toString(), oldUrl);
			}
			res.sendRedirect(login);
		}
	}
	
	/**
	 * 检查是否拥有进入相关网页的权限
	 * @param req
	 * @return 如果拥有权限则返回true，没有返回false
	 */
	private boolean checkPermission(HttpServletRequest req){
		HttpSession session =req.getSession();
		String id = (String)session.getAttribute(SessionEnum.USERID.toString());
		
		if(StringUtils.isNotBlank(id)){
			User user = SpringUtils.getBaseService().get(User.class, id);
			//防止出现参数冲突即：www.oneflyingleaf.com/author/*.html?/auther/=...的情况
			String url = req.getRequestURL().toString().split("?")[0];
			//作者
			if(User.USER_AUTHOR.equals(user.getPermission()) && url.contains("/author/")){
				return true;
			}
			//管理员
			if(User.USER_MANAGER.equals(user.getPermission()) && !url.contains("/author/")){
				return true;
			}
			//超级管理员
			if(User.USER_SUPER_MANAGER.equals(user.getPermission())){
				return true;
			}
			//普通用户
			if(User.USER_NOR.equals(user.getPermission()) && url.contains("/normal/")){
				return true;
			}
		}
		return false;
	}

	public void init(FilterConfig fConfig) throws ServletException {
		log.info("登录拦截器 初始化...");
	}

}
