package com.cxx.server.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Project {
    private String projectName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "project_id_seq")
    private Long projectId;

    private String note;
}
