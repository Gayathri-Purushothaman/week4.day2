package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions builder=new Actions(driver);
		WebElement menFashion=driver.findElement(By.xpath("//li[@navindex='1']/a/span[@class='catText']"));
		builder.moveToElement(menFashion).perform();
		Thread.sleep(3000);
		WebElement sportsShoes=driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		sportsShoes.click();
		WebElement countOfShoes=driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		String count=countOfShoes.getText();
		WebElement trainingShoes=driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		trainingShoes.click();
		WebElement sortBy=driver.findElement(By.xpath("//div[@class='sort-selected']"));
		sortBy.click();
		WebElement sortLowToHigh=driver.findElement(By.xpath("//ul[@class='sort-value']/li[@data-index='1']"));
		sortLowToHigh.click();
		driver.navigate().refresh();
	List <WebElement> priceColl=driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
	
		int priceCollSize=priceColl.size();
		
		List <Integer> arrInt=new LinkedList<Integer>();
		List<String> arrText=new ArrayList<String>();
		
		for(int i=0;i<priceColl.size();i++)
		{
			
			
			arrInt.add(Integer.valueOf(priceColl.get(i).getAttribute("data-price")));
			arrText.add(priceColl.get(i).getAttribute("data-price"));
		}
		List<Integer>intList=new ArrayList<Integer>();

		for(String s : arrText)
			{
			intList.add(Integer.valueOf(s));	
			}
Collections.sort(intList);
int j=0;
for(int i=0;i<arrInt.size();i++)
{
	
	System.out.println(arrInt.get(i)+"|"+intList.get(i));
	
	if(intList.get(i)==arrInt.get(i))
			{
	       j++;
			}
}
if(j==priceColl.size())
{
	System.out.println("The values displayed are sorted as expected");
}
else
{
	System.out.println("The values displayed are not sorted as expected");
}
Thread.sleep(3000);

driver.findElement(By.xpath("//input[@class='input-filter'][@name='fromVal']")).clear();
driver.findElement(By.xpath("//input[@class='input-filter'][@name='fromVal']")).sendKeys("500");
driver.findElement(By.xpath("//input[@class='input-filter'][@name='toVal']")).clear();
driver.findElement(By.xpath("//input[@class='input-filter'][@name='toVal']")).sendKeys("1200");


driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();

Thread.sleep(5000);
driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();

WebElement priceFilter=driver.findElement(By.xpath("//div[@class='filters-top-selected']//div[@class='navFiltersPill']/a"));
String priceFilterText=priceFilter.getText();
WebElement colorFilter=driver.findElement(By.xpath("(//div[@class='filters-top-selected']//div[@class='navFiltersPill']/a)[2]"));
String colorFilterText=colorFilter.getText();
if(priceFilterText.contains("Rs. 900 - Rs. 1200")&&colorFilterText.contains("Navy"))
{
	System.out.println("Filters are applied correctly");
}
else if(priceFilterText.contains("Rs. 900 - Rs. 1200")&&(colorFilterText.contains("Navy")==false))
{
	System.out.println("Price filter alone applied correctly");
}
else if(colorFilterText.contains("Navy")&&(priceFilterText.contains("Rs. 900 - Rs. 1200")==false))
{
	System.out.println("Color filter alone applied correctly");
}
else
{
	System.out.println("Both color and price filters are not applied correctly");
}
	
WebElement firstImage=driver.findElement(By.xpath("//picture[@class='picture-elem']/img[@class='product-image wooble']"));
Actions builder1=new Actions(driver);
builder1.moveToElement(firstImage).perform();
WebElement quickView=driver.findElement(By.xpath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[1]"));
quickView.click();
WebElement priceEle=driver.findElement(By.xpath("//span[@class='payBlkBig']"));
String price=priceEle.getText().substring(0,3);
System.out.println(price);
WebElement shoeImage=driver.findElement(By.xpath("//img[@slidenum='0']"));
File source=shoeImage.getScreenshotAs(OutputType.FILE);
File destination=new File("./snaps/ShoeScreenShot.png");
FileUtils.copyFile(source, destination);
driver.quit();




	}


}
