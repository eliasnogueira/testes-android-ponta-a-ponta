package com.eliasnogueira.trianguloapp.models;

public class TrianguloResponse {

    public Boolean status;
    public String lado1;
    public String lado2;
    public String lado3;
    public String resultado;

    public TrianguloResponse() {
    	
    }
    
    public TrianguloResponse(String lado1, String lado2, String lado3) {
    	this.lado1 = lado1;
    	this.lado2 = lado2;
    	this.lado3 = lado3;
    }
    
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getLado1() {
        return lado1;
    }

    public void setLado1(String lado1) {
        this.lado1 = lado1;
    }

    public String getLado2() {
        return lado2;
    }

    public void setLado2(String lado2) {
        this.lado2 = lado2;
    }

    public String getLado3() {
        return lado3;
    }

    public void setLado3(String lado3) {
        this.lado3 = lado3;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
	
	
}
