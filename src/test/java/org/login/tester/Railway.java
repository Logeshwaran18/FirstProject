package org.login.tester;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Railway {
	public static void main(String[] args) throws AWTException, InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.railyatri.in/train-ticket");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement from = driver.findElement(By.id("boarding_from"));
		from.sendKeys("salem");
		Thread.sleep(2000);
		Robot r = new Robot();
		for (int i = 0; i < 3; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_UP);

		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		WebElement to = driver.findElement(By.id("boarding_to"));
		to.sendKeys("chennai");
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_UP);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		WebElement date = driver.findElement(By.xpath("//p[text()='20 Feb']"));
		date.click();
		WebElement search = driver.findElement(By.id("tt_search_dweb"));
		search.click();

		WebElement ticket = driver.findElement(By.id("sa_status_02602_2S"));
		ticket.click();
		
		FluentWait<WebDriver> f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
		f.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='AVAILABLE-0008']")));
		
		WebElement btnAvb = driver.findElement(By.xpath("//p[text()='AVAILABLE-0008']"));
		btnAvb.click();

		WebElement name = driver.findElement(By.id("adult_add_fullname"));
		name.sendKeys("logesh");
		WebElement age = driver.findElement(By.id("adult_add_age"));
		age.sendKeys("23");

		WebElement window = driver.findElement(By.id("adult_add_berth"));
		window.click();
		WebElement prefer = driver.findElement(By.xpath("//li[text()='No Preference']"));
		prefer.click();

		WebElement save = driver.findElement(By.xpath("//button[@class='save_psngr_btn']"));
		save.click();
		WebElement pincode = driver.findElement(By.id("pincode"));
		pincode.sendKeys("636001");
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("mettur");
		WebElement post = driver.findElement(By.id("postoffice"));
		
		Select s = new Select(post);
		Thread.sleep(3000);
		s.selectByValue("Salem Fort S.O");
	
		WebElement email = driver.findElement(By.id("user_email"));
		email.sendKeys("logesh@gmail.com");
		WebElement phone = driver.findElement(By.id("user_phone"));
		phone.sendKeys("9629930060");

	}

}
