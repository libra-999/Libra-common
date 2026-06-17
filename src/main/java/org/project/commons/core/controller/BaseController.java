package org.project.commons.core.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.project.commons.constant.HttpStatus;
import org.project.commons.core.domain.Resp;
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

    public Resp success() {
        return Resp.success();
    }

    public Resp error() {
        return Resp.error();
    }

    public Resp success(String message) {
        return Resp.success(message);
    }

    public Resp success(Object data) {
        return Resp.success(data);
    }

    public Resp error(String message) {
        return Resp.error(message);
    }

    public Resp warn(String message) {
        return Resp.warn(message);
    }

    protected Resp toAjax(int rows) {
        return rows > 0 ? Resp.success() : Resp.error();
    }

    protected Resp toAjax(boolean result) {
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
