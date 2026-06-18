package org.project.commons.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Getter
@Setter
public class BaseEntity {


    private Integer id;

    @CreatedDate
    private Instant createdAt;

    private Instant updatedAt;

    private Instant deletedAt;

    private String createdBy;

    private String updatedBy;

    private String deletedBy;

}
