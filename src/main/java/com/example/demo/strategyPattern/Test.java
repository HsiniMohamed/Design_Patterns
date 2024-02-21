package com.example.demo.strategyPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Test {

	public static void main(String[] args) throws Exception {
		Context context=new Context();
		Strategy strategy;
		
		 Map<String, Strategy> map=new HashMap<>();

		Scanner scanner=new Scanner(System.in);
		while (true) {
			System.out.println("Quelle Strategy ?");
			String str=scanner.nextLine();
			strategy= map.get(str);
			if (strategy==null) {
				System.out.println("Création d'un nouvel objet de StrategyImpl"+str);
				strategy=(Strategy) Class.forName("com.example.demo.strategyPattern.StrategyImpl"+str).getConstructor().newInstance();
				map.put( str,strategy);
			}
			context.setStrategy(strategy);
			context.effectuerOperation();
		}
		
		
		
	}

}
