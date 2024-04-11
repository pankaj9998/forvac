package com.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Image;



public interface ImageRepository extends JpaRepository<Image, Long> {

	boolean existsByCategoryNameAndImageTitle(String categoryName, String imageTitle);

	List<Image> findByCategoryName(String category);

   boolean existsByCategoryNameAndImageName(String categoryName, String imageName);



}
