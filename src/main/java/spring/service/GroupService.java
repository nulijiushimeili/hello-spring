package spring.service;

import org.springframework.stereotype.Service;
import spring.dao.IGroupDao;
import spring.model.Group;

import javax.annotation.Resource;

/**
 * service 层依赖于 dao 层
 */
@Service
public class GroupService implements IGroupService {

//    private IGroupDao groupDao = new GroupDao();
    // 使用spring容器管理的话,就不用new了
    private IGroupDao groupDao ;

    public IGroupDao getGroupDao() {
        return groupDao;
    }

//    @Resource(name = "groupProxyDao")
//    @Resource(name = "logDynamicProxy")
    @Resource
    public void setGroupDao(IGroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public void save(Group group) {
        groupDao.add(group);
    }

    public void load(){
        groupDao.load();
    }
}
