package com.deltaworks.deltaworks;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import org.json.JSONException;

import java.util.List;

import static java.lang.Thread.sleep;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    SupportMapFragment mapFrag;
    LocationRequest mLocationRequest;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    FusedLocationProviderClient mFusedLocationClient;
    EditText search;
    Button searchbutton;
    String input ="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        BitmapDrawable bitmapdraw = (BitmapDrawable) getResources().getDrawable(R.drawable.seeam);
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, 140, 140, false);

        BitmapDrawable bitmapdraw1 = (BitmapDrawable) getResources().getDrawable(R.drawable.tim);
        Bitmap c = bitmapdraw1.getBitmap();
        Bitmap smallMarker1 = Bitmap.createScaledBitmap(c, 140, 140, false);

        BitmapDrawable bitmapdraw2 = (BitmapDrawable) getResources().getDrawable(R.drawable.aditya);
        Bitmap d = bitmapdraw2.getBitmap();
        Bitmap smallMarker2 = Bitmap.createScaledBitmap(d, 140, 140, false);

        BitmapDrawable bitmapdraw3 = (BitmapDrawable) getResources().getDrawable(R.drawable.friendss);
        Bitmap e = bitmapdraw3.getBitmap();
        Bitmap smallMarker3 = Bitmap.createScaledBitmap(e, 200, 200, false);

        BitmapDrawable bitmapdraw4 = (BitmapDrawable) getResources().getDrawable(R.drawable.profile);
        Bitmap f = bitmapdraw4.getBitmap();
        Bitmap smallMarker4 = Bitmap.createScaledBitmap(f, 200, 200, false);



        // Addding a marker with the given coordinates
        LatLng Seeam = new LatLng(43.2579, -79.9188);
        mMap.addMarker(new MarkerOptions().position(Seeam).title("Seeam").icon(BitmapDescriptorFactory.fromBitmap(smallMarker))); // sets the marker with the name & title
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Seeam)); // moves camera to given person selected.

        LatLng Tim = new LatLng(43.2611417, -79.92250580000001);
        mMap.addMarker(new MarkerOptions().position(Tim).title("Tim").icon(BitmapDescriptorFactory.fromBitmap(smallMarker1))); // sets the marker with the name & title
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Tim)); // moves camera to given person selected.

        LatLng Aditya = new LatLng(43.2610324, -79.9168325);
        mMap.addMarker(new MarkerOptions().position(Aditya).title("Aditya").icon(BitmapDescriptorFactory.fromBitmap(smallMarker2))); // sets the marker with the name & title
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Aditya)); // moves camera to given person selected.

        LatLng friends = new LatLng(7.222, -35.285);
        mMap.addMarker(new MarkerOptions().position(friends).title("friends").icon(BitmapDescriptorFactory.fromBitmap(smallMarker3))); // sets the marker with the name & title

        LatLng profile = new LatLng(50.222, -35.285);
        mMap.addMarker(new MarkerOptions().position(profile).title("profile").icon(BitmapDescriptorFactory.fromBitmap(smallMarker4))); // sets the marker with the name & title

        search = (EditText) findViewById(R.id.search);
        searchbutton = (Button)findViewById(R.id.search_button);

        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = String.valueOf(search.getText());
                if(input.toLowerCase().trim().equals("powerlift")){
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(Seeam));
                    Toast.makeText(getApplicationContext(), "Seeam is a great match", Toast.LENGTH_SHORT).show();
                }

                else if(input.toLowerCase().trim().equals("cardio")){
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(Aditya));
                    Toast.makeText(getApplicationContext(), "Aditya is a great match", Toast.LENGTH_SHORT).show();
                }

                else if(input.toLowerCase().trim().equals("core")){
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(Tim));
                    Toast.makeText(getApplicationContext(), "Timothy is a great match", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(getApplicationContext(), "Sorry, that activity does not exist", Toast.LENGTH_SHORT).show();
                }


            }
        });

        mMap.setOnMarkerClickListener(marker -> {

            if ((marker.getTitle().equals("Seeam")) || (input.equals("Seeam"))) { // if marker source is clicked
                mMap.moveCamera(CameraUpdateFactory.newLatLng(Seeam));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
                Toast.makeText(getApplicationContext(), marker.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(getApplicationContext(),buddyprofile.class);
                startActivity(intent3);}


            if (marker.getTitle().equals("Aditya")){ // if marker source is clicked
                mMap.moveCamera(CameraUpdateFactory.newLatLng(Aditya));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
                Toast.makeText(getApplicationContext(), marker.getTitle(), Toast.LENGTH_SHORT).show();}

            if (marker.getTitle().equals("Tim")){ // if marker source is clicked
                mMap.moveCamera(CameraUpdateFactory.newLatLng(Tim));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
                Toast.makeText(getApplicationContext(), marker.getTitle(), Toast.LENGTH_SHORT).show();}

            if (marker.getTitle().equals("friends")){ // if marker source is clicked
                mMap.moveCamera(CameraUpdateFactory.newLatLng(friends));
                Intent intent = new Intent(getApplicationContext(),friends.class);
                startActivity(intent);}

            if (marker.getTitle().equals("profile")){ // if marker source is clicked
                mMap.moveCamera(CameraUpdateFactory.newLatLng(profile));
                Intent intent2 = new Intent(getApplicationContext(),profile.class);
                startActivity(intent2);}
            return true;
        });


    }
}
