package com.riskcheck.api;

import com.riskcheck.models.CryptoData;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

public class ApiClient {

    private static final String API_URL = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd";

    public CryptoData[] fetchCryptoData() throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(API_URL);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String responseBody = EntityUtils.toString(response.getEntity());

                // Convert JSON response to Java objects using Jackson
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(responseBody, CryptoData[].class);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
