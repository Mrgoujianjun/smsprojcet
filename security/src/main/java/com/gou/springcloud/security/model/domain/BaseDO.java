package com.gou.springcloud.security.model.domain;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author goujianjun
 * @email lygoujianjun@163.com
 * @date 2020-03-01 21:54
 */
@Data
public class BaseDO {
    @Id
    private String id;
    private Date createTime;
    private Date modifyTime;
    private String note;
}
