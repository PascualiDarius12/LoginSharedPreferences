package com.moviles.loginsharedpreferences.Ui.Login;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.moviles.loginsharedpreferences.Modelo.Usuario;

import java.io.*;


public class MainActivityViewModel extends AndroidViewModel {
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public Usuario loginObjeto(String email, String password) {
        File archivo = new File(getApplication().getFilesDir(), "fichero.dat");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            while (true) {
                Usuario usuario = (Usuario) ois.readObject();
                Log.d("perro", usuario.getMail()+" "+usuario.getPassword());
                Log.d("perro", email+" "+password);
                //trim para eliminar espacios en blancos, me daba error por eso, no se si se guardaba con un espacio en blanco o se recuperaba asi el objeto
                if (usuario.getMail().trim().equals(email.trim()) && usuario.getPassword().trim().equals(password.trim())) {
                    return usuario;
                }
            }
        } catch (EOFException e) {
            // Se alcanzó el final del archivo, usuario no encontrado
            Toast.makeText(getApplication(), "Usuario no encontrado", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplication(), "Archivo no encontrado", Toast.LENGTH_LONG).show();
            Log.d("salida ", e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            Toast.makeText(getApplication(), "Error de E/S", Toast.LENGTH_LONG).show();
            Log.d("salida ", e.toString());
            e.printStackTrace();
        }
        return null;
    }

}
