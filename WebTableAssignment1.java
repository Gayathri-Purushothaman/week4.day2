package week4.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableAssignment1 {

	public static void main(String[] args) {
		int rowSizeExcludingHeader=0;
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html ");
		driver.manage().window().maximize();
//		WebElement learnLocatorsChk=driver.findElement(By.xpath("//font[contains(text(),'Locators')]/parent::td/following-sibling::td/input"));
//		learnLocatorsChk.click();
		
		List<WebElement> colSize=driver.findElements(By.xpath("//font[contains(text(),'Locators')]/ancestor::tr/td"));
		int countOfCol=colSize.size();
System.out.println("The number of columns "+countOfCol);
		List<WebElement> rowSize=driver.findElements(By.xpath("//tbody/tr"));
		int countOfRowsIncludingHeader=rowSize.size();
		
		List <WebElement> eachRow=new ArrayList<WebElement>();
		for(int i=2;i<=countOfRowsIncludingHeader;i++)
		{
		WebElement rowsExcludingHeader=driver.findElement(By.xpath("//tbody/tr["+i+"]"));
	
		eachRow.add(rowsExcludingHeader);
	
		rowSizeExcludingHeader=eachRow.size();
		}
		
		System.out.println("The number of rows excluding header "+rowSizeExcludingHeader);
		System.out.println("The number of rows including header "+countOfRowsIncludingHeader);
		List<WebElement> rowsLearnToInteractWithElements=driver.findElements(By.xpath("//font[contains(text(),'interact')]/ancestor::tr/td/font"));
		int numberOfRowsLearnToInteract=rowsLearnToInteractWithElements.size();
		System.out.println(numberOfRowsLearnToInteract);
		List<WebElement> valueCols=driver.findElements(By.xpath("//tbody/tr/td/font[contains(text(),'interact')]/following::font"));
		int colValueSize=valueCols.size();
		System.out.println(colValueSize);
		WebElement value;
		System.out.println("The Progress values are");
		for(int i=3;i<numberOfRowsLearnToInteract;i++)
		{
			
			value=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]"));	
				System.out.println(value.getText());
		}
				
List <String> valString=new ArrayList<String>();	
List<Integer> intString=new ArrayList<Integer>();
List<Integer> onlyNo=new ArrayList<Integer>();
int leastValue=0;
		for(int i=2;i<=countOfRowsIncludingHeader;i++)
		{
		WebElement valueOfRowsExcludingHeader=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]"));
	valString.add(valueOfRowsExcludingHeader.getText().replace('%','0'));
	
		
		}
		for(String s:valString)
		{
			intString.add(Integer.valueOf(s));
		}
		for(Integer no:intString)
		{
			onlyNo.add(no/10);
		}
	
		Collections.sort(onlyNo);
		leastValue=onlyNo.get(0);
		System.out.println("The least value is "+leastValue+"%");
		WebElement chk=driver.findElement(By.xpath("//font[text()='"+leastValue+"%']/following::input"));
		chk.click();
			
		}

	
	
}
