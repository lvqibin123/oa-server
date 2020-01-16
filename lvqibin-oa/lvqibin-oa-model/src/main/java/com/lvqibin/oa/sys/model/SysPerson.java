package com.lvqibin.oa.sys.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import java.sql.Blob;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 人员表
 * </p>
 *
 * @author shiyongbiao
 * @since 2019-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPerson extends Model<SysPerson> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 数字编号
     */
    private Integer numb;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码(MD5)
     */
    private String password;

    /**
     * 密码时限（天）
     */
    private Integer passwordTimeLimit;

    /**
     * 密码修改时间
     */
    private LocalDateTime passwordModifyTime;

    /**
     * 所属部门
     */
    private String mainOrgId;

    /**
     * 密级
     */
    private String safeLevelId;

    /**
     * 序号
     */
    private Integer sequence;

    /**
     * 可用状态
     */
    private String validState;

    /**
     * 描述
     */
    private String description;

    /**
     * 照片
     */
    private String photo;

    /**
     * 照片修改时间
     */
    private LocalDateTime photoLastModified;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 参加工作日期
     */
    private LocalDate joinDate;

    /**
     * 出生地
     */
    private String homePlace;

    /**
     * 国家
     */
    private String country;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 学历
     */
    private String degree;

    /**
     * 毕业院校
     */
    private String graduateSchool;

    /**
     * 专业
     */
    private String speciality;

    /**
     * 学年制
     */
    private String schoolLength;

    /**
     * 职称
     */
    private String title;

    /**
     * 婚姻状况
     */
    private String marriage;

    /**
     * 证件号码
     */
    private String cardNo;

    /**
     * 证件类型
     */
    private String cardKind;

    /**
     * 家庭住址
     */
    private String familyAddress;

    /**
     * 邮编
     */
    private String zip;

    /**
     * MSN
     */
    private String msn;

    /**
     * QQ
     */
    private String qq;

    /**
     * 电子邮件
     */
    private String mail;

    /**
     * 移动电话
     */
    private String mobilePhone;

    /**
     * 家庭电话
     */
    private String familyPhone;

    /**
     * 办公电话
     */
    private String officePhone;

    /**
     * 英文名称
     */
    private String englishName;

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
