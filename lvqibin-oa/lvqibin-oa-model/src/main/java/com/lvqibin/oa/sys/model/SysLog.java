package com.lvqibin.oa.sys.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 日志表
 * </p>
 *
 * @author shiyongbiao
 * @since 2019-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysLog extends Model<SysLog> {

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
    private String typeName;

    /**
     * 描述
     */
    private String description;

    /**
     * 操作者ID
     */
    private String creatorId;

    /**
     * 操作时间
     */
    private LocalDateTime creatorTime;

    /**
     * 过程
     */
    private String process;

    /**
     * 过程
     */
    private String processName;

    /**
     * 环节
     */
    private String activity;

    /**
     * 环节
     */
    private String activityName;

    /**
     * 动作名称
     */
    private String actionName;

    /**
     * 动作
     */
    private String action;

    /**
     * 操作状态
     */
    private String status;

    /**
     * 参数
     */
    private String parameters;

    /**
     * 结果
     */
    private String result;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 终端类型
     */
    private String deviceType;

    /**
     * 操作系统
     */
    private String operatingSystem;

    /**
     * 备注 
     */
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
