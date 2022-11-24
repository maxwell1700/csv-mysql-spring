package com.example.naproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CSVModel {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "filename")
    private String filename;
    @Column(name = "origin")
    private String origin;
    @Column(name = "metadata")
    private String metadata;
    @Column(name = "hash")
    private String hash;

}

