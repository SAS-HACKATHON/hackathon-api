package com.sofrecom.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofrecom.hackathon.repository.ArticleRepo;

@Service
public class ArticleService {

	@Autowired
	ArticleRepo articleRepo;
}
