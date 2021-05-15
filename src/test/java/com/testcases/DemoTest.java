package com.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest extends TestBase {

	
	@Test
	public void test01() {
		driver = initialization();
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
	@Test
	public void test02() {
		Assert.assertEquals(true, false);
	}
	
}
