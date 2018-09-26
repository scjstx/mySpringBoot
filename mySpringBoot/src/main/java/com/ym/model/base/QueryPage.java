package com.ym.model.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.StringUtils;

import lombok.Data;

@Data
public class QueryPage {

	private int pageSize;

	private int pageNumber;

	private List<PageOrder> sort;

	public Pageable createPageable() {
		Pageable pageable = null;
		if (!StringUtils.isEmpty(this.getSort())) {
			Order order = null;
			List<Order> orders = new ArrayList<>();
			for (PageOrder o : sort) {
				if (StringUtils.hasText(o.getField()) && StringUtils.hasText(o.getOrder())) {
					if (Direction.ASC.toString().equals(o.getOrder().trim().toUpperCase())) {
						order = new Order(o.getField());
					} else {
						order = new Order(Direction.DESC, o.getField());
					}
					orders.add(order);
				}
			}
			if (orders.size() > 0) {
				Sort s = new Sort(orders);
				pageable = new PageRequest(this.getPageNumber(), this.getPageSize(), s);
			} else {
				pageable = new PageRequest(this.getPageNumber(), this.getPageSize());
			}
		} else {
			pageable = new PageRequest(this.getPageNumber(), this.getPageSize());
		}
		return pageable;
	}
}
