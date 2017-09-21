package com.sofrecom.hackathon.api;

import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@RequestMapping(path="/api")
@ApiIgnore
public abstract class BaseController {

}
