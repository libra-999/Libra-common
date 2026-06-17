package org.project.commons.core.domain;

import java.util.HashMap;
import java.util.Objects;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.project.commons.constant.HttpStatus;
import org.project.commons.utils.string.StringUtils;

@EqualsAndHashCode(callSuper = false)
@Data
public class Resp extends HashMap<String, Object> {

    public static final String CODE_TAG = "code";
    public static final String MSG_TAG = "msg";
    public static final String DATA_TAG = "data";

    public Resp(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    public Resp(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    public static Resp success() {
        return Resp.success("Operation is successful");
    }
    public static Resp success(Object data) {
        return Resp.success("Operation is successful", data);
    }
    public static Resp success(String msg) {
        return Resp.success(msg, null);
    }
    public static Resp success(String msg, Object data) {
        return new Resp(HttpStatus.SUCCESS, msg, data);
    }
    public static Resp warn(String msg) {
        return Resp.warn(msg, null);
    }
    public static Resp warn(String msg, Object data) {
        return new Resp(HttpStatus.WARN, msg, data);
    }
    public static Resp error() {
        return Resp.error("Operation failed");
    }
    public static Resp error(String msg) {
        return Resp.error(msg, null);
    }
    public static Resp error(String msg, Object data) {
        return new Resp(HttpStatus.ERROR, msg, data);
    }
    public static Resp error(int code, String msg) {
        return new Resp(code, msg, null);
    }

    public boolean isSuccess() {
        return Objects.equals(HttpStatus.SUCCESS, this.get(CODE_TAG));
    }
    public boolean isWarn() {
        return Objects.equals(HttpStatus.WARN, this.get(CODE_TAG));
    }
    public boolean isError() {
        return Objects.equals(HttpStatus.ERROR, this.get(CODE_TAG));
    }

    @Override
    public Resp put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
