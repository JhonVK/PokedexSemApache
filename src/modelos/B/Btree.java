package modelos.B;

import modelos.Pokemons.Pokemon;

public class Btree{
    public Bnode raiz; // Raiz da árvore
    private Integer order; // Ordem da árvore

    public Btree(int order){
        this.order = order;
        this.raiz = null;
    }

    public Bnode getRaiz(){
        return raiz;
    }

    public void printBTree(int intervalo, int intervalo2) {
        if(raiz!=null){
            raiz.printInOrder(intervalo, intervalo2);
        }else{
            System.out.println("Árvore B vazia");
        }
    }

    public void inserir(Pokemon pokemon){
        if(raiz==null){ //Arvore vazia entao crio um novo no
            raiz=new Bnode(true);
            raiz.getKeys().add(pokemon);
            return;
        }else if(raiz.getKeys().size()==order){ //Arvore cheia, entao balancear
            Bnode novaRaiz = new Bnode(false);
            Bnode antigaraiz = raiz;
            
            raiz=novaRaiz;
            novaRaiz.getChildren().add(antigaraiz);
            dividirNo(novaRaiz, 0);
        }
        
        inserirNaoCheia(raiz, pokemon);
        
    }

    private void inserirNaoCheia(Bnode no, Pokemon pokemon){
        int i=no.getKeys().size()-1; //pegamos o tamanho da pag para saber onde inserir
        
        if(no.isfolha()){
            while (i>=0 && pokemon.getBaseExperience()<no.getKeys().get(i).getBaseExperience()) {
                no.getKeys().add(i+1, no.getKeys().get(i));
                no.getKeys().remove(i); //duplicamos e removemos para manter a ordem(confuso usei como base codigo do geeksforgeeks)
                i--;
            }
            no.getKeys().add(i+1, pokemon);
        }else{//caso nao seja folha
            while(i>=0 && pokemon.getBaseExperience()<no.getKeys().get(i).getBaseExperience()){
                i--;
            }
            i++;

            if(no.getChildren().get(i).getKeys().size()==order){
                dividirNo(no, i);  
                if(pokemon.getBaseExperience()>no.getKeys().get(i).getBaseExperience()){
                    i++;
                }
            }
            inserirNaoCheia(no.getChildren().get(i), pokemon);
        }
    }

    private void dividirNo(Bnode pai, int indiceFilho){

        Bnode filho = pai.getChildren().get(indiceFilho);
        Bnode novoFilho = new Bnode(filho.isfolha());

        int meio=(order-1)/2;

        for(int i=meio+1; i<filho.getKeys().size(); i++){
            novoFilho.getKeys().add(filho.getKeys().get(i));
        }
        
        while(filho.getKeys().size()>meio+1){
            filho.getKeys().remove(meio+1);
        }

        // Se não for um nó folha, também divide os filhos
        if(!filho.isfolha()){
            for(int i=meio+1; i<filho.getChildren().size(); i++) {
                novoFilho.getChildren().add(filho.getChildren().get(i));
            }
            
            while(filho.getChildren().size()>meio+1){
                filho.getChildren().remove(meio+1);
            }
        }

        // Insere a chave mediana no pai
        pai.getKeys().add(indiceFilho, filho.getKeys().get(meio));
        filho.getKeys().remove(meio);

        // Adiciona o novo filho ao pai
        pai.getChildren().add(indiceFilho+1, novoFilho);
    }

    public Pokemon pesquisar(Pokemon pokemon) {
        if(raiz==null){
            return null;
        }
        return pesquisarRecursivo(raiz, pokemon);
    }
    
    private Pokemon pesquisarRecursivo(Bnode node, Pokemon pokemon){
        // Percorrendo as chaves do nó atual
        for (int i = 0; i < node.getKeys().size(); i++) {
            if(node.getKeys().get(i).getName().equals(pokemon.getName())){
                return node.getKeys().get(i);
            }
    
            if(pokemon.getBaseExperience()<node.getKeys().get(i).getBaseExperience()){
                if(node.isfolha()){
                    return null;
                }
                return pesquisarRecursivo(node.getChildren().get(i), pokemon);
            }
        }

        if(!node.isfolha()){
            return pesquisarRecursivo(node.getChildren().get(node.getChildren().size()-1), pokemon);
        }
        return null;
    }
  
    
}