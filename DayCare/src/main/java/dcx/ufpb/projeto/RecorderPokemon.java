package dcx.ufpb.projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RecorderPokemon {

    private String arquivoPokemon = "Pokemon.txt";

    private RecorderDataPokemon gravador;

    public RecorderPokemon(){
        this.gravador = new RecorderDataPokemon();
    }


    public void gravaPokemon(ArrayList<Pokemon> pokemons) throws IOException {
        ArrayList<String> textoAGravar = new ArrayList<>();
        for (Pokemon p: pokemons ){
            String linha = p.getNomeDoTreinador()+"###"+p.getEspecieDoPokemon()+"###"+p.getNivelDoPokemon()+"###"+p.getSexoDoPokemon();
            textoAGravar.add(linha);
        }
        this.gravador.gravaTextoEmArquivo(textoAGravar, this.arquivoPokemon);
    }

    public List<Pokemon> recuperaPokemon() throws IOException {
        List<String> dadosDosPokemon = this.gravador.recuperaTextoDeArquivo(this.arquivoPokemon);
        List<Pokemon> listaPokemon = new LinkedList<>();
        for (String s: dadosDosPokemon){
            String [] dados = s.split("###");
            Pokemon pokemon = new Pokemon(dados[0], dados[1], (dados[2]), dados[3]);
            listaPokemon.add(pokemon);
        }
        return listaPokemon;
    }

}
