package com.gzzz;

import com.gzzz.config.JavaConfig;
import com.gzzz.service.StudentService;
import com.gzzz.service.TopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * projectName: com.atguigu.test
 *
 * description:
 */
@SpringJUnitConfig(JavaConfig.class)
public class TxTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TopService topService;
    @Test
    public void testTx(){
        studentService.changeInfo();
    }

    @Test
    public void test1(){
        topService.topService();
    }
}
