import modelos.PokeCliente;
import modelos.Pokemons.Pokemon;
import modelos.B.Btree;
import modelos.Trie.Trie;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


public class App {

    private static Hashtable<String, Pokemon> hashPokemons=new Hashtable<>();
    private static String leituraStr;
    private static int leituraInt;
    private static Pokemon pokemon;
    private static Btree btree;
    private static List<Pokemon> lista=new ArrayList<>();
    
        public static void main(String[] args) throws Exception {

            Scanner ler= new Scanner(System.in);
            PokeCliente cliente= new PokeCliente();
            Trie trie=new Trie();
            int i=0;
 
        do{
            System.out.println("\nEscolha:\n");
            System.out.println("1. Árvore Trie\n2. Árvore B\n3. Tabela Hash");
            while(true){
                try{
                    leituraInt=ler.nextInt();
                    ler.nextLine();
                    break;
                }catch(Exception e) {
                    System.out.println("Entrada inválida. Digite um número.");
                    ler.nextLine();
                }
            }
            
            switch(leituraInt){
                case 1:
                do{
                    System.out.println("1. Adicionar Pokémon\n2. Pesquisar Pokémon\n3. Pesquisar Pokémon por prefixo\n4. Sair");
                    while(true){
                        try{
                            leituraInt=ler.nextInt();
                            ler.nextLine();
                            break;
                        }catch(Exception e) {
                            System.out.println("Entrada inválida. Digite um número.");
                            ler.nextLine();
                        }
                    }

                    if(leituraInt==1){
                        System.out.println("Para sair digite sair. ");
                            System.out.println("Escreva os nomes dos pokemons que deseja inserir: ");
                        do{
                            leituraStr=ler.nextLine();
                            pokemon=cliente.getPokemon(leituraStr);
                            if(!leituraStr.equalsIgnoreCase("sair")){
                                if(pokemon!=null){
                                    trie.inserir(pokemon);
                                    System.out.println("Pokémon Inserido.");
                                }else{
                                    System.out.println("Nome incorreto.");
                                }
                            }
                           
                        }while(!leituraStr.equalsIgnoreCase("sair"));
                            
                      
                        
                    }else if(leituraInt==2){
                        System.out.println("Escreva o nome do pokemon que deseja pesquisar: ");
                        leituraStr=ler.nextLine();
                        pokemon=cliente.getPokemon(leituraStr);
                        if(pokemon==null){                       
                            System.out.println("Nome incorreto.");
                        }else{
                            trie.pesquisar(pokemon);
                        }
                        
                    }else if(leituraInt==3){
                        System.out.println("Escreva o prefixo: ");
                        leituraStr=ler.nextLine();
                        System.out.println("Escreva o intervalo de experiência que deseja listar: ");
                        int intervalo=ler.nextInt();
                        int intervalo2=ler.nextInt();
                        ler.nextLine();
                        trie.pesquisaPrefixo(leituraStr, intervalo, intervalo2);

                    }else if(leituraInt==4){
                        break;
                    }
                    }while(true);
                    break;
                case 2:
                do{
                    System.out.println("1. Adicionar Pokémon\n2. Pesquisar Pokémon\n3. Listar Pokémons\n4. Sair");
                    
                    while(true){
                    try{
                        leituraInt=ler.nextInt();
                        break;
                    }catch(Exception e) {
                        System.out.println("Entrada inválida. Digite um número.");
                        ler.nextLine();
                    }
                    }
                    ler.nextLine();

                    if(leituraInt==1){
                        if(i==0){
                            System.out.println("Escreva a ordem da árvore B: ");
                            while (true){
                                try{
                                    leituraInt=ler.nextInt();
                                    ler.nextLine();
                                    break;
                                }catch(Exception e) {
                                    System.out.println("Entrada inválida. Digite um número.");
                                    ler.nextLine();
                                }  
                            }
                            btree=new Btree(leituraInt);
                            i++;
                        }

                        System.out.println("Para sair digite sair. ");
                        System.out.println("Escreva os nomes dos pokemons que deseja inserir: ");
                        
                        do{
                            leituraStr=ler.nextLine();
                            pokemon=cliente.getPokemon(leituraStr);
                            if(!leituraStr.equalsIgnoreCase("sair")){
                                if(pokemon!=null){
                                    btree.inserir(pokemon);
                                    System.out.println("Pokémon Inserido.");
                                }else{
                                    System.out.println("Nome incorreto.");
                                }
                            }
                        }while(!leituraStr.equalsIgnoreCase("sair"));
                            
                        
                    }else if(leituraInt==2){
                        System.out.println("Escreva o nome do pokemon que deseja pesquisar: ");
                        leituraStr=ler.nextLine();
                        pokemon=cliente.getPokemon(leituraStr);
                        if(pokemon==null){                       
                            System.out.println("Nome incorreto.");
                        }else{
                            Pokemon pokemone=btree.pesquisar(pokemon);
                            if(pokemone!=null){
                                System.out.println("Pokémon encontrado: "+pokemone.getName());
                                pokemone.printPokemon();
                            }else{
                                System.out.println("Pokémon não encontrado.");
                            }
                        }
                        
                    }else if(leituraInt==3){
                        int inter, inter2;
                        System.out.println("Escreva o intervalo de experiência que deseja listar: ");
                        inter=ler.nextInt();
                        inter2=ler.nextInt();
                        ler.nextLine();
                        btree.printBTree(inter, inter2);
                        
                    }else if(leituraInt==4){
                        break;
                    }
                    }while(true);    

                    break;
                case 3:
                    do{
                        System.out.println("1. Adicionar Pokémon\n2. Pesquisar Pokémon\n3. Listar Pokémons ordenados por acessos\n4. Sair");
                        while(true){
                        try{
                            leituraInt=ler.nextInt();
                            break;
                        }catch(Exception e) {
                            System.out.println("Entrada inválida. Digite um número.");
                            ler.nextLine();
                        }
                        }
                        ler.nextLine();

                        if(leituraInt==1){
                            System.out.println("Para sair digite sair. ");
                                System.out.println("Escreva os nomes dos pokemons que deseja inserir: ");
                                do{
                                    leituraStr=ler.nextLine();
                                    if(!leituraStr.equalsIgnoreCase("sair")){                                   
                                        pokemon=cliente.getPokemon(leituraStr.toLowerCase());
                                        if(pokemon==null){
                                            System.out.println("Pokémon não encontrado. Tente novamente.");
                                        }else{
                                            hashPokemons.put(pokemon.getName(), pokemon);                  
                                            lista = new ArrayList<>(hashPokemons.values());
                                            lista.sort(Comparator.comparingInt(Pokemon::getAcessos).reversed());
                                            System.out.println("Pokémon Inserido.");
                                        }
                                    }
                                }while(!leituraStr.equalsIgnoreCase("sair"));
                               
                                                                                         
                        }else if(leituraInt==2){
                            System.out.println("Escreva o nome do pokemon que deseja pesquisar: ");
                            leituraStr=ler.nextLine();
                            pokemon=hashPokemons.get(leituraStr.toLowerCase());
                            if(pokemon==null){
                                System.out.println("Pokémon não encontrado. Tente novamente.");
                            }else{
                                System.out.println("Pokémon encontrado: "+pokemon.getName());
                                pokemon.printPokemon();
                                pokemon.incAcessos();

                                lista = new ArrayList<>(hashPokemons.values());
                                lista.sort(Comparator.comparingInt(Pokemon::getAcessos).reversed());
                            }
                        }else if(leituraInt==3){
                            for (int j=0; j<lista.size(); j++){
                                System.out.println("Nome: "+lista.get(j).getName() + ", Experiência: "+lista.get(j).getBaseExperience()+", Acessos: "+lista.get(j).getAcessos());
                            }   
                        }else if(leituraInt==4){
                            break;
                        }
                        }while(true);    
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        System.out.println("Deseja voltar?");
        while(true){
            try{
                leituraStr=ler.nextLine();
                if(!leituraStr.equalsIgnoreCase("sim") && !leituraStr.equalsIgnoreCase("nao")){
                    throw new IllegalArgumentException("Entrada inválida. Digite 'sim' ou 'nao'.");
                }else{
                    break;
                }
            }catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        }

    }while(leituraStr.equalsIgnoreCase("sim"));

    ler.close();
    }
}
