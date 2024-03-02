package com.javatesting.simple;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.util.StringUtils;

public class RemoveVowels {

	public static void main(String[] args) {
		//String words = "Our company culture is focused on helping our employees enable innovation by building breakthroughs together. How? We focus every day on building the foundation for tomorrow and creating a workplace that embraces differences, values flexibility, and is aligned to our purpose-driven and future-focused work. We offer a highly collaborative, caring team environment with a strong focus on learning and development, recognition for your individual contributions, and a variety of benefit options for you to choose from. Apply now!";
		String words ="haveaniceday";
		
		System.out.println(words.replaceAll("[AEIOUaeiou]", ""));
	}

}
