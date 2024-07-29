package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	/*RestTemplate rt = new RestTemplate(); // this can be static for performance
	String url = "https://host:port/path1/path2?stringVar1=	{var1value}&floatVar2={var2value}";
	MyClass result = rt.getForObject(url, MyClass.class, "SomeString", 123.4f);
	Map<String, Object> params = new HashMap<>(2);
    params.put("var1value", "SomeString");
    params.put("var2value", 123.4f);
	MyClass result = rt.getForObject(url, MyClass.class, params);*/
}
