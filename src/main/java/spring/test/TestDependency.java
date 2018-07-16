package spring.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import spring.action.GroupAction;
import spring.model.User;

public class TestDependency {
    @Test
    public void test01(){
        BeanFactory factory = new ClassPathXmlApplicationContext("/spring.xml");
        GroupAction groupAction = factory.getBean("groupAction" , GroupAction.class);
        groupAction.save();
        groupAction.load();

    }


}
