package tests;

import basico.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.util.ArrayList;


public class TestYouse {
    private WebDriver driver;

    @Test
    public void ativarYouse() {


        //instanciando classes que serão utilizadas
        NrArquivo nrlinha = new NrArquivo();
        LerArquivoYouse arquivo = new LerArquivoYouse();
        AbrirYouse abrirNavegador = new AbrirYouse();
        Tela1 tela = new Tela1();
        Tela2 tela2=new Tela2();
        Tela3 tela3=new Tela3();
        Tela4 tela4=new Tela4();
        //fim instanciando


        //carregar numlinha dos arquivos na pasta
        ArrayList<String> listaNr = nrlinha.carregarArquivos();
        System.out.println("carregou lista com numero dos arquivos");

        if (listaNr.size() == 0) {
            JOptionPane.showMessageDialog(null, "Acabou todos os arquivos!");
        }

        while (listaNr.size() > 0) {

            try {

                //chamar o abrir que retornar o navegador com a consulta do calculo realizada
                driver = abrirNavegador.abrirNavegadorYouse();
                //setar no objeto as informações contida no arquivo
                Variaveis variaveis = arquivo.lerArquivoNr(listaNr.get(0));
                //adicionar o nrlinha no objeto
                variaveis.setNrlinha(listaNr.get(0));

                tela.preencherTela1(driver, variaveis);
                String retorno = tela2.preencherTela2(driver, variaveis);
                if (retorno.contains("OK")) {
                    boolean aceita = tela2.verificarAceita(driver, variaveis);
                    if (aceita) {
                        tela3.preencherTela3(driver, variaveis);
                        tela4.preencherTela4(driver, variaveis);
                    }
                    //mover arquivo para prontos
                    nrlinha.deleteArquivo(listaNr.get(0), "PRONTOS");
                } else if (retorno.contains("CARRO")) {
                    //carro com descrição errada
                    nrlinha.deleteArquivo(listaNr.get(0), "CARRO");
                } else if (retorno.contains("RESTRICAO VEICULO")) {
                    nrlinha.deleteArquivo(listaNr.get(0), "RESTRICAO VEICULO");
                }

                //carregar novamente os arquivos da pasta
                listaNr = nrlinha.carregarArquivos();
                if (listaNr.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Acabou todos os arquivos!");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());

            } finally {
                driver.quit();
                System.gc();
                continue;

            }
        }
    }
}
