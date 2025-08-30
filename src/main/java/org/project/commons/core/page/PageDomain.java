package org.project.commons.core.page;

import lombok.Getter;
import lombok.Setter;
import org.project.commons.utils.string.StringUtils;

@Getter
@Setter
public class PageDomain
{

    private Integer pageNum;
    private Integer pageSize;
    private String orderByColumn;
    private String isAsc = "asc";
    private Boolean reasonable = true ;

    public String getOrderBy()
    {
        if (StringUtils.isEmpty(orderByColumn)) return "";
        return StringUtils.toUnderScoreCase(orderByColumn) + " " + isAsc;
    }

    public void setIsAsc(String isAsc)
    {
        if (StringUtils.isNotEmpty(isAsc))
        {
            if ("ascending".equals(isAsc))
            {
                isAsc = "asc";
            }
            else if ("descending".equals(isAsc))
            {
                isAsc = "desc";
            }
            this.isAsc = isAsc;
        }
    }

    public Boolean getReasonable()
    {
        if (StringUtils.isNull(reasonable)) return true;
        return reasonable;
    }

}
