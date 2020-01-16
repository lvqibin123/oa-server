package com.lvqibin.oa.sys.service;

import com.lvqibin.oa.sys.model.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysMenuService extends IService<SysMenu> {
	/**
	 *  根据当前登录人ID 
	 *  获取app、user和menue 的信息
	 *  date 2019-12-04
	 *@author lvqibin
	 *@param type 菜单使用类型
     *@param menuType 菜单类型
     *@param thisUserID 当前登录人ID
     *@return JsonObject  json对象
	 */
	
	JsonObject getMenuListByTypeAndParentAndUserID(String type ,String menuType ,String thisUserID);
	
	/**
	 * 根据当前登录人token  和
	 *  parent 获取菜单list
	 * date:2019-12-13
	 *@author lvqibin
     *@param type parent 父节点  不能为空
     *@param thisUserID 当前登录人ID 主要做权限过滤用
     *@return Message
	 */
	JsonObject getMenuByParen(String parent, String thisUserID);
	
	/**
	 * 获取最大的 排序号
	 *  date 2018-12-13
	 *@author lvqibin
     *@param id 如果同级节点id为parent 不能为空，如果子节点 id为id
     *@return long  最大的排序号
	 */
	
	long getMaxSequence(String id);
	
	/**
	 * 根据ID删除该菜单和其子菜单
	 *  date 2019-12-13
	 *@author lvqibin
     *@param id 主键ID
     *@return int  删除成功的数量
	 */
	
	int deleteMenuWithChildByID(String id);
	
	
	/**
	 *  获取 所有 的 menu 的信息
	 *  date 2019-12-13
	 *@author lvqibin
     *@return JsonArray  json对象
	 */
	
	JsonArray getAllMenu();
	
}
