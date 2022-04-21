package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		WebElement item1=driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));
		WebElement item5=driver.findElement(By.xpath("//ul[@id='sortable']/li[5]"));
		WebElement item2=driver.findElement(By.xpath("//ul[@id='sortable']/li[2]"));
Actions builder=new Actions(driver);
builder.clickAndHold(item1).moveToElement(item5).clickAndHold(item5).moveToElement(item2).perform();




	}

}
