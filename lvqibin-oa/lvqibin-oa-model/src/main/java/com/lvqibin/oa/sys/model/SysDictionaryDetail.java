package com.lvqibin.oa.sys.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据字典从表
 * </p>
 *
 * @author shiyongbiao
 * @since 2019-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysDictionaryDetail extends Model<SysDictionaryDetail> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 版本
     */
    @Version
    private Integer version;

    /**
     * 主表ID
     */
    private String mainId;

    /**
     * 名称
     */
    private String name;

    /**
     * 顺序
     */
    private String orderNo;

    /**
     * 是否可用编码(1可用，0不可用)
     */
    private String enabledCode;

    /**
     * 编码
     */
    private String code;

    /**
     * 备注
     */
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
