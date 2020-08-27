package com.example.demo.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: crx
 * @Create: 17:35 2019/11/29
 */
public class UmsPermissionNode extends UmsPermission {
    private List<UmsPermissionNode> children;

    public List<UmsPermissionNode> getChildren() {
        return children;
    }

    public void setChildren(List<UmsPermissionNode> children) {
        this.children = children;
    }

    public UmsPermissionNode(Long id, Long pid, String name, String value, String icon, Integer type, String uri, Integer status, Date createTime, Integer sort, List<UmsPermissionNode> children) {
        super(id, pid, name, value, icon, type, uri, status, createTime, sort);
        this.children = children;
    }
}
