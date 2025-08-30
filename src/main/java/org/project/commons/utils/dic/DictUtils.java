package org.project.commons.utils.dic;

import java.util.Collection;
import java.util.List;

import com.alibaba.fastjson2.JSONArray;
import org.project.commons.core.domain.entity.SysDictData;
import org.project.commons.core.redis.RedisCache;
import org.project.commons.utils.string.StringUtils;
import org.project.commons.utils.spring.SpringUtils;

public class DictUtils {

    public static final String SEPARATOR = ",";

    public static void setDictCache(String key, List<SysDictData> dictDatas) {
        SpringUtils.getBean(RedisCache.class).setCacheObject(getCacheKey(key), dictDatas);
    }

    public static List<SysDictData> getDictCache(String key) {
        JSONArray arrayCache = JSONArray.of(SpringUtils.getBean(RedisCache.class).getCacheObject(getCacheKey(key)));
        return arrayCache.toList(SysDictData.class);
    }

    public static String getDictLabel(String dictType, String dictValue) {
        if (StringUtils.isEmpty(dictValue)) {
            return StringUtils.EMPTY;
        }
        return getDictLabel(dictType, dictValue, SEPARATOR);
    }

    public static String getDictValue(String dictType, String dictLabel) {
        if (StringUtils.isEmpty(dictLabel)) {
            return StringUtils.EMPTY;
        }
        return getDictValue(dictType, dictLabel, SEPARATOR);
    }

    public static String getDictLabel(String dictType, String dictValue, String separator) {
        StringBuilder propertyString = new StringBuilder();
        List<SysDictData> datas = getDictCache(dictType);
        if (StringUtils.isNull(datas)) {
            return StringUtils.EMPTY;
        }
        if (StringUtils.containsAny(separator, dictValue)) {
            for (SysDictData dict : datas) {
                for (String value : dictValue.split(separator)) {
                    if (value.equals(dict.getDictValue())) {
                        propertyString.append(dict.getDictLabel()).append(separator);
                        break;
                    }
                }
            }
        } else {
            for (SysDictData dict : datas) {
                if (dictValue.equals(dict.getDictValue())) {
                    return dict.getDictLabel();
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }

    public static String getDictValue(String dictType, String dictLabel, String separator) {
        StringBuilder propertyString = new StringBuilder();
        List<SysDictData> datas = getDictCache(dictType);
        if (StringUtils.isNull(datas)) {
            return StringUtils.EMPTY;
        }
        if (StringUtils.containsAny(separator, dictLabel)) {
            for (SysDictData dict : datas) {
                for (String label : dictLabel.split(separator)) {
                    if (label.equals(dict.getDictLabel())) {
                        propertyString.append(dict.getDictValue()).append(separator);
                        break;
                    }
                }
            }
        } else {
            for (SysDictData dict : datas) {
                if (dictLabel.equals(dict.getDictLabel())) {
                    return dict.getDictValue();
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }

    public static String getDictValues(String dictType) {
        StringBuilder propertyString = new StringBuilder();
        List<SysDictData> datas = getDictCache(dictType);
        if (StringUtils.isNull(datas)) {
            return StringUtils.EMPTY;
        }
        for (SysDictData dict : datas) {
            propertyString.append(dict.getDictValue()).append(SEPARATOR);
        }
        return StringUtils.stripEnd(propertyString.toString(), SEPARATOR);
    }

    public static String getDictLabels(String dictType) {
        StringBuilder propertyString = new StringBuilder();
        List<SysDictData> datas = getDictCache(dictType);
        if (StringUtils.isNull(datas)) {
            return StringUtils.EMPTY;
        }
        for (SysDictData dict : datas) {
            propertyString.append(dict.getDictLabel()).append(SEPARATOR);
        }
        return StringUtils.stripEnd(propertyString.toString(), SEPARATOR);
    }

    public static void removeDictCache(String key) {
        SpringUtils.getBean(RedisCache.class).delete(getCacheKey(key));
    }

    public static void clearDictCache() {
        Collection<String> keys = SpringUtils.getBean(RedisCache.class).keys("sys_key_config" + "*");
        SpringUtils.getBean(RedisCache.class).deleteObject(keys);
    }

    public static String getCacheKey(String configKey) {
        return "sys_key_config" + configKey;
    }
}
