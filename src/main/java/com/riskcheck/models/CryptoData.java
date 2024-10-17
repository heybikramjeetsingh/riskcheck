package com.riskcheck.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoData {
    private double[] historicalPrices; // Optional: Store historical prices for calculations


    private String id;
    private String name;
    private double current_price;
    private double market_cap;
    private double total_volume;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("current_price")
    public double getCurrentPrice() {
        return current_price;
    }

    public void setCurrentPrice(double currentPrice) {
        this.current_price = currentPrice;
    }

    @JsonProperty("market_cap")
    public double getMarketCap() {
        return market_cap;
    }

    public void setMarketCap(double marketCap) {
        this.market_cap = marketCap;
    }

    @JsonProperty("total_volume")
    public double getTotalVolume() {
        return total_volume;
    }

    public void setTotalVolume(double totalVolume) {
        this.total_volume = totalVolume;
    }
}
