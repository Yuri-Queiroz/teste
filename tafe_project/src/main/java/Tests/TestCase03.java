package Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.Locale;

public class TestCase03 {

    private static Faker faker = new Faker(new Locale("PT-BR"));
    public WebDriver browser;
    public static WebDriverWait wait;

    @BeforeTest
    public void abrirNavegador(){
        String caminho = "driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", caminho);
        browser = new ChromeDriver();
        wait = new WebDriverWait(browser, 40);
        browser.navigate().to("https://automationexercise.com/");
    }

    @Test
    public void LoginUserWithIncorrectEmailAndPassword(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        browser.findElement(By.tagName("body")).isDisplayed();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href=\"/login\"]")));
        browser.findElement(By.xpath("//a[@href=\"/login\"]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")));
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).isDisplayed();

        String email = faker.internet().emailAddress();
        String senha = faker.internet().password();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")));
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys(email);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")));
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys(senha);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")));
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")));
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).isDisplayed();
    }

    @AfterTest
    public void fechar(){
        browser.quit();
    }
}
