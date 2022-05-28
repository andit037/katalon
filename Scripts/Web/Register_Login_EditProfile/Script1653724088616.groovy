import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import java.sql.Timestamp;
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.ExpectedConditions;

WebUI.openBrowser('')

//WebUI.deleteAllCookies()

WebUI.maximizeWindow()

//Go to Home-Page
WebUI.navigateToUrl(GlobalVariable.sehatqBaseUrl)

//Go to Daftar-page
WebUI.navigateToUrl(GlobalVariable.sehatqBaseUrl+"/daftar/email")

Timestamp timestamp = new Timestamp(System.currentTimeMillis())
 
String emailName = "testSehat"+timestamp.getTime()+"@gmail.com"
System.out.println(timestamp.getTime());

//Inserting mandatory field on Daftar-Page
WebUI.verifyElementPresent(findTestObject('Web/Daftar_EmailPage/daftarField', ['name' : "name"]),5)

WebUI.sendKeys(findTestObject('Web/Daftar_EmailPage/daftarField', ['name' : "name"]), accountName)

WebUI.verifyElementPresent(findTestObject('Web/Daftar_EmailPage/daftarField', ['name' : "email"]),5)

WebUI.sendKeys(findTestObject('Web/Daftar_EmailPage/daftarField', ['name' : "email"]), emailName)

WebUI.verifyElementPresent(findTestObject('Web/Daftar_EmailPage/daftarField', ['name' : "password"]),5)

WebUI.sendKeys(findTestObject('Web/Daftar_EmailPage/daftarField', ['name' : "password"]), password)

WebUI.scrollToElement(findTestObject('Web/Daftar_EmailPage/daftarField', ['name' : "name"]), 5)

WebUI.verifyElementPresent(findTestObject('Object Repository/Web/Daftar_EmailPage/ceklist_btn'),5)

WebElement el = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Web/Daftar_EmailPage/ceklist_btn'),30)

WebUI.executeJavaScript("arguments[0].click()", Arrays.asList(el))

if(WebUI.verifyElementClickable(findTestObject('Object Repository/Web/Daftar_EmailPage/daftarConfirm_btn'), FailureHandling.STOP_ON_FAILURE))
	WebUI.click(findTestObject('Object Repository/Web/Daftar_EmailPage/daftarConfirm_btn'))  
else
	System.out.println('Daftar Button still disable')
	
WebUI.deleteAllCookies()

//Go to Login-Page
WebUI.navigateToUrl(GlobalVariable.sehatqBaseUrl+"/login/email")

WebUI.verifyElementPresent(findTestObject('Object Repository/Web/LoginPage/emailField'),5)

WebUI.sendKeys(findTestObject('Object Repository/Web/LoginPage/emailField'), emailName)

WebUI.verifyElementPresent(findTestObject('Object Repository/Web/LoginPage/passwordField'),5)

WebUI.sendKeys(findTestObject('Object Repository/Web/LoginPage/passwordField'), password)

WebUI.click(findTestObject('Object Repository/Web/LoginPage/loginButton'))

WebUI.delay(3)

//Go to Profile-Page
WebUI.navigateToUrl(GlobalVariable.sehatqBaseUrl+"/profil")

WebUI.verifyElementPresent(findTestObject('Object Repository/Web/ProfilePage/editProfile_btn'),5)

WebUI.click(findTestObject('Object Repository/Web/ProfilePage/editProfile_btn'))

//Editing Profile Page
WebUI.click(findTestObject('Object Repository/Web/ProfilePage/date_btn'))

WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), 30);

Select selectMonth = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='month']"))))
String optionLabelMonth = selectMonth.getFirstSelectedOption().getText()

Select selectYear = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='year']"))))
String optionLabelYear = selectYear.getFirstSelectedOption().getText()

String dob = '12-January-2022'
String dateBirth = dob.split("-")[0]
String monthBirth = dob.split("-")[1]
String yearBirth = dob.split("-")[2]


while(!optionLabelMonth.equals(monthBirth) || !optionLabelYear.equals(yearBirth)) {
	WebUI.click(findTestObject('Object Repository/Web/ProfilePage/previousArrowDate'))
	Select selectMonthLoop = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='month']"))))
	Select selectYearLoop = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='year']"))))
	optionLabelMonth = selectMonthLoop.getFirstSelectedOption().getText()
	optionLabelYear = selectYearLoop.getFirstSelectedOption().getText()
	
}

List<WebElement> trElements = WebUI.findWebElements(findTestObject('Object Repository/Web/ProfilePage/dateGroup'),10)

for (WebElement dateElement: trElements) {
	System.out.println(dateElement.getText())
	if (dateElement.getText().equals(dateBirth)) {
		dateElement.click()
		break;
	}
}

WebUI.uploadFile(findTestObject('Object Repository/Web/ProfilePage/uploadFile'), 'D:\\test.png')

WebUI.click(findTestObject('Object Repository/Web/ProfilePage/jenisIdentitas_btn', ['label' : "Jenis Kelamin"]))

WebUI.scrollToElement(findTestObject('Object Repository/Web/ProfilePage/jenisIdentitas_btn', ['label' : "Jenis Kelamin"]), 5)

WebUI.click(findTestObject('Object Repository/Web/ProfilePage/perempuanOptionDropdown'))

WebUI.sendKeys(findTestObject('Object Repository/Web/ProfilePage/heightField'),"170")

WebUI.sendKeys(findTestObject('Object Repository/Web/ProfilePage/wightField'),"70")

WebUI.sendKeys(findTestObject('Object Repository/Web/ProfilePage/labelField', ['name' : "phone"]),no_telepon)

WebUI.sendKeys(findTestObject('Object Repository/Web/ProfilePage/alamatField'),"Kuningan,Jakarta Selatan")

WebUI.click(findTestObject('Object Repository/Web/ProfilePage/simpan_btn'))

WebUI.delay(5)

WebUI.closeBrowser()