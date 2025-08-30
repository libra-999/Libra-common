package org.project.commons.core.domain.entity;

import java.util.Date;
import java.util.List;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.project.commons.annotation.Excel;
import org.project.commons.annotation.Excels;
import org.project.commons.core.domain.BaseEntity;
import org.project.commons.enums.BusinessType;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
@Builder
public class SysUser extends BaseEntity {

    @Id
    @Excel(name = "用户序号", type = BusinessType.EXPORT, cellType = Excel.ColumnType.NUMERIC, prompt = "用户编号")
    private Long userId;

    @Excel(name = "部门编号", type = BusinessType.IMPORT)
    private Long deptId;

    @Excel(name = "登录名称")
    private String userName;

    @Excel(name = "用户名称")
    private String nickName;

    @Excel(name = "用户邮箱")
    private String email;

    @Excel(name = "手机号码", cellType = Excel.ColumnType.TEXT)
    private String phonenumber;

    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    private String avatar;

    private String password;

    @Excel(name = "账号状态", readConverterExp = "0=正常,1=停用")
    private String status;

    private String delFlag;

    @Excel(name = "最后登录IP", type = BusinessType.EXPORT)
    private String loginIp;

    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = BusinessType.EXPORT)
    private Date loginDate;

    private Date pwdUpdateDate;

    @Excels({
        @Excel(name = "部门名称", targetAttr = "deptName", type = BusinessType.EXPORT),
        @Excel(name = "部门负责人", targetAttr = "leader", type = BusinessType.EXPORT)
    })
    private SysDept dept;

    private List<SysRole> roles;

    private Long[] roleIds;

    private Long[] postIds;

    private Long roleId;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("userName", getUserName())
            .append("nickName", getNickName())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("sex", getSex())
            .append("avatar", getAvatar())
            .append("password", getPassword())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("loginIp", getLoginIp())
            .append("loginDate", getLoginDate())
            .append("pwdUpdateDate", getPwdUpdateDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("dept", getDept())
            .toString();
    }
}
