package dcx.ufpb.projeto;

import java.util.Objects;

/**
 * Classe Onde estão os Atributos e Construtores do Programa..............
 */

public class Pokemon {
    private String nomeDoTreinador;
    private String especieDoPokemon;
    private String nivelDoPokemon;
    private String sexoDoPokemon;

    public Pokemon(String nomeDoTreinador, String especieDoPokemon,String nivelDoPokemon, String sexoDoPokemon){
        this.nomeDoTreinador= nomeDoTreinador;
        this.especieDoPokemon=especieDoPokemon;
        this.nivelDoPokemon= nivelDoPokemon;
        this.sexoDoPokemon= sexoDoPokemon;
    }
    public Pokemon(){
        this("","","","");
    }
    public String getNomeDoTreinador(){
        return this.nomeDoTreinador;
    }
    public void setNomeDoTreinador(String nomeT){
        this.nomeDoTreinador= nomeT;
    }

    public String getEspecieDoPokemon() {
        return especieDoPokemon;
    }
    public void setEspecieDoPokemon(String especie){
        this.especieDoPokemon= especie;
    }

    public String getNivelDoPokemon() {
        return nivelDoPokemon;
    }
    public void setNiveldoPokemon(String nivel){
        this.nivelDoPokemon= nivel;
    }
    public String getSexoDoPokemon(){
        return this.sexoDoPokemon;
    }
    public void setSexoDoPokemon(String sexoPokemon){
        this.sexoDoPokemon= sexoPokemon;
    }

    @Override
    public String toString() {
        return "Treinador de nome '" + this.nomeDoTreinador+ "'. \nEspecíe do pokemon: '"+ this.especieDoPokemon +"'. \nNível do Pokemon: '" + this.nivelDoPokemon + "'. \nSexo do Pokemon: '"+ this.sexoDoPokemon+ "'.\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return nivelDoPokemon == pokemon.nivelDoPokemon && nomeDoTreinador.equals(pokemon.nomeDoTreinador) && especieDoPokemon.equals(pokemon.especieDoPokemon) && sexoDoPokemon.equals(pokemon.sexoDoPokemon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeDoTreinador, especieDoPokemon, nivelDoPokemon, sexoDoPokemon);
    }
}
