package dcx.ufpb.projeto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe Onde Está O Gravador de Dados Pokemon..............
 */

public class RecorderDataPokemon {

    //Recuperador de Texto Do Arquivo.............
    public List<String> recuperaTextoDeArquivo(String nomeArquivo)
            throws IOException {
        BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<>();
        try {
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String texto = null;
            do {
                texto = leitor.readLine();
                if (texto!=null){
                    textoLido.add(texto);
                }
            } while (texto!=null);
        } finally {
            if (leitor!=null){
                leitor.close();
            }
        }
        return textoLido;
    }

    //Gravador De Texto Arquivo................
    public void gravaTextoEmArquivo(List<String> texto, String nomeArquivo)
            throws IOException {
        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter(nomeArquivo, false));
            for (String s: texto){
                gravador.write(s+"\n");
            }
        } finally {
            if (gravador!=null){
                gravador.close();
            }
        }

    }
}