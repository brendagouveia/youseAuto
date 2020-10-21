package supporte;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class VerificarElemento {



  //espera pelo elemento
    public static boolean verificar(WebDriver driver, String elemento, String tipo, int tempo) {
        System.out.println("testar se o elemento está visivel");
        boolean verificar = false;
        boolean controlaRepeat = false;
        int conta = 0;
        while (!verificar) {
            try {

                if (tipo.toUpperCase().contains("ID")) {
                    driver.findElement(By.id(elemento)).isDisplayed();
                } else if (tipo.toUpperCase().contains("NAME")) {
                    driver.findElement(By.name(elemento)).isDisplayed();
                } else if (tipo.toUpperCase().contains("XPATH")) {
                    driver.findElement(By.xpath(elemento)).isDisplayed();
                } else if (tipo.toUpperCase().contains("CLASS")) {
                    driver.findElement(By.className(elemento)).isDisplayed();
                } else if (tipo.toUpperCase().contains("ATIVO")) {
                    driver.findElement(By.id(elemento)).isEnabled();
                }
                verificar = true;
                controlaRepeat = true;
                System.out.println("achou o elemento");


            }finally {
                if (verificar==false){
                    conta = conta + 1;
                    System.out.println("não achou o elemento");
                }

                if (conta < tempo) {
                    continue;
                }else{
                    controlaRepeat = false;
                }

            }
        }
        return controlaRepeat;
    }


    //metodo para verificar se elememto existe
    public static boolean verificarExiste(WebDriver driver, String elemento, String tipo, int tempo) {
        System.out.println("testar se o elemento está visivel");
        boolean verificar = false;
        for (int i=0;i<=tempo;i++){
            if (tipo.toUpperCase().contains("ID")) {
                if (driver.findElements(By.id(elemento)).size()>0){
                    verificar = true;
                }
            } else if (tipo.toUpperCase().contains("NAME")) {
                if (driver.findElements(By.name(elemento)).size()>0){
                    verificar = true;
                }
            } else if (tipo.toUpperCase().contains("XPATH")) {
                if (driver.findElements(By.xpath(elemento)).size()>0){
                    verificar = true;
                }
            } else if (tipo.toUpperCase().contains("CLASS")) {
                if (driver.findElements(By.className(elemento)).size()>0){
                    verificar = true;
                }
            }
        }

        return verificar;
    }

}


