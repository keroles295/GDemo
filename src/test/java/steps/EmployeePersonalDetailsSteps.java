package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.List;
import java.util.Map;

public class EmployeePersonalDetailsSteps extends CommonMethods {

    @When("user finds the new employee and clicks on it")
    public void user_finds_the_new_employee_and_clicks_on_it() throws InterruptedException {
        int sizeOfTable=emp.recentAddedEmployeeTable.size();
        for(int i=0; i<sizeOfTable; i++){
          String rowText=emp.recentAddedEmployeeTable.get(i).getText();
          if (!rowText.isEmpty()){
              List<WebElement> checkBoxEmp=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
              checkBoxEmp.get(i).click();
              Thread.sleep(3000);
          }
        }

    }
    @Then("user navigated to Personal Details and user clicks on edit button")
    public void user_navigated_to_personal_details_and_user_clicks_on_edit_button() {
        click(personalDetails.editeAndSaveButton);
    }

    @When("user fills out all of the information from excel file using {string} sheet")
    public void user_fills_out_all_of_the_information_from_excel_file_using_sheet(String sheetName) {
        List<Map<String, String>>listOfmapsEmpl=ExcelReader.excelListIntoMap(Constants.TEST_DATA_FILEPATH,sheetName);
        for (Map<String, String> excelgMap : listOfmapsEmpl) {
         sendText(personalDetails.otherId,excelgMap.get("otherId") );
         sendText(personalDetails.driversLicenseNumber, excelgMap.get("dLNumber"));
         click(personalDetails.licenseExpiryDate);
         click(personalDetails.ddMonthForLED);
        selectDropdown(personalDetails.ddMonthForLED, excelgMap.get("ddMonthLED"));
        selectDropdown(personalDetails.ddYearForLED, excelgMap.get("ddYearFLED"));
        for(WebElement dayOfLEDTable: personalDetails.calenderOfLED){
            String dayOfLed=dayOfLEDTable.getText();
            if (dayOfLed.equals(excelgMap.get("ddForDaysOfLED"))){
                click(dayOfLEDTable);
                break;
            }
        }
        sendText(personalDetails.sSNNumber,excelgMap.get("sSNNumber"));
        sendText(personalDetails.sINNumber,excelgMap.get("sINNumber"));
        click(personalDetails.femaleOption);
        selectDropdown(personalDetails.maritalStatusDD, excelgMap.get("ddForMaritalStatus"));
       selectDropdown(personalDetails.nationalityDD, excelgMap.get("ddForNationality"));
       click(personalDetails.dateOfBirthButton);
       selectDropdown(personalDetails.ddMonthForDOB, excelgMap.get("ddMonthForDOB"));
        selectDropdown(personalDetails.ddYearForDOB,excelgMap.get("ddYearForDOB"));
            for (WebElement dateOfBirthTR:personalDetails.calenderOfDOB
                 ) {
                String dayOfB =dateOfBirthTR.getText();
                if (dayOfB.equals(excelgMap.get("dayOfDOB"))){
                    click(dateOfBirthTR);
                    break;
                }
            }
        sendText(personalDetails.nickName, excelgMap.get("nickName"));
        if(!personalDetails.smokeOption.isSelected()){
            jsClick(personalDetails.smokeOption);
        }
        sendText(personalDetails.militaryService, excelgMap.get("militaryService"));


        }

    }
    @When("user clicks on save button to save all of the information")
    public void user_clicks_on_save_button_to_save_all_of_the_information() {
        click(personalDetails.editeAndSaveButton);
    }

    @When("user clicks on add attachment")
    public void user_clicks_on_add_attachment() {
        click(personalDetails.attachmentsButton);

    }
    @When("user attacths file and add comment from excel file using {string} sheet")
    public void user_attacths_file_and_add_comment_from_excel_file_using_sheet(String sheetName) {

        List<Map<String, String>>exclListMap=ExcelReader.excelListIntoMap(Constants.TEST_DATA_FILEPATH, sheetName);
        for (Map<String, String> stringStringMap : exclListMap) {
            sendText(personalDetails.chooceFileButton, stringStringMap.get("choiseFilePath"));
            sendText(personalDetails.addComment, stringStringMap.get("comment"));
        }
    }

    @When("user clicks on upload button")
    public void user_clicks_on_upload_button() {
        click(personalDetails.uploadButton);
    }

    @Then("user verifies that the attachement has been uploaded  using {string} sheet")
    public void user_verifies_that_the_attachement_has_been_uploaded_using_sheet(String sheetName) {
        List<Map<String, String>> excListM=ExcelReader.excelListIntoMap(Constants.TEST_DATA_FILEPATH, sheetName);
        for (Map<String, String> mpData : excListM) {



            List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='tblAttachments']/tbody/tr/td[3]"));
            for (WebElement rowDatum : rowData) {
                String expectedT = mpData.get("comment");

                String actualText = rowDatum.getText();
                System.out.println(actualText);
                Assert.assertEquals(expectedT, actualText);




            }
        }


    }


}
