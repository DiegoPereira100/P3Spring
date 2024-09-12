package br.edu.fatecpg.spring.ConsomeApi.service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ConsumoApi {
    private static final String API_KEY = "212353bf"; // Substitua pela sua chave de API

    public static String obterDado(String nome) throws IOException, InterruptedException {
        // Codifica o nome para que espaços e caracteres especiais sejam corretamente representados na URL
        String nomeCodificado = URLEncoder.encode(nome, StandardCharsets.UTF_8.toString());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.omdbapi.com/?t=" + nomeCodificado + "&apikey=" + API_KEY))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}


