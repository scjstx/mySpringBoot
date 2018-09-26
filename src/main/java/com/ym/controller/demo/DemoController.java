package com.ym.controller.demo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ym.entity.demo.Demo;
import com.ym.model.demo.DemoQueryVO;
import com.ym.service.demo.DemoService;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@Resource
	DemoService demoService;

	@RequestMapping("/listPage")
	@ResponseBody
	private Page<Demo> listPage(@RequestBody DemoQueryVO vo) {
		return demoService.listPage(vo.getKeyword(), vo.getQueryPage().createPageable());
	}

	@RequestMapping("/list")
	@ResponseBody
	private List<Demo> list(@RequestBody DemoQueryVO vo) {
		return demoService.list(vo.getKeyword(), vo.getKeyword());
	}
}
