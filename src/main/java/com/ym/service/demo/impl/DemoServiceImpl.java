package com.ym.service.demo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ym.dao.demo.DemoDao;
import com.ym.entity.demo.Demo;
import com.ym.service.demo.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Resource
	DemoDao demoDao;

	@Override
	public Page<Demo> listPage(String keyword, Pageable pageable) {
		return demoDao.findByNameContainingOrNicknameContaining(keyword, keyword, pageable);
		// return demoDao.myListPage(keyword, pageable);
	}

	@Override
	public List<Demo> list(String name, String nickname) {
		return demoDao.findByNameContainingOrNicknameContaining(name, nickname);
	}

	@Override
	public Demo add(Demo demo) {
		return demoDao.add(demo);
	}

	@Override
	public Demo update(Demo demo) {
		return demoDao.update(demo);
	}

	@Override
	public void delete(Demo demo) {
		demoDao.delete(demo);
	}

	@Override
	public void deleteById(String id) {
		demoDao.delete(id);
	}

}
