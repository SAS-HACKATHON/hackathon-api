package com.sofrecom.hackathon.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sofrecom.hackathon.model.Article;
import com.sofrecom.hackathon.service.ArticleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = { "Articles" })
public class ArticleController extends BaseController{
	
	@Autowired
	ArticleService  articleService;
	
	@ApiOperation(value = "Gets All Articles")
	@RequestMapping(value = "/articles", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<Article>> getAllArticles() {

		return new ResponseEntity<>(articleService.findAll(), HttpStatus.OK);

	}
	
	
	@ApiOperation(value = "Add new Article")
	@RequestMapping(value = "/article/add", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<Article> addNewCategory(@RequestBody Article article, HttpServletRequest req) {
		boolean articleAddSuccess = articleService.insertOrSaveUser(article);
		if (articleAddSuccess == true) {
			return new ResponseEntity<>(article, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(article, HttpStatus.FAILED_DEPENDENCY);
		}

	}
	

	@SuppressWarnings("null")
	@ApiOperation(value = "get articles by category", notes = "", response = Article.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Article.class) })
	@RequestMapping(value = "/category/{id}/articles", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Article>> articlesByCategory(@ApiParam(value = "article id ", required = true) @PathVariable("id") Integer id) {

		List<Article> articles = articleService.findByCategory(id);
		
		if (articles != null || !articles.isEmpty()) {
			return new ResponseEntity<>(articles, HttpStatus.OK);
		}
		
		else {
			return  new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}

		

	}
	
	
	

}
