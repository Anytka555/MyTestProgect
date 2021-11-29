import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RozetkaFirstTest {
    WebDriver driver;

    @BeforeMethod

    public void before() {
        System.setProperty("webdriver.chrome.driver", "/Users/annaluchenkova/IdeaProjects/MyTestProgect/src/test/TestSuites/chromedriver 2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");

    }

    // titleOfFirstItem
    public void waitForElementVisibility(String titleOfFirstItem) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//a[@class=\"goods-tile__heading ng-star-inserted\"]")));
    }

    @Test
    public void firstTest() {

        WebElement inputSearch = driver.findElement(By.xpath("//input[@name='search']"));
        inputSearch.sendKeys("Mac");
        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(text(), 'Найти')]"));
        searchBtn.click();

        WebElement titleOfFirstItem = driver.findElement(By.xpath("//a[@class=\"goods-tile__heading ng-star-inserted\"]"));
        String titleOfFirstItemText = titleOfFirstItem.getText().trim();
        String titleOfFirstItemTextExpected = "Бокал для шампанского Chef&Sommelier 300 мл серия Macaron (L9348)";

        assertEquals(titleOfFirstItemTextExpected, titleOfFirstItemText, "Бокал для шампанского Chef&Sommelier 300 мл серия Macaron (L9348)");
    }

    @AfterMethod
    public void after() {

        if (driver != null) {
            driver.quit();
        }
    }
}



