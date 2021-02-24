package basico;

import java.io.*;
import java.util.ArrayList;

public class NrArquivo {

    //String tipoSO="WINDOWS";
    String tipoSO="LINUX";

    public ArrayList<String> carregarArquivos() {
        ArrayList<String> listaNrlinha = new ArrayList<String>();
        File[] files;
        if (tipoSO.contains("WINDOWS")) {
            files = new File("D:\\youse\\arquivos\\").listFiles();
        } else {
            files = new File("/home/robertinho/youse/arquivos/").listFiles();
        }
        //

        try {
            for (File file : files) {
                listaNrlinha.add(file.getName());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaNrlinha;
    }

    public void deleteArquivo(String nrtxt, String tipo) throws IOException {
        File arqOrigem = null;
        File arqDestino = null;

        if (tipoSO.contains("WINDOWS")) {
            if (tipo.toUpperCase().contains("PRONTOS")) {
                arqOrigem = new File("D:\\youse\\arquivos\\" + nrtxt);
                arqDestino = new File("D:\\youse\\prontos\\" + nrtxt);
            } else if (tipo.toUpperCase().contains("CARRO")) {
                arqOrigem = new File("D:\\youse\\arquivos\\" + nrtxt);
                arqDestino = new File("D:\\youse\\carro\\" + nrtxt);
            } else if (tipo.toUpperCase().contains("RESTRICAO VEICULO")) {
                arqOrigem = new File("D:\\youse\\arquivos\\" + nrtxt);
                arqDestino = new File("D:\\youse\\restricao veiculo\\" + nrtxt);
            } else if (tipo.toUpperCase().contains("RESTRICAO")) {
                arqOrigem = new File("D:\\youse\\arquivos\\" + nrtxt);
                arqDestino = new File("D:\\youse\\restricao\\" + nrtxt);
            }
        } else {
            if (tipo.toUpperCase().contains("PRONTOS")) {

                arqOrigem = new File("/home/robertinho/youse/arquivos/" + nrtxt);
                arqDestino = new File("/home/robertinho/youse/prontos/" + nrtxt);
            } else if (tipo.toUpperCase().contains("CARRO")) {
                arqOrigem = new File("/home/robertinho/youse/arquivos/" + nrtxt);
                arqDestino = new File("/home/robertinho/youse/carro/" + nrtxt);
            } else if (tipo.toUpperCase().contains("RESTRICAO VEICULO")) {
                arqOrigem = new File("/home/robertinho/youse/arquivos/" + nrtxt);
                arqDestino = new File("/home/robertinho/youse/restricao veiculo/" + nrtxt);
            } else if (tipo.toUpperCase().contains("RESTRICAO")) {
                arqOrigem = new File("/home/robertinho/youse/arquivos/" + nrtxt);
                arqDestino = new File("/home/robertinho/youse/restricao/" + nrtxt);
            }
        }


        if (arqOrigem.exists() && arqOrigem.isFile()) {
            InputStream in = new FileInputStream(arqOrigem);
            OutputStream out = new FileOutputStream(arqDestino);
            // Transferindo bytes de entrada para saída
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = in.read(buffer)) > 0) {
                out.write(buffer, 0, lenght);
            }
            in.close();
            out.close();
            boolean i = true;
            while (i) {
                if (arqOrigem.delete()) {
                    i = false;
                } else {
                    System.gc();
                }
            }

        }
    }

    public void deleteArquivoRestrito(String nrtxt) throws IOException {
        File arqOrigem;
        if (tipoSO.contains("WINDOWS")){
             arqOrigem = new File("D:\\youse\\pdf\\" + nrtxt);
        }else{
             arqOrigem = new File("/home/robertinho/youse/pdf/" + nrtxt);
        }


        if (arqOrigem.exists() && arqOrigem.isFile()) {

            boolean i = true;
            while (i) {
                if (arqOrigem.delete()) {
                    i = false;
                } else {
                    System.gc();
                }
            }

        }
    }
}





