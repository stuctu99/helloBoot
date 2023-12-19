package com.bs.firstboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ViewTestController {

	@Value("${linux.home}")
	private String homeDir;
	
	@Value("${linux.url}")
	private String url;
	
	@Value("${window.javahome}")
	private String path;
	
	@GetMapping("/valuetest")
	@ResponseBody
	public List<String> ymlData(){
		log.debug(homeDir);
		log.debug(url);
		log.debug(path);
		return List.of(homeDir,url, path);
	}
	
//	@GetMapping("/")
//	public String index() {
//		return "index";
//	}
//	
//	@GetMapping("/board/boardList")
//	public String boardmain() {
//		return "/board/boardList";
//	}
}
