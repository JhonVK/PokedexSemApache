package modelos.Trie;
import java.util.ArrayList;
import java.util.Comparator;


import modelos.Pokemons.Pokemon;

public class Trie{
    private Nodetrie raiz; 
    private static ArrayList<Pokemon> listaPokemons = new ArrayList<Pokemon>(); //Lista que vamos usar para imprimir os pokemons na ordem correta

    public Trie(){
        this.raiz=new Nodetrie();
    }

    public void inserir(Pokemon pokemon){
        String name = pokemon.getName().toLowerCase();
        Nodetrie atual = raiz;

        for(char ch : name.toCharArray()){ //Percorrendo a string
            atual.getFilho().putIfAbsent(ch, new Nodetrie()); //So inserimos caso nao exista (putIfAbsent)
            atual = atual.getFilho().get(ch); 
        }
        atual.setFinal(); //Aqui é o final da palavra
        atual.setPokemon(pokemon); //Aqui setamos o pokemon
    }

    public void pesquisar(Pokemon pokemon){
        String name = pokemon.getName().toLowerCase(); //Transformando a string em minuscula
        Nodetrie atual = raiz;

        for(char ch : name.toCharArray()){ 
            if(atual.getFilho().get(ch)!=null){ 
                atual = atual.getFilho().get(ch);  //se o filho for igual ao primeiro caracter nos continuamos
            }else{
                System.out.println("Pokémon não encontrado."); //se nao, o pokemon nao existe
                return;
            }
        }
            if(atual.getFinal()){ //se chegarmos ao fim da palavra significa que achamos o pokemon
                atual.getPokemon().printPokemon();
                System.out.println("\n");
            }else{
                System.out.println("Pokémon não encontrado.");
            }
    }
    public void pesquisaPrefixo(String prefixo, int intervalo, int intervalo2){
        Nodetrie atual = raiz;
        listaPokemons.clear();
        for(char ch : prefixo.toCharArray()){ 
            if(atual.getFilho().get(ch)!=null){
                atual = atual.getFilho().get(ch); //se o filho for igual ao primeiro caracter nos continuamos
            }else{
                System.out.println("Prefixo não existe."); //se nao, o prefixo nao existe
                return;
            }
        }
        recursivo(atual, intervalo, intervalo2);//esse e o nodo que tem o ultimo carac do prefixo
        imprimirLista();

    }
    public void imprimirLista(){
        for(Pokemon p : listaPokemons){
            System.out.println("Nome: "+p.getName()+ "\nExperiência: "+p.getBaseExperience() +" \n");     
        }
    }
    public void recursivo(Nodetrie atual, int intervalo, int intervalo2){
        String alfabeto = "abcdefghijklmnopqrstuvwxyz"; //assim vamos procurar por todas as letras do alfabeto a partir do prefixo (atual)
    
        for(char ch : alfabeto.toCharArray()){
            Nodetrie proximo = atual.getFilho().get(ch);
            if(proximo != null){
                recursivo(proximo, intervalo, intervalo2);
            }
        }
    
        if(atual.getFinal() && atual.getPokemon().getBaseExperience() >= intervalo && atual.getPokemon().getBaseExperience() <= intervalo2){ //se for o final da palavra e estiver no intervalo
            listaPokemons.add(atual.getPokemon()); //adicionamos o pokemon na lista
            listaPokemons.sort((Comparator.comparingInt(Pokemon::getBaseExperience).reversed())); //ordenamos a lista
        }

    }
    
}
