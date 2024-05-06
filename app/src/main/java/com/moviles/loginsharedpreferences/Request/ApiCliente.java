package com.moviles.loginsharedpreferences.Request;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.moviles.loginsharedpreferences.Modelo.Usuario;

public class ApiCliente {

    private static SharedPreferences sp;

    private static SharedPreferences Conectar(Context contexto){
        if(sp == null){
            sp=contexto.getSharedPreferences("usuarios",0);
        }
        return sp;
    }

    public static void registrar(Context contexto, Usuario usuario){
        SharedPreferences sp = Conectar(contexto);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("nombre", usuario.getNombre());
        editor.putString("apellido", usuario.getApellido());
        editor.putString("email", usuario.getMail());
        editor.putLong("dni", usuario.getDni());
        editor.putString("password", usuario.getPassword());
        editor.commit();
        Toast.makeText(contexto, "Usuario registrado", Toast.LENGTH_SHORT).show();



    }

    public static Usuario getUsuario(Context contexto){
        SharedPreferences sp = Conectar(contexto);
        String nombre = sp.getString("nombre","-1");
        String apellido = sp.getString("apellido","-1");
        String email= sp.getString("email","-1");
        String password = sp.getString("password","-1");
        Long dni = sp.getLong("dni",-1);

        Usuario usuario = new Usuario(nombre, apellido, dni, email, password);
        return usuario;
    }

    public static Usuario login(Context contexto, String mail, String password){
        SharedPreferences sp = Conectar(contexto);
        String nombre = sp.getString("nombre","-1");
        String apellido = sp.getString("apellido","-1");
        String email= sp.getString("email","-1");
        String pass = sp.getString("password","-1");
        Long dni = sp.getLong("dni",-1);

        if(mail.equals(email) && password.equals(pass)){
            Usuario usuario = new Usuario(nombre, apellido, dni, email, password);
            return usuario;
        }else{

            Toast.makeText(contexto, "Email o Password incorrecto.", Toast.LENGTH_SHORT).show();
            return null;
        }


    }


}
