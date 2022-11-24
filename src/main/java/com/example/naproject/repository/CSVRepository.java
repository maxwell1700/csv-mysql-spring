package com.example.naproject.repository;

import com.example.naproject.model.CSVModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CSVRepository extends JpaRepository<CSVModel, Integer> {
}
