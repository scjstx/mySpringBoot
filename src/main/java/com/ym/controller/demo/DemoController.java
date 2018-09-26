package com.ym.controller.demo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ym.entity.demo.Demo;
import com.ym.model.demo.DemoQueryVO;
import com.ym.model.demo.DemoVO;
import com.ym.service.demo.DemoService;
import com.ym.util.UUIDGenerator;

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

	@RequestMapping("/add")
	@ResponseBody
	private Demo add(@RequestBody DemoVO vo) {
		Demo demo = new Demo();
		BeanUtils.copyProperties(vo, demo);
		demo.setId(UUIDGenerator.generateUUIDStr());
		return demoService.add(demo);
	}

}
