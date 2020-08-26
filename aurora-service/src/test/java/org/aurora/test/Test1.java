// Copyright (C) 2017 Meituan
// All rights reserved
package org.aurora.test;

import com.aurora.aop.TargetClass;
import com.aurora.chain.ConcreteChainHandler;
import com.aurora.chain.N2Command;
import com.aurora.dao.AuroraTestDao;
import com.aurora.domain.ContentEvent;
import com.aurora.factory.IFactory;
import com.aurora.po.AuroraTestTablePO;
import com.aurora.service.TemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zhangjian49
 * @version 1.0
 * @date 2017/7/4 下午7:47
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/application*.xml")
public class Test1 {

    @Resource
    private TargetClass targetClass;

    @Resource(name="itemAFactory")
    private IFactory factory;

    @Resource
    private AuroraTestDao auroraTestDao;

    @Resource
    private TemplateService templateService;

    @Test
    public void testGetValue(){
        System.out.println(templateService.getValue());
    }

    @Test
    public void testHello(){
        System.out.println("OK");
    }

    @Test
    public void testDao(){
        AuroraTestTablePO po = new AuroraTestTablePO();
        po.setUserName("111");
        auroraTestDao.insert(po);
    }

    @Test
    public void testASP(){
        targetClass.function();
    }

    @org.junit.Test
    public void testA(){
        factory.createItem().print();
    }

    @org.junit.Test
    public void testB(){
        factory.createItem();
    }

    @org.junit.Test
    public void testC(){
        ConcreteChainHandler concreteChainHandler = new ConcreteChainHandler();
        concreteChainHandler.executeChain(new N2Command());
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testPublishEvent() {
        applicationContext.publishEvent(new ContentEvent("今年是龙年的博客更新了"));
    }
}
