package com.sofrecom.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofrecom.hackathon.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
