package com.example.demo.beanUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Integer id;
    private String createTime;
    private BigDecimal balance;
}