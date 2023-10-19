package co.edu.sena.metalcofapp.interfases;

import co.edu.sena.metalcofapp.modelos.Cliente;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ClienteApi {
    @POST ("api/clientes")
    Call<Cliente>registrarDatos(@Body Cliente c);
}
