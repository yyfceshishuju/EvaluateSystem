package com.zpark.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zpark.util.GenerationDetailUtil;



public class TestConcact {
	public static void  main(String srg[]){
		List<String> list = new ArrayList<String>();
		list.add("1:3;2:3;3:5;4:3;5:5");
		list.add("1:2;2:3;3:2;4:2;5:5");
		list.add("1:3;2:5;3:5;4:2;5:3");
		String str = GenerationDetailUtil.generateCommendDetail(list);
		System.out.println(str);
//		String str1 = "1,2,3,4,5,";
//		String[] str1 = str.split(",");
//		for(String str2:str1){
//			System.out.println(Integer.parseInt(str2));
//		}
		
//		Date d1 = new Date();
//		int sun =10;
//		for(int i = 0 ; i < 100; i ++){
//			sun *= i;
//			System.out.print(1);
//		}
//		System.out.println();
//		Date d2 = new Date();
//		System.out.println(d1.getTime() - d2.getTime());
		GenerationDetailUtil.getScoreList("1:3;2:4;3:5;4:1;5:2;6:5;7:5;8:5;");
	}
}
