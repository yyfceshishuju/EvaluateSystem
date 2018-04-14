package com.zpark.test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class TestDouble {
	    public static void main(String[] args) {  
	               DecimalFormat df = new DecimalFormat( "0.000 ");  
	               double d1 = 2.1;  
	               double d2 = 1.2345678;  
	               System.out.println(df.format(d1));   
	               System.out.println(df.format(d2));   
	             System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));  
	        }  
	}  

