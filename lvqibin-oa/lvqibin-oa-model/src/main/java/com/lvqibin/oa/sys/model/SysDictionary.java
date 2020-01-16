package com.lvqibin.oa.sys.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据字典主表
 * </p>
 *
 * @author shiyongbiao
 * @since 2019-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysDictionary extends Model<SysDictionary> {

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
     * 类别
     */
    private String type;

    /**
     * 编码
     */
    private String code;

    /**
     * 顺序
     */
    private String orderNo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否可用编码(1可用，0不可用)
     */
    private String enabledCode;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
