package com.wildfire.interfaces.rest.dto;

public class RegistrarFocoRequest {
    private Double latitude;
    private Double longitude;
    private Double intensidade;
    private String regiaoId;

    // Getters e Setters
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Double getIntensidade() { return intensidade; }
    public void setIntensidade(Double intensidade) { this.intensidade = intensidade; }

    public String getRegiaoId() { return regiaoId; }
    public void setRegiaoId(String regiaoId) { this.regiaoId = regiaoId; }
}