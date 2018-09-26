package com.ym.model.base;

import java.io.Serializable;

import lombok.Data;

@Data
public class PageOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	private String field;
	private String order;

}
