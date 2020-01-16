package com.lvqibin.oa.sys.service.impl;

import com.lvqibin.oa.sys.model.App;
import com.lvqibin.oa.sys.model.Menu;
import com.lvqibin.oa.sys.model.SysMenu;
import com.lvqibin.oa.sys.model.SysOrg;
import com.lvqibin.oa.sys.model.SysPerson;
import com.lvqibin.oa.sys.model.User;
import com.lvqibin.oa.sys.dao.SysMenuMapper;
import com.lvqibin.oa.sys.dao.SysOrgMapper;
import com.lvqibin.oa.sys.dao.SysPersonMapper;
import com.lvqibin.oa.sys.service.SysMenuService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
	@Autowired
	private SysPersonMapper personMapper;
	@Autowired
	private SysOrgMapper orgMapper;
	
	@Value("${app.name}")
	private String appName;
	@Value("${app.description}")
	private String appDescription;	
	
	public JsonObject getMenuListByTypeAndParentAndUserID(String type, String menuType, String thisUserID) {
		// TODO Auto-generated method stub
		log.debug("SysMenuServiceImpl.getMenuListByTypeAndParentAndUserID >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("params： type = " + type);
    	log.debug("params： thisUserID = " + thisUserID);
		// roles.clear();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		App app  = new App();
		app.setName(appName);
		app.setDescription(appDescription);
		JsonObject  menues = new JsonObject();
		String appJson = gson.toJson(app);
		menues.addProperty("app", appJson);
		SysPerson sysPerson = personMapper.selectById(thisUserID);
		if(sysPerson!=null) {
			User user = new User();
			user.setId(sysPerson.getId());
			user.setName(sysPerson.getName());
			user.setEmail(sysPerson.getMail());
			user.setAvatar(sysPerson.getPhoto());
	        String userJson = gson.toJson(user);
	        menues.addProperty("user", userJson);
		} 
		List<SysOrg> thisOrgList =  orgMapper.selectList(new QueryWrapper<SysOrg>().eq(true, "person_id", thisUserID));
		if (thisOrgList!=null && thisOrgList.size()>0  ) {
			SysOrg thisSysOrg = thisOrgList.get(0);
			List<SysMenu> list=this.getMenuByTypeAndParentAndUserID("root" , type  ,  menuType,thisSysOrg.getId()) ;
			JsonArray menuArray = this.getSubMenuByTypeAndParentAndUserID(list , type,  menuType , thisSysOrg.getId());
			menues.add("menu", menuArray);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("orgID", StringUtils.isNotEmpty(thisSysOrg.getId()) ? thisSysOrg.getId() :null);
			// 用于存放所以的 角色 主要用于angular ACL 全称叫访问控制列表（Access Control List） 前端的路由守卫控制 
			List<String> roles = new ArrayList<String>();
			List<SysMenu> list1 =   baseMapper.getMenuByTypeAndParentAndUserOrgID(param);			
			if (list1 !=null && list1.size() > 0 ) {
				for ( int i = 0 ;i<list1.size() ;i++) {
					if (StringUtils.isNotEmpty(list1.get(i).getUrl())) {
						roles.add(list1.get(i).getUrl());
					}
				}
				if (roles !=null && roles.size() > 0 ) {
					JsonArray rolesArray = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJsonTree(roles, new TypeToken<List<String>>() {}.getType()).getAsJsonArray();
					menues.add("roles", rolesArray);
				} else {
					menues.add("roles", null);
				}
			} else {
				menues.add("roles", null);
			}
		} else {
			menues.add("menu", null);
			menues.add("roles", null);
		}
		log.debug("menues = " +menues.toString());
		log.debug("SysMenuServiceImpl.getMenuListByTypeAndParentAndUserID <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return menues;
	}
	
	public JsonObject getMenuByParen(String parent, String thisUserID) {
		log.debug("SysMenuServiceImpl.getMenuByParen >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("params： parent = " + parent);
    	log.debug("params： thisUserID = " + thisUserID);
		JsonObject  menues = new JsonObject();
		if(StringUtils.isNotEmpty(parent)&&StringUtils.isNotEmpty(thisUserID)){
			QueryWrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>();
			wrapper.eq(true, "parent", parent);
			wrapper.orderBy(true, true, " level,sequence ");
			List<SysMenu> sysMenu =  baseMapper.selectList(wrapper);
			if( sysMenu!=null && sysMenu.size()>0 ) {
				List<Menu> menuList = new ArrayList<Menu>(); 
				for( int i = 0; i<sysMenu.size() ; i++ ) {
					Menu menu = new Menu();
					menu.setKey(sysMenu.get(i).getId());
					menu.setLevel(sysMenu.get(i).getLevel());
					menu.setTitle(sysMenu.get(i).getName());
					menu.setSequence(sysMenu.get(i).getSequence());
					menu.setParent(sysMenu.get(i).getParent());
					long count =  baseMapper.selectCount(new QueryWrapper<SysMenu>().
							eq(true, "parent", sysMenu.get(i).getId()));
					menu.setChildren(null);
					menu.setLeaf(count==0);
					menuList.add(menu);
					menu.setMenuType(sysMenu.get(i).getMenuType());
				}
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
				String nodes = gson.toJson(menuList);
				menues.addProperty("nodes", nodes);
			}else {
				menues.addProperty("nodes", "");
			}
		}else {
			menues.addProperty("nodes", "");
		}
		log.debug("menues = " +menues.toString());
		log.debug("SysMenuServiceImpl.getMenuByParen <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return menues;
	}
	
	public long getMaxSequence(String id) {
		log.debug("SysMenuServiceImpl.getMaxSequence >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("params： id = " + id);
		log.debug("SysMenuServiceImpl.getMaxSequence <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return baseMapper.getMaxSequence(id);
	}
	
	public int deleteMenuWithChildByID(String id) {
		log.debug("SysMenuServiceImpl.deleteMenuWithChildByID >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("params： id = " + id);
		log.debug("SysMenuServiceImpl.deleteMenuWithChildByID <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return baseMapper.deleteMenuWithChildByID(id);
	}
	
	public JsonArray getAllMenu() {
		// TODO Auto-generated method stub
		log.debug("SysMenuServiceImpl.getAllMenu  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		List<SysMenu> list=this.getMenuByParentid("root");
		JsonArray menuArray = this.getSubMenu(list,"");
		log.debug(" menuArray "  + menuArray.toString());
		log.debug("SysMenuServiceImpl.getAllMenu  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return menuArray;
	}
	public List<SysMenu> getMenuByTypeAndParentAndUserID(String parentid,String type, String menuType ,String userOrgID) {
		List<SysMenu> findList = new ArrayList<SysMenu>();
		if(StringUtils.isNotEmpty(parentid) && StringUtils.isNotEmpty(userOrgID) && StringUtils.isNotEmpty(type)){
			Map<String, Object> param = new HashMap<String, Object>();
			
			param.put("paren", StringUtils.isNotEmpty(parentid) ? parentid :null);
			param.put("type", StringUtils.isNotEmpty(type) ? type :null);
			param.put("orgID", StringUtils.isNotEmpty(userOrgID) ? userOrgID :null);
			if (StringUtils.isNotEmpty(userOrgID)) {
				List<String> menuTypes = Arrays.asList(menuType.split(","));
				param.put("menuType", menuTypes);
			}
			findList =  baseMapper.getMenuByTypeAndParentAndUserOrgID(param);
			
		}
		return findList;
	}
	public JsonArray getSubMenuByTypeAndParentAndUserID(List<SysMenu> list,String type , String menuType,String userOrgID) {
		JsonArray jsonArray = new JsonArray();
		if (list != null && list.size() > 0) {
			for (SysMenu menu : list) {
				JsonObject jsonobj = new JsonObject();
				
				jsonobj.addProperty("title", menu.getName());
				jsonobj.addProperty("text", menu.getName());
				jsonobj.addProperty("level", menu.getLevel());
				jsonobj.addProperty("link", menu.getUrl());
				jsonobj.addProperty("parent", menu.getParent());
				jsonobj.addProperty("key", menu.getId());
				jsonobj.addProperty("url", menu.getUrl());
				List<SysMenu> subMenus = this.getMenuByTypeAndParentAndUserID(menu.getId(), type, menuType , userOrgID);
				if (subMenus != null && subMenus.size() > 0) {
					JsonArray subArray = this.getSubMenuByTypeAndParentAndUserID(subMenus , type , menuType, userOrgID);
					jsonobj.add("children", subArray);
				} else {
					jsonobj.addProperty("isLeaf", true);
				}
				jsonArray.add(jsonobj);

			}
		}
		return jsonArray;
	}
	public List<SysMenu> getMenuByParentid(String parentid) {
		List<SysMenu> findList = new ArrayList<SysMenu>();
		if(StringUtils.isNotEmpty(parentid)){
			QueryWrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>();
			wrapper.eq(true, "parent", parentid);
			wrapper.orderBy(true, true, " sequence ");
			findList =  baseMapper.selectList(wrapper);
		}
		return findList;
	}
	
	public JsonArray getSubMenu(List<SysMenu> list,String keyword) {
		JsonArray jsonArray = new JsonArray();
		if (list != null && list.size() > 0) {
			for (SysMenu menu : list) {
				JsonObject jsonobj = new JsonObject();
				
				jsonobj.addProperty("title", menu.getName());
				jsonobj.addProperty("text", menu.getName());
				jsonobj.addProperty("level", menu.getLevel());
				jsonobj.addProperty("link", menu.getUrl());
				jsonobj.addProperty("parent", menu.getParent());
				jsonobj.addProperty("key", menu.getId());
				jsonobj.addProperty("url", menu.getUrl());
				jsonobj.addProperty("menuType", menu.getMenuType());

				List<SysMenu> subMenus = this.getMenuByParentid(menu.getId());
				if (subMenus != null && subMenus.size() > 0) {
					JsonArray subArray = this.getSubMenu(subMenus,keyword);
					jsonobj.add("children", subArray);
				} else {
					jsonobj.addProperty("isLeaf", true);
				}
				jsonArray.add(jsonobj);

			}
		}
		return jsonArray;
	}
}
