package id.sch.smktelkom_mlg.student.googlemaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    static final CameraPosition NEWYORK = CameraPosition.builder()
            .target(new LatLng(40.7127, 74.0059))
            .zoom(15)
            .bearing(0)
            .tilt(0)
            .build();
    static final CameraPosition KUALALUMPUR = CameraPosition.builder()
            .target(new LatLng(3.1385036, 101.6169484))
            .zoom(15)
            .bearing(0)
            .tilt(0)
            .build();
    static final CameraPosition MALANG = CameraPosition.builder()
            .target(new LatLng(-7.97683, 112.6586844))
            .zoom(15)
            .bearing(0)
            .tilt(0)
            .build();
    MarkerOptions smktelkom;
    MarkerOptions kosrocky;
    MarkerOptions kosdorayaki;
    MarkerOptions bebekdulur;
    MarkerOptions nelongso;
    MarkerOptions biru;
    GoogleMap m_map;
    boolean mapReady = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smktelkom = new MarkerOptions()
                .position(new LatLng(-7.9779684, 112.6592985))
                .title("SMK Telkom")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        kosrocky = new MarkerOptions()
                .position(new LatLng(-7.977883, 112.658810))
                .title("Kos Rocky")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        kosdorayaki = new MarkerOptions()
                .position(new LatLng(-7.977683, 112.658922))
                .title("Kos Dorayaki")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        bebekdulur = new MarkerOptions()
                .position(new LatLng(-7.974750, 112.660070))
                .title("Bebek Dulur")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        nelongso = new MarkerOptions()
                .position(new LatLng(-7.976780, 112.663762))
                .title("Ayam Nelongso")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        biru = new MarkerOptions()
                .position(new LatLng(7.977464, 112.654484))
                .title("Biru")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        Button btnMalang = (Button) findViewById(R.id.btnMalang);
        btnMalang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(MALANG);
            }
        });

        Button btnNewYork = (Button) findViewById(R.id.btnNewYork);
        btnNewYork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(NEWYORK);
            }
        });

        Button btnKuala = (Button) findViewById(R.id.btnKuala);
        btnKuala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(KUALALUMPUR);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.addMarker(smktelkom);
        m_map.addMarker(kosrocky);
        m_map.addMarker(kosdorayaki);
        m_map.addMarker(bebekdulur);
        m_map.addMarker(biru);
        flyTo(MALANG);
    }
}
