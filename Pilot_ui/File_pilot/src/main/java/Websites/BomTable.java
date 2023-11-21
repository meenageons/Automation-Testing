package Websites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BomTable {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window,scrollTo(0, 3500)", "");

		WebElement Table_edit[] = new WebElement[] {
				driver.findElement(By.xpath("(//tr[contains(@class,'q-tr')]/td)[12]")),
				driver.findElement(By.xpath("(//tr[contains(@class,'q-tr')]/td)[21]")) };

		int i = 0;
		while (i < 2) {
			Thread.sleep(2500);
			Table_edit[i].click();
			Thread.sleep(2500);
			driver.findElement(
					By.xpath("//*[@class='q-menu q-position-engine scroll q-popup-edit']//label/div/div/div/input"))
					.sendKeys(" 123");
			Thread.sleep(2500);
			WebElement cancel = driver
					.findElement(By.xpath("//*[@class='q-popup-edit__buttons row justify-center no-wrap']//button[2]"));
			Thread.sleep(2500);
			cancel.click();
			i++;
		}

		//Sourcing page
		Thread.sleep(2500);
		driver.findElement(By.xpath("(//div[contains(@class,'q-tab__content self-stretch flex-center relative-position q-anchor--skip non-selectable column')]/div)[5]")).click();
		
		js.executeScript("window,scrollTo(0, 3500)", "");
		Thread.sleep(3000);
		WebElement sourcing_table[] = new WebElement[] {
				driver.findElement(By.xpath("(//tr[contains(@class,'q-tr')]/td)[2]")),
				driver.findElement(By.xpath("(//tr[contains(@class,'q-tr')]/td)[15]")) };

		int j = 0;
		while (j < 2) {
			Thread.sleep(3500);
			sourcing_table[j].click();
			Thread.sleep(2500);
			driver.findElement(By.xpath("//*[@class='q-menu q-position-engine scroll q-popup-edit']//label//div//div//div//input")).sendKeys(" 123");
			j++;
		}

	}

}
