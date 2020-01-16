package com.lvqibin.oa.sys.service.impl;

import com.lvqibin.oa.sys.model.SysDictionary;
import com.lvqibin.oa.sys.model.SysDictionaryDetail;
import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.sys.dao.SysDictionaryDetailMapper;
import com.lvqibin.oa.sys.dao.SysDictionaryMapper;
import com.lvqibin.oa.sys.service.SysDictionaryService;
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
 * 数据字典主表 服务实现类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
@Service
public class SysDictionaryServiceImpl extends ServiceImpl<SysDictionaryMapper, SysDictionary> implements SysDictionaryService {

	@Autowired
	private SysDictionaryDetailMapper detailMapper;
	
	public DataAngularResult<SysDictionary> searchByPage(Integer page, Integer pagesize, String keyWord) {
		// TODO Auto-generated method stub
		log.debug("SysDictionaryServiceImpl.searchByPage  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        log.debug("Param :  page = " + page );
        log.debug("Param :  pagesize = " + pagesize );
        log.debug("Param :  keyWord = " + keyWord );
        DataAngularResult<SysDictionary> ds = null;
        if (page!=null && pagesize!=null) {
            PageHelper.startPage(page, pagesize);
            QueryWrapper<SysDictionary> wrapper = new QueryWrapper<SysDictionary>();
            if (StringUtils.isNotEmpty(keyWord)) {
            	wrapper.like(true, "type", keyWord);
            }
            wrapper.orderBy(true, true, " order_no ");
            List<SysDictionary> list = baseMapper.selectList(wrapper);
            PageInfo<SysDictionary> pageInfo = new PageInfo<SysDictionary>(list);
            ds = new DataAngularResult<SysDictionary>(pageInfo.getTotal(), list);
        }
        log.debug(" ds = " + ds.toString());
        log.debug("SysDictionaryServiceImpl.searchByPage  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
        return ds;
	}

	public long getMaxOrderNo() {
		// TODO Auto-generated method stub
		log.debug("SysDictionaryServiceImpl.getMaxOrderNo  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		long maxOrderNo =  baseMapper.getMaxOrderNo();
		log.debug("action  : query    maxOrderNo = " + maxOrderNo );
		log.debug("SysDictionaryServiceImpl.getMaxOrderNo  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return maxOrderNo;
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delWhithDetailById(String id) throws Exception {
		// TODO Auto-generated method stub
		log.debug("SysDictionaryServiceImpl.delWhithDetailById  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
		int delSum = 0;
		log.debug("Param :  id = " + id );
		if (StringUtils.isNotEmpty(id)) {
			try {
				delSum =  baseMapper.deleteById(id) + detailMapper.delete(new QueryWrapper<SysDictionaryDetail>().eq(true, "main_id", id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
		} else {
			delSum = 0 ;
		}
		log.debug("action  : del    delSum = " + delSum );
		log.debug("SysDictionaryServiceImpl.delWhithDetailById  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" );
		return delSum;
	}

}
