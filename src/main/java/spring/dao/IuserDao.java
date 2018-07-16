package spring.dao;

import spring.annotation.Log;
import spring.model.User;

public interface IuserDao {
    @Log("添加用户")
    void add(User user);
}
