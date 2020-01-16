package com.lvqibin.oa.sys.service.impl;

import com.lvqibin.oa.sys.model.SysPermission;
import com.lvqibin.oa.common.UUIDUtil;
import com.lvqibin.oa.sys.dao.SysPermissionMapper;
import com.lvqibin.oa.sys.service.SysPermissionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public long insertbatch(String roleId, List<String> menuList) throws Exception {
		log.debug("SysPermissionServiceImpl.insertbatch  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param : roleId = " + roleId );
		log.debug("Param : menuList.size() = " + menuList.size() );
		log.debug("Param : menuList.toString() = " + menuList.toString() );
		long insterSum = 0 ;
		try {
			if (menuList != null && menuList.size() > 0 ) {
				QueryWrapper<SysPermission> queryWrapper = new QueryWrapper<SysPermission>();
				queryWrapper.eq(true, "role_id", roleId);
				baseMapper.delete(queryWrapper);
				List<SysPermission> list = new ArrayList<SysPermission>();
				for ( int i = 0 ; i < menuList.size() ; i++ ) {
					SysPermission permission = new SysPermission();
					permission.setId(UUIDUtil.getUuid());
					permission.setRoleId(roleId);
					permission.setDescription("功能权限");
					permission.setValidState("1");
					permission.setVersion(1);
					permission.setMenuId(menuList.get(i));
					list.add(permission);
				}
				insterSum =  baseMapper.insertbatch(list);
			} else {
				QueryWrapper<SysPermission> queryWrapper = new QueryWrapper<SysPermission>();
				queryWrapper.eq(true, "role_id", roleId);
				baseMapper.delete(queryWrapper);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		log.debug(" insterSum "  + insterSum);
		log.debug("SysPermissionServiceImpl.search  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return insterSum;
	}

}
