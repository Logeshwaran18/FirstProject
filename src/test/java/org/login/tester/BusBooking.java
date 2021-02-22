package org.login.tester;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BusBooking {
	public static void main(String[] args) throws AWTException{

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");

		WebElement from = driver.findElement(By.id("src"));
		from.sendKeys("salem");	
		Robot r = new Robot();
		FluentWait<WebDriver> f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
		f.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='autoFill']")));
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		WebElement to = driver.findElement(By.id("dest"));
		to.sendKeys("chennai");
		f.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='autoFill']")));
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		WebElement date = driver.findElement(By.id("onward_cal"));
		date.click();

		WebElement table = driver.findElement(By.xpath("//table[@class='rb-monthTable first last']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);

			List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {
				String text = datas.get(j).getText();

				if (text.equals("20")) {
					System.out.println(text);
					datas.get(j).click();
				}
			}
		}
		WebElement searchBtn = driver.findElement(By.id("search_btn"));
		searchBtn.click();
		
		f.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon icon-close c-fs']")));
		WebElement xbutton = driver.findElement(By.xpath("//i[@class='icon icon-close c-fs']"));
		xbutton.click();
		
		WebElement seats = driver.findElement(By.xpath("(//div[@class='button view-seats fr'])[2]"));
		seats.click();
		
		
		
		
	}

}
