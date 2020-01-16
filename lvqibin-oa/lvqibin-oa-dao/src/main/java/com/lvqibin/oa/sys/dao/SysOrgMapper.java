package com.lvqibin.oa.sys.dao;

import com.lvqibin.oa.sys.model.SysOrg;
import com.lvqibin.oa.sys.model.SysPerson;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 组织机构表 Mapper 接口
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysOrgMapper extends BaseMapper<SysOrg> {
	// 根据ID删除该组织机构和其子组织机构
	int deleteOrgWithChildByID(@Param("id") String id);
	
	// 根据id获取最大的 排序号
	long getMaxSequence(@Param("id") String id);
	
	// 对组织机构的 fName,fCode 字段的值进行修正 id 修改的起始ID  为all则全集修正 否则只修正正id和其子节点
	int correctionOrg(@Param("id") String id);
	
	/**
	 * 组织机构人员保存 保存人员信息的同时将人员信息写入组织机构表中
	 *  date 2019-01-15
	 *@author lvqibin
     *@param psm 人员信息
     *@return FormMessage  保存成功或者失败返回值
	 */
	int saveOrUpdateOrgAndPsm(SysPerson o) throws  Exception ;
}
