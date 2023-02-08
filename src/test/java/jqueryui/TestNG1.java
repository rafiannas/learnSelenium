package jqueryui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG1 {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
	}

	@Test
	public void oke() {
		setUp();
		driver.findElement(By.name("q")).sendKeys("testNG" + Keys.ENTER);
		driver.close();

	}
	
	@Test
	public void oke2() {
		setUp();
		driver.findElement(By.name("q")).sendKeys("testNG" + Keys.ENTER);
		driver.findElement(By.xpath("//h3[contains(text(),'TestNG - Welcome')]")).click();
		driver.close();

	}

}
