package com.ym.dao.demo.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ym.entity.demo.Demo;

public interface JpaDemoDao {
	
	Page<Demo> myListPage(String keyword, Pageable pageable);
	
}
