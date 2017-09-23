package com.sofrecom.hackathon.api;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(tags = { "Articles" })
public class ArticleController extends BaseController{

}
