package p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatadrivenNotepad {

	public static void main(String[] args) throws Throwable {
		 File f=new File("E:\\testing\\7.test data\\adactin.txt");
		    FileReader fr=new FileReader(f);
		    @SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(fr);
		   for(int i=1;i<=5;i++)
		   {
		    String x=br.readLine();
		     System.out.println(x);
		    String[] y= x.split("#");
		    System.out.println(y[0]);
		    System.out.println(y[1]);

		    System.setProperty("webdriver.chrome.driver","E:\\testing\\1. webdrivers\\chrome\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			
			driver.get("http://www.adactin.com/HotelAppBuild2");
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys(y[0]);
			driver.findElement(By.id("password")).sendKeys(y[1]);
			driver.findElement(By.id("login")).click();
			Thread.sleep(10000);
			 new Select(driver.findElement(By.id("location"))).selectByValue(y[2]);
			    new Select(driver.findElement(By.id("hotels"))).selectByValue(y[3]);
			    new Select(driver.findElement(By.id("room_type"))).selectByValue(y[4]);
			    driver.findElement(By.id("datepick_in")).clear();
				driver.findElement(By.id("datepick_in")).sendKeys(y[5]);
				driver.findElement(By.id("datepick_out")).clear();
				driver.findElement(By.id("datepick_out")).sendKeys(y[6]);
				driver.findElement(By.id("Submit")).click();
				driver.findElement(By.id("radiobutton_0")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("continue")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("first_name")).sendKeys(y[7]);
				driver.findElement(By.id("last_name")).sendKeys(y[8]);
				driver.findElement(By.id("address")).sendKeys(y[9]);
				
				driver.findElement(By.id("cc_num")).sendKeys(y[10]);
				new Select(driver.findElement(By.xpath(".//*[@id='cc_type']"))).selectByIndex(2);
				new Select(driver.findElement(By.xpath(".//*[@id='cc_exp_month']"))).selectByIndex(2);
				new Select(driver.findElement(By.xpath(".//*[@id='cc_exp_year']"))).selectByIndex(2);
				
				driver.findElement(By.id("cc_cvv")).sendKeys("123");
				
			    
			driver.findElement(By.xpath(".//*[@id='book_now']")).click();
			Thread.sleep(5000);
			String s=driver.findElement(By.xpath(".//*[@id='order_no']")).getAttribute("value");
			System.out.println("Order number is : "+s);
			System.out.println("Test pass");
			
		driver.quit();
	}

}
}