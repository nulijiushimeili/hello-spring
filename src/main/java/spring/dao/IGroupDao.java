package spring.dao;

import spring.annotation.Log;
import spring.model.Group;

public interface IGroupDao {
    @Log("执行了添加数据的操作")
    public void add(Group group);
    @Log("加载数据")
    public Group load();
}
