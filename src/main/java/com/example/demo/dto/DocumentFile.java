package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class DocumentFile {
    /**
     * 文书材料id
     * */
    private String wsclid;
    /**
     * 路径
     * */
    private String path;
}
