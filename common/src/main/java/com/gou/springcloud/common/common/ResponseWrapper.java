package com.gou.springcloud.common.common;

import com.gou.springcloud.common.bean.GlobalConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author goujianjun
 * @date 2019-07-24 15:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseWrapper {
    private Integer code;
    private String message;

    public static ResponseWrapper ok() {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode(GlobalConstant.SUCCESS_CODE);
        responseWrapper.setMessage(GlobalConstant.SUCCESS_MESSAGE);
        return responseWrapper;
    }

    public static ResponseWrapper wrap(Integer code, String message) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setCode(code);
        responseWrapper.setMessage(message);
        return responseWrapper;
    }

}
