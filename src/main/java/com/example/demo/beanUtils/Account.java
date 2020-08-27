package com.example.demo.beanUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;
    private Date createTime;
    private BigDecimal balance;
}