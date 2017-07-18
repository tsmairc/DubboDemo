package interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 
 * 类名称：LoginHandlerInterceptor.java 类描述：
 * 
 * @author mrc
 * @version 1.0
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter{
	
	@SuppressWarnings("unused")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		String path = request.getServletPath();
//		if(StringUtils.isBlank(path)){
//			//兼容WebSphere
//			path = request.getPathInfo();
//		}
//		return true;
		// shiro管理的session
//		Subject currentUser = SecurityUtils.getSubject();
//		Session session = currentUser.getSession();
//		User user = (User)session.getAttribute(Const.SESSION_USER);
//		if(user != null){
//			path = path.substring(1, path.length());
//			boolean b = Jurisdiction.hasJurisdiction(path);
//			if(!b){
//				response.sendRedirect(request.getContextPath() + Const.LOGIN);
//			}
//			return b;
//		}
//		else{
//			// 登陆过滤
			if(request.getServletPath().length() > 2){
				return true;
			}
			String url = request.getContextPath() + "/test.do";
			response.sendRedirect(url);
			return false;
//			return false;
//		}
		
	}
	
}
