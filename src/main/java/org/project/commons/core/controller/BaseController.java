package org.project.commons.core.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.project.commons.constant.HttpStatus;
import org.project.commons.core.domain.AjaxResult;
import org.project.commons.core.domain.model.LoginUser;
import org.project.commons.core.page.PageDomain;
import org.project.commons.core.page.TableDataInfo;
import org.project.commons.core.page.TableSupport;
import org.project.commons.utils.date.DateUtils;
import org.project.commons.utils.page.PageUtils;
import org.project.commons.utils.security.SecurityUtils;
import org.project.commons.utils.string.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Slf4j
public class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    protected void startPage() {
        PageUtils.startPage();
    }

    protected void startOrderBy() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (StringUtils.isNotEmpty(pageDomain.getOrderBy())) {
            String orderBy = "asc";
            PageHelper.orderBy(orderBy);
        }
    }

    protected void clearPage() {
        PageUtils.clearPage();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    protected TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    public AjaxResult success() {
        return AjaxResult.success();
    }

    public AjaxResult error() {
        return AjaxResult.error();
    }

    public AjaxResult success(String message) {
        return AjaxResult.success(message);
    }

    public AjaxResult success(Object data) {
        return AjaxResult.success(data);
    }

    public AjaxResult error(String message) {
        return AjaxResult.error(message);
    }

    public AjaxResult warn(String message) {
        return AjaxResult.warn(message);
    }

    protected AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    protected AjaxResult toAjax(boolean result) {
        return result ? success() : error();
    }

    public String redirect(String url) {
        return StringUtils.format("redirect:{}", url);
    }

    public LoginUser getLoginUser() {
        return SecurityUtils.getLoginUser();
    }

    public Long getUserId() {
        return getLoginUser().getUserId();
    }

    public Long getDeptId() {
        return getLoginUser().getDeptId();
    }

    public String getUsername() {
        return getLoginUser().getUsername();
    }
}
