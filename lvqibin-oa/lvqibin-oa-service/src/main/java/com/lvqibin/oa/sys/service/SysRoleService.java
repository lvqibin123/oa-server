package com.lvqibin.oa.sys.service;

import com.lvqibin.oa.common.DataAngularResult;
import com.lvqibin.oa.sys.model.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-02
 */
public interface SysRoleService extends IService<SysRole> {

	  /**
   * date:2019-12-13
      * 分页查询 授权
   * @param page 页码
   * @param  pagesize 条数
   * @param  keyWord 关键字搜索 可以为空
   * */
	public DataAngularResult<SysRole> searchByPage( Integer page, Integer pagesize,String keyWord);
	
	/**
     *  根据sys_role的主键id删除sys_role 和 sys_permission 中的数据
     *  date 2019-01-18
     *@author lvqibin
     *@param id  sys_role的主键id
     *@return JsonObject  json对象
     */
	int delRoleAndPermissionById(String id) throws Exception;
	
	
	/**
     *  通过orgID获取该节点未分配的角色列表
     *  date 2019-01-19
     *@author lvqibin
     *@param pagenum  当前页面
     *@param pagesize 分页条数
     *@param orgID  组织ID
     *@param keyworlds 查询的关键字
     *@return DataAngularResult<SysRole> 
     */
	
	DataAngularResult<SysRole> queryNotRolePage(int pagenum, int pagesize, String orgID , String keyworlds);
}
