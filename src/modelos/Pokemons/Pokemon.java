package modelos.Pokemons;
import java.net.URI;
import java.util.List;
import java.awt.Desktop;

public class Pokemon {
    private int id;
    private String name;
    private int base_experience;
    private int height;
    private boolean is_default;
    private int order;
    private int weight;

    private PokemonSprites sprites;
    private List<PokemonAbility> abilities;
    private List<PokemonMove> moves;
    private List<PokemonType> types;
    private List<PokemonStat> stats;

    private int acessos=0;
    
    public int getAcessos() {
        return acessos;
    }
    public PokemonSprites getSprites() {
        return sprites;
    }
    public void printPokemon(){
        
        System.out.println("Pokémon encontrado: " + getName()+ "\n\nExperiência: "+getBaseExperience()+ "\nAltura: "+
        getHeight()+ "\nPeso: "+getWeight()+ "\nOrdem: "+getOrder());
        for(int k=0; k<getAbilities().size(); k++){
            System.out.println("Habilidade "+(k+1)+": "+getAbilities().get(k).getAbility().getName());
        }
        for(int k=0; k<getTypes().size(); k++){
            System.out.println("Tipo "+(k+1)+": "+getTypes().get(k).getType().getName());
        }
        for(int k=0; k<getStats().size(); k++){
            System.out.println(getStats().get(k).getStat().getName()+": "+ getStats().get(k).getBaseStat());
        }
        for(int k=0; k<3; k++){
            System.out.println("Movimento "+(k+1)+": "+getMoves().get(k).getMove().getName());
        }
        try {
            Desktop.getDesktop().browse(new URI(getSprites().getFront_default()));
        } catch (Exception e) {
            System.out.println("Erro ao abrir a imagem: " + e.getMessage());
}
        System.out.println("\n");
    }
    
    public void incAcessos() {
        this.acessos = this.acessos + 1;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBaseExperience() {
        return base_experience;
    }
    public void setBaseExperience(int base_experience) {
        this.base_experience = base_experience;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public boolean isDefault() {
        return is_default;
    }
    public void setDefault(boolean is_default) {
        this.is_default = is_default;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public List<PokemonAbility> getAbilities() {
        return abilities;
    }
    public void setAbilities(List<PokemonAbility> abilities) {
        this.abilities = abilities;
    }
    public List<PokemonMove> getMoves() {
        return moves;
    }
    public void setMoves(List<PokemonMove> moves) {
        this.moves = moves;
    }
    
    public List<PokemonType> getTypes() {
        return types;
    }
    public void setTypes(List<PokemonType> types) {
        this.types = types;
    }
    public List<PokemonStat> getStats() {
        return stats;
    }
    public void setStats(List<PokemonStat> stats) {
        this.stats = stats;
    }
 


}
