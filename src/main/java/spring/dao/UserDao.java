package spring.dao;

import org.springframework.stereotype.Repository;
import spring.model.User;

@Repository
public class UserDao implements IuserDao {
    public void add(User user) {
        System.out.println("添加了 " + user );
    }
}
