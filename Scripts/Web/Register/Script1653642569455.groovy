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

WebUI.openBrowser('')

WebUI.deleteAllCookies()

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.sehatqBaseUrl)



WebUI.verifyElementPresent(findTestObject('Web/HomePage/account_btn'),5)

WebUI.click(findTestObject('Web/HomePage/account_btn'))


Timestamp timestamp = new Timestamp(System.currentTimeMillis())
 
String emailName = "testSehat"+timestamp.getTime()+"@gmail.com"
System.out.println(timestamp.getTime());

WebUI.scrollToElement(findTestObject('Object Repository/Web/LoginPage/loginButton'), 5)

WebUI.verifyElementPresent(findTestObject('Object Repository/Web/HomePage/daftar_btn'),5)

WebUI.click(findTestObject('Object Repository/Web/HomePage/daftar_btn'))

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

WebUI.delay(5)

if(WebUI.verifyElementClickable(findTestObject('Object Repository/Web/Daftar_EmailPage/daftarConfirm_btn'), FailureHandling.STOP_ON_FAILURE))
	WebUI.click(findTestObject('Object Repository/Web/Daftar_EmailPage/daftarConfirm_btn'))  
else
	System.out.println('Daftar Button still disable')
WebUI.delay(10)



