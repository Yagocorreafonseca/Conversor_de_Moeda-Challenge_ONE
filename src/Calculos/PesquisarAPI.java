package Calculos;

import Modelos.Moeda;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PesquisarAPI {

    public static String buscarCotacoes(String nomeMoeda1, String nomeMoeda2, Moeda moeda) throws IOException, InterruptedException {

        String endereco = "https://v6.exchangerate-api.com/v6/74f3651b7eb61e725123ca39/latest/" + nomeMoeda1;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        JSONObject jsonObject = new JSONObject(json);

        if (jsonObject.has("conversion_rates")) {
            JSONObject ratesObject = jsonObject.getJSONObject("conversion_rates");

            // Verifica se as moedas solicitadas estão presentes nas taxas de conversão
            if (ratesObject.has(nomeMoeda1) && ratesObject.has(nomeMoeda2)) {
                moeda.setCotacao1(ratesObject.getDouble(nomeMoeda1));
                moeda.setCotacao2(ratesObject.getDouble(nomeMoeda2));

                double convertido = moeda.getQuantidade() * moeda.getCotacao2();

                return "A cotação atual é: " +
                        "O valor de " + moeda.getCotacao1() + " " + nomeMoeda1 + " equivale a " +
                        moeda.getCotacao2() + " " + nomeMoeda2 +
                        ", logo " + moeda.getQuantidade() + " "
                        + nomeMoeda1 + " equivale a " + convertido + " " + nomeMoeda2;
            } else {
                return "Moeda não encontrada nas taxas de conversão.";
            }

        } else {
            return "Objeto 'conversion_rates' não encontrado na resposta JSON.";
        }



    }
}


