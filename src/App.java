import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        //fazer a conexao HTTP e buscar os top 50 filmes
           String url = "https://imdb-api.com/en/API/MostPopularMovies/k_t2mh0gt5";
           URI endereco = URI.create(url);
           var client = HttpClient.newHttpClient();
           HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
           HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
           String body = response.body();

         

        //extrair só os dados que interessam(titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
       
        //exibir e manipular os dados
        for (Map<String,String> filmes : listaDeFilmes) {
        String urlImagem = filmes.get("image");
        String titulo = filmes.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();

            String nomeArquivo = titulo + ".png";

           var geradora = new GeradoraDeFigurinhas();
           geradora.cria(inputStream, nomeArquivo);
           
            System.out.println(filmes.get("title"));
            System.out.println();
           
        }
    }
}