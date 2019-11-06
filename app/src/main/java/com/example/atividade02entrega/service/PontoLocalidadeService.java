package com.example.atividade02entrega.service;

import com.example.atividade02entrega.model.PontoLocalidade;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PontoLocalidadeService {

    @GET("{id}/json")
    Call<PontoLocalidade> select(@Path("id") int id);


}
