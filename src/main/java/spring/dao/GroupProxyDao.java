package spring.dao;

import org.springframework.stereotype.Repository;
import spring.model.Group;

import javax.annotation.Resource;

/**
 * 使用静态代理模式添加程序的功能
 * 需要修改之前的引用
 */
@Repository
public class GroupProxyDao implements IGroupDao {
    private IGroupDao groupHibernateDao;

    public IGroupDao getGroupHibernateDao() {
        return groupHibernateDao;
    }

    @Resource
    public void setGroupHibernateDao(IGroupDao groupHibernateDao) {
        this.groupHibernateDao = groupHibernateDao;
    }

    public void add(Group group) {
//        Log.log("执行了新增操作");
        groupHibernateDao.add(group);
    }

    public Group load() {
        return null;
    }
}
