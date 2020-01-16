package com.lvqibin.oa.sys.service.impl;

import com.lvqibin.oa.sys.model.SysPerson;
import com.lvqibin.oa.common.JWT.JwtToken;
import com.lvqibin.oa.sys.dao.SysPersonMapper;
import com.lvqibin.oa.sys.service.SysPersonService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.JsonObject;

import org.springframework.stereotype.Service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 人员表 服务实现类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@Service
public class SysPersonServiceImpl extends ServiceImpl<SysPersonMapper, SysPerson> implements SysPersonService {

	public JsonObject loginSystemByAngular(String loginName, String password) {
		// TODO Auto-generated method stub
		log.debug("SysPersonServiceImpl.loginSystemByAngular >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		JsonObject  msg = new JsonObject();
		try {
			if(StringUtils.isNotEmpty(loginName)&&StringUtils.isNotEmpty(loginName)){ 
				log.debug("params： loginName = " + loginName);
		    	log.debug("params： password = " + password);
				List<SysPerson> users =  baseMapper.selectList(new QueryWrapper<SysPerson>().eq(true, "login_name", loginName).eq(true, "password", DigestUtils.md5Hex(password)));
				if(users.size()>0){
					SysPerson user = users.get(0);
					msg.addProperty("success", "true");
					msg.addProperty("msg", "登录成功！");
					String token = JwtToken.createToken( user.getId(),user.getName(),user.getLoginName(),user.getPassword());
					msg.addProperty("token", token);
					msg.addProperty("name", user.getName());
					// msg.addProperty("avatar", "");
					msg.addProperty("email", user.getMail());
					msg.addProperty("id", user.getId());
				}else{
					msg.addProperty("success", "false");
					msg.addProperty("msg", "登录失败！用户名或密码错误！");
					msg.addProperty("errorCode", "userNameAndPasswordIsError");
				}
			}else{
				msg.addProperty("success", "false");
				msg.addProperty("msg", "登录失败！用户名和密码不能为空！");
				msg.addProperty("errorCode", "userNameAndPasswordIsNullError");
			}
			log.debug("returnData msg = " + msg);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("SysPersonServiceImpl.loginSystemByAngular <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return msg;
	}
}
