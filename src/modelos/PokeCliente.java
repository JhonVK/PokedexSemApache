package modelos;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import modelos.Pokemons.Pokemon;
import com.google.gson.Gson;




public class PokeCliente {
    // URL base da API
    private static final String URL_BASE = "https://pokeapi.co/api/v2/pokemon/";

    // Cliente q fara as requisições
    private final HttpClient client;

    public PokeCliente(){
        this.client=HttpClient.newHttpClient();
    }

    public Pokemon getPokemon(String pokemon){
        // a URL da requisição final
        String URL= URL_BASE+pokemon.toLowerCase();

        // criar a requisição
        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create(URL))
            .build();

        // enviando a solicitação
        try{
            // temos 2 parametros aqui, o httpResponse(que é a requisição (request)) e o segundo é um bodyHandlers
            
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            
            Gson gson = new Gson();

            Pokemon pokemonObject = gson.fromJson(response.body(), Pokemon.class);
            return pokemonObject;

        }catch (Exception e) {
            return null;
        }
        
    }

}
