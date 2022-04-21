package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		WebElement item1=driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
		WebElement item2=driver.findElement(By.xpath("//ol[@id='selectable']/li[2]"));
		WebElement item5=driver.findElement(By.xpath("//ol[@id='selectable']/li[5]"));
		WebElement item7=driver.findElement(By.xpath("//ol[@id='selectable']/li[7]"));
Actions builder=new Actions(driver);
builder.keyDown(Keys.CONTROL).click(item1).click(item2).click(item5).click(item7).keyUp(Keys.CONTROL).perform();

	}

}
