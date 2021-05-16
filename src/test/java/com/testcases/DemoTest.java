package com.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest extends TestBase {

	
	@Test
	public void test01() throws Exception {
		driver = initialization();
		Thread.sleep(5000);
		edriver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		edriver.findElement(By.id("password")).sendKeys("123456");
		edriver.findElement(By.xpath("//button")).click();
		Assert.assertEquals(edriver.getTitle(), "JavaByKiran | Dashboard");
	}
	
	@Test
	public void test02() {
		Assert.assertEquals(true, false);
	}
	
}
