package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * TAjlc
 *
 * @author sucheng-1
 */
@Setter
@Getter
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class TAjlc {

    /**
     * FETCH_FIELDS
     */
    private static final String FETCH_FIELDS = "fetchFields";

    /**
     * 编号
     */
    @Column(name = "t_ajlc.c_bh")
    private String cBh;

    /**
     * 案件阶段简拼
     */
    @Column(name = "t_ajlc.c_ajjdjp")
    private String cAjjdjp;

}