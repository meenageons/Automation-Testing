package PilotUi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
		
		Thread.sleep(2000);
		WebElement upload_file = driver.findElement(By.xpath("//*[@class='q-field__native row items-center cursor-pointer']"));
		upload_file.click();
		
		String File = "C:\\Users\\Dell\\Downloads\\Test2.xlsx";
		Thread.sleep(1000);		
		StringSelection content = new StringSelection(File);
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
	}

}
