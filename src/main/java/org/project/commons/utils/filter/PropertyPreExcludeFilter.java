package org.project.commons.utils.filter;

import com.alibaba.fastjson2.filter.SimplePropertyPreFilter;

public class PropertyPreExcludeFilter extends SimplePropertyPreFilter
{
    // extract value from token to be safe response API
    public PropertyPreExcludeFilter addExcludes(String... filters)
    {
        for (String filter : filters) {
            this.getExcludes().add(filter);
        }
        return this;
    }
}
