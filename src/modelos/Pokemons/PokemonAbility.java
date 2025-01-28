package modelos.Pokemons;

@SuppressWarnings("unused")

public class PokemonAbility {
    private boolean isHidden;
    private int slot;
    private Ability ability;

    public Ability getAbility() {
        return ability;
    }

    public static class Ability {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }

}
