package com.common.commonutil.ip;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.common.commonutil.constant.IPConstant;
import com.common.commonutil.model.DeviceInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeviceFind {

    public static final String WHO_IS = IPConstant.WHO_IS_BASE_URL;

    public static JSONObject findDeviceInfo(String ip) {
        if (Ip.internalIp(ip)) return null;
        try {
            String res = HttpUtil.get(WHO_IS + "/" + ip);
            JSONObject json = JSONUtil.parseObj(res);

            if (StrUtil.isBlankIfStr(json)) {
                return null;
            } else {

                String region = json.get("region").toString();
                String city = json.get("city").toString();
                String latitude = json.get("latitude").toString();
                String longitude = json.get("longitude").toString();
                String country = json.get("country").toString();

                log.info("==> latitude: {}, longitude: {}", latitude, longitude);
                return JSONUtil.parseObj(DeviceInfo.of(city, region, country, latitude, longitude));
            }

        } catch (Exception e) {
            log.error("==> msg: {}", e.getMessage());
        }
        return null;
    }

}
