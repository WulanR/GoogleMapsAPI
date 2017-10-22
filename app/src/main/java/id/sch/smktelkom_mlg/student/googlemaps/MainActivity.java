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
import com.google.android.gms.maps.model.PolylineOptions;

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
    MarkerOptions smktelkom, kosrocky, kosdorayaki, bebekdulur, nelongso, biru;
    LatLng telkom = new LatLng(-7.9779684, 112.6592985);
    LatLng rocky = new LatLng(-7.977883, 112.658810);
    LatLng dora = new LatLng(-7.977683, 112.658922);
    LatLng dulur = new LatLng(-7.974750, 112.660070);
    LatLng nelo = new LatLng(-7.976780, 112.663762);
    LatLng bi = new LatLng(7.977464, 112.654484);

    GoogleMap m_map;
    boolean mapReady = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smktelkom = new MarkerOptions()
                .position(telkom)
                .title("SMK Telkom")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        kosrocky = new MarkerOptions()
                .position(rocky)
                .title("Kos Rocky")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        kosdorayaki = new MarkerOptions()
                .position(dora)
                .title("Kos Dorayaki")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        bebekdulur = new MarkerOptions()
                .position(dulur)
                .title("Bebek Dulur")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        nelongso = new MarkerOptions()
                .position(nelo)
                .title("Ayam Nelongso")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

        biru = new MarkerOptions()
                .position(bi)
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
        map.addPolyline(new PolylineOptions().geodesic(true)
                .add(telkom)
                .add(rocky)
                .add(dora)
                .add(dulur)
                .add(nelo)
                .add(bi));

        flyTo(MALANG);

    }
}
