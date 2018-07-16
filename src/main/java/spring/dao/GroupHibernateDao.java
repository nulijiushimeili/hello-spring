package spring.dao;

import org.springframework.stereotype.Repository;
import spring.model.Group;

@Repository
public class GroupHibernateDao  implements IGroupDao{

    public void add(Group group) {
//        Log.log("新增日志");
        System.out.println("使用hibernate添加了... ");
    }

    public Group load() {
        return null;
    }
}
