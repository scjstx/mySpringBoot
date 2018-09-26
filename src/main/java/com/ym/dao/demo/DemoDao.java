package com.ym.dao.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ym.dao.common.BaseDao;
import com.ym.dao.demo.jpa.JpaDemoDao;
import com.ym.entity.demo.Demo;

public interface DemoDao extends BaseDao<Demo>, JpaDemoDao {

	Page<Demo> findByNameContainingOrNicknameContaining(String name, String nickname, Pageable pageable);

	List<Demo> findByNameContainingOrNicknameContaining(String name, String nickname);

}
