package com.riskcheck;

import com.riskcheck.api.ApiClient;
import com.riskcheck.models.CryptoData;

import java.io.IOException;

public class RiskAnalyzer {

    private ApiClient apiClient;

    public RiskAnalyzer() {
        this.apiClient = new ApiClient();
    }
    private double calculateVolatility(CryptoData cryptoData) {
        return 0;
        // Implementation for fetching historical prices and calculating volatility
    }
    private double calculateHistoricalPerformance(CryptoData cryptoData) {
        return 0;
        // Implementation for fetching historical price change
    }
    private double calculateSentimentScore(CryptoData cryptoData) {
        return 0;
        // Implementation for analyzing social media sentiment
    }
    private String classifyRisk(double riskScore) {
        if (riskScore <= 3) {
            return "Low";
        } else if (riskScore <= 7) {
            return "Medium";
        } else {
            return "High";
        }
    }
    public void analyzeRisks() {
        try {
            CryptoData[] cryptoDataList = apiClient.fetchCryptoData();

            for (CryptoData cryptoData : cryptoDataList) {
                double risk = calculateRisk(cryptoData);
                String riskCategory = classifyRisk(risk);
                System.out.println();
                System.out.printf("Crypto: %s | Current Price: $%.4f%n > Risk Score: %.2f%n > Risk Category: %s%n", cryptoData.getName(), cryptoData.getCurrentPrice(), risk, riskCategory);
            }
        } catch (IOException e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
    }

    private double calculateRisk(CryptoData cryptoData) {
        // Simple risk calculation: higher risk for lower volume and lower market cap
        double volumeRisk = Math.max(1, 100000000 / cryptoData.getTotalVolume());
        double marketCapRisk = Math.max(1, 100000000 / cryptoData.getMarketCap());
        double volatilityRisk = calculateVolatility(cryptoData);
        double historicalPerformanceRisk = calculateHistoricalPerformance(cryptoData);
        double sentimentRisk = calculateSentimentScore(cryptoData);
        return (volumeRisk + marketCapRisk + volatilityRisk + historicalPerformanceRisk + sentimentRisk) / 5;
    }

    public static void main(String[] args) {
        System.out.println("The coins are categorised as Low (0-3), Medium (4-7), and High (8-10) based on the combined risk score.");
        System.out.println();
        RiskAnalyzer analyzer = new RiskAnalyzer();
        analyzer.analyzeRisks();
    }
}
