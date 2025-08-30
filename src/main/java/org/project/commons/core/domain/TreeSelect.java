package org.project.commons.core.domain;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.project.commons.core.domain.entity.SysDept;
import org.project.commons.core.domain.entity.SysMenu;
import org.project.commons.utils.string.StringUtils;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TreeSelect implements Serializable {

    private Long id;
    private String label;
    private boolean disabled = false;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeSelect> children;

    public TreeSelect(SysDept dept) {
        this.id = dept.getDeptId();
        this.label = dept.getDeptName();
        this.disabled = StringUtils.equals("DEPT_DISABLE", dept.getStatus());
        this.children = dept.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    public TreeSelect(SysMenu menu) {
        this.id = menu.getMenuId();
        this.label = menu.getMenuName();
        this.children = menu.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
    }
}
