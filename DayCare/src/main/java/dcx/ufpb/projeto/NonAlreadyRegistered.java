package dcx.ufpb.projeto;

/**
 * Exception Para os Pokemons Não-Cadastrados........
 */

public class NonAlreadyRegistered extends Exception{
    public NonAlreadyRegistered(String msg) {
        super(msg);
    }
}
