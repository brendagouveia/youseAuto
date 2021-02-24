package basico;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import supporte.VerificarElemento;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Impressao {

   // String tipoSO = "WINDOWS";
     String tipoSO="LINUX";

    public void imprimir(WebDriver driver, String nrlinha) throws IOException, UnsupportedFlavorException {
        String textoQueSeraEscrito;
        WebElement corpoPag = driver.findElement(By.id("container"));
        corpoPag.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        corpoPag.sendKeys(Keys.chord(Keys.CONTROL, "c"));


        final Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

        if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            textoQueSeraEscrito = (String) t.getTransferData(DataFlavor.stringFlavor);
            FileWriter arquivo;

            File file;
            if (tipoSO.contains("WINDOWS")) {
                file = new File("D:\\youse\\pdf\\" + nrlinha);
            } else {
                file = new File("/home/robertinho/youse/pdf/" + nrlinha);
            }

            arquivo = new FileWriter(file, true);
            if (file.exists()) {
                arquivo.append(textoQueSeraEscrito);
            } else {
                arquivo.write(textoQueSeraEscrito);
            }

            System.gc();
            arquivo.close();

        }


    }


    public void imprimirPDF(WebDriver driver, String nrlinha, String parte) throws IOException, UnsupportedFlavorException, InterruptedException, AWTException, FindFailed {
        String numeroPdf = nrlinha.replaceAll(".TXT", "");
        File file;
        if (tipoSO.contains("WINDOWS")) {
             file = new File("d:\\youse\\pdf\\" + parte + numeroPdf + ".pdf");
        }else{
            file = new File("/home/robertinho/youse/pdf/" + parte + numeroPdf + ".pdf");
        }
        if (!file.exists()) {


            if (VerificarElemento.verificar(driver, "container", "ID", 10)) {


                System.out.println("janela imprimir");
                Robot r = new Robot();
                r.keyPress(KeyEvent.VK_CONTROL);
                r.keyPress(KeyEvent.VK_P);
                r.keyRelease(KeyEvent.VK_CONTROL);
                r.keyRelease(KeyEvent.VK_P);
                Thread.sleep(18000);

                System.out.println("passou o tempo");

                Pattern btnimp;
                Pattern btnsalvar;

                System.out.println("VAI CARREGAR AS IMAGENS");
                try {
                    Screen s = new Screen();
                    if (tipoSO.contains("WINDOWS")) {
                        System.out.println("caminho");
                        btnimp = new Pattern("D:\\imagem\\imprimir.png");
                        btnsalvar = new Pattern("D:\\imagem\\salvar.png");
                        System.out.println(btnimp.toString());
                    } else {
                        btnimp = new Pattern("/home/robertinho/youse/imagem/imprimir.png");
                        btnsalvar = new Pattern("/home/robertinho/youse/imagem/salvar.png");

                    }


                    System.out.println("vai clicar");

                    s.click(btnimp);
                    Thread.sleep(18000);
                     numeroPdf = nrlinha.replaceAll(".TXT", "");
                    if (tipoSO.contains("WINDOWS")) {
                        s.type("d:\\youse\\pdf\\" + parte + numeroPdf);
                    } else {
                        s.type("/home/robertinho/youse/pdf/" + parte + numeroPdf);
                    }

                    Thread.sleep(1000);
                    s.click(btnsalvar);
                    Thread.sleep(3000);

                } catch (FindFailed e) {
                    System.out.println(e.getMessage());

                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }

                System.out.println("imprimiu");
            }
        }

    }

    public void imprimirRestricao(WebDriver driver, String nrlinha) throws IOException, UnsupportedFlavorException {
        String textoQueSeraEscrito;
        WebElement corpoPag = driver.findElement(By.id("container"));
        corpoPag.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        corpoPag.sendKeys(Keys.chord(Keys.CONTROL, "c"));


        final Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

        if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            textoQueSeraEscrito = (String) t.getTransferData(DataFlavor.stringFlavor);
            FileWriter arquivo;

            File file;
            if (tipoSO.contains("WINDOWS")) {
                file = new File("D:\\youse\\restricao\\" + nrlinha);
            } else {
                file = new File("/home/robertinho/youse/restricao/" + nrlinha);
            }

            arquivo = new FileWriter(file, true);
            if (file.exists()) {
                arquivo.append(textoQueSeraEscrito);
            } else {
                arquivo.write(textoQueSeraEscrito);
            }

            System.gc();
            arquivo.close();

        }


    }
}
