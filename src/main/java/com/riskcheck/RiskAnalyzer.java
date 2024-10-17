package com.riskcheck;

import com.riskcheck.api.ApiClient;
import com.riskcheck.models.CryptoData;

import java.io.IOException;
import java.util.Arrays;

public class RiskAnalyzer {

    private ApiClient apiClient;

    public RiskAnalyzer() {
        this.apiClient = new ApiClient();
    }

    public void analyzeRisks() {
        try {
            CryptoData[] cryptoDataList = apiClient.fetchCryptoData();

            for (CryptoData cryptoData : cryptoDataList) {
                double risk = calculateRisk(cryptoData);
                System.out.printf("Crypto: %s | Risk Score: %.2f%n", cryptoData.getName(), risk);
            }
        } catch (IOException e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
    }

    private double calculateRisk(CryptoData cryptoData) {
        // Simple risk calculation: higher risk for lower volume and lower market cap
        double volumeRisk = Math.max(1, 100000000 / cryptoData.getTotalVolume());
        double marketCapRisk = Math.max(1, 100000000 / cryptoData.getMarketCap());

        return (volumeRisk + marketCapRisk) / 2;
    }

    public static void main(String[] args) {
        RiskAnalyzer analyzer = new RiskAnalyzer();
        analyzer.analyzeRisks();
    }
}
