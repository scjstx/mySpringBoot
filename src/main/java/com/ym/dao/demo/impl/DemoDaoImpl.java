package com.ym.dao.demo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.ym.dao.common.BaseDaoImpl;
import com.ym.entity.demo.Demo;

public class DemoDaoImpl extends BaseDaoImpl<Demo> {

	Page<Demo> myListPage(String keyword, Pageable pageable) {
		StringBuffer dataHql = new StringBuffer(); 
		StringBuffer totalHql = new StringBuffer("select count(1) ");
		StringBuffer paramHql = new StringBuffer("from Demo d where 1 = 1 ");
		StringBuffer orderByStr = getOrderByStr(pageable.getSort(), "d", "id");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if (StringUtils.hasText(keyword)) {
			paramHql.append("and (name like :keyword ");
			paramHql.append("or nickname like :keyword ");
			paramHql.append(") ");
			paramMap.put("keyword", "%" + keyword + "%");
		}
		dataHql.append(paramHql).append(orderByStr);
		totalHql.append(paramHql);
		List<Demo> content = getContent(dataHql.toString(), paramMap, pageable);
		long total = getTotal(totalHql.toString(), paramMap);
		return new PageImpl<Demo>(content, pageable, total);
	}

	
}
