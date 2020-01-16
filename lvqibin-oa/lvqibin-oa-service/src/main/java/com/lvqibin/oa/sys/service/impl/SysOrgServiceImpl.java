package com.lvqibin.oa.sys.service.impl;

import com.lvqibin.oa.sys.model.Org;
import com.lvqibin.oa.sys.model.SysOrg;
import com.lvqibin.oa.sys.model.SysPerson;
import com.lvqibin.oa.common.UUIDUtil;
import com.lvqibin.oa.sys.dao.SysOrgMapper;
import com.lvqibin.oa.sys.dao.SysPersonMapper;
import com.lvqibin.oa.sys.service.SysOrgService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 组织机构表 服务实现类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@Service
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrg> implements SysOrgService {
	@Autowired
	private SysPersonMapper personMapper;
	
	public JsonObject getOrgByParen(String parent) {
		// TODO Auto-generated method stub
		log.debug("SysOrgServiceImpl.getOrgByParen  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		JsonObject  menues = new JsonObject();
		log.debug("Param :  parent = " + parent );
		if(StringUtils.isNotEmpty(parent)){ 
			List<SysOrg> sysOrg =  baseMapper.selectList(new QueryWrapper<SysOrg>().eq(true, "parent",  parent).orderBy(true, true, "level,sequence" ));
			if( sysOrg!=null && sysOrg.size()>0 ) {
				List<Org> orgList = new ArrayList<Org>(); 
				for( int i = 0; i<sysOrg.size() ; i++ ) {
					Org org = new Org();
					if ("ogn".equals(sysOrg.get(i).getOrgKindId())) {
						org.setIcon("gold" );
					} else if ("dpt".equals(sysOrg.get(i).getOrgKindId())) {
						org.setIcon("deployment-unit" );
					} else if ("pos".equals(sysOrg.get(i).getOrgKindId())) {
						org.setIcon( "team" );
					} else if ("psm".equals(sysOrg.get(i).getOrgKindId())) {
						org.setIcon( "user" );
					} else {
						org.setIcon( "" );
					}
					org.setTitle(sysOrg.get(i).getName());
					org.setSequence(sysOrg.get(i).getSequence());
					org.setParent(sysOrg.get(i).getParent());
					long count =  baseMapper.selectCount(new QueryWrapper<SysOrg>().eq(true, "parent",  sysOrg.get(i).getId()));
					org.setChildren(null);
					org.setLeaf(count==0);
					org.setAllId(sysOrg.get(i).getAllId());
					org.setAllCode(sysOrg.get(i).getAllCode());
					org.setAllName(sysOrg.get(i).getAllName());
					org.setPersonId(sysOrg.get(i).getPersonId());
					org.setKey(sysOrg.get(i).getId());  // 注意此处如果不返回 则前端页面会出现多选情况
					orgList.add(org);
				}
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
				String nodes = gson.toJson(orgList);
				menues.addProperty("nodes", nodes);
			}else {
				menues.addProperty("nodes", "");
			}
		}else {
			menues.addProperty("nodes", "");
		}
		log.debug("action  :  query  menues =  " + menues );
		log.debug("SysOrgServiceImpl.getOrgByParen  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return menues;
	}

	public long getMaxSequence(String id) {
		// TODO Auto-generated method stub
		log.debug("SysOrgServiceImpl.getMaxSequence  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param :  id = " + id );
		long maxSequence = baseMapper.getMaxSequence(id) ;
		log.debug("action  :  query  maxSequence =  " + maxSequence );
		log.debug("SysOrgServiceImpl.getMaxSequence  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return maxSequence;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteOrgWithChildAndPersonByID(String id) throws Exception {
		// TODO Auto-generated method stub
		log.debug("SysOrgServiceImpl.deleteOrgWithChildAndPersonByID  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		int delSum =  0 ;
		try {
			int delPserson = personMapper.deletePersonByOrgID(id);
			int delOrg = baseMapper.deleteOrgWithChildByID(id);
			delSum = delOrg + delPserson ;
			log.debug("action  :  delete  delSum =  " + delSum );
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		log.debug("SysOrgServiceImpl.deleteOrgWithChildAndPersonByID  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return delSum;
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public int saveOrUpdateOrgAndPsm(SysPerson o) throws  Exception  {
		// TODO Auto-generated method stub
		log.debug("SysOrgServiceImpl.saveOrUpdateOrgAndPsm  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param :  sysPerson = " + o.toString() );
	
		int sum = 0;
		if(StringUtils.isNotEmpty(o.getMainOrgId())){ 
			SysOrg sysOrg = new SysOrg();
			SysOrg parenOrg =	baseMapper.selectById(o.getMainOrgId());
			if(StringUtils.isEmpty(o.getId())) {
				String psmId = UUIDUtil.getUuid();
				String orgId = UUIDUtil.getUuid();
				sysOrg.setId(orgId);
				sysOrg.setAllId(parenOrg.getAllId() + "/" + orgId);
				sysOrg.setName(o.getName());
				sysOrg.setAllName(parenOrg.getAllName() + "/" + o.getName());
				sysOrg.setCode(o.getCode());
				sysOrg.setAllCode(parenOrg.getAllCode() + "/" + o.getCode() );
				sysOrg.setParent(parenOrg.getId());
				sysOrg.setPersonId(psmId);
				sysOrg.setLevel(parenOrg.getLevel() + 1);
				sysOrg.setSequence(Long.toString(this.getMaxSequence(parenOrg.getId())));
				sysOrg.setPhone(o.getMobilePhone());
				sysOrg.setAddress(o.getFamilyAddress());
				sysOrg.setZip(o.getZip());
				sysOrg.setNodeKind("nkLeaf");
				sysOrg.setOrgKindId("psm");
				sysOrg.setVersion(1);
				sysOrg.setValidState(o.getValidState());
				
				o.setId(psmId);
				o.setPassword(DigestUtils.md5Hex("123456"));
				try {
					sum = baseMapper.insert(sysOrg) + personMapper.insert(o);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					throw e;
				}
				log.debug("action  :  insert  insertSum =  " + sum );
			} else {
				String orgId = UUIDUtil.getUuid();
				sysOrg.setId(orgId);
				sysOrg.setAllId(parenOrg.getAllId() + "/" + orgId);
				sysOrg.setName(o.getName());
				sysOrg.setAllName(parenOrg.getAllName() + "/" + o.getName());
				sysOrg.setCode(o.getCode());
				sysOrg.setAllCode(parenOrg.getAllCode() + "/" + o.getCode() );
				sysOrg.setParent(parenOrg.getId());
				sysOrg.setLevel(parenOrg.getLevel() + 1);
				sysOrg.setSequence(Long.toString(this.getMaxSequence(parenOrg.getId())));
				sysOrg.setPhone(o.getMobilePhone());
				sysOrg.setAddress(o.getFamilyAddress());
				sysOrg.setZip(o.getZip());
				sysOrg.setNodeKind("nkLeaf");
				sysOrg.setOrgKindId("psm");
				sysOrg.setVersion(1);
				sysOrg.setValidState(o.getValidState());
				
				try {
					// o.setPassword(DigestUtils.md5Hex(o.getPassword()));
					sum = baseMapper.update(sysOrg, new QueryWrapper<SysOrg>().eq(true, "id", sysOrg.getId()))
							+ personMapper.update(o, new QueryWrapper<SysPerson>().eq(true, "id", o.getId()));
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					throw e;
				}
				log.debug("action  :  update  updateSum =  " + sum );
			}
		}else {
			sum = 0 ;
		}
		
		log.debug("SysOrgServiceImpl.saveOrUpdateOrgAndPsm  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return sum;
	}
	
	
	public int correctionOrg(String id) {
		// TODO Auto-generated method stub
		log.debug("SysOrgServiceImpl.correctionOrg  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param :  id = " + id );
		int updateSum  =  baseMapper.correctionOrg(id);
		log.debug("action  :  update   updateSum =  " + updateSum );
		log.debug("SysOrgServiceImpl.correctionOrg  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return updateSum;
	}

	public JsonObject getSelectOrg(String parent, String disabledType) {
		// TODO Auto-generated method stub
		log.debug(
				"SysOrgServiceImpl.getSelectOrg  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		JsonObject menues = new JsonObject();
		log.debug("Param :  parent = " + parent);
		log.debug("Param :  disabledType = " + disabledType);
		if (StringUtils.isNotEmpty(parent)) {
			List<SysOrg> sysOrg = baseMapper.selectList(new QueryWrapper<SysOrg>().eq(true, "parent",  parent).orderBy(true, true, "level,sequence" ));
			if (sysOrg != null && sysOrg.size() > 0) {
				List<Org> orgList = new ArrayList<Org>();
				for (int i = 0; i < sysOrg.size(); i++) {
					Org org = new Org();
					org.setKey(sysOrg.get(i).getId());
					org.setLevel(sysOrg.get(i).getLevel());
					if ("ogn".equals(sysOrg.get(i).getOrgKindId())) {
						org.setIcon("gold" );
						if (disabledType.indexOf("ogn") != -1) {
							org.setDisabled(true);
						} else {
							org.setDisabled(false);
						}
					} else if ("dpt".equals(sysOrg.get(i).getOrgKindId())) {
						org.setIcon("deployment-unit" );
						if (disabledType.indexOf("dpt") != -1) {
							org.setDisabled(true);
						} else {
							org.setDisabled(false);
						}
						
					} else if ("pos".equals(sysOrg.get(i).getOrgKindId())) {
						org.setIcon( "team" );
						if (disabledType.indexOf("pos") != -1) {
							org.setDisabled(true);
						} else {
							org.setDisabled(false);
						}
					} else if ("psm".equals(sysOrg.get(i).getOrgKindId())) {
						org.setIcon( "user" );
						if (disabledType.indexOf("psm") != -1) {
							org.setDisabled(true);
						} else {
							org.setDisabled(false);
						}
					} else {
						org.setIcon( "" );
					}
					org.setTitle(sysOrg.get(i).getName());
					org.setSequence(sysOrg.get(i).getSequence());
					org.setParent(sysOrg.get(i).getParent());
					long count =  baseMapper.selectCount(new QueryWrapper<SysOrg>().eq(true, "parent",  sysOrg.get(i).getId()));
					org.setChildren(null);
					org.setLeaf(count==0);
					org.setAllId(sysOrg.get(i).getAllId());
					org.setAllCode(sysOrg.get(i).getAllCode());
					org.setAllName(sysOrg.get(i).getAllName());
					org.setPersonId(sysOrg.get(i).getPersonId());
					org.setKey(sysOrg.get(i).getId());  // 注意此处如果不返回 则前端页面会出现多选情况
					orgList.add(org);
				}
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
				String nodes = gson.toJson(orgList);
				menues.addProperty("nodes", nodes);
			} else {
				menues.addProperty("nodes", "");
			}
		} else {
			menues.addProperty("nodes", "");
		}
		log.debug("action  :  query  menues =  " + menues);
		log.debug(
				"SysOrgServiceImpl.getSelectOrg  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return menues;
	}
}
