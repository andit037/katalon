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

//Editing to Profile Page
Mobile.waitForElementPresent(findTestObject('Mobile/ProfilePage/noTelpon_field',[('packageName') : GlobalVariable.sehatPackageName]), 10)

Mobile.setText(findTestObject('Mobile/ProfilePage/noTelpon_field',[('packageName') : GlobalVariable.sehatPackageName]), noTelpon,10)

Mobile.tap(findTestObject('Mobile/ProfilePage/dob_btn',[('packageName') : GlobalVariable.sehatPackageName]), 10)

String day = Mobile.getText(findTestObject('Mobile/ProfilePage/day'),10)
String month = Mobile.getText(findTestObject('Mobile/ProfilePage/month'),10)
String year = Mobile.getText(findTestObject('Mobile/ProfilePage/year'),10)

System.out.println("day "+day+" month "+month+" year "+year)

String dob = "1 Jan 2021"
String dateBirth = dob.split(" ")[0]
String monthBirth = dob.split(" ")[1]
String yearBirth = dob.split(" ")[2]

System.out.println("dateBirth "+dateBirth+" monthBirth "+monthBirth+" yearBirth "+yearBirth)

while(!day.equals(dateBirth)) {

	day = Mobile.getText(findTestObject('Mobile/ProfilePage/day'),10)
}

