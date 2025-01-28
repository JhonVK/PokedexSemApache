package modelos.Pokemons;

import java.util.List;
@SuppressWarnings("unused")
public class PokemonMove { 
    
    private Move move;
    private List<PokemonMoveVersion> versionGroupDetails;

    public Move getMove() {
        return move;
    }
    public static class Move{
        private String name;

        public String getName() {
            return name;
        }
    }

    public static class PokemonMoveVersion{
        private MoveLearnMethod moveLearnMethod;
        private int levelLearnedAt;
    }

    public static class MoveLearnMethod{
        private String name;
    }
}
