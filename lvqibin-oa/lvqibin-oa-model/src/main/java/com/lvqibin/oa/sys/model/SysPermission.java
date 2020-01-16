package com.lvqibin.oa.sys.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author shiyongbiao
 * @since 2019-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermission extends Model<SysPermission> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 所属角色
     */
    private String roleId;

    /**
     * 描述
     */
    private String description;

    /**
     * 序号
     */
    private Integer sequence;

    /**
     * 可用状态
     */
    private String validState;

    /**
     * 版本
     */
    @Version
    private Integer version;

    /**
     * 菜单ID
     */
    private String menuId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
