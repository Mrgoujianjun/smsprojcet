package com.gou.springcloud.security.model.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-01 21:53
 */
@Data
@Table(name = "t_user")
@Alias(value = "user")
public class User extends BaseDO{
    /**
     * 登录账号
     */
    @NotNull
    private String username;
    /**
     * 登录密码
     */
    @NotNull
    private String password;
    /**
     * 账号状态 0：未激活；1：激活
     */
    private Boolean status;
    /**
     * 版本
     */
    private String version;
    /**
     * 用户是否正常 0：不正常；1：正常
     */
    private Integer flag;
    /**
     * 用户未过期 0：否；1：是
     */
    @Column(name = "is_expired")
    private Boolean expired;
    /**
     * 账号未锁定，0：否；1：是
     */
    @Column(name = "is_locked")
    private Boolean locked;
    /**
     * 用户到期时间
     */
    private String expireTime;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 性别   1、女 2、男
     */
    private Integer sex;
    /**
     * 生日
     */
    private Date birthday;

    /**
     * 生日类型（默认公历） 1：农历生日； 2：公历生日
     */
    private Integer birthdayType;

    /**
     * 联系方式
     */
    private Long phone;
}
