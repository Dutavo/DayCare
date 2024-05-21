package dcx.ufpb.projeto;

import java.util.ArrayList;

/**
 * Interface do Programa..............
 */


public interface PokemonSystemInterface {

    //Métodos a Implementar.....................
    void cadastraPokemon(String nomeDoTreinador, String especieDoPokemon, String nivelDoPokemon, String sexoDoPokemon) throws AlreadyRegisteredPokemon;

    ArrayList<Pokemon> pesquisaPokemons(String nomeDoTreinador, String especieDoPokemon, String nivelDoPokemon, String sexoDoPokemon);

    ArrayList<Pokemon> listarPokemonsCadastrados();

    void apagarPokemonsDoSistema(String nomeDoTreinador, String especieDoPokemon) throws NonAlreadyRegistered;
}
