package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 文书材料的导航接口
 *
 * @author gyj
 * @version v1.0.0
 * @date 2020/1/16 15:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentNavigation {
    /**
     * 阶段名称
     * */
    private String jdmc;
    /**
     * 阶段代码
     * */
    private String jddm;

    /**
     * 文书/材料
     * */
    private List<DocumentFile> wsFile;
}
