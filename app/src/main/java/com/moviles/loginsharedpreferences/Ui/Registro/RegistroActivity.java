package com.moviles.loginsharedpreferences.Ui.Registro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.moviles.loginsharedpreferences.Modelo.Usuario;
import com.moviles.loginsharedpreferences.R;
import com.moviles.loginsharedpreferences.Request.ApiCliente;
import com.moviles.loginsharedpreferences.Ui.Login.MainActivityViewModel;
import com.moviles.loginsharedpreferences.databinding.ActivityRegistroBinding;

public class RegistroActivity extends AppCompatActivity {
    private RegistroActivityViewModel vm;
    private ActivityRegistroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);

        vm.getmUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                binding.etNombre.setText(usuario.getNombre());
                binding.etApellido.setText(usuario.getApellido());
                binding.etDni.setText(usuario.getDni().toString());
                binding.etEmail2.setText(usuario.getMail());
                binding.etPass2.setText(usuario.getPassword().toString());
            }
        });

        binding.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario(binding.etNombre.getText().toString(),binding.etApellido.getText().toString(),
                        Long.parseLong(binding.etDni.getText().toString()),binding.etEmail2.getText().toString(),binding.etPass2.getText().toString());

                ApiCliente.registrar(getApplication(),usuario);
            }
        });

        Intent intent = getIntent();
        if(intent.hasExtra("usuario")){
            Usuario usuario = (Usuario) intent.getSerializableExtra("usuario");
            vm.cargarUsuario(usuario);

        }


    }
}