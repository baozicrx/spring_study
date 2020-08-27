package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description:
 * @Author: crx
 * @Create: 10:24 2020/4/26
 */
@Data
public class ResultDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, Object> data;

    private Integer status;
}
