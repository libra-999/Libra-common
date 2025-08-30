package org.project.commons.utils.page;

import com.github.pagehelper.PageHelper;

import org.project.commons.core.page.PageDomain;
import org.project.commons.core.page.TableSupport;

public class PageUtils extends PageHelper
{

    public static void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        Boolean reasonable = pageDomain.getReasonable();
        PageHelper.startPage(pageNum, pageSize, "asc").setReasonable(reasonable);
    }

    public static void clearPage()
    {
        PageHelper.clearPage();
    }
}
