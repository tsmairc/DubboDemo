package service;

import java.util.Random;

import interfaces.ITestService;

public class TestService implements ITestService{

	@Override
	public String test(){
		System.out.println("this is test servcie");
		Random random = new Random();
		return "this is test service=" + random.nextFloat() * random.nextFloat();
	}
	
}
