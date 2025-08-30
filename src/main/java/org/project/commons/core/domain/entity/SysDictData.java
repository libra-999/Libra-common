package org.project.commons.core.domain.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.project.commons.annotation.Excel;
import org.project.commons.core.domain.BaseEntity;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@AllArgsConstructor(staticName = "of")
@Builder
public class SysDictData extends BaseEntity
{
    @Id
    private Integer id;

    @Excel(name = "字典编码", cellType = Excel.ColumnType.NUMERIC)
    private Long dictCode;

    @Excel(name = "字典排序", cellType = Excel.ColumnType.NUMERIC)
    private Long dictSort;

    @Excel(name = "字典标签")
    private String dictLabel;

    @Excel(name = "字典键值")
    private String dictValue;

    @Excel(name = "字典类型")
    private String dictType;

    private String cssClass;

    private String listClass;

    @Excel(name = "是否默认", readConverterExp = "Y=是,N=否")
    private String isDefault;

    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dictCode", getDictCode())
            .append("dictSort", getDictSort())
            .append("dictLabel", getDictLabel())
            .append("dictValue", getDictValue())
            .append("dictType", getDictType())
            .append("cssClass", getCssClass())
            .append("listClass", getListClass())
            .append("isDefault", getIsDefault())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
