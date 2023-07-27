package com.cxx.server.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "source_id_seq")
    private Long id;

    private String name;

    private String projectId;

    private String type;

    private String connStr;

    private String note;
}
