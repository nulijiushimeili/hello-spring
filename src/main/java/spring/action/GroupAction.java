package spring.action;

import org.springframework.stereotype.Controller;
import spring.model.Group;
import spring.model.User;
import spring.service.IGroupService;
import spring.service.IUserService;

import javax.annotation.Resource;

/**
 * action 层依赖于 service 层
 */
@Controller
public class GroupAction {
//    private IGroupService groupService = new GroupService();

    // 使用spring容器管理就不用new了
    private IGroupService groupService;

    private IUserService userService;

    private User user ;

    public User getUser() {
        return user;
    }

    @Resource
    public void setUser(User user) {
        this.user = user;
    }

    public IUserService getUserService() {
        return userService;
    }

    @Resource
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public IGroupService getGroupService() {
        return groupService;
    }

    @Resource
    public void setGroupService(IGroupService groupService) {
        this.groupService = groupService;
    }

    private Group group;

    public String save(){
        groupService.save(group);
        userService.save(user);
        return "success";
    }

    public void load(){
//        MyLogger.getLogger().info(" invoke groupAction load() ");
        groupService.load();
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
