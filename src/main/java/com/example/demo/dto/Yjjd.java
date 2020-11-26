package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Yjjd
 * 一级节点
 *
 * @author sucheng-1
 * @version 1.0
 * @date 2020/2/13 13:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Yjjd {
    /**
     * 案件编号
     */
    private String lascdcbh;
    /**
     * 发生时间
     */
    private LocalDateTime fssj;

}
