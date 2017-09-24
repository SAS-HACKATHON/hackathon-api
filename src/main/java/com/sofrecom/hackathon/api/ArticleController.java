package com.sofrecom.hackathon.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sofrecom.hackathon.ArticleNotificationHandler;
import com.sofrecom.hackathon.model.Article;
import com.sofrecom.hackathon.service.ArticleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = { "Articles" })
public class ArticleController extends BaseController {

	public final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	ArticleService articleService;

	@Autowired
    ArticleNotificationHandler articleNotificationHandler;
	
	@ApiOperation(value = "Gets All Articles")
	@RequestMapping(value = "/articles", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<Article>> getAllArticles() {
		articleNotificationHandler.createArticleCallback(articleService.findAll().get(0));
		return new ResponseEntity<>(articleService.findAll(), HttpStatus.OK);

	}

	@ApiOperation(value = "Add new Article")
	@RequestMapping(value = "/article/add", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<Article> addNewCategory(@RequestBody Article article, HttpServletRequest req) {
		boolean articleAddSuccess = articleService.insertOrSaveArticle(article);
		if (articleAddSuccess == true) {
			articleNotificationHandler.createArticleCallback(article);
			return new ResponseEntity<>(article, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(article, HttpStatus.NOT_FOUND);
		}

	}

	@ApiOperation(value = "get articles by category", notes = "", response = Article.class)
	@RequestMapping(value = "/category/{id}/articles", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Article>> articlesByCategory(
			@ApiParam(value = "article id ", required = true) @PathVariable("id") Integer id) {

		List<Article> articles = articleService.findByCategory(id);

		if (articles != null || !articles.isEmpty()) {
			return new ResponseEntity<>(articles, HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}

	}

	@ApiOperation(value = "get articles by category", notes = "", response = Article.class)
	@RequestMapping(value = "/articles/{type}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Article>> articlesByType(
			@ApiParam(value = "article id ", required = true) @PathVariable("type") String type) {

		List<Article> articles = articleService.findByType(type);

		if (articles != null || !articles.isEmpty()) {
			return new ResponseEntity<>(articles, HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}

	}

	@ApiOperation(value = "update  article")
	@RequestMapping(value = "/article/update", method = RequestMethod.PUT, produces = { "application/json" })
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {

		boolean articleAddSuccess = articleService.insertOrSaveArticle(article);

		if (articleAddSuccess == true) {
			return new ResponseEntity<>(article, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(article, HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "delete  article")
	@RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteArticle(@PathVariable("id") Integer id) {

		Article article = articleService.findById(id);
		if (article == null) {
			logger.error("Unable to delete. Article with id {} not found.", id);
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		articleService.deleteArticle(article);
		return new ResponseEntity<Article>(HttpStatus.NO_CONTENT);
	}
	
	
	@SubscribeMapping("/topic/chart/{aa}")
	@SendTo("/topic/chart/{aa}")
	@CrossOrigin(value="*")
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void sendNotification(@DestinationVariable("aa") int aa) {
		System.out.println(aa);
	}

}
