package spring.dao;

import org.springframework.stereotype.Repository;
import spring.model.Group;

@Repository
public class GroupDao  implements  IGroupDao{

    public void add(Group group) {
        System.out.println("添加了group");
    }

    public Group load() {
        System.out.println("查找到了group");
        return null;
    }
}
