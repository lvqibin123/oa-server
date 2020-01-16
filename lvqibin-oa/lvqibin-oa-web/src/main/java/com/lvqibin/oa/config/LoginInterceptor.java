package com.lvqibin.oa.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.google.gson.Gson;
import com.lvqibin.oa.common.CheckToken;
import com.lvqibin.oa.common.JWT.JwtToken;
import com.lvqibin.oa.common.JWT.LoginToken;
import com.lvqibin.oa.sys.model.SysPerson;
import com.lvqibin.oa.sys.service.SysPersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	@Autowired
	private SysPersonService sysPersonService;
	
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object)
			throws Exception {
		
		
		// 设置跨域
		/*
		 * 全局设置的跨域操作在此处不生效 此处必须单独设置跨域 
		 */
		/*httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
		httpServletResponse.setHeader("Access-Control-Max-Age", "0");  
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");  
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");  
		httpServletResponse.setHeader("XDomainRequestAllowed","1");   
		httpServletResponse.setHeader("XDomainRequestAllowed","1");  */
		
		// 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        //JsonObject  msg = new JsonObject();
        ResponseData responseData = ResponseData.ok();
        
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有LoginToken注释，有则跳过认证
        if (method.isAnnotationPresent(LoginToken.class)) {
            LoginToken loginToken = method.getAnnotation(LoginToken.class);
            if (loginToken.required()) {
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(CheckToken.class)) {
            CheckToken checkToken = method.getAnnotation(CheckToken.class);
            if (checkToken.required()) {
                // 执行认证
            	//无token，请重新登录
                if (token == null) {
                	responseData = ResponseData.tokenError();
                    responseMessage(httpServletResponse, httpServletResponse.getWriter(), responseData);
                	return false;
                }
                // 获取 token 中的 user id
                String userId = null;
                try {
                    userId = JWT.decode(token).getClaim("id").asString();
                } catch (JWTDecodeException j) {
                	responseData = ResponseData.tokenError();
                    responseMessage(httpServletResponse, httpServletResponse.getWriter(), responseData);
                    return false;
                }
                
                SysPerson user = sysPersonService.getById(userId);
                //用户不存在，请重新登录
                if (user == null) {
                	responseData = ResponseData.tokenError();
                    responseMessage(httpServletResponse, httpServletResponse.getWriter(), responseData);
                	return false;
                }
                Boolean verify = JwtToken.isVerify(token, user.getLoginName(),user.getPassword());
                //token 合法性校验
                if (!verify) {
                	responseData = ResponseData.tokenError();
                    responseMessage(httpServletResponse, httpServletResponse.getWriter(), responseData);
                	return false;
                }
                return true;
            }
        }
        return true;
	}

    
    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response, PrintWriter out, ResponseData responseData) throws IOException {
        //responseData = ResponseData.tokenError();
        response.setContentType("application/json; charset=utf-8");  
        Gson gs = new Gson();  
        String json = gs.toJson(responseData);
        out.append(json);
        out.flush();
        out.close();
    }
    
}
