package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;


import java.util.List;

public class EmployeePersonalDetails extends CommonMethods {

    @FindBy(id = "personal_txtOtherID")
    public WebElement otherId;
    @FindBy(xpath = "//input[@id='personal_txtLicenNo']")
    public WebElement driversLicenseNumber;
    @FindBy(xpath = "//input[@id='personal_txtLicExpDate']")
    public WebElement licenseExpiryDate;
    @FindBy(id = "btnSave")
    public WebElement editeAndSaveButton;

    @FindBy(className = "ui-datepicker-month")
    public WebElement ddMonthForLED;
    @FindBy(className = "ui-datepicker-year")
    public WebElement ddYearForLED;
    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
    public List <WebElement> calenderOfLED;
    @FindBy(id = "personal_txtNICNo")
    public WebElement sSNNumber;
    @FindBy(id = "personal_txtSINNo")
    public WebElement sINNumber;
    @FindBy(xpath = "//label[text()='Male']")
    public WebElement maleOption;
    @FindBy(xpath = "//label[text()='Female']")
    public WebElement femaleOption;
    @FindBy(id = "personal_cmbMarital")
    public WebElement maritalStatusDD;
    @FindBy(id = "personal_cmbNation")
    public WebElement nationalityDD;
    @FindBy(id = "personal_DOB")
    public WebElement dateOfBirthButton;
    @FindBy(className = "ui-datepicker-month")
    public WebElement ddMonthForDOB;
    @FindBy(className = "ui-datepicker-year")
    public WebElement ddYearForDOB;
    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
    public List<WebElement> calenderOfDOB;
    @FindBy(id = "personal_txtEmpNickName")
    public WebElement nickName;
    @FindBy(id = "personal_chkSmokeFlag")
    public WebElement smokeOption;
    @FindBy(id = "personal_txtMilitarySer")
    public WebElement militaryService;
    @FindBy(id = "btnAddAttachment")
    public WebElement attachmentsButton;
    @FindBy(id = "ufile")
    public WebElement chooceFileButton;
    @FindBy(id = "txtAttDesc")
    public WebElement addComment;
    @FindBy(id = "btnSaveAttachment")
    public WebElement uploadButton;
    @FindBy(id = "cancelButton")
    public WebElement cancelButton;


    public EmployeePersonalDetails(){
        PageFactory.initElements(driver,this);
    }



}
