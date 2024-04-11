package com.company.repository;

import com.company.entity.ProductImg;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImgRepository extends JpaRepository<ProductImg, Long> {

	Optional<ProductImg> findById(Long id);

	void deleteById(Long id);
}
