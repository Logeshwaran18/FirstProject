package org.login.tester;

import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sam2 {

	@Test()
	private void tc1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("logesj");

	}
	@Test(invocationCount=3,priority=-5)
	private void tc2() {
		System.out.println("2");

	}
	@Test(enabled=false)
	private void tc3() {
		System.out.println("3");

	}

}
