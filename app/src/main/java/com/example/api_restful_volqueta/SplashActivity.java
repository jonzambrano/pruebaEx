package com.example.api_restful_volqueta;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Referencia al botón
        Button btnIngresar = findViewById(R.id.btn_ingresar);
        TextView tvPoliticas = findViewById(R.id.tv_politicas);

        // Establecer el listener para el clic
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para abrir MainActivity
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                // Opcional: Finalizar esta actividad para que el usuario no pueda volver a ella
                finish();
            }
        });

        // Hacer que el enlace de "políticas de privacidad" sea clickeable
        String textoPoliticas = "Al hacer clic en ingresar, aceptas nuestras <a href='https://www.quevedo.gob.ec/'>políticas de privacidad</a>.";
        tvPoliticas.setText(Html.fromHtml(textoPoliticas, Html.FROM_HTML_MODE_COMPACT));
        tvPoliticas.setMovementMethod(LinkMovementMethod.getInstance());
    }
}