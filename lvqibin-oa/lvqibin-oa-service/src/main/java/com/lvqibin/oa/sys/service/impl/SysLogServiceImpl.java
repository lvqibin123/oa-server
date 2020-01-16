package com.lvqibin.oa.sys.service.impl;

import com.lvqibin.oa.sys.model.SysLog;
import com.lvqibin.oa.sys.model.SysOrg;
import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.common.HttpRequestDeviceUtils;
import com.lvqibin.oa.common.UUIDUtil;
import com.lvqibin.oa.sys.dao.SysLogMapper;
import com.lvqibin.oa.sys.dao.SysOrgMapper;
import com.lvqibin.oa.sys.service.SysLogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
	@Autowired
	private SysOrgMapper orgMapper;
	
	public int insterLog(String activity, String activityName, String action, String actionName, String parameters
			,String result,String thisUserID ,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		HttpRequestDeviceUtils httpRequestDeviceUtils = new HttpRequestDeviceUtils();	
		log.debug("SysLogServiceImpl.insterLog  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param :  activity = " + activity );
		log.debug("Param :  activityName = " + activityName );
		log.debug("Param :  action = " + action );
		log.debug("Param :  actionName = " + actionName );
		log.debug("Param :  parameters = " + parameters );
		log.debug("Param :  result = " + result );
		log.debug("Param :  thisUserID = " + thisUserID );
		String useros = "";
		String Agent = request.getHeader("User-Agent"); 
		if (StringUtils.isEmpty(Agent)) {
			useros = "";
		} else {
			StringTokenizer st = new StringTokenizer(Agent,";"); 
			st.nextToken(); 
			//得到用户的浏览器名 
			//String userbrowser = st.nextToken(); 
			//得到用户的操作系统名 
			useros = st.nextToken(); 
		}
		String token = request.getHeader("token");
		String userID = "" ;
		SysOrg sysOrg = new SysOrg();
		if (StringUtils.isEmpty("thisUserID")) {
			sysOrg = null;
		}else {
			userID = thisUserID;
			List<SysOrg> thisOrgList =  orgMapper.selectList(new QueryWrapper<SysOrg>().eq(true, "person_id", userID));
			if (thisOrgList!=null && thisOrgList.size()>0 ) {
				sysOrg =  thisOrgList.get(0);
			}
		}
		SysLog sysLog = new SysLog();
		sysLog.setId(UUIDUtil.getUuid());
		sysLog.setVersion(1);
		sysLog.setActivity(activity);
		sysLog.setActivityName(activityName);
		sysLog.setAction(action);
		sysLog.setActionName(actionName);
		sysLog.setParameters(parameters);
		sysLog.setResult(result);
		sysLog.setCreatorTime(LocalDateTime.now());
		sysLog.setCreatorId(sysOrg.getPersonId());
		sysLog.setIp(request.getRemoteAddr());
		sysLog.setDeviceType(httpRequestDeviceUtils.isMobileDevice(request)?"mobile":"pc");
		sysLog.setOperatingSystem(useros);
		log.debug("sysLog =  " + sysLog.toString() );
		int insterSum = baseMapper.insert(sysLog);
		log.debug("action : inster  insterSum = " + insterSum );
		log.debug("SysLogServiceImpl.insterLog  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return insterSum;
	}

	public DataAngularResult<SysLog> searchByPage(Integer page, Integer pagesize, String keyWord) {
		log.debug("SysLogServiceImpl.searchByPage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  page = " + page );
        log.debug("Param :  pagesize = " + pagesize );
        log.debug("Param :  keyWord = " + keyWord );
        DataAngularResult<SysLog> ds = null;
        if (page!=null && pagesize!=null) {
            PageHelper.startPage(page, pagesize);
            QueryWrapper<SysLog> wrapper = new QueryWrapper<SysLog>();
            if (StringUtils.isNotEmpty(keyWord)) {
            	wrapper.like(true, "name", keyWord);
            }
            List<SysLog> list = baseMapper.selectList(wrapper);
            PageInfo<SysLog> pageInfo = new PageInfo<SysLog>(list);
            ds = new DataAngularResult<SysLog>(pageInfo.getTotal(), list);
        }
        log.debug(" ds = " + ds.toString());
        log.debug("SysLogServiceImpl.searchByPage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return ds;
	}
	
}
