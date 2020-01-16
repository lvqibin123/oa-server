package com.lvqibin.oa.app.service.impl;

import com.lvqibin.oa.app.model.AppFarmer;
import com.lvqibin.oa.app.dao.AppFarmerMapper;
import com.lvqibin.oa.app.service.AppFarmerService;
import com.lvqibin.oa.common.DataAngularResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-17
 */
@Service
public class AppFarmerServiceImpl extends ServiceImpl<AppFarmerMapper, AppFarmer> implements AppFarmerService {

	public DataAngularResult<AppFarmer> searchByPage(Integer page, Integer pagesize, String keyWord) {
		log.debug("AppFarmerServiceImpl.searchByPage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  page = " + page );
        log.debug("Param :  pagesize = " + pagesize );
        log.debug("Param :  keyWord = " + keyWord );
        DataAngularResult<AppFarmer> ds = null;
        if (page!=null && pagesize!=null) {
            PageHelper.startPage(page, pagesize);
            QueryWrapper<AppFarmer> wrapper = new QueryWrapper<AppFarmer>();
            if (StringUtils.isNotEmpty(keyWord)) {
            	wrapper.like(true, "name", keyWord);
            }
            List<AppFarmer> list = baseMapper.selectList(wrapper);
            PageInfo<AppFarmer> pageInfo = new PageInfo<AppFarmer>(list);
            ds = new DataAngularResult<AppFarmer>(pageInfo.getTotal(), list);
        }
        log.debug(" ds = " + ds.toString());
        log.debug("AppFarmerServiceImpl.searchByPage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return ds;
	}

}
