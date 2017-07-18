package service;

import interfaces.ITestService;

public class TestService implements ITestService{

	@Override
	public String test(){
		System.out.println("this is test servcie");
		return "this is test service";
	}
	
}
