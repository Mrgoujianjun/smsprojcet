package com.gou.springcloud.nacosprovider.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author goujianjun
 * @date 2019-06-10 15:53
 */
@Data
@Table(name = "t_user")
@Alias(value = "userInfo")
public class UserInfo {
    private String id;
    private String userName;
    private String loginName;
    @JSONField(serialize = false)
    private String loginPassword;
    private String phone;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private Integer status;
    private String version;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;
}
