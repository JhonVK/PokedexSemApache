package modelos.B;
import java.util.ArrayList;
import java.util.List;


import modelos.Pokemons.Pokemon;


public class Bnode {
    private ArrayList<Bnode> filhos; //filhos
    private ArrayList<Pokemon> chaves; //chaves
    private Boolean folha; //se é folha


    public Bnode(boolean folha){
        this.folha = folha;
        this.filhos = new ArrayList<Bnode>();
        this.chaves = new ArrayList<Pokemon>();
    }

    public List<Pokemon> getKeys() {
        return chaves;
    }

    public List<Bnode> getChildren() {
        return filhos;
    }
    
    public boolean isfolha() {
        return folha;
    }
    
    public void setfolha(boolean folha) {
        this.folha = folha;
    }

    public void setKeys(ArrayList<Pokemon> chaves) {
        this.chaves = chaves;
    }

    public void setChildren(ArrayList<Bnode> filhos) {
        this.filhos = filhos;
    }

    public void addKey(Pokemon chave) {
        chaves.add(chave);
    }

    public void addChild(Bnode filho) {
        filhos.add(filho);
    }

    public void clearKeys() {
        chaves.clear();
    }

    public void clearChildren() {
        filhos.clear();
    }

    public void insertKey(int index, Pokemon chave) {
        chaves.add(index, chave);
    }

    public void insertChild(int index, Bnode filho) {
        filhos.add(index, filho);
    }
    
    public void splitChild(int i, Bnode y) {
        
    }

    public void printInOrder(int intervalo, int intervalo2) {
        int i;
        for(i=chaves.size()-1; i>=0; i--){
            if(!isfolha()){
                filhos.get(i+1).printInOrder(intervalo, intervalo2);
            }
            if(chaves.get(i).getBaseExperience()>=intervalo && chaves.get(i).getBaseExperience()<=intervalo2){
                System.out.println("Nome: "+ chaves.get(i).getName()+ "\nExperiência: "+ chaves.get(i).getBaseExperience());  
                System.out.println("\n");   
            }
        if(!isfolha()){
            filhos.get(0).printInOrder(intervalo, intervalo2);
        } 
    }

}}

      
    

