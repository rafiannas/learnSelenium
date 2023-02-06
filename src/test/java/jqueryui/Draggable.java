package jqueryui;

import org.openqa.selenium.By;
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

	}

}
