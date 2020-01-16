package com.lvqibin.oa.sys.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author shiyongbiao
 * @since 2019-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 父节点
     */
    private String parent;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 序号
     */
    private String sequence;

    /**
     * 可用状态
     */
    private String validState;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 版本
     */
    @Version
    private Integer version;

    /**
     * 菜单类型PCorAPP
     */
    private String type;

    /**
     * 菜单类型
     */
    private String menuType;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
