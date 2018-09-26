package com.ym.dao.common;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class BaseDaoImpl<T> {

	@PersistenceContext
	public EntityManager entityManager;

	/**
	 * 拼接 order by语句
	 * 
	 * @param sort
	 * @param aliasName
	 *            别名
	 * @param defaultField
	 *            默认排序字段
	 * @return
	 */
	public StringBuffer getOrderByStr(Sort sort, String aliasName, String defaultField) {
		StringBuffer res = new StringBuffer();
		if (sort != null) {
			res.append("order by ");
			boolean commas = false;
			for (Sort.Order order : sort) {
				if (commas)
					res.append(", ");
				else
					commas = true;
				res.append(aliasName).append(".").append(order.getProperty()).append(" ");
				if (order.isDescending()) {
					res.append("desc ");
				}
			}
		} else {
			res.append("order by ").append(defaultField).append(" asc");
		}
		return res;
	}

	/**
	 * 获取总数
	 * 
	 * @param totalHql
	 * @param paramMap
	 * @return
	 */
	public long getTotal(String totalHql, Map<String, Object> paramMap) {
		Query totalQuery = entityManager.createQuery(totalHql);
		paramMap.forEach((k, v) -> {
			totalQuery.setParameter(k, v);
		});
		return (long) totalQuery.getSingleResult();
	}

	/**
	 * 获取分页数据
	 * 
	 * @param dataHql
	 * @param paramMap
	 * @param pageable
	 * @return
	 */
	public List<T> getContent(String dataHql, Map<String, Object> paramMap, Pageable pageable) {
		Query dataQuery = entityManager.createQuery(dataHql);
		dataQuery.setFirstResult(pageable.getOffset());
		dataQuery.setMaxResults(pageable.getPageSize());
		paramMap.forEach((k, v) -> {
			dataQuery.setParameter(k, v);
		});
		@SuppressWarnings("unchecked")
		List<T> res = dataQuery.getResultList();
		return res;
	}
}
