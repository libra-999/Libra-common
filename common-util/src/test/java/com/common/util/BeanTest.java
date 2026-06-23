package com.common.util;

import cn.hutool.core.lang.Assert;
import com.common.commonutil.bean.Bean;
import com.common.util.model.TestDTO;
import com.common.util.model.TestEntity;
import org.junit.jupiter.api.Test;


public class BeanTest {


    @Test
    public void BeanCopy(){
        TestEntity testEntity = new TestEntity();
        TestDTO target = new TestDTO();

        testEntity.setId(1);
        testEntity.setUsername("test");
        testEntity.setGender("M");
        Bean.copyBeanProp(testEntity, target);
        Assert.equals(testEntity.getUsername(), target.getUsername(),"==>Username field copied incorrect");
        Assert.equals(testEntity.getId(), target.getId(),"==>ID field copied incorrect");
        Assert.equals(testEntity.getGender(), target.getGender(),"==>Gender field copied incorrect");

    }

}
