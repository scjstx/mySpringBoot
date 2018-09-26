package com.ym.service.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ym.entity.demo.Demo;

public interface DemoService {
	
	Page<Demo> listPage(String keyword, Pageable pageable);
	
	List<Demo> list(String name, String nickname);
	
	Demo add(Demo demo);
	
	Demo update(Demo demo);
	
	void delete(Demo demo);
	
	void deleteById(String id);
	
}
