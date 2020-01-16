package com.lvqibin.oa.sys.service.impl;

import com.lvqibin.oa.sys.model.SysAuthorize;
import com.lvqibin.oa.sys.model.SysPermission;
import com.lvqibin.oa.sys.model.SysRole;
import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.sys.dao.SysPermissionMapper;
import com.lvqibin.oa.sys.dao.SysRoleMapper;
import com.lvqibin.oa.sys.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
	@Autowired
	private SysPermissionMapper permissionMapper;

	public DataAngularResult<SysRole> searchByPage(Integer page, Integer pagesize, String keyWord) {
		log.debug("SysRoleServiceImpl.searchByPage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  page = " + page );
        log.debug("Param :  pagesize = " + pagesize );
        log.debug("Param :  keyWord = " + keyWord );
        DataAngularResult<SysRole> ds = null;
        if (page!=null && pagesize!=null) {
            PageHelper.startPage(page, pagesize);
            QueryWrapper<SysRole> wrapper = new QueryWrapper<SysRole>();
            if (StringUtils.isNotEmpty(keyWord)) {
            	wrapper.like(true, "name", keyWord);
            }
            List<SysRole> list = baseMapper.selectList(wrapper);
            PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(list);
            ds = new DataAngularResult<SysRole>(pageInfo.getTotal(), list);
        }
        log.debug(" ds = " + ds.toString());
        log.debug("SysRoleServiceImpl.searchByPage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return ds;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delRoleAndPermissionById(String id) throws Exception {
		log.debug("SysRoleServiceImpl.delRoleAndPermissionById  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param : id = " + id );
		int delSum = 0 ;
		try {
			delSum =  delSum + baseMapper.deleteById(id);
			QueryWrapper<SysPermission> queryWrapper = new QueryWrapper<SysPermission>();
			queryWrapper.eq(true, "role_id", id);
			delSum =  delSum + permissionMapper.delete(queryWrapper);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		log.debug("action  : del    delSum = " + delSum );
		log.debug("SysRoleServiceImpl.delRoleAndPermissionById  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return delSum;
	}

	public DataAngularResult<SysRole> queryNotRolePage(int pagenum, int pagesize, String orgId,
			String keyworlds) {
		log.debug("SysRoleServiceImpl.queryNotRolePage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param : pagenum = " + pagenum );
		log.debug("Param : pagesize = " + pagesize );
		log.debug("Param : orgId = " + orgId );
		PageHelper.startPage(pagenum, pagesize);
		List<SysRole> list = baseMapper.getNotRoleByOrgId(orgId, keyworlds );
		PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(list);
		DataAngularResult<SysRole> ds = new DataAngularResult<SysRole>(pageInfo.getTotal(), list);
		log.debug("action : query  ds = " + ds.toString() );
		log.debug("SysRoleServiceImpl.queryNotRolePage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return ds;
	}

}
