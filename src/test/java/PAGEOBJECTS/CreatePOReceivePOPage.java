package PAGEOBJECTS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePOReceivePOPage {
	private static final int TIMEOUT = 10;
	private static final int POLLING = 100;
	private WebDriverWait wait;
	private WebDriver driver;
	Actions ac;
	Select sc;
	
	public CreatePOReceivePOPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
		ac = new Actions(driver);
		
	}

	@CacheLookup
	@FindBy(xpath = "(//span[normalize-space()='Product Management'])[1]")
	WebElement ProductManagement;

	@CacheLookup
	@FindBy(xpath = "(//div[contains(text(),'Products')])[1]")
	WebElement product;

	@CacheLookup
	@FindBy(xpath = "//div[normalize-space()='Create Product']")
	WebElement Createproduct;

	@CacheLookup
	@FindBy(id = "cf_782")
	WebElement ProductNumber;

	@CacheLookup
	@FindBy(name = "cf_796")
	WebElement M1;

	@CacheLookup
	@FindBy(id = "procurrentcost")
	public WebElement CurrentCost;

	@CacheLookup
	@FindBy(id = "cf_840")
	WebElement AddQohOnhand;

	@CacheLookup
	@FindBy(xpath = "//span[@id='dtlview_Product Number']")
	WebElement VerifyProductnumber;

	@CacheLookup
	@FindBy(xpath = "//span[@id='dtlview_M1']")
	WebElement VerifyM1;

	@CacheLookup
	@FindBy(xpath = "(//span[@id='dtlview_Serial #'])[1]")
	WebElement VerifyEquipmentCreated;
	
	@CacheLookup
	@FindBy(xpath = "(//input[@id='btnCashAutoComplete'])[1]")
	WebElement FinalizeCash;
	
	@CacheLookup
	@FindBy(xpath = "//button[@id='soproductoptionsave']")
	WebElement SetOptionProductYes;
	
	@CacheLookup
	@FindBy(xpath = "//div[normalize-space()='Equipment PO']")
	WebElement EquipmentPO;
	
	@CacheLookup
	@FindBy(xpath = "//div[normalize-space()='Create Equipment PO']")
	WebElement CreateEquipmentPO;
	
	@CacheLookup
	@FindBy(xpath = "//input[@id='vendor_name']")
	WebElement EnterVendor;
	
	@CacheLookup
	@FindBy(xpath = "(//select[@id='smodel0'])[1]")
	WebElement SelectModel;
	
	@CacheLookup
	@FindBy(xpath = "//input[@id='samount0']")
	WebElement EnterCost;
	
	@CacheLookup
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[3]")
	WebElement FinalizePO;
	
	@CacheLookup
	@FindBy(xpath = "//div[normalize-space()='Equipment PO Receiving']")
	WebElement EquipmentPOReceieving;
	
	@CacheLookup
	@FindBy(xpath = "//input[@value='by_purchaseorder']")
	WebElement SelectByPurchaseOrder;
	
	@CacheLookup
	@FindBy(xpath = "//button[@id='btnAddSN-1']")
	WebElement AddSerialNo;
	
	@CacheLookup
	@FindBy(xpath = "//input[@id='serialnumbertxt']")
	public WebElement EnterSerialNO;
	
	@CacheLookup
	@FindBy(xpath = "//input[@name='btnAddSN']")
	WebElement ClickVerifySerialNo;
	
	@CacheLookup
	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement ClickSaveSerialNo;
	
	@CacheLookup
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	WebElement SaveEquipmentReceiving;
	
	@CacheLookup
	@FindBy(xpath = "(//input[@id='searchbuttonPO'])[1]")
	WebElement ClickSearchNOw;
	
	@CacheLookup
	@FindBy(xpath = "(//input[@name='selected_id'])[1]")
	WebElement SelectEquipment;
	
	@CacheLookup
	@FindBy(linkText = "Create Equipment Receiving")
	WebElement CreateEquipmentPOReceiving;
	
	@CacheLookup
	@FindBy(xpath = "//input[@id='equipment_save']")
	WebElement Save;

	@CacheLookup
	@FindBy(xpath = "//span[normalize-space()='Equipment Management']")
	WebElement EquipmentManagement;

	@CacheLookup
	@FindBy(xpath = "//div[normalize-space()='Equipment']")
	WebElement Equipment;

	@CacheLookup
	@FindBy(xpath = "//div[normalize-space()='Create Machine']")
	WebElement createEquipment;

	@CacheLookup
	@FindBy(xpath = "(//select[@id='cf_equipment_group'])[1]")
	public WebElement ProductFamily;

	@CacheLookup
	@FindBy(id = "cf_year")
	public
	WebElement Year;

	@CacheLookup
	@FindBy(id = "cf_make")
	public
	WebElement Make;

	@CacheLookup
	@FindBy(id = "cf_equipment_model")
	public
	WebElement Model;

	@CacheLookup
	@FindBy(xpath = "//div[@id='objModelChange']//span[@aria-hidden='true'][normalize-space()='×']")
	WebElement CloseModelPopup;

	@CacheLookup
	@FindBy(id = "availability_status")
	public
	WebElement AvailabilityStatus;

	@CacheLookup
	@FindBy(id = "cf_782")
	WebElement Serial;

	@CacheLookup
	@FindBy(name = "attachment_cost")
	WebElement EquipmentCost;

	@CacheLookup
	@FindBy(id = "equipment_save")
	WebElement EquipmentSave;

	@CacheLookup
	@FindBy(xpath = "//span[normalize-space()='Point Of Sale']")
	WebElement PointOfSale;

	@CacheLookup
	@FindBy(xpath = "(//div[normalize-space()='Sales Orders'])[1]")
	WebElement SalesOrdersClick;

	@CacheLookup
	@FindBy(xpath = "//div[normalize-space()='Create Sales Orders']")
	WebElement CreateNewSales;

	@CacheLookup
	@FindBy(xpath = "//input[@id='single_accountid']")
	WebElement enterAccountName;

	@CacheLookup
	@FindBy(id = "productName1")
	WebElement enterProductNo1;

	@CacheLookup
	@FindBy(xpath = "//div[@id='objaddnode_PO']//div[@class='modal-body']//button[@id='closemodalobjaddnode']")
	WebElement CloseVendorPopup;

	@CacheLookup
	@FindBy(id = "pushtoqueue")
	WebElement PushToQB;

	@CacheLookup
	@FindBy(id = "cf_serial_no1")
	WebElement EnterEquipment1;

	@CacheLookup
	@FindBy(id = "opproductNumberownedcar1")
	WebElement AddOptionProduct;

	@CacheLookup
	@FindBy(id = "amount1")
	WebElement EquipmentPrice;

	@CacheLookup
	@FindBy(id = "add_newoption1")
	WebElement ClickOptionProduct;

	public void productManagement() {
		ac.moveToElement(ProductManagement).perform();
	}

	public void product() {
		ac.moveToElement(product).perform();
	}

	public void createproduct() {
		Createproduct.click();
	}

	public void productNumber(String pr) {
		ProductNumber.sendKeys(pr);
	}

	public void m1(String pr) {
		M1.sendKeys(pr);
	}

	public void currentCost(String pr) {
		CurrentCost.sendKeys(pr);
	}

	public void saveProduct() {
		Save.click();
	}

	public void equipmentManagement() {
		ac.moveToElement(EquipmentManagement).perform();
	}

	public void equipment() {
		ac.moveToElement(Equipment).perform();
	}

	public void createEquipment() {
		createEquipment.click();
	}

	public void productFamily() {
		sc = new Select(ProductFamily);
		sc.selectByContainsVisibleText("New");
		
	}

	public void year() {
		sc = new Select(Year);
		sc.selectByContainsVisibleText("2024");
	}

	public void make() {
		sc = new Select(Make);
		sc.selectByContainsVisibleText("Club Car");
	}

	public void model() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Model)).click();
		sc = new Select(Model);
		sc.selectByContainsVisibleText("CRU LSV");
		
	}

	public WebElement closemodelPopup() {
		return CloseModelPopup;
	}

	public void availabilityStatus() {
		Select sc4 = new Select(AvailabilityStatus);
		sc4.selectByContainsVisibleText("Available");
	}

	public WebElement serial() {

		return Serial;
	}

	public WebElement equipmentCost() {
		return EquipmentCost;
	}

	public WebElement equipmentSave() {

		return EquipmentSave;
	}

	public void pointOfSale() {
		ac.moveToElement(PointOfSale).perform();

	}

	public void salesOrdersClick() {
		 ac.moveToElement(SalesOrdersClick).perform();
	}

	public void createNewSales() {
		CreateNewSales.click();
	}

	public WebElement enterAccountName() {
		return enterAccountName;
	}

	public WebElement enterProductNo1() {
		return enterProductNo1;
	}

	public WebElement closeVendorPopup() {
		return CloseVendorPopup;
	}

	public WebElement pushToQB() {
		return PushToQB;
	}

	public WebElement enterEquipment1() {
		return EnterEquipment1;
	}

	public WebElement addOptionProduct() {
		// TODO Auto-generated method stub
		return AddOptionProduct;
	}

	public WebElement equipmentPrice() {
		// TODO Auto-generated method stub
		return EquipmentPrice;
	}

	public WebElement clickOptionProduct() {
		// TODO Auto-generated method stub
		return ClickOptionProduct;
	}

	public void addQohOnhand(String st) {
		AddQohOnhand.sendKeys(st);
		;
	}

	public WebElement verifyProductnumber() {
		// TODO Auto-generated method stub
		return VerifyProductnumber;
	}

	public WebElement verifym1() {
		// TODO Auto-generated method stub
		return VerifyM1;
	}
	
	public WebElement verifyEquipmentCreated() {
		// TODO Auto-generated method stub
		return VerifyEquipmentCreated;
	}

	public void finalizeCash() {
		FinalizeCash.click();
		
	}

	public void setOptionProductYes() {
		SetOptionProductYes.click();
		
	}

	public void equipmentPO() {
		ac.moveToElement(EquipmentPO).perform();
		
	}

	public void createEquipmentPO() {
		CreateEquipmentPO.click();
	}

	public void enterVendor() throws InterruptedException {
		try {
			EnterVendor.sendKeys("SP");
			EnterVendor.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			EnterVendor.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
	}

	public void selectModel() {
		try {
			sc = new Select(SelectModel);
			sc.selectByIndex(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void enterCost() {
		EnterCost.sendKeys(Keys.CONTROL + "a");
		EnterCost.sendKeys("5000.87");
		
	}

	public void finalizePO() {
		FinalizePO.click();
		
	}

	public void equipmentPOReceieving() {
		ac.moveToElement(EquipmentPOReceieving).perform();
		
		
	}

	public void createEquipmentPOReceiving() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(CreateEquipmentPOReceiving));
		until.click();
		
	}

	public void selectByPurchaseOrder() {
		SelectByPurchaseOrder.click();
		
	}

	public void selectEquipmentPO(String eq) {
		Select sc1 = new Select(driver.findElement(By.xpath("//select[@id='equipmentpoid']")));
		sc1.selectByContainsVisibleText(eq);
		
	}

	public void addSerialNo() {
		AddSerialNo.click();
		
	}

	public void enterSerialNO(String st) {
		EnterSerialNO.sendKeys(st);
		
	}

	public void clickVerifySerialNo() {
		ClickVerifySerialNo.click();
		
	}

	public void clickSaveSerialNo() {
		ClickSaveSerialNo.click();
		
	}

	public void saveEquipmentReceiving() {
		SaveEquipmentReceiving.click();
		
	}

	public void clickSearchNOw() {
		ClickSearchNOw.click();
		
	}

	public void selectEquipment() {
		SelectEquipment.click();
		
	}
	

}
