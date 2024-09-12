package br.edu.fatecpg.spring.ConsomeApi.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public static class ConsomeApi {

        public static final String url = "https://parallelum.com.br/fipe/api/v1/carros";

        public String responseHttp(String url) throws IOException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        public String retornarMarcas() throws IOException, InterruptedException {
            return this.responseHttp(url + "/marcas");
        }
        public String retornarModelos(String codigoMarca) throws IOException, InterruptedException {
            return this.responseHttp(url + "/marcas/" + codigoMarca + "/modelos");
        }
        public String retornarAnos(String codigoMarca, String codigoModelo) throws IOException, InterruptedException {
            return this.responseHttp(url + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos");
        }
        public String retornarPreco(String codigoMarca, String codigoModelo, String codigoAno) throws IOException, InterruptedException {
            return this.responseHttp(url + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos/" + codigoAno);
        }
    }
}


