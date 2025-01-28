package modelos.Pokemons;
@SuppressWarnings("unused")
public class PokemonType {
    private int slot;
    private Type type;

    public Type getType() {
        return type;
    }

    public static class Type {
        private String name;

        public String getName() {
            return name;
        }
    }
}