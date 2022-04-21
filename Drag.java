package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
WebElement draggable=driver.findElement(By.id("draggable"));
Actions builder=new Actions(driver);
builder.dragAndDropBy(draggable, 100, 200).pause(2000).perform();
builder.dragAndDropBy(draggable, 150, 300).pause(2000).perform();



	}

}
