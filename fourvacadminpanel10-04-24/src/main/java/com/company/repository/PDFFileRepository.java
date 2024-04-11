package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.PDFFile;

public interface PDFFileRepository extends JpaRepository<PDFFile, Long> {

}
