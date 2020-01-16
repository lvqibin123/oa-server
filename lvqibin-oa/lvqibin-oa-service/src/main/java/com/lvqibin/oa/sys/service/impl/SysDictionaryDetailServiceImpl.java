package com.lvqibin.oa.sys.service.impl;

import com.lvqibin.oa.sys.model.AngularSelectBean;
import com.lvqibin.oa.sys.model.SysDictionaryDetail;
import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.sys.dao.SysDictionaryDetailMapper;
import com.lvqibin.oa.sys.service.SysDictionaryDetailService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典从表 服务实现类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@Service
public class SysDictionaryDetailServiceImpl extends ServiceImpl<SysDictionaryDetailMapper, SysDictionaryDetail> implements SysDictionaryDetailService {
	
	public JsonArray getDictionaryDetailByMainCode(String code) {
		// TODO Auto-generated method stub
		log.debug("SysDictionaryServiceImpl.getDictionaryDetailByMainCode  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param : code = " + code );
		List<AngularSelectBean> list = new ArrayList<AngularSelectBean>();
		List<SysDictionaryDetail> dictionaryDetailList = baseMapper.getDictionaryDetailByMainCode(code);
		JsonArray dataArray = new JsonArray();
		if (dictionaryDetailList!=null && dictionaryDetailList.size() > 0 ) {
			for (int i = 0 ; i < dictionaryDetailList.size() ; i ++ ) {
				AngularSelectBean  select = new AngularSelectBean() ;
				select.setLabel(dictionaryDetailList.get(i).getName());
				select.setValue(dictionaryDetailList.get(i).getCode());
				list.add(select);
			}
			dataArray = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJsonTree(list, new TypeToken<List<AngularSelectBean>>() {}.getType()).getAsJsonArray();
			log.debug("action  : query    dataArray = " + dataArray.toString() );
		} else {
			dataArray = null;
			log.debug("action  : query    dataArray =  null " );
		}
		log.debug("SysDictionaryServiceImpl.getDictionaryDetailByMainCode  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return dataArray;
	}

	public DataAngularResult<SysDictionaryDetail> searchByPage(Integer page, Integer pagesize, String mainId,
			String keyWord) {
		log.debug("SysDictionaryDetailServiceImpl.searchByPage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  page = " + page );
        log.debug("Param :  pagesize = " + pagesize );
        log.debug("Param :  keyWord = " + keyWord ); 
        log.debug("Param :  mainId = " + mainId );
        DataAngularResult<SysDictionaryDetail> ds = null;
        if (page!=null && pagesize!=null && StringUtils.isNotEmpty(mainId)) {
            PageHelper.startPage(page, pagesize);
            QueryWrapper<SysDictionaryDetail> wrapper = new QueryWrapper<SysDictionaryDetail>();
            if (StringUtils.isNotEmpty(keyWord)) {
            	wrapper.like(true, "name", keyWord);
            }
            wrapper.eq(true, "main_id", mainId);
            wrapper.orderBy(true, true, " order_no ");
            List<SysDictionaryDetail> list = baseMapper.selectList(wrapper);
            PageInfo<SysDictionaryDetail> pageInfo = new PageInfo<SysDictionaryDetail>(list);
            ds = new DataAngularResult<SysDictionaryDetail>(pageInfo.getTotal(), list);
        }
        log.debug(" ds = " + ds.toString());
        log.debug("SysDictionaryDetailServiceImpl.searchByPage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return ds;
	}

	public long getMaxOrderNoByMainId(String mainId) {
		log.debug("SysDictionaryServiceImpl.getMaxOrderNo  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		log.debug("Param :  mainId = " + mainId );
		long maxOrderNo =  baseMapper.getMaxOrderNo(mainId);
		log.debug("action  : query    maxOrderNo = " + maxOrderNo );
		log.debug("SysDictionaryServiceImpl.getMaxOrderNo  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return maxOrderNo;
	}
}
