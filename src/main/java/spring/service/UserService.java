package spring.service;

import org.springframework.stereotype.Service;
import spring.dao.IuserDao;
import spring.model.User;

import javax.annotation.Resource;

@Service
public class UserService implements IUserService{
    private IuserDao userDao;
    public void save(User user) {
        userDao.add(user);
    }

    public IuserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(IuserDao userDao) {
        this.userDao = userDao;
    }
}
