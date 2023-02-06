package jqueryui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
//		default functionality
		Actions action = new Actions(driver);
		driver.switchTo().frame(0);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		action.clickAndHold(drag).moveByOffset(50, 50).build().perform();
		
		
//		auto scroll
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Auto-scroll')]")).click();
		Thread.sleep(5000);
		
		driver.switchTo().frame(0);
		WebElement drag1 = driver.findElement(By.id("draggable"));
		WebElement drag2 = driver.findElement(By.id("draggable2"));
		WebElement drag3 = driver.findElement(By.id("draggable3"));
		
		action.clickAndHold(drag1).moveByOffset(0, 70).build().perform();
		action.clickAndHold(drag2).moveByOffset(0, 100).build().perform();
		action.clickAndHold(drag3).moveByOffset(0, 110).build().perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,120)", "");
	}

}
