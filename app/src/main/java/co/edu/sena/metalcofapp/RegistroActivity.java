package co.edu.sena.metalcofapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.sena.metalcofapp.interfases.ClienteApi;
import co.edu.sena.metalcofapp.modelos.Cliente;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistroActivity extends AppCompatActivity {

    EditText txtDocumento, txtNombre, txtDireccion, txtCiudad, txtTelefono, txtContrasena;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtDocumento = findViewById(R.id.txtDocumento);
        txtNombre = findViewById(R.id.txtNombre);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtCiudad = findViewById(R.id.txtCiudad);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtContrasena = findViewById(R.id.txtContrasena);
        btnRegistrar = findViewById(R.id.btnResgistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registrar();
            }
        });

    }

    public void registrar(){
        int documento= Integer.parseInt(txtDocumento.getText().toString());
        String nombre= txtNombre.getText().toString();
        String direccion= txtDireccion.getText().toString();
        String ciudad= txtCiudad.getText().toString();
        int telefono= Integer.parseInt(txtTelefono.getText().toString());
        String contrasena= txtContrasena.getText().toString();

        Cliente c = new Cliente(documento,nombre,direccion,ciudad,telefono,contrasena);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/").addConverterFactory(GsonConverterFactory.create()).build();
        ClienteApi clienteApi = retrofit.create(ClienteApi.class);

        Call<Cliente> call=clienteApi.registrarDatos(c);

        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                Toast.makeText(RegistroActivity.this, "Registro exitoso!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Toast.makeText(RegistroActivity.this, "¡Registro Fallido!", Toast.LENGTH_SHORT).show();
            }
        });

    }


}