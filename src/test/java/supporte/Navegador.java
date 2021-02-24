package supporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Navegador {

    public static WebDriver retornarNavegador() throws IOException, InterruptedException {

        ChromeDriver driver = null;


        //System.setProperty("webdriver.chrome.driver", "D:\\youse\\driver\\chromedriver.exe");
         System.setProperty("webdriver.chrome.driver", "/home/robertinho/drivers/chromedriver");



        System.out.println("iniciar o abrir");
        driver = new ChromeDriver();

        driver.get("https://www.youse.com.br/seguro-auto/");
        System.out.println("espera a janela abrir");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        return driver;
    }


}
