package com.sofrecom.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofrecom.hackathon.model.Category;
import com.sofrecom.hackathon.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	CategoryRepo categoryRepo;

	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

}
