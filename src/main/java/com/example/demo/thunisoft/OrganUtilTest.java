package com.example.demo.thunisoft;

import org.apache.commons.lang3.StringUtils;

import com.thunisoft.artery.organ.model.IDept;
import com.thunisoft.jcw.base.util.OrganUtil;

/**
 * @Description:
 * @Author: crx
 * @Create: 15:44 2020/9/2
 */
public class OrganUtilTest {
    public static void main(String[] args) {
        OrganUtil.getDept("34000008");

    }

    /**
     * 获取部门名称
     *
     * @param deptId 部门id
     * @return string
     */
    public static String getDeptName(String deptId) {
        String deptName = "";
        if (StringUtils.isNotEmpty(deptId)) {
            System.out.println(OrganUtil.getDept(deptId));
            IDept dept = OrganUtil.getDept(deptId);
            if (dept == null) {
                System.out.println("获取不到对应的部门名称,部门id：{}" + deptId);
                return deptName;
            }
            deptName = dept.getName();
        }
        return deptName;
    }
}
