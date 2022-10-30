package com.revature.steps.defect;

import com.revature.components.DefectAssigner;
import com.revature.components.Table;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.Page;
import com.revature.pages.ReportPage;
import com.revature.runners.DefectRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DefectTest {
    private static Page setuppage;
    private static Page managerpage;
    private static Table defects;
    private static int defectCount;
    private static DefectAssigner assigner;
    private static int submitButtonIndex;

    @BeforeAll
    public static void addDefect() {
        setuppage = new Page(new ChromeDriver());
        setuppage.get(DefectRunner.home);
        setuppage = LoginPage.from(setuppage).login("g8tor", "chomp!");
        setuppage = ReportPage.from(setuppage.clink("Report a Defect"));
        ReportPage.found(setuppage).sendKeys("12/10/2022");
        ReportPage.description(setuppage).sendKeys("Hello please resolve this");
        ReportPage.reproduction(setuppage).sendKeys("I don't understand what this field is for so I shall leave it blank");
        ReportPage.submit(setuppage).click();
        setuppage.alertAccept();
        setuppage.quit();
    }
    @Before
    public void setup() {
        // setup manager
        managerpage = new Page(new ChromeDriver());
        managerpage.get(DefectRunner.home);
        LoginPage.from(managerpage).login("g8tor", "chomp!");

        // setup tester
//        DefectRunner.testerDriver = new ChromeDriver();
//        DefectRunner.testerDriver.get(
//                "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=4"
//        );
//        DefectRunner.testerPage = new LoginPage(DefectRunner.testerDriver);
//        DefectRunner.testerPage = ((LoginPage)DefectRunner.testerPage).login("ryeGuy", "coolbeans");

        // setup employee
//        DefectRunner.employeeDriver = new ChromeDriver();
//        DefectRunner.employeeDriver.get(
//                "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=4"
//        );
//        DefectRunner.employeePage = new LoginPage(DefectRunner.employeeDriver);
//        DefectRunner.employeePage = ((LoginPage)DefectRunner.employeePage).login("cavalier89", "alucard");

    }

    @After
    public void cleanup() {
        managerpage.quit();
        //DefectRunner.testerDriver.quit();
        //DefectRunner.employeeDriver.quit();
    }

    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() {
        // will need to pull session cookies for real test
        if (! HomePage.validate(managerpage, "manager")) Assertions.fail("Driver was not on manager login page");
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        if (! HomePage.validate(managerpage, "manager")) Assertions.fail("Driver was not on manager login page");
    }
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        defects = HomePage.defectTable(managerpage);
        defectCount = defects.size();
        submitButtonIndex = defects.index("Select");
    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        defects.row(0).col(submitButtonIndex).findElement(By.tagName("button")).click();
    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        assigner = HomePage.defectAssigner(managerpage);
        String weight = assigner.description().getCssValue("font-weight");
        if (!weight.equals("700")) Assertions.fail("The font weight of the description was not bold");
    }
    @When("The manager selects an tester from the drop down")
    public void the_manager_selects_an_tester_from_the_drop_down() {
        assigner.select(0);
    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        HomePage.from(managerpage).assign();
    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        int current = defects.findElements(By.xpath("./tbody/tr")).size();
        if (defectCount >= defects.size()) Assertions.fail("The number of defects remained the same after defect removal");
    }
    @Given("The assigned tester is on their home page")
    public void the_assigned_tester_is_on_their_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
