package com.moviles.loginsharedpreferences.Ui.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.moviles.loginsharedpreferences.Modelo.Usuario;
import com.moviles.loginsharedpreferences.R;
import com.moviles.loginsharedpreferences.Request.ApiCliente;
import com.moviles.loginsharedpreferences.Ui.Registro.RegistroActivity;
import com.moviles.loginsharedpreferences.Ui.Registro.RegistroActivityViewModel;
import com.moviles.loginsharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel vm;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                Usuario usuario = ApiCliente.login(getApplication(),binding.etMail.getText().toString(), binding.etPassword.getText().toString());
                if (usuario != null){
                    intent.putExtra("usuario", usuario);
                    startActivity(intent);
                }


            }
        });
    }
}