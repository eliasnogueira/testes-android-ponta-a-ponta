package com.eliasnogueira.trianguloapp.api;

import com.eliasnogueira.trianguloapp.models.TrianguloResponse;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface TrianguloApi {

    @FormUrlEncoded
    @POST("/triangulo/api/calcular")
    public void calculaTriangulo(@Field("lado1") String lado1, @Field("lado2") String lado2, @Field("lado3") String lado3, Callback<TrianguloResponse> callback);
}
