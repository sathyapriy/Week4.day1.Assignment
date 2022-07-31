package Week4.day1;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class mergeContacts {
	public static void main(String[] args) throws InterruptedException {
//		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		 * 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
//		 * 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
//		 * 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
//		 * 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
//			 * 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.linkText("Merge Contacts")).click();
//		 * 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//span[text()='From Contact']/following::a")).click();
//		 * 8. Click on First Resulting Contact
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindow= new ArrayList<String>(windowHandles);
		String fromContactWindow = listWindow.get(1);
		String mainWindow = listWindow.get(0);
		driver.switchTo().window(fromContactWindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
//		 * 9. Click on Widget of To Contact
		driver.switchTo().window(mainWindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='To Contact']/following::a")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listWindow1= new ArrayList<String>(windowHandles1);
		String toComtactWindow = listWindow1.get(1);
		driver.switchTo().window(toComtactWindow);
		Thread.sleep(3000);
//		 * 10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
//		 * 11. Click on Merge button using Xpath Locator		
		driver.switchTo().window(mainWindow);
		Thread.sleep(3000);
		driver.findElement(By.linkText("Merge")).click();
//		 * 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
//		 * 13. Verify the title of the page
		String title = driver.getTitle();
		System.out.println(title);
	}
}
