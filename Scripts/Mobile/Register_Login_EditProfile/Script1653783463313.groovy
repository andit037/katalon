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
import java.sql.Timestamp;
import org.openqa.selenium.By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.MobileElement;
import io.appium.java_client.MobileBy

//Launch the app

Mobile.startExistingApplication(GlobalVariable.sehatPackageName)

Mobile.waitForElementPresent(findTestObject('Mobile/HomePage/tidak_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/HomePage/tidak_btn',[('packageName') : GlobalVariable.sehatPackageName]),
	10)

Mobile.delay(5)

Mobile.waitForElementPresent(findTestObject('Mobile/HomePage/profile_btn',[('packageName') : GlobalVariable.sehatPackageName]),
	30)

Mobile.tap(findTestObject('Mobile/HomePage/profile_btn',[('packageName') : GlobalVariable.sehatPackageName]),
	30)

//Go to and inserting mandatory field on Daftar-Page
Mobile.waitForElementPresent(findTestObject('Mobile/LoginPage/signUp_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/LoginPage/signUp_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.waitForElementPresent(findTestObject('Mobile/DaftarPage/namaLengkap_Field',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.setText(findTestObject('Mobile/DaftarPage/namaLengkap_Field',[('packageName') : GlobalVariable.sehatPackageName]), accountName,10)

Timestamp timestamp = new Timestamp(System.currentTimeMillis())

String emailName = "testSehat"+timestamp.getTime()+"@gmail.com"
System.out.println(timestamp.getTime());

Mobile.setText(findTestObject('Mobile/DaftarPage/email_Field',[('packageName') : GlobalVariable.sehatPackageName]), emailName,10)

Mobile.setText(findTestObject('Mobile/DaftarPage/password_Field',[('packageName') : GlobalVariable.sehatPackageName]), password,10)

Mobile.tap(findTestObject('Mobile/DaftarPage/checkBox_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/DaftarPage/daftar_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.waitForElementPresent(findTestObject('Mobile/ProfilePage/lewati_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/ProfilePage/lewati_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.waitForElementPresent(findTestObject('Mobile/ProfilePage/yes_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/ProfilePage/yes_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

//Confirm Log-Out

Mobile.waitForElementPresent(findTestObject('Mobile/ProfilePage/threeVerticalDots',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/ProfilePage/threeVerticalDots',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.waitForElementPresent(findTestObject('Mobile/ProfilePage/PengaturanAplikasi_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/ProfilePage/PengaturanAplikasi_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.waitForElementPresent(findTestObject('Mobile/ProfilePage/logOut_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/ProfilePage/logOut_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.waitForElementPresent(findTestObject('Mobile/ProfilePage/yes_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/ProfilePage/yes_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.waitForElementPresent(findTestObject('Mobile/HomePage/tidak_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/HomePage/tidak_btn',[('packageName') : GlobalVariable.sehatPackageName]),
	10)

Mobile.tap(findTestObject('Mobile/HomePage/profile_btn',[('packageName') : GlobalVariable.sehatPackageName]),
	10)

//Go to Login Page
Mobile.waitForElementPresent(findTestObject('Mobile/DaftarPage/email_Field',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.setText(findTestObject('Mobile/DaftarPage/email_Field',[('packageName') : GlobalVariable.sehatPackageName]), emailName,10)

Mobile.setText(findTestObject('Mobile/DaftarPage/password_Field',[('packageName') : GlobalVariable.sehatPackageName]), password,10)

Mobile.tap(findTestObject('Mobile/LoginPage/login_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

//Editing to Profile Page
Mobile.waitForElementPresent(findTestObject('Mobile/ProfilePage/noTelpon_field',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.setText(findTestObject('Mobile/ProfilePage/noTelpon_field',[('packageName') : GlobalVariable.sehatPackageName]), noTelpon,10)

Mobile.tap(findTestObject('Mobile/ProfilePage/dob_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

AppiumDriver driver = MobileDriverFactory.getDriver()

List <WebElement> calendar = driver.findElementsById("android:id/numberpicker_input")

//Get date-Now
for(int i=0; i<calendar.size();i++) {
	System.out.println(calendar.get(i).getText())
} 

String day = "18";
String month = "May";
String year = "1989";

MobileElement elDay = driver.findElementByXPath("//*[@class = 'android.widget.NumberPicker' and @index = '0']/android.widget.EditText")
System.out.println("day1111  "+elDay.getText())
MobileElement elMonth = driver.findElementByXPath("//*[@class = 'android.widget.NumberPicker' and @index = '1']/android.widget.EditText")
System.out.println("month1111  "+elMonth.getText())
MobileElement elYear = driver.findElementByXPath("//*[@class = 'android.widget.NumberPicker' and @index = '2']/android.widget.EditText")
System.out.println("year1111  "+elYear.getText())

boolean isScroll=true

while(isScroll) {
	if(!(elDay.getText()).equals(day)) {
		elDay = driver.findElement(MobileBy.AndroidUIAutomator(
			"new UiScrollable(new UiSelector().scrollable(true).instance(0))"+
			".scrollBackward(2).scrollIntoView(new UiSelector().className(\"android.widget.EditText\")"+
			".resourceId(\"android:id/numberpicker_input\"))"))
		System.out.println("day    "+elDay.getText())
	}else if(!(elMonth.getText()).equals(month)) {
		elMonth = driver.findElement(MobileBy.AndroidUIAutomator(
			"new UiScrollable(new UiSelector().scrollable(true).instance(1))"+
			".scrollBackward(2).scrollIntoView(new UiSelector().className(\"android.widget.EditText\")"+
			".resourceId(\"android:id/numberpicker_input\").instance(1))"))
		System.out.println("month  "+elMonth.getText())
	}else if(!(elYear.getText()).equals(year)) {
		elYear = driver.findElement(MobileBy.AndroidUIAutomator(
			"new UiScrollable(new UiSelector().scrollable(true).instance(2))"+
			".scrollBackward(2).scrollIntoView(new UiSelector().className(\"android.widget.EditText\")"+
			".resourceId(\"android:id/numberpicker_input\").instance(2))"))
		System.out.println("year   "+elYear.getText())
	}else
		isScroll=false		
}

Mobile.tap(findTestObject('Mobile/ProfilePage/pilih-btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/ProfilePage/jenisKelamin_field',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/ProfilePage/perempuan',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/ProfilePage/jenisIdentitas_field',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.tap(findTestObject('Mobile/ProfilePage/ktp',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.setText(findTestObject('Mobile/ProfilePage/noIdentitas_field',[('packageName') : GlobalVariable.sehatPackageName]), ktp,10)

Mobile.tap(findTestObject('Object Repository/Mobile/ProfilePage/lanjut_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.delay(5)