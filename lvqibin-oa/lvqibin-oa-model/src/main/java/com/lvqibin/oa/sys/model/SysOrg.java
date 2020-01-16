package com.lvqibin.oa.sys.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 组织机构表
 * </p>
 *
 * @author shiyongbiao
 * @since 2019-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysOrg extends Model<SysOrg> {

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
     * 全路径名
     */
    private String allName;

    /**
     * 全路径ID
     */
    private String allId;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 长名称
     */
    private String longName;

    /**
     * 全路径编码
     */
    private String allCode;

    /**
     * 组织类型
     */
    private String orgKindId;

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
     * 电话
     */
    private String phone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮编
     */
    private String zip;

    /**
     * 描述
     */
    private String description;

    /**
     * 人员
     */
    private String personId;

    /**
     * 节点类型
     */
    private String nodeKind;

    /**
     * 版本
     */
    @Version
    private Integer version;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
