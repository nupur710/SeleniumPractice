package automating.webelements;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {
	
	public static void main(String[] args) throws InterruptedException {
		//edit
		WebDriver driver= new ChromeDriver();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//Handling static dropdowns
		WebElement currency= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select select= new Select(currency);
		select.selectByIndex(3);
		System.out.println(select.getFirstSelectedOption().getText());
		WebElement passengers= driver.findElement(By.id("divpaxinfo"));
		passengers.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("hrefIncAdt"))));
		
		//select 5 adults
		int i= 0;
		while(i<4) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		System.out.println(passengers.getText());
		driver.findElement(By.id("btnclosepaxoption")).click();
		//Handling Dynamic dropdowns
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	    driver.findElement(By.xpath("//a[@value='IXG']")).click();
	   // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@vlue='MAA']"))));
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
	}
	
	

}
