package com.lvqibin.oa.sys.service.impl;

import com.lvqibin.oa.sys.model.SysAuthorize;
import com.lvqibin.oa.sys.model.SysAuthorizeCustom;
import com.lvqibin.oa.sys.model.SysOrg;
import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.common.Message;
import com.lvqibin.oa.common.UUIDUtil;
import com.lvqibin.oa.sys.dao.SysAuthorizeMapper;
import com.lvqibin.oa.sys.dao.SysOrgMapper;
import com.lvqibin.oa.sys.service.SysAuthorizeService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 授权表 服务实现类
 * </p>
 *
 * @author lvqibin
 * @since 2019-11-29
 */
@Service
public class SysAuthorizeServiceImpl extends ServiceImpl<SysAuthorizeMapper, SysAuthorize> implements SysAuthorizeService {
	@Autowired
	private SysOrgMapper orgMapper;
	
	public Message searchByPage(Integer page, Integer pagesize) {
		log.debug("SysAuthorizeServiceImpl.searchByPage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  page = " + page );
        log.debug("Param :  pagesize = " + pagesize );
        Message message  = new Message();
        if (page!=null && pagesize!=null) {
            PageHelper.startPage(page, pagesize);
            Wrapper wrapper = new QueryWrapper<SysAuthorize>();
            List<SysAuthorize> list = baseMapper.selectList(wrapper);
            PageInfo<SysAuthorize> pageInfo = new PageInfo<SysAuthorize>(list);
            message.setStatus(200);
            message.setMessage("查询成功！");
            message.setTotal(Long.toString(pageInfo.getTotal()));
            message.setData(list);
        } else {
        	message.setStatus(-200);
        	message.setMessage("起始页和分页条数不能为空！");
        }
        log.debug(" message = " + message.toString());
        log.debug("SysAuthorizeServiceImpl.searchByPage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return message;
	}

	public DataAngularResult<SysAuthorizeCustom> queryAuthorizePage(int pagenum, int pagesize, String orgId,
			String showParenRole) {
		log.debug("SysAuthorizeServiceImpl.queryAuthorizePage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param : pagenum = " + pagenum );
		log.debug("Param : pagesize = " + pagesize );
		log.debug("Param : orgId = " + orgId );
		log.debug("Param : showParenRole = " + showParenRole );
		 PageHelper.startPage(pagenum, pagesize);
		List<SysAuthorizeCustom> list = baseMapper.selectAllByOrgId(orgId,StringUtils.isNotEmpty(showParenRole)?showParenRole:"false");
		PageInfo<SysAuthorizeCustom> pageInfo = new PageInfo<SysAuthorizeCustom>(list);
		DataAngularResult<SysAuthorizeCustom> ds = new DataAngularResult<SysAuthorizeCustom>(pageInfo.getTotal(), list);
		log.debug("action : query  ds = " + ds.toString() );
		log.debug("SysAuthorizeServiceImpl.queryAuthorizePage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return ds;
	}

	public long insertbatch(List<String> list, String thisUserId, String orgId) throws Exception {
		log.debug("SysAuthorizeServiceImpl.insertbatch  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param : list.size() = " + list.size() );
		log.debug("Param : list.toString() = " + list.toString() );
		log.debug("Param : thisUserID = " + thisUserId );
		long insterSum = 0 ;
		if ( list!=null && list.size() >0) {
			List<SysAuthorize> dataList = new ArrayList<SysAuthorize>();
			SysOrg sysOrg =  orgMapper.selectById(orgId);
			if (sysOrg!=null ) {
				for ( int i = 0 ; i < list.size() ; i ++ ) {
					SysAuthorize authorize =new SysAuthorize();
					authorize.setId(UUIDUtil.getUuid());
					authorize.setRoleId(list.get(i));
					authorize.setOrgId(sysOrg.getId());
					authorize.setDescription("");
					authorize.setCreateTime(LocalDateTime.now());
					authorize.setVersion(1);
					dataList.add(authorize);
				}
				insterSum = baseMapper.insertbatch(dataList);
			}else {
				insterSum = 0 ;
			}
		}else {
			insterSum = 0 ;
		}
		log.debug("action : inster  insterSum = " + insterSum );
		log.debug("SysAuthorizeServiceImpl.search  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return insterSum;
	}

	public int delByIds(List<String> list) throws Exception {
		log.debug("SysAuthorizeServiceImpl.delByIds  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param : list.size() = " + list.size() );
		log.debug("Param : list.toString() = " + list.toString() );
		int delSum = 0 ;
		if ( list!=null && list.size()>0 ) {
			delSum  = baseMapper.deleteBatchIds(list);
		} else {
			delSum = 0 ;
		}
		log.debug("action : del  delSum = " + delSum );
		log.debug("SysAuthorizeServiceImpl.delByIds  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return delSum;
	}

}
