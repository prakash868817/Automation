package robimyplex;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.thoughtworks.selenium.Wait;

public class Navigations {
	AndroidDriver obj;
	WebDriverWait wait;

	@BeforeTest
	public void Launch() throws MalformedURLException, InterruptedException {
		DesiredCapabilities c = new DesiredCapabilities();
		// c.setCapability(CapabilityType.BROWSER_NAME,"");
		c.setCapability("deviceName", "SOROEQVO6TPVYPTK");// SOROEQVO6TPVYPTK
															// //7daecc6a
		c.setCapability("platformName", "Android");
		c.setCapability("platformVersion", "6.0");
		c.setCapability("appPackage", "com.android.robistaging");
		c.setCapability("appActivity",
				"com.android.myplex.ui.activities.LoginActivity");
		// c.setCapability("appActivity","com.myplex.music.ui.sun.activities.MoviesSplash");
		URL u = new URL("http://127.0.0.1:4723/wd/hub");
		obj = new AndroidDriver(u, c);
		Thread.sleep(10000);
		// obj.findElement(By.name("Terms & Conditions")).click();
		wait = new WebDriverWait(obj, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name("Enter mobile number to get one time password")));
		Thread.sleep(1000);

	}

	@Test(priority = 0)
	public void login() throws InterruptedException, MalformedURLException {
		obj.findElement(By.name("Enter Mobile number")).sendKeys("52255082");// Send
																				// OTP
		Thread.sleep(1000);
		obj.findElement(By.name("Send OTP")).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Go")));
		obj.findElement(By.name("Go")).click();
		Thread.sleep(1000);
		// obj.findElement(By.name("Resend OTP")).click();
		Thread.sleep(1000);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Go")));
		Thread.sleep(1000);
		obj.findElement(By.name("Change Number")).click();
		Thread.sleep(1000);
		obj.findElement(By.name("Enter Mobile number")).sendKeys("52255082");// Send
																				// OTP
		Thread.sleep(1000);
		obj.findElement(By.name("Send OTP")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Go")));
		Thread.sleep(10000);
		obj.findElement(By.name("Go")).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name("Schedule")));
		obj.findElement(By.name("Schedule")).click();
		Thread.sleep(20000);

	}

	/*@Test(priority = 1)
	public void Navigationdrawer() throws InterruptedException {

		obj.findElement(By.xpath("//*[@content-desc='Robi TV']")).click();
		// To highlight the clicking elemnet
		// WebElement
		// mov=obj.findElement(By.xpath("//*[@resource-id='com.myplex.musicbeta:id/item_name'][@text='MOVIES']"));
		Thread.sleep(2000);
		obj.findElement(
				By.xpath("//*[@resource-id='com.android.robistaging:id/relative_navigation_item'][@index='0']"))
				.click();

		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@content-desc='Robi TV']")).click();
		Thread.sleep(2000);
		obj.findElement(
				By.xpath("//*[@resource-id='com.android.robistaging:id/relative_navigation_item'][@index='1']"))
				.click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@content-desc='Robi TV']")).click();
		Thread.sleep(2000);
		obj.findElement(
				By.xpath("//*[@resource-id='com.android.robistaging:id/relative_navigation_item'][@index='2']"))
				.click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@content-desc='Robi TV']")).click();
		Thread.sleep(2000);
		obj.findElement(
				By.xpath("//*[@resource-id='com.android.robistaging:id/relative_navigation_item'][@index='3']"))
				.click();
		Thread.sleep(2000);
		String packs = obj.findElement(By.name("Current Active Packs:"))
				.getText();
		try {

			if (packs.equalsIgnoreCase(obj.findElement(
					By.name("Current Active Packs:")).getText())) {
				System.out.println("My TV Account page is opened");
				obj.navigate().back();

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		Thread.sleep(2000);
		obj.findElement(By.xpath("//*[@content-desc='Robi TV']")).click();
		Thread.sleep(2000);
		try {
			obj.findElement(
					By.xpath("//*[@resource-id='com.android.robistaging:id/relative_navigation_item'][@index='4']"))
					.click();
			Thread.sleep(2000);
			obj.findElement(By.id("com.android.robistaging:id/RadioGroup"))
					.click();
			Thread.sleep(2000);

			System.out.println("Auto is selecte4d");
			Thread.sleep(2000);
			obj.findElement(By.name("High Defenition(HD)")).click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			obj.findElement(By.name("Standard Defenition(SD)")).click();
			Thread.sleep(2000);

			Thread.sleep(2000);
			obj.findElement(By.name("Low Defenition")).click();
			Thread.sleep(2000);
			obj.findElement(
					By.id("com.android.robistaging:id/toolbar_settings_button"))
					.click();
			Thread.sleep(2000);
			obj.findElement(
					By.id("com.android.robistaging:id/toggle_notification"))
					.click();
			Thread.sleep(2000);
			obj.findElement(By.id("com.android.robistaging:id/toggle_autoplay"))
					.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try { // About
			Thread.sleep(2000);
			obj.findElement(By.xpath("//*[@content-desc='Robi TV']")).click();
			Thread.sleep(2000);

			obj.findElement(
					By.xpath("//*[@resource-id='com.android.robistaging:id/relative_navigation_item'][@index='5']"))
					.click();
			Thread.sleep(2000);
			// obj.navigate().back();
			Thread.sleep(2000);
			
			 * long startTime = System.currentTimeMillis();
			 * obj.findElement(By.name("About App")).click();
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By
			 * .name(
			 * "Free Live TV, Movies, Music and Video On-Demand, Online, Anytime!"
			 * ))); System.out.println("about text is present"); long endTime =
			 * System.currentTimeMillis(); long totalTime = endTime - startTime;
			 * System.out.println(totalTime);
			 * System.out.println("Total Page Load Time: " + totalTime +
			 * "milliseconds"); Thread.sleep(2000); Thread.sleep(1000);
			 * obj.navigate().back(); Thread.sleep(1000);
			 * obj.findElement(By.name("Terms And Conditions")).click();
			 * Thread.sleep(2000);
			 * System.out.println("going to click on terms and condiotions");
			 * Thread.sleep(1000);
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By
			 * .name("Terms and Conditions"))); Thread.sleep(1000);
			 * System.out.println("terms and comditions is present");
			 * Thread.sleep(1000); obj.navigate().back(); Thread.sleep(1000);
			 
			// FAQ
			Thread.sleep(1000);
			obj.findElement(By.name("FAQ")).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name("Help & FAQ’s")));
			Thread.sleep(1000);
			System.out.println("FAQ is present");
			Thread.sleep(1000);
			obj.navigate().back();
			Thread.sleep(1000);
			// share app
			obj.findElement(By.name("Share App")).click();
			Thread.sleep(1000);
			// WhatsApp
			// obj.scrollTo("Copy to clipboard");
			Thread.sleep(1000);
			obj.navigate().back();
			Thread.sleep(5000);
			obj.findElement(By.name("Rate this app")).click();
			Thread.sleep(1000);
			obj.navigate().back();
			Thread.sleep(1000);
			obj.navigate().back();
			Thread.sleep(1000);

		} catch (Exception e)

		{
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
			obj.findElement(By.xpath("//*[@content-desc='Robi TV']")).click();
			Thread.sleep(2000);
			obj.findElement(
					By.xpath("//*[@resource-id='com.android.robistaging:id/relative_navigation_item'][@index='0']"))
					.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void Home() throws InterruptedException {

		Thread.sleep(3000);
		List<WebElement> view = obj.findElements(By.name("View all"));
		view.get(0).click();
		Thread.sleep(3000);
		obj.scrollTo("Auto TV");
		obj.navigate().back();
		Thread.sleep(2000);
		view.get(1).click();
		Thread.sleep(2000);
		obj.scrollTo("7up FnF Journey - Ep 11 P");
		Thread.sleep(2000);
		obj.navigate().back();
		obj.findElement(By.xpath("//*[@content-desc='Robi TV']")).click();
		Thread.sleep(2000);
		obj.findElement(
				By.xpath("//*[@resource-id='com.android.robistaging:id/relative_navigation_item'][@index='1']"))
				.click();

	}

	@Test(priority = 3)
	public void Live() throws InterruptedException {

		Thread.sleep(2000);
		obj.scrollTo("com.android.robistaging:id/channel_arrow_img");
		Thread.sleep(2000);

	}

	@Test(priority = 4)
	public void Videos() throws InterruptedException {
		try {
			obj.findElement(By.name("Videos")).click();
			Thread.sleep(2000);
			Thread.sleep(2000);

			List<WebElement> view = obj.findElements(By.name("View all"));
			view.get(0).click();
			Thread.sleep(2000);
			obj.scrollTo("Kajal Agrawal Celebrates ");
			Thread.sleep(2000);
			obj.navigate().back();
			Thread.sleep(2000);
			view.get(1).click();
			Thread.sleep(2000);
			obj.scrollTo("KKB - School Principal");
			Thread.sleep(2000);
			obj.navigate().back();
			Thread.sleep(2000);
			view.get(2).click();
			Thread.sleep(2000);
			obj.scrollTo("Amar Mondo Shovab - Pathi");
			Thread.sleep(2000);
			obj.navigate().back();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/*
	 * @AfterTest public void Report() {
	 * 
	 * // Create object of Property file Properties props = new Properties();
	 * 
	 * // this will set host of server- you can change based on your //
	 * requirement props.put("mail.smtp.host", "smtp.gmail.com");
	 * 
	 * // set the port of socket factory
	 * props.put("mail.smtp.socketFactory.port", "465");
	 * 
	 * // set socket factory props.put("mail.smtp.socketFactory.class",
	 * "javax.net.ssl.SSLSocketFactory");
	 * 
	 * // set the authentication to true props.put("mail.smtp.auth", "true");
	 * 
	 * // set the port of SMTP server props.put("mail.smtp.port", "465");
	 * 
	 * // This will handle the complete authentication Session session =
	 * Session.getDefaultInstance(props,
	 * 
	 * new javax.mail.Authenticator() {
	 * 
	 * protected PasswordAuthentication getPasswordAuthentication() {
	 * 
	 * return new PasswordAuthentication("prakash.s@apalya.com",
	 * "ammananna143");
	 * 
	 * }
	 * 
	 * });
	 * 
	 * try {
	 * 
	 * // Create object of MimeMessage class Message message = new
	 * MimeMessage(session);
	 * 
	 * // Set the from address message.setFrom(new
	 * InternetAddress("prakash.s@apalya.com"));
	 * 
	 * // Set the recipient address
	 * message.setRecipients(Message.RecipientType.TO, InternetAddress
	 * .parse("prakashqasel@gmail.com,prakash.s@aplaya.com"));
	 * 
	 * // Add the subject link message.setSubject("Testing Report");
	 * 
	 * // Create object to add multimedia type content BodyPart messageBodyPart1
	 * = new MimeBodyPart();
	 * 
	 * // Set the body of email
	 * messageBodyPart1.setText("Robi Navigation Report");
	 * 
	 * // Create another object to add another content MimeBodyPart
	 * messageBodyPart2 = new MimeBodyPart();
	 * 
	 * // Mention the file which you want to send String filename =
	 * "D:\\Tigo\\Robi\\test-output\\testng-results.xml";
	 * 
	 * // Create data source and pass the filename DataSource source = new
	 * FileDataSource(filename);
	 * 
	 * // set the handler messageBodyPart2.setDataHandler(new
	 * DataHandler(source));
	 * 
	 * // set the file messageBodyPart2.setFileName(filename);
	 * 
	 * // Create object of MimeMultipart class Multipart multipart = new
	 * MimeMultipart();
	 * 
	 * // add body part 1 multipart.addBodyPart(messageBodyPart2);
	 * 
	 * // add body part 2 multipart.addBodyPart(messageBodyPart1);
	 * 
	 * // set the content message.setContent(multipart);
	 * 
	 * // finally send the email Transport.send(message);
	 * 
	 * System.out.println("=====Email Sent=====");
	 * 
	 * } catch (MessagingException e) {
	 * 
	 * throw new RuntimeException(e); }
	 * 
	 * }
	 */
	public void excel() {
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> signature = new ArrayList<String>();
		ArrayList<String> status = new ArrayList<String>();

		try {

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(
					"D:\\Tigo\\Robi\\test-output\\testng-results.xml"));

			// normalize text representation
			doc.getDocumentElement().normalize();
			System.out.println("Root element of the doc is :\" "
					+ doc.getDocumentElement().getNodeName() + "\"");
			NodeList listOfPersons = doc.getElementsByTagName("person");
			int totalPersons = listOfPersons.getLength();
			System.out.println("Total no of people : " + totalPersons);
			for (int s = 0; s < listOfPersons.getLength(); s++) {
				Node firstPersonNode = listOfPersons.item(s);
				if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {
					Element firstPersonElement = (Element) firstPersonNode;
					NodeList firstNameList = firstPersonElement
							.getElementsByTagName("first");
					Element firstNameElement = (Element) firstNameList.item(0);
					NodeList textFNList = firstNameElement.getChildNodes();
					System.out
							.println("First Name : "
									+ ((Node) textFNList.item(0))
											.getNodeValue().trim());
					name.add(((Node) textFNList.item(0)).getNodeValue()
							.trim());
					/*NodeList lastNameList = firstPersonElement
							.getElementsByTagName("last");
					Element lastNameElement = (Element) lastNameList.item(0);
					NodeList textLNList = lastNameElement.getChildNodes();
					System.out
							.println("Last Name : "
									+ ((Node) textLNList.item(0))
											.getNodeValue().trim());
					signature.add(((Node) textLNList.item(0)).getNodeValue()
							.trim());*/
					/*NodeList ageList = firstPersonElement
							.getElementsByTagName("age");
					Element ageElement = (Element) ageList.item(0);
					NodeList textAgeList = ageElement.getChildNodes();
					System.out.println("Age : "
							+ ((Node) textAgeList.item(0)).getNodeValue()
									.trim());
					status.add(((Node) textAgeList.item(0)).getNodeValue().trim());*/
				}// end of if clause

			}// end of for loop with s var
			for (String firstName : name) {
				System.out.println("firstName : " + firstName);
			}
			/*for (String lastName : signature) {
				System.out.println("lastName : " + lastName);
			}
			for (String age : status) {
				System.out.println("age : " + age);
			}*/

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());
		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sample sheet");

		Map<String, Object[]> data = new HashMap<String, Object[]>();
		for (int i = 0; i < name.size(); i++) {
			data.put(i + "", new Object[] { name.get(i),
					signature.get(i), status.get(i) });
		}
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}

		try {
			FileOutputStream out = new FileOutputStream(new File(
					"D:\\Results\\book.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void Report() {

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
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress("prakash.s@apalya.com"));

			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO, InternetAddress
					.parse("prakashqasel@gmail.com,prakash.s@aplaya.com"));

			// Add the subject link
			message.setSubject("Testing Report");

			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email
			messageBodyPart1.setText("Robi Navigation Report");

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename = "D:\\Results\\book.xlsx";

			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));

			// set the file
			messageBodyPart2.setFileName(filename);

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

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
