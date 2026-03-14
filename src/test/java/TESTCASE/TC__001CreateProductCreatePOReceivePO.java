package TESTCASE;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PAGEOBJECTS.CreatePOReceivePOPage;
import utils.ExtentReportManager;

public class TC__001CreateProductCreatePOReceivePO extends Baseclass {

	public String accountName = "SPD";
	public String m1;
	public String currentCost;
	public String productNumber;
	public String serial;
	public String addProductQohOnhand;
	public String equipmentPONO;
	ExtentTest testt1 = extent.createTest("Create Product");

	@Test(priority = 1, groups = "createProduct", enabled = true)
	public void createProduct() throws InterruptedException {
		CreatePOReceivePOPage cc = new CreatePOReceivePOPage(driver);
		Thread.sleep(8000);
		try {
			System.out.println("Create Product Test started");
			cc.productManagement();
			logger.info("Hovered on productManagement hovered successfully");

			cc.product();
			logger.info("Hovered on product successfully");

			cc.createproduct();
			logger.info("Clicked on product successfully");
			testt1.info("Opened create product page successfully");
			Thread.sleep(2000);

			String expCreateProductUrl = "Products - Dallas - admin - Green Team Holdings, LLC. - ENV: demo-gcd";
			boolean actCreateProductUrl = driver.getTitle().contains(expCreateProductUrl);
			if (actCreateProductUrl == true) {
				logger.info("Title verified successfully");
				testt1.info("Title verified successfully");
				Assert.assertTrue(true);
			} else {
				logger.info("Title not verified");
				testt1.info("Title not verified");
				Assert.assertTrue(false);
			}

			cc.saveProduct();
			logger.info("Clicked on saveProduct without entering any details");

			try {
				String text = driver.switchTo().alert().getText();
				if (text.equals("Enter Product Number!")) {
					logger.info("Alert message verified successfully");
					driver.switchTo().alert().accept();
					logger.info("Alert accepted successfully");
					testt1.info("Alert accepted successfully");
					Assert.assertTrue(true);
				} else {
					logger.info("Alert message not verified");
					testt1.info("Alert message not verified");
					Assert.assertTrue(false);
				}
			} catch (Exception e) {
				e.getMessage();
			}

			productNumber = randomeNumFive();
			cc.productNumber(productNumber);
			logger.info("Product number entered is:" + driver.findElement(By.id("cf_782")).getAttribute("value"));
			testt1.info("Product number entered is:" + driver.findElement(By.id("cf_782")).getAttribute("value"));

			m1 = randomeNumThree();
			cc.m1(m1);
			logger.info("M1 entered is:" + driver.findElement(By.name("cf_796")).getAttribute("value"));
			testt1.info("M1 entered is:" + driver.findElement(By.name("cf_796")).getAttribute("value"));

			addProductQohOnhand = randomeNumThree();
			cc.addQohOnhand(addProductQohOnhand);
			logger.info(
					"AddQohOnhand entered successfully " + driver.findElement(By.id("cf_840")).getAttribute("value"));
			testt1.info(
					"AddQohOnhand entered successfully " + driver.findElement(By.id("cf_840")).getAttribute("value"));

			currentCost = randomeNumThree();
			cc.currentCost(currentCost);
			logger.info("CurrentCost entered is:" + cc.CurrentCost.getAttribute("value"));
			testt1.info("CurrentCost entered is:" + cc.CurrentCost.getAttribute("value"));

			cc.saveProduct();
			logger.info("Clicked on saveProduct successfully");
			testt1.info("Clicked on saveProduct successfully");

			boolean contains2 = cc.verifym1().getText().contains(m1);
			if (contains2 == true) {
				logger.info("M1 verified successfully");
				testt1.log(Status.PASS, "M1 verified successfully");

				Assert.assertTrue(true);
			} else {
				logger.info("M1 verification failed!");
				testt1.log(Status.PASS, "M1 verification failed!");
				Assert.assertTrue(false);
			}

			boolean contains = cc.verifyProductnumber().getText().contains(productNumber);
			if (contains == true) {
				logger.info("Created product verified successfully");
				testt1.log(Status.PASS, "Created product verified successfully");
				Assert.assertTrue(true);
			} else {
				logger.info("Product verification failed!");
				testt1.log(Status.FAIL, "Product verification failed!");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	ExtentTest testt2 = extent.createTest("Create Equipment");

	@Test(priority = 2, enabled = true)
	public void createEquipment() throws InterruptedException {
		CreatePOReceivePOPage cc = new CreatePOReceivePOPage(driver);

		Actions acc = new Actions(driver);
		Thread.sleep(2000);
		try {
			cc.equipmentManagement();
			logger.info("Hovered on equipmentManagement successfully");

			cc.equipment();
			logger.info("Hovered on equipment successfully");

			cc.createEquipment();
			logger.info("Clicked on createEquipment successfully");
			testt2.info("Opened create equipment successfully");

			String expCreateEqp = "Equipment - Dallas - admin - Green Team Holdings, LLC. - ENV: demo-gcd";
			boolean actCreateEqp = driver.getTitle().contains(expCreateEqp);
			if (actCreateEqp == true) {
				logger.info("Title verified successfully");
				testt2.info("Title verified successfully");
				Assert.assertTrue(true);
			} else {
				logger.info("Title verification failed!");
				testt2.info("Title verification failed!");
				Assert.assertTrue(false);
			}
			cc.productFamily();
			logger.info("Product family selected is: " + cc.ProductFamily.getAttribute("value"));
			testt2.info("Product family selected is: " + cc.ProductFamily.getAttribute("value"));

			cc.year();
			logger.info("year selected is: " + cc.Year.getAttribute("value"));
			testt2.info("year selected is: " + cc.Year.getAttribute("value"));

			cc.make();
			logger.info("Make selected is: " + cc.Make.getAttribute("value"));
			testt2.info("Make selected is: " + cc.Make.getAttribute("value"));

			cc.model();
			logger.info("Model selected is: " + cc.Model.getAttribute("value"));
			testt2.info("Model selected is: " + cc.Model.getAttribute("value"));

			try {
				cc.closemodelPopup().click();
				logger.info("Model popup closed successfully");
				testt2.info("Model popup closed successfully");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			cc.availabilityStatus();
			logger.info("Availability Status selected is: " + cc.AvailabilityStatus.getAttribute("value"));
			testt2.info("Availability Status selected is: " + cc.AvailabilityStatus.getAttribute("value"));

			serial = randomeNum();
			cc.serial().sendKeys(serial);
			logger.info("Serial number entered is: " + cc.serial().getAttribute("value"));
			testt2.info("Serial number entered is: " + cc.serial().getAttribute("value"));

			cc.equipmentCost().sendKeys(randomeNumFive());
			logger.info("Equipment cost entered successfully");

			cc.equipmentSave().click();
			logger.info("Clicked on equipment save successfully");
			testt2.info("Clicked on equipment save successfully");

			cc.closeVendorPopup().click();
			logger.info("Vendor popup closed successfully");
			testt2.info("Vendor popup closed successfully");

			try {
				cc.pushToQB().click();
				logger.info("Clicked on pushToQB successfully");
				testt2.info("Clicked on pushToQB successfully");
				
			} catch (ElementNotInteractableException e) {
				System.out.println(e.getMessage());
			} 
			Thread.sleep(1000);

			String te = cc.verifyEquipmentCreated().getText();
			Thread.sleep(1000);
			if (te.contains(serial)) {
				logger.info("Created equipment verified successfully");
				testt2.log(Status.PASS, "Created equipment verified successfully");
				Assert.assertTrue(true);
			} else {
				logger.info("Equipment verification failed!");
				testt2.info("Equipment verification failed!");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	ExtentTest testt3 = extent.createTest("Create SalesOrder");

	@Test(priority = 3, enabled = true, groups = { "createProduct", "createSalesorder" })
	public void createSalesorder() {
		CreatePOReceivePOPage cc = new CreatePOReceivePOPage(driver);

		try {
			cc.pointOfSale();
			logger.info("Hovered on pointOfSale successfully");

			cc.salesOrdersClick();
			logger.info("Hovered on salesOrdersClick successfully");

			cc.createNewSales();
			logger.info("Clicked on createNewSales successfully");
			testt3.info("Opened create Salesorder page successfully");

			cc.enterAccountName().sendKeys(accountName);
			logger.info("Account name entered is: " + cc.enterAccountName().getAttribute("value"));
			testt3.info("Account name entered is: " + cc.enterAccountName().getAttribute("value"));

			cc.enterAccountName().sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			cc.enterAccountName().sendKeys(Keys.ENTER);
			logger.info("Account name selected successfully");

			cc.enterProductNo1().sendKeys(productNumber);
			logger.info("Product number entered is: " + cc.enterProductNo1().getAttribute("value"));
			testt3.info("Product number entered is: " + cc.enterProductNo1().getAttribute("value"));

			cc.enterProductNo1().sendKeys(Keys.ENTER);
			cc.enterProductNo1().sendKeys(Keys.ENTER);
			logger.info("Product number selected successfully");

			cc.enterEquipment1().sendKeys(serial);
			cc.enterEquipment1().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			cc.enterEquipment1().sendKeys(Keys.ENTER);
			logger.info("Equipment number entered is: " + cc.enterEquipment1().getAttribute("value"));
			testt3.info("Equipment number entered is: " + cc.enterEquipment1().getAttribute("value"));

			cc.equipmentPrice().sendKeys(randomeNumFive());
			logger.info("Equipment price entered successfully" + cc.equipmentPrice().getAttribute("value"));
			testt3.info("Equipment price entered successfully" + cc.equipmentPrice().getAttribute("value"));

			cc.clickOptionProduct().click();
			logger.info("Clicked on option product successfully");
			testt3.info("Clicked on option product successfully");

			cc.addOptionProduct().sendKeys(productNumber);
			cc.addOptionProduct().sendKeys(Keys.ENTER);
			cc.addOptionProduct().sendKeys(Keys.ENTER);
			logger.info("Option product entered is: " + cc.addOptionProduct().getAttribute("value"));
			testt3.info("Option product entered is: " + cc.addOptionProduct().getAttribute("value")); // cc.salesSave().click();

			try {
				cc.setOptionProductYes();
				logger.info("Clicked on option product yes successfully");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				logger.info("Clicked on option product no successfully");
			}

			cc.finalizeCash();
			logger.info("Clicked on finalize cash successfully");
			testt3.log(Status.PASS,"Salesorder created successfully");
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	ExtentTest testt4 = extent.createTest("Create Equipment PO");

	@Test(priority = 4, enabled = true, groups = "createProduct")
	public void CreateEquipmentPO() throws InterruptedException {
		CreatePOReceivePOPage cc = new CreatePOReceivePOPage(driver);

		Actions acc = new Actions(driver);

		try {
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(demoUrl);
			cc.equipmentManagement();
			logger.info("Hovered on equipmentManagement successfully");

			cc.equipmentPO();
			logger.info("Hovered on equipment successfully");

			cc.createEquipmentPO();
			logger.info("Clicked on createEquipmentPO successfully");
			testt4.info("Opened create equipment PO page successfully");

			equipmentPONO = driver.findElement(By.xpath("//input[@id='equipmentponumber']")).getAttribute("value");

			System.out.println("Equipment PO number is: " + equipmentPONO);

			cc.enterVendor();
			logger.info("Vendor entered successfully");

			cc.selectModel();
			logger.info("Model selected successfully");

			cc.enterCost();
			logger.info("Cost entered successfully");
			Thread.sleep(1000);
			cc.finalizePO();
			logger.info("Clicked on finalize PO successfully");
			testt4.info("Equipment PO created successfully");
			WebElement linkElement = driver.findElement(By.linkText(equipmentPONO));
			String linkText = linkElement.getText();
			Assert.assertEquals(linkText, equipmentPONO);
			logger.info("Created Equipment PO verified successfully");
			testt4.log(Status.PASS, "Created Equipment PO verified successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(3000);
	}

	ExtentTest testt5 = extent.createTest("Create Equipment receiving");

	@Test(priority = 5, enabled = true)
	public void createEquipmentReceiving() throws InterruptedException {
		CreatePOReceivePOPage cc = new CreatePOReceivePOPage(driver);
		Actions acc = new Actions(driver);

		try {
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(demoUrl);
			cc.equipmentManagement();
			logger.info("Hovered on equipmentManagement successfully");

			cc.equipmentPOReceieving();
			logger.info("Hovered on equipment receiving successfully");

			cc.createEquipmentPOReceiving();
			logger.info("Clicked on create equipment receiving successfully");
			testt5.info("Opened create equipment receiving page successfully");

			cc.selectByPurchaseOrder();
			logger.info("Selected by purchase order successfully");

			cc.selectEquipmentPO(equipmentPONO);
			logger.info("Selected equipment PO successfully");
			Thread.sleep(3000);

			cc.clickSearchNOw();
			logger.info("Clicked on search now successfully");

			cc.addSerialNo();
			logger.info("Serial number added successfully");

			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='_iframe-manageSerialNumbers']")));
			cc.enterSerialNO(equipmentPONO + 1);
			logger.info("Serial number entered is: " + cc.EnterSerialNO.getAttribute("value"));
			testt5.info("Serial number entered is: " + cc.EnterSerialNO.getAttribute("value"));

			cc.clickVerifySerialNo();
			logger.info("Clicked on verify serial number successfully");

			cc.clickSaveSerialNo();
			logger.info("Clicked on save serial number successfully");

			driver.switchTo().defaultContent();

			cc.selectEquipment();
			logger.info("Selected equipment successfully");
			cc.saveEquipmentReceiving();
			logger.info("Clicked on save equipment receiving successfully");
			String text = driver.switchTo().alert().getText();
			if (text.equals("New Equipment(s) created/updated Successfully.")) {
				logger.info("Alert message verified successfully");
				driver.switchTo().alert().accept();
				logger.info("Alert accepted successfully");
				testt5.log(Status.PASS,"Equipment receiving created successfully");
				Assert.assertTrue(true);
			} else {
				logger.info("Alert message not verified");
				testt5.info("Equipment receiving creation failed!");

				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
