package com.ym.model.demo;

import com.ym.model.base.QueryPage;

import lombok.Data;

@Data
public class DemoQueryVO {

	private String name;

	private String nickname;

	private String keyword;

	private QueryPage queryPage;

}
