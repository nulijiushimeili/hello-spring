package spring.test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import spring.model.Group;
import spring.model.HelloSpring;
import spring.model.User;

public class SpringTest {

    private static Logger logger = LogManager.getLogger(Test.class.getName());

    // 这是以前创建对象的方式
    @Test
    public void test01(){
        HelloSpring hs = new HelloSpring();
        System.out.println(hs.getName());
    }

    /**
     *     使用spring的bean创建对象,
     */
    @Test
    public void test02(){
        // 加载sprannotation.xml
        BeanFactory factory = new ClassPathXmlApplicationContext("/spring.xml");
        logger.info("config loaded complete!");

        // 获取bean
        HelloSpring hs = (HelloSpring)factory.getBean("helloSpring");
        logger.info("create class success.");
        System.out.println(hs.getName());


        HelloSpring hs2 = factory.getBean("helloSpring",HelloSpring.class);
        System.out.println(hs2.getName());

        // 默认spring创建的对象是单例的
        System.out.println(hs.equals(hs2));  // true
    }

    /**
     * 测试集合注入
     */
    @Test
    public void test03(){
        BeanFactory factory = new ClassPathXmlApplicationContext("/spring.xml");
        User user = factory.getBean("user",User.class);

        for(String name : user.getNames()){
            System.out.println(name);
        }
    }

    /**
     * 测试集合注入
     */
    @Test
    public void test04(){
        BeanFactory factory = new ClassPathXmlApplicationContext("/spring.xml");

        logger.info("create class instance ...");
        Group group1 = factory.getBean("group1" , Group.class);
        Group group2 = factory.getBean("group2" , Group.class);
        Group group3 = factory.getBean("group3" , Group.class);
        User user = factory.getBean("user" ,User.class);

        logger.info("======== list 注入 test ...");
        for(Group group : user.getGroupList()){
            System.out.println(group.getId() + "-----------" + group.getName());
        }
        System.out.println("--------------------------------------");

        logger.info("======== set 注入 test ");
        for(Group group : user.getSets()){
            System.out.println(group.getId() + "-----------" + group.getName());
        }
        System.out.println("--------------------------------------");

        logger.info("========== hashmap 注入 test ...");
        for(String tag : user.getHashMap().keySet()){
            System.out.println(tag + "-----------" + user.getHashMap().get(tag).getId() +" ---------  " + user.getHashMap().get(tag).getName());
        }
    }

    @Test
    public void test05(){
        BeanFactory factory = new ClassPathXmlApplicationContext("/spring.xml");
        HelloSpring helloSpring = factory.getBean("helloSpring",HelloSpring.class);
        for(String name : helloSpring.getUser().getNames()){
            System.out.println(name);
        }
    }

}
