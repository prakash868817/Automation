package robimyplex;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Search {
	AndroidDriver obj;
	WebDriverWait wait;

	@BeforeTest
	public void launch() throws BiffException, IOException,
			InterruptedException {
		/*
		 * File f=new File("D:\\RobiSearch\\Search_Results.xls"); Workbook
		 * wb=Workbook.getWorkbook(f); //Goto sheet1 for reading Sheet
		 * sh1=wb.getSheet(0); //sheet1 int nor=sh1.getRows(); WritableWorkbook
		 * wwb=Workbook.createWorkbook(f,wb); WritableSheet
		 * wsh1=wwb.getSheet(0);
		 */
		DesiredCapabilities c = new DesiredCapabilities();

		// c.setCapability(CapabilityType.BROWSER_NAME,"");

		c.setCapability("deviceName", "7daecc6a");// SOROEQVO6TPVYPTK //7daecc6a//35c5ca13//ZY223WRMN3

		c.setCapability("platformName", "Android");
		c.setCapability("platformVersion", "5.1.1");
		c.setCapability("appPackage", "com.android.robistaging");
		c.setCapability("appActivity",
				"com.android.myplex.ui.activities.LoginActivity");
		// c.setCapability("appActivity","com.myplex.music.ui.sun.activities.MoviesSplash");
		URL u = new URL("http://127.0.0.1:4723/wd/hub");
		obj = new AndroidDriver(u, c);
		Thread.sleep(15000);
		//obj.findElement(By.name("Videos")).click();
		Thread.sleep(2000);
		
		  wait = new WebDriverWait(obj, 1000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By
		  .name("Enter mobile number to get one time password")));
		 Thread.sleep(1000);
		 
	}

	
	  @Test(priority = 0) public void login() throws InterruptedException,
	  MalformedURLException {
	 obj.findElement(By.name("Enter Mobile number")).sendKeys("32384425");
	 //
	  //Send // OTP Thread.sleep(1000);
	  obj.findElement(By.name("Send OTP")).click(); Thread.sleep(5000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Go")));
	  Thread.sleep(1000); obj.findElement(By.name("Go")).click();
	  Thread.sleep(1000); obj.findElement(By.name("Resend OTP")).click();
	  Thread.sleep(1000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Go")));
	  Thread.sleep(1000); obj.findElement(By.name("Change Number")).click();
	 Thread.sleep(1000);
	  obj.findElement(By.name("Enter Mobile number")).sendKeys("32384425");
	 // Send // OTP Thread.sleep(1000);
	 obj.findElement(By.name("Send OTP")).click(); Thread.sleep(1000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Go")));
	  Thread.sleep(15000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By
	  .name("Schedule"))); obj.findElement(By.name("Schedule")).click();
	  Thread.sleep(15000);
	  
	  
	  
	  }
	 

	@Test(priority = 1)
	public void search() throws InterruptedException, BiffException,
			IOException, WriteException {
		
		
		Thread.sleep(1000);
		File f = new File("D:\\RobiSearch\\live_search.xls");
		Workbook wb = Workbook.getWorkbook(f);
		// Goto sheet1 for reading
		Sheet sh1 = wb.getSheet(0); // sheet1
		int nor = sh1.getRows();
		WritableWorkbook wwb = Workbook.createWorkbook(f, wb);
		WritableSheet wsh1 = wwb.getSheet(0);
		System.out.println("number of rows in sheet:" + nor);
		for (int j = 1; j < nor; j++) {
			String ipch = sh1.getCell(0, j).getContents();
			Thread.sleep(1000);
			System.out.println("clicking on :" + ipch);
			Thread.sleep(1000);
			obj.findElement(By.id("com.android.robistaging:id/search_button"))
					.click();
			Thread.sleep(1000);
			obj.findElement(By.id("com.android.robistaging:id/search_src_text"))
					.sendKeys(ipch);

			Thread.sleep(3000);
			obj.hideKeyboard();
			Thread.sleep(1000);
			List<WebElement> list = obj.findElements(By
					.id("com.android.robistaging:id/title"));
			try {
				for (WebElement i : list) {
					System.out.println(i);

				}
				if (list.size() == 1) {
					System.out.println("one channel present");
					// String
					// s=obj.findElement(By.id("com.android.robistaging:id/title")).getText();
					// System.out.println(s);
					// Label r=new Label(3,j,s);
					// wsh1.addCell(r);

					obj.findElement(By.id("com.android.robistaging:id/title"))
							.click();
					Label p = new Label(2, j, "PASS");
					wsh1.addCell(p);
					Label c = new Label(1, j, list.size() + "");
					wsh1.addCell(c);

				} else if (list.size() > 1 && list.size() <= 10) {
					System.out.println("more channel(s) present");
					String s = "";
					for (WebElement i : list) {
						// Label k=new Label(3,j,i.getText());
						if (ipch.equalsIgnoreCase(obj.findElement(
								By.id("com.android.robistaging:id/title"))
								.getText())) {
							System.out.println("both are same ");
							Label o = new Label(3, j, s);
							wsh1.addCell(o);
						} else {
							System.out.println("channelname: " + i.getText());
							if (s.equals("")) {
								s = s + i.getText();
							} else {
								s = s + ", " + i.getText();
							}
						}
						// o =new Label(3,j,o.toString() + " " + k.toString() );

						// wsh1.getCell(arg0)

					}
					Label o = new Label(3, j, s);
					wsh1.addCell(o);

					Label p = new Label(2, j, "FAIL");
					wsh1.addCell(p);
					Label c = new Label(1, j, list.size() + "");
					wsh1.addCell(c);
				} else {
					System.out.println("No channels present");
					Label o = new Label(3, j, "No channels present in the list");
					wsh1.addCell(o);
					Label p = new Label(2, j, "FAIL");
					wsh1.addCell(p);
					Label c = new Label(1, j, list.size() + "");
					wsh1.addCell(c);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			obj.navigate().back();
		}

		wwb.write();
		wwb.close();
		wb.close();
	}

	@AfterTest
	public void Report() throws IOException {
		// Create object of Property file
		Properties props = new Properties();

		// this will set host of server- you can change based on your
		// requirement
		props.put("mail.smtp.host", "smtp.gmail.com");

		// set the port of socket factory
		props.put("mail.smtp.socketFactory.port", "465");

		// set socket factory
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,

		new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("prakash.s@apalya.com",
						"ammananna143");

			}

		});

		try {

			// Create object of MimeMessage class
			MimeMessage message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress("prakash.s@apalya.com"));

			// Set the recipient address
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress
							.parse("praveen.guntaka@apalya.com,anusha.b@apalya.com,arun.k@apalya.com,lv.ramana@apalya.com"));

			// Add the subject link
			message.setSubject("Robi Search Functionality Testing");

			// Create object to add multimedia type content
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email
			messageBodyPart1.setText("Robi Search Results");

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename1 = "D:\\RobiSearch\\live_search.xls";

			// Create data source and pass the filename
			DataSource source1 = new FileDataSource(filename1);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source1));

			// set the file
			messageBodyPart2.setFileName(filename1);
			MimeBodyPart messageBodyPart3 = new MimeBodyPart(); 
			String filename2 = "E:/Java/connect.txt";//change accordingly 
			DataSource source2 = new FileDataSource(filename2); 
			messageBodyPart3.setDataHandler(new DataHandler(source2)); 
			messageBodyPart3.setFileName(filename2); 
			messageBodyPart3.attachFile("D:\\Tigo\\Robi\\test-output\\testng-results.xml"); 
			Multipart multipart = new MimeMultipart(); 
			multipart.addBodyPart(messageBodyPart1); 
			//multipart.addBodyPart(messageBodyPart2); 
			multipart.addBodyPart(messageBodyPart3); 
			// Create object of MimeMultipart class
						// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}

}
