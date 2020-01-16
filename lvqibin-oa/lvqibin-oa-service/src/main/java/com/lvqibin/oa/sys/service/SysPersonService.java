package com.lvqibin.oa.sys.service;

import com.lvqibin.oa.sys.model.SysPerson;
import com.baomidou.mybatisplus.extension.service.IService;
import com.google.gson.JsonObject;

/**
 * <p>
 * 人员表 服务类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysPersonService extends IService<SysPerson> {
	
	/**
     *  系统登录 主要用于 ng-alain 端的登录
     *  date 2019-12-03
     *@author lvqibin
     *@param loginName   用户名
     *@param password   密码
     *@return JsonObject  json对象
     */
	JsonObject loginSystemByAngular(String loginName, String password);
}
