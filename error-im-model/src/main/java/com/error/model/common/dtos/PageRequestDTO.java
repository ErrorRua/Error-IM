package com.error.model.common.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 分页查询参数
 * 查询频道列表   频道名称  page   size
 *                      page   size
 *
 */
@Data
@Slf4j
public class PageRequestDTO {
    @Schema(name="当前页",requiredMode = Schema.RequiredMode.REQUIRED)
    protected Integer size;
    @Schema(name="每页显示条数",requiredMode = Schema.RequiredMode.REQUIRED)
    protected Integer page;


    public void checkParam() {
        if (this.page == null || this.page <= 0) {
            setPage(1);
        }
        if (this.size == null || this.size <= 0 || this.size > 100) {
            setSize(10);
        }
    }
}
