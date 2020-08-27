package com.example.demo.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: crx
 * @Create: 17:33 2019/11/29
 */
@Data
@AllArgsConstructor
public class UmsPermission implements Serializable {
    private Long id;

    private Long pid;

    private String name;

    private String value;

    private String icon;

    private Integer type;

    private String uri;

    private Integer status;

    private Date createTime;

    private Integer sort;

    private static final long serialVersionUID = 1L;

}
