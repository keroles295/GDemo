package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class EmployeeInformationPage  {
    @FindBy(id="empsearch_id")
    public WebElement idEmployeeSearch;

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement nameEmployeeSearch;

    @FindBy(id="searchBtn")
    public WebElement searchButton;


    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
    public List<WebElement> recentAddedEmployeeTable;

    //public EmployeeInformationPage(){
      //  PageFactory.initElements(driver, this);
  //  }
}