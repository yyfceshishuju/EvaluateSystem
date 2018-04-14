package com.zpark.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class GenerationDetailUtil {
		
	public static String[] getDetailAndTotalScore(LinkedHashMap<String,String> inputEvaluateItemDetailMap,LinkedHashMap<String,String> selectEvaluateItemDetailMap){
		StringBuilder stringBuilderSelect = new StringBuilder();
		StringBuilder stringBuilderInput = new StringBuilder();
		String[] str =new String[3];
		double totalScore = 0;
		if(selectEvaluateItemDetailMap!=null){
		for (Entry<String,String> entry : selectEvaluateItemDetailMap.entrySet()) {
			totalScore+=Double.parseDouble(entry.getValue());
			stringBuilderSelect.append(entry.getKey());
			stringBuilderSelect.append(":");
			stringBuilderSelect.append(entry.getValue());
			stringBuilderSelect.append(";");
			}
		}
		if(inputEvaluateItemDetailMap!=null){
		for(Entry<String,String> entry : inputEvaluateItemDetailMap.entrySet()){
			stringBuilderInput.append(entry.getKey());
			stringBuilderInput.append(":");
		if(entry.getValue() != null){
			if("".equals(entry.getValue().trim()) ){
				stringBuilderInput.append("无");
			}
			else{
				stringBuilderInput.append(entry.getValue());
			}
		}else{
			stringBuilderInput.append("无");

			}
		stringBuilderInput.append(";");

		}
		}
		System.out.println("选项测评详情   "+stringBuilderSelect);
		System.out.println("输入测评详情   "+stringBuilderInput);
		System.out.println("总分   "+totalScore/selectEvaluateItemDetailMap.size());
		str[0]=stringBuilderSelect.toString();
		str[1]=stringBuilderInput.toString();
		str[2]=String.valueOf(totalScore/selectEvaluateItemDetailMap.size());
		return str;
	}
	
	public static String generateCommendDetail(List<String> list){
		int size = 0;
		for(String str:list){
			if(str == null) return null;
			String[] str1 = str.split(";");
			size = str1.length;
		}
		int[] a = new  int[size];
		for(String str:list){
			String[] str1 = str.split(";");
			for(String str2:str1){
				String[] str3 = str2.split(":");
				int id = Integer.parseInt(str3[0]);
				
				for(int i = 0 ; i < a.length; i ++){
					if(id == (i+1)){
						a[i] +=Integer.parseInt(str3[1]);
					}
				}
			}
		}
		for(int in :a){
			System.out.print(in+"--");
		}
		System.out.println();
		System.out.println(a.length);
		StringBuilder sb = new StringBuilder();
		int k = 1;
		DecimalFormat df = new DecimalFormat( "0.000");  
		for(int i = 0 ; i<a.length; i++){
			System.out.println(a[0]+"----");
			double b =( a[i] /(double) list.size());
			String str = df.format(b);
			sb.append(k).append(":").append(str);
			k++;
			if(i != size){
				sb.append(";");
			}
		}
		return sb.toString();
	}
	
	public static List<Integer> getScoreList(String str){
		List<Integer> list = new ArrayList<Integer>();
		String[] str1= str.split(";");
		for(String str2:str1){
			String[] str3 = str2.split(":");
			list.add(Integer.parseInt(str3[1]));
		}
		return list;
	}
	public static List<String> getStringScoreList(String str){
		List<String> list = new ArrayList<String>();
		String[] str1= str.split(";");
		for(String str2:str1){
			String[] str3 = str2.split(":");
			list.add((str3[1]));
		}
		return list;
	}
	
	public static List<String> getCommentList(String str){
		List<String> list = new ArrayList<String>();
		//如果comment为null的话，添加两个“无”替代
		if(str == null){
			list.add("无");
			list.add("无");
			return list;
		}
		String[] str1= str.split(";");
		for(String str2:str1){
			String[] str3 = str2.split(":");
			list.add(str3[1]);
		}
		return list;
	}
}
