package src;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class AppJava {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Fazendo a requisicao Http
        String url = "https://api.mocki.io/v2/549a5d8b";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        //Criando o parse (convertendo String em lista) extrai os dados que interessam*
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parserConversor(body);

        //Exibir e manipular os dados que interessam (titulo,imagem,classificacao)
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            
        }

    }

}
