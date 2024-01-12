package com.gzzz.service;

import com.gzzz.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class StudentService {
    
    @Autowired
    private StudentDao studentDao;

    /**
     *  添加事务：
     *      只需要添加@Transactional注解
     *      添加位置：方法/类
     *          加在方法上表示当前方法有事务
     *          加在类上表示类下的所有方法都有事务
     *
     * @Transactional注解的属性：
     *      1.只读模式可以提升查寻事务的效率！ 当事务中只有查询代码时，推荐使用只读模式
     *         boolean readOnly() default false;
     *
     *      2.超时时间
     *         int timeout() default -1; 默认永不超时
     *         设置timeout = 超时秒数
     *         如果超过时间，就会回滚事务并释放TransactionTimedOutException异常
     *         如果类上注解设置了超时时间，方法也设置了@Transactional注解，则超时时间不会生效，因为被方法上的注解覆盖了
     *
     *      3.指定异常回滚和指定异常不回滚：
     *          默认情况下，只有发生运行时异常事务才会回滚
     *          可以通过设置rollbackFor指定Exception异常来控制所有异常都回滚
     *              rollbackFor = Exception.class
     *          也可以设置noRollbackFor 来指定不回滚的异常
     *
     *      4.事务隔离级别: 读未提交、读已提交、可重复读、串行化
     *          推荐设置为第二个级别
     *          isolation = Isolation.READ_COMMITTED 读已提交
     *
     *      5.
     */
    @Transactional(timeout = 3,rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public void changeInfo(){
        studentDao.updateAgeById(88,1);
        // 测试超时回滚
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        // 测试异常回滚
        try {
            new FileInputStream("sss.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();//注意，不能抛出运行时异常，否则默认就会因为是运行时异常而回滚
        }
        System.out.println("-----------");
        studentDao.updateNameById("test2",1);
    }

    @Transactional(readOnly = true)
    public void getStudentInfo() {
        // 获取学生信息  查询数据库 不修改
        // 但是查询方法没有必要添加事务
        // 所以只读模式主要是因为 添加在类上的@Transactional注解会让类下的所有方法都有事务
        // 查询方法可以通过再次添加注解设置为只读模式
    }


    /**
     * 声明两个独立修改数据库的事务业务方法
     *      这两个事务的传播行为不能上面的是Propagation.REQUIRED，下面的是Propagation.REQUIRES_NEW,
     *            这样会因为上面的事务没提交就运行到下面的事务导致进入死锁
     */

    /**
     * 在同一个类中，对于@Transactional注解的方法调用，事务传播行为不会生效。这是因为Spring框架中使用代理模式实现了事务机制，在同一个类中的方法
     * 调用并不经过代理，而是通过对象的方法调用，因此@Transactional注解的设置不会被代理捕获，也就不会产生任何事务传播行为的效果。
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeAge(){
        studentDao.updateAgeById(99,1);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changeName(){
        studentDao.updateNameById("test2",1);
        int i = 1/0;
    }
}
