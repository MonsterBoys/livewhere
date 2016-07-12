package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;

import java.util.List;

public class GroupEntity {
    private String parent_name;
    private List<ChildEntity> children;

    public GroupEntity(String parent_name, List<ChildEntity> children) {
        this.parent_name = parent_name;
        this.children = children;
    }

    public GroupEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public List<ChildEntity> getChildren() {
        return children;
    }

    public void setChildren(List<ChildEntity> children) {
        this.children = children;
    }
}
