package spring.model;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 集合注入的测试
 */
public class User {
    private String [] names ;

    private List<Group> groupList;

    private Set<Group> sets;

    private HashMap<String,Group> hashMap;

    public Set<Group> getSets() {
        return sets;
    }

    public void setSets(Set<Group> sets) {
        this.sets = sets;
    }

    public HashMap<String, Group> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, Group> hashMap) {
        this.hashMap = hashMap;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }


}
