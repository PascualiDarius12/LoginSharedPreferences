package com.moviles.loginsharedpreferences.Ui.Registro;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.moviles.loginsharedpreferences.Modelo.Usuario;

public class RegistroActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Usuario> mUsuario;
    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Usuario> getmUsuario() {
        if(mUsuario == null){
            mUsuario = new MutableLiveData<>();
        }
        return mUsuario;
    }


    public void cargarUsuario(Usuario usuario){


            mUsuario.setValue(usuario);

    }



}
