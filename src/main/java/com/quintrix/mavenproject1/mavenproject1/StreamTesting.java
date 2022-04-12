package com.quintrix.mavenproject1.mavenproject1;

import java.util.ArrayList;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTesting {
	
	
	public static void main (String[] args) {
		
		List<Integer> numbers1 = new ArrayList<>();
		
		
		
		for (int i  = 0; i < 101; i++) {
			numbers1.add(i);
		}
		
		int[] arr = numbers1.stream().mapToInt(i -> i).filter(i -> i%5 == 0)
				.toArray();
		
		for(int x: arr) {
			System.out.println(x + " Is a number that is divisible by 5");
		}
		
		List<String> numbersAsString = numbers1.stream().filter(i-> i% 10 == 0)
				.map(String::valueOf).skip(3).collect(Collectors.toList());
		
		System.out.println("--------------------------------------------------");
		numbersAsString.stream().forEach(System.out::println);
		
		Predicate<Integer> customCondition = new Predicate<Integer>() 
				{
					public boolean test(Integer n) {
						if (n % 3 == 0 && n %2 == 0) {
							return true;
						}
						return false;
					}
			
				};
		
		long max = numbers1.stream().filter(customCondition).count();
		
		System.out.println("--------------------------------------------------");
		
		System.out.println("The number of integers divisible by both two and three in the ArrayList is " + max);
	}

}
