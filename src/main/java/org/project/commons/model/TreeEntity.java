package org.project.commons.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TreeEntity extends BaseEntity
{
    private String parentName;
    private Long parentId;
    private Integer orderNum;
    private String ancestors;
    private List<?> children = new ArrayList<>();

}
