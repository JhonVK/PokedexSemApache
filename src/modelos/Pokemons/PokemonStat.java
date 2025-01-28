package modelos.Pokemons;


public class PokemonStat{
    private Stat stat;
    private int effort;
    private int base_stat;


    public Stat getStat() {
        return stat;
    }

    public int getBaseStat() {
        return base_stat;
    }

    public int getEffort() {
        return effort;
    }


    public static class Stat{
        private String name;

        public String getName() {
            return name;
        }
    }
}
