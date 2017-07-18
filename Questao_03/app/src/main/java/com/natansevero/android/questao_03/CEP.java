package com.natansevero.android.questao_03;

/**
 * Created by natan on 15/07/17.
 */
/*
* Entidade para representar o CEP
* */
public class CEP {

    private String logradouro;
    private String bairro;
    private String municipio;
    private String uf;

    public CEP(){

    }

    public CEP(String logradouro, String bairro, String municipio, String uf) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "CEP{" +
                "logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", municipio='" + municipio + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
