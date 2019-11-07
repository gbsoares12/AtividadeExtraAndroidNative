package com.example.atividade02entrega;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.atividade02entrega.dao.AppDatabase;
import com.example.atividade02entrega.model.PontoLocalidade;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsFragment extends SupportMapFragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener{

    private GoogleMap mMap;

    List<PontoLocalidade> listaPontoLocalidade = new ArrayList();

    private final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION =1;

    private boolean permissionGranted;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getMapAsync(this);
    }


    public void populaArrayTeste(){

        PontoLocalidade ponto1 = new PontoLocalidade();
        ponto1.setTitulo("teste2");
        ponto1.setDescricao("Teste Descrição");
        ponto1.setLatitude(-26.8997);
        ponto1.setLongitude(-49.2359);
        ponto1.setVisitado(true);

        //registrarPonto(ponto1);
        //listaPontoLocalidade.add(ponto1);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        populaArrayTeste();
        this.listaPontoLocalidade = carregarPontosLocalidades();

        getLocationPermission();
        updateLocationUI();

        for(PontoLocalidade ponto : listaPontoLocalidade){
            LatLng posicaoGeo = new LatLng(ponto.getLatitude(), ponto.getLongitude());
            mMap.addMarker(new MarkerOptions()
                    .position(posicaoGeo)
                    .draggable(true)
                    .snippet("Descrição do Ponto: "+ponto.getDescricao() + "\n"
                    + "Visitado: " + (ponto.getVisitado() ? "Sim" : "Ainda Não"))
                    .title(ponto.getTitulo()));
        }

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(-27.0591, -49.5312)));
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        String textMsgToast = "Titulo: " + marker.getTitle() +"\n" + marker.getSnippet();

        Log.d("teste", "@@@@@@@@@@@@@@@@@@@@@@ TESTEEEEEE @@@@@@@@@@@@@@@@@@@@@@");
        Toast.makeText(this.getContext(), textMsgToast, Toast.LENGTH_LONG).show();
        return false;
    }


    private void getLocationPermission() {
        if (ContextCompat.checkSelfPermission(getContext().getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            permissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this.getActivity(),
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        permissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    permissionGranted = true;
                }
            }
        }
//        updateLocationUI();
    }

    private void updateLocationUI() {
        if (mMap == null) {
            return;
        }
        try {
            if (permissionGranted) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                mMap.setMyLocationEnabled(false);
                mMap.getUiSettings().setMyLocationButtonEnabled(false);
                getLocationPermission();
            }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage());
        }
    }


    @Override
    public void onMapClick(LatLng latLng) {
        Log.d("teste", "teste");
        Toast.makeText(getContext(), "Coordenadas: " + latLng.toString(), Toast.LENGTH_SHORT).show();

        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .draggable(true)
                .snippet("Teste")
                .title("Cidade de Testadores"));
    }

    public List<PontoLocalidade> carregarPontosLocalidades(){
        AppDatabase db = Room.databaseBuilder(this.getContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
        return db.pontoLocalidadeDAO().getAll();
    }

    public void registrarPonto(PontoLocalidade ponto){
        AppDatabase db = Room.databaseBuilder(this.getContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();
        db.pontoLocalidadeDAO().insertAll(ponto);
        listaPontoLocalidade.add(ponto);

    }
}
