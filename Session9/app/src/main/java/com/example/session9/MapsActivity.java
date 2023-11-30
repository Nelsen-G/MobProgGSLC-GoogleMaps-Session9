package com.example.session9;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.session9.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Button btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLocation(-6.18844282528431, 106.736486728151, "Rumah Orang");
            }
        });

        Button btnUniversity = findViewById(R.id.btnUniversity);
        btnUniversity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLocation(-6.223500381422234, 106.64921256952833, "BINUS Alsut");
            }
        });

        Button btnOffice = findViewById(R.id.btnOffice);
        btnOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLocation(-3.751653153225633, 137.2174351485148, "Freeport Papua");
            }
        });

        Button btnRestaurant = findViewById(R.id.btnRestaurant);
        btnRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLocation(-6.223586407458105, 106.8335643251114, "Makan Mewah");
            }
        });

        Button btnParking = findViewById(R.id.btnParking);
        btnParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLocation(-6.223874636315477, 106.84266225655517, "Langganan Parkir");
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }

    private void goToLocation(double latitude, double longitude, String locName) {
        LatLng location = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(location).title(locName));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
    }
}