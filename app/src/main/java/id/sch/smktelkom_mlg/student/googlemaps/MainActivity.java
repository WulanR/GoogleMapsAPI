package id.sch.smktelkom_mlg.student.googlemaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    static final CameraPosition NEWYORK = CameraPosition.builder()
            .target(new LatLng(40.7127, 74.0059))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition SMKTELKOM = CameraPosition.builder()
            .target(new LatLng(-7.9768972, 112.6565519))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition KUALALUMPUR = CameraPosition.builder()
            .target(new LatLng(3.1385036, 101.6169484))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMap = (Button) findViewById(R.id.btnTelkom);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(SMKTELKOM);
            }
        });

        Button btnSatelit = (Button) findViewById(R.id.btnNewYork);
        btnSatelit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(NEWYORK);
            }
        });

        Button btnHybrid = (Button) findViewById(R.id.btnMalaysia);
        btnHybrid.setOnClickListener(new View.OnClickListener() {
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
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(SMKTELKOM);
    }
}
