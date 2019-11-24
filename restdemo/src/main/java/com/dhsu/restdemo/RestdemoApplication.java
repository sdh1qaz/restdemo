package com.dhsu.restdemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = {"/api"})
public class RestdemoApplication {

	private static int count_post = 0;//post调用次数
	private static int count_get = 0;//post调用次数
	
	public static void main(String[] args) {
		SpringApplication.run(RestdemoApplication.class, args);
	}
	
	
	@RequestMapping(value = {"/post"}, produces = "application/json;charset=utf-8",consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> post(@RequestBody RequestDto requestDto){
		synchronized (this) {
			count_post += 1;//调用次数加1
		}
		Map<String, String> map = new HashMap<String,String>();
		map.put("输入的name", requestDto.getName());
		map.put("调用时间", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		map.put("已调用次数", String.valueOf(count_post));
		return map;
	}
	
	@RequestMapping(value = {"/get/{name}"}, produces = "application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> get(@PathVariable String name){
		synchronized (this) {
			count_get += 1;//调用次数加1
		}
		Map<String, String> map = new HashMap<String,String>();
		map.put("输入的name", name);
		map.put("调用时间", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		map.put("已调用次数", String.valueOf(count_get));
		return map;
	}

}
