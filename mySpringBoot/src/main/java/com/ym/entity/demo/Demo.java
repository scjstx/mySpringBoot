package com.ym.entity.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Demo {

	@Id
	private String id;

	private String name;

	private String nickname;

	private Integer age;

	private String sex;

}
