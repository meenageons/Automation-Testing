package Websites;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class firefox {
	@Test
	public void UploadFile() throws InterruptedException, AWTException {

		System.setProperty("webdriver.gecko.driver", "./Firefox/geckodriver.exe");
		FirefoxOptions driver1 = new FirefoxOptions();
		WebDriver driver = new FirefoxDriver(driver1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");

		// Upload File path
		String[] file1 = new String[] { "E:\\Vuelogix Xml File\\Test6.xlsx",
				"E:\\Vuelogix Xml File\\Test7.xlsx", "E:\\Vuelogix Xml File\\Test8.xlsx" };

		int i = 0;
		while (i < 3) {

			// File location
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@class='q-field__native row items-center cursor-pointer']"))).click();

			StringSelection content = new StringSelection(file1[i]);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);

			Robot past_key = new Robot();
			past_key.keyPress(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			past_key.keyPress(KeyEvent.VK_V);
			past_key.keyRelease(KeyEvent.VK_V);
			past_key.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			past_key.keyPress(KeyEvent.VK_ENTER);
			past_key.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			i++;

//			// Notification message
//			String err0r_m = "//*[@class='q-notification__content row items-center col']";
//
//			if (err0r_m.equals("//*[@class='q-notification__content row items-center col']")) {
//				WebElement error = driver
//						.findElement(By.xpath("//*[@class='q-notification__content row items-center col']"));
//				System.out.println(error.getText() + " Test - Success");
//			}
//
//			else {
//				System.out.println("Fail");
//			}

			//Bom Tree
			//Boeing
			driver.findElement(By.xpath("//*[@class='q-icon notranslate material-icons q-tree__arrow']")).click();
			
			//SlicePRO Battery Board
			Thread.sleep(1000);		
			driver.findElement(By.xpath("//*[@class='q-icon notranslate material-icons q-tree__arrow']")).click();

			
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window,scrollTo(0, 3500)", "");

			Thread.sleep(2000);
			js.executeScript("window,scrollTo(0, 0)", "");
	
		}
		
	}
}
