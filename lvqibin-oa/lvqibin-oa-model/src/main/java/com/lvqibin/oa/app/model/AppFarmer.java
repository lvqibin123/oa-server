package com.lvqibin.oa.app.model;

import com.baomidou.mybatisplus.annotation.Version;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lvqibin
 * @since 2019-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AppFarmer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 版本
     */
    @Version
    private Integer version;

    /**
     * 姓名
     */
    private String name;

    /**
     * 养户编号
     */
    private String code;

    /**
     * 简称
     */
    private String simpleName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 银行卡号
     */
    private String bankCard;

    /**
     * 家庭住址
     */
    private String familyAddress;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 镇
     */
    private String town;
    /**
     * 村
     */
    private String village;

    /**
     * 县
     */
    private String county;

    /**
     * 猪舍地址（详细）
     */
    private String piggeryAddress;

    /**
     * 猪舍占地面积
     */
    private String area;

    /**
     * 最大养殖规模
     */
    private String maxSize;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 半径范围最大值
     */
    private String maxRadius;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 是否允许登录（1允许登录，其他 不允许登录）
     */
    private Integer isAllowLogin;

    /**
     * 附件
     */
    private String attachment;

    /**
     * 描述
     */
    private String description;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人ID
     */
    private String modifyUseId;

    /**
     * 更新时间
     */
    private LocalDateTime modifyTime;

    /**
     * 登录失败次数
     */
    private Integer loginFailCount;
    
    /**
     * 添加日期
     */
    private LocalDate addDate;


}
