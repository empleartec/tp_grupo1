package com.example.javier.melomanofinal.clienteRest;

import retrofit.RestAdapter;

/**
 * Created by Javier on 19/02/2016.
 */
public class ConexionServidor {
    public static MelomanoService createMelomanoService() {
        String SERVER_IP = "10.12.0.200";
        String SERVER_IP_GENY = "127.0.0.1";
        String API_URL = "http://10.54.11.108:9800";
        //192.168.1.33
        //10.54.11.108
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        MelomanoService cancionesService = restAdapter.create(MelomanoService.class);
        return cancionesService;
    }
}
