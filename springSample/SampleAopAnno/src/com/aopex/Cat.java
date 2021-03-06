package com.aopex;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cat {

	private String name;
	private int age;
	private String color;
	
	public Cat() {}

	public Cat(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}
	
	public void catInfo() {
		System.out.println("이름:" + name);
		System.out.println("나이:" + age);
		System.out.println("색상:" + color);
	}
	
}
