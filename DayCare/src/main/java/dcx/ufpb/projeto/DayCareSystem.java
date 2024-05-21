package dcx.ufpb.projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Principal para o Código DayCare, onde estão os métodos do programa.....
 */

public class DayCareSystem implements PokemonSystemInterface {

    private ArrayList<Pokemon> ListaDadosPokemons;
    private RecorderDataPokemon gravador = new RecorderDataPokemon();

    public DayCareSystem() {
        this.ListaDadosPokemons = new ArrayList<>();
    }

    public ArrayList<Pokemon> carregarPokemon(){
        ArrayList<Pokemon> Poke = new ArrayList<>();
        try {
            List<String> Linhas = gravador.recuperaTextoDeArquivo("Pokemon.txt");
            for (String l: Linhas) {
                Poke.add(new Pokemon(l.split("###")[0], l.split("###")[1], l.split("###")[2], l.split("###")[3]));
            }
        } catch (IOException e) {
        }
        return Poke;
    }

    public boolean existePokemon(String nomeDoTreinador, String especieDoPokemon, String nivelDoPokemon, String sexoDoPokemon) {
        for (Pokemon p : this.ListaDadosPokemons) {
            if (p.getNomeDoTreinador().equals(nomeDoTreinador) && p.getEspecieDoPokemon().equals(especieDoPokemon) && p.getSexoDoPokemon().equals(sexoDoPokemon) && p.getNivelDoPokemon().equals(nivelDoPokemon)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void cadastraPokemon(String nomeDoTreinador, String especieDoPokemon, String nivelDoPokemon, String sexoDoPokemon) throws AlreadyRegisteredPokemon {
        if (this.existePokemon(nomeDoTreinador, especieDoPokemon, nivelDoPokemon, sexoDoPokemon)) {
            throw new AlreadyRegisteredPokemon("Este seu Pokemon [" + especieDoPokemon + "] de nível:" + nivelDoPokemon + " e do sexo:" + sexoDoPokemon + "já está cadastrado");
        } else {
            Pokemon ListaPokemonCadastrados = new Pokemon(nomeDoTreinador, especieDoPokemon, nivelDoPokemon, sexoDoPokemon);
            this.ListaDadosPokemons.add(ListaPokemonCadastrados);
        }

    }

    @Override
    public ArrayList<Pokemon> pesquisaPokemons(String nomeDoTreinador, String especieDoPokemon, String nivelDoPokemon, String sexoDoPokemon) {
        ArrayList<Pokemon> ResultadoDaBusca = new ArrayList<>();

        for (Pokemon p : ListaDadosPokemons) {
            if ((nomeDoTreinador == null || p.getNomeDoTreinador().equals(nomeDoTreinador)) ||
                    (especieDoPokemon == null || p.getEspecieDoPokemon().equals(especieDoPokemon)) ||
                    (nivelDoPokemon == null || p.getNivelDoPokemon().equals(nivelDoPokemon)) ||
                    (sexoDoPokemon == null || p.getSexoDoPokemon().equals(sexoDoPokemon))) {

                ResultadoDaBusca.add(p);

            }
        }
        return ResultadoDaBusca;

    }

    @Override
    public ArrayList<Pokemon> listarPokemonsCadastrados() {
        return this.ListaDadosPokemons;
    }

    @Override
    public void apagarPokemonsDoSistema(String nomeDoTreinador, String especieDoPokemon) throws NonAlreadyRegistered {
        ArrayList<Pokemon> pokemonsRemover = new ArrayList<>();

        for (Pokemon p : ListaDadosPokemons) {
            if (p.getNomeDoTreinador().equals(nomeDoTreinador) &&
                    p.getEspecieDoPokemon().equals(especieDoPokemon)) {

                pokemonsRemover.add(p);
            } else {
                throw new NonAlreadyRegistered("As informações sobre o pokemon:  [" + especieDoPokemon + "] não foram cadastradas");
            }
        }

        ListaDadosPokemons.removeAll(pokemonsRemover);
    }


    public ArrayList<Pokemon> getListaDadosPokemons() {
        return ListaDadosPokemons;
    }

    public void setListaDadosPokemons(ArrayList<Pokemon> listaDadosPokemons) {
        ListaDadosPokemons = listaDadosPokemons;

    }
}