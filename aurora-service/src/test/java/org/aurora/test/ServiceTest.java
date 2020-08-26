package org.aurora.test;

import com.aurora.service.TemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/application*.xml")
public class ServiceTest {

    @Resource
    private TemplateService templateService;

    @Test
    public void testHello(){
        System.out.println("OK");
    }


    @Test
    public void testGetValue(){
        System.out.println(templateService.getValue());
    }
}
