package com.example.demo.study;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: crx
 * @Create: 17:07 2019/10/29
 */
@Data
public class TreeNode {
    protected int id;
    protected int parentId;
    protected List<TreeNode> children = new ArrayList<TreeNode>();

    public void add(TreeNode node) {
        children.add(node);
    }
}
