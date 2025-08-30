package org.project.commons.core.domain.entity;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.project.commons.annotation.Excel;
import org.project.commons.core.domain.BaseEntity;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class SysRole extends BaseEntity {

    @Excel(name = "角色序号", cellType = Excel.ColumnType.NUMERIC)
    @Id
    private Long roleId;

    @Excel(name = "角色名称")
    private String roleName;

    @Excel(name = "角色权限")
    private String roleKey;

    @Excel(name = "角色排序")
    private Integer roleSort;

    @Excel(name = "数据范围", readConverterExp = "1=所有数据权限,2=自定义数据权限,3=本部门数据权限,4=本部门及以下数据权限,5=仅本人数据权限")
    private String dataScope;
    private boolean menuCheckStrictly;
    private boolean deptCheckStrictly;

    @Excel(name = "角色状态", readConverterExp = "0=正常,1=停用")
    private String status;
    private String delFlag;
    private boolean flag = false;
    private Long[] menuIds;
    private Long[] deptIds;
    private Set<String> permissions;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("roleId", getRoleId())
            .append("roleName", getRoleName())
            .append("roleKey", getRoleKey())
            .append("roleSort", getRoleSort())
            .append("dataScope", getDataScope())
            .append("menuCheckStrictly", isMenuCheckStrictly())
            .append("deptCheckStrictly", isDeptCheckStrictly())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
