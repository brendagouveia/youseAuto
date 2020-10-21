package basico;

import org.openqa.selenium.*;
import supporte.Navegador;
import supporte.VerificarElemento;
import java.io.IOException;





public class AbrirYouse {

    private WebDriver driver;


    public WebDriver abrirNavegadorYouse() throws IOException, InterruptedException, ExceptionPorto {
        driver = Navegador.retornarNavegador();
        System.out.println("abriu o navegador");

        if (VerificarElemento.verificar(driver,"//*[contains(text(), 'Cotar agora')]","XPATH",30)){

            System.out.println("ACHOU O BOTAO DE COTACAO");
            driver.findElement(By.xpath("//*[contains(text(), 'Cotar agora')]")).click();

            Thread.sleep(2000);

        }
        return driver;

    }
}
