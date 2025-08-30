package org.project.commons.utils.ip;

import lombok.extern.slf4j.Slf4j;
import org.project.commons.constant.Constants;
import org.project.commons.utils.string.StringUtils;
import org.project.commons.utils.http.HttpUtils;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

@Slf4j
public class AddressUtils {

    public static final String IP_URL = "http://whois.pconline.com.cn/ipJson.jsp";
    public static final String UNKNOWN = "XX XX";

    public static String getRealAddressByIP(String ip) {
        if (IpUtils.internalIp(ip)) {
            return "内网IP";
        }
        try {
            String rspStr = HttpUtils.sendGet(IP_URL, "ip=" + ip + "&json=true", Constants.GBK);
            if (StringUtils.isEmpty(rspStr)) {
                log.error("Get geographic location exception {}", ip);
                return UNKNOWN;
            }
            JSONObject obj = JSON.parseObject(rspStr);
            String region = obj.getString("pro");
            String city = obj.getString("city");
            return String.format("%s %s", region, city);
        } catch (Exception e) {
            log.error("Get geographic location exception {}", ip);
        }
        return UNKNOWN;
    }
}
