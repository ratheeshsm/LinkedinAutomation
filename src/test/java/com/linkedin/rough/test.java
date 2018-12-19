package com.linkedin.rough;


import java.util.Date;



public class test {

	public static void main(String[] args) {
	

			Date d = new Date();
			System.out.println(System.getProperty("user.dir"));
			
			String screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
			System.out.println(screenshotName);


		}

		

	}