package com.example.api_restful_volqueta;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// IMPORTS FALTANTES - AGREGAR ESTOS:
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VolquetaAdapter adapter;
    private List<Volqueta> volquetaList;
    private ProgressBar progressBar;
    private TextView tvError;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupRecyclerView();
        setupApi();
        loadVolquetas();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress_bar);
        tvError = findViewById(R.id.tv_error);
    }

    private void setupRecyclerView() {
        volquetaList = new ArrayList<>();
        adapter = new VolquetaAdapter(this, volquetaList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void setupApi() {
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    private void loadVolquetas() {
        showLoading(true);

        Call<List<Volqueta>> call = apiService.getVolquetas();
        call.enqueue(new Callback<List<Volqueta>>() {
            @Override
            public void onResponse(Call<List<Volqueta>> call, Response<List<Volqueta>> response) {
                showLoading(false);

                if (response.isSuccessful() && response.body() != null) {
                    volquetaList.clear();
                    volquetaList.addAll(response.body());
                    adapter.notifyDataSetChanged();

                    if (volquetaList.isEmpty()) {
                        showError("No hay volquetas disponibles");
                    }
                } else {
                    showError("Error al cargar los datos");
                }
            }

            @Override
            public void onFailure(Call<List<Volqueta>> call, Throwable t) {
                showLoading(false);
                showError("Error de conexión: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showLoading(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        recyclerView.setVisibility(show ? View.GONE : View.VISIBLE);
        tvError.setVisibility(View.GONE);
    }

    private void showError(String message) {
        tvError.setText(message);
        tvError.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }
}