package modelos.Trie;

import java.util.HashMap;

import modelos.Pokemons.Pokemon;

public class Nodetrie {
    private HashMap<Character, Nodetrie> filho;
    private boolean finalPalavra;
    private Pokemon pokemon;
    
    public Nodetrie(){
        this.filho=new HashMap<>();
        this.finalPalavra=false;
    }

    public void setFinal(){
        this.finalPalavra=true;
    }
    public boolean getFinal(){
        return this.finalPalavra;
    }

    public HashMap<Character, Nodetrie> getFilho() {
        return filho;
    }

    public void setFilho(HashMap<Character, Nodetrie> filho) {
        this.filho = filho;
    }

    public boolean isFinalPalavra() {
        return finalPalavra;
    }

    public void setFinalPalavra(boolean finalPalavra) {
        this.finalPalavra = finalPalavra;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
