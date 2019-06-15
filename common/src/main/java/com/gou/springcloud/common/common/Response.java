package com.gou.springcloud.common.common;

import com.gou.springcloud.common.context.ContextInfo;
import lombok.Data;

/**
 * @author goujianjun
 * @date 2019-06-04 15:51
 */
@Data
public class Response {
    private String code;
    private String message;
    private String context;

    public Response buildResponse(String code) {
        switch (code) {
            case "200":
                this.code = code;
                this.message = ContextInfo.SUCCESS_MESSAGE;
                break;
            case "401":
                this.code = code;
                this.message = ContextInfo.FAILD_MESSAGE;
            default:
                break;
        }
        return this;
    }

    public Response buildResponse(String code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }
}
