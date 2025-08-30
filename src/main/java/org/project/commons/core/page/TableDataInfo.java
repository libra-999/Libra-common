package org.project.commons.core.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class TableDataInfo implements Serializable {

    private Integer id;
    private long total;
    private List<?> rows;
    private int code;
    private String msg;

    public TableDataInfo() {

    }

    public TableDataInfo(List<?> list, long total) {
        this.rows = list;
        this.total = total;
    }

}
