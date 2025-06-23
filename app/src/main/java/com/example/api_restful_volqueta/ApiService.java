package com.example.api_restful_volqueta;
import com.example.api_restful_volqueta.Volqueta;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("volquetas")
    Call<List<Volqueta>> getVolquetas();
}