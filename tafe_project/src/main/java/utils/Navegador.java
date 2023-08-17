package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Navegador {

    public static WebDriver driver;
    public static WebDriverWait wait;


    public void abrirNavegador(){
        String caminhoDriver = "driver/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", caminhoDriver);

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 40);

        driver.get("https://www.automationexercise.com");

        driver.manage().window().maximize();
    }

    public void abrirNavegadorComLogin(){
        String caminhoDriver = "driver/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", caminhoDriver);

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 40);

        driver.get("https://www.automationexercise.com/login");

        driver.manage().window().maximize();
    }

    public void fecharNavegador(){
        driver.quit();
    }


}
