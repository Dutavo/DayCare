package dcx.ufpb.projeto;

/**
 * Exception Para os Pokemons Já-Cadastrados...........
 */
public class AlreadyRegisteredPokemon extends Exception{
    public AlreadyRegisteredPokemon(String msg) {
        super(msg);
    }
}
