package com.example.digeat.customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.digeat.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CustomerMapPage extends FragmentActivity {

    ImageView btnBack;
    BottomNavigationView bottomNavigationView;
    Intent movePage;
    TextView findPlace;
    GoogleMap mMap;
    SupportMapFragment mapFragment;
//    String type = "restaurant";
//    FusedLocationProviderClient fusedLocationProviderClient;
//    double currLat = 0, currLong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_map_page);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this::onMapReady);
//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
//        checkPermission();

        findPlace = findViewById(R.id.findPlace);
//        findPlace.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" +
//                        -6.157146 + "," + 106.782262 + "&radius=5000&types=restaurant&sensor=true&key=AIzaSyB32BglX6VzAAvw9zoJh5LlsatKqgV70tQ";
//
//                new PlaceTask().execute(url);
//            }
//        });

        btnBack = findViewById(R.id.backBtn);
        btnBack.setOnClickListener(view -> {
            onBackPressed();
        });

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        Menu menu = bottomNavigationView.getMenu();
        menu.getItem(0).setChecked(true);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    movePage = new Intent(this, CustomerHomePage.class);
                    startActivity(movePage);
                    break;

                case R.id.order:
                    movePage = new Intent(this, CustomerOrderPage.class);
                    startActivity(movePage);
                    break;

                case R.id.menu:
                    movePage = new Intent(this, CustomerMenuPage.class);
                    startActivity(movePage);
                    break;

                case R.id.profile:
                    movePage = new Intent(this, CustomerProfilePage.class);
                    startActivity(movePage);
                    break;
            }
            return true;
        });
    }

//    private void checkPermission() {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            Task<Location> task = fusedLocationProviderClient.getLastLocation();
//            task.addOnSuccessListener(new OnSuccessListener<Location>() {
//                @Override
//                public void onSuccess(Location location) {
//                    if (location != null){
//                        currLat = location.getLatitude();
//                        currLong = location.getLongitude();
//                        mapFragment.getMapAsync(new OnMapReadyCallback() {
//                            @Override
//                            public void onMapReady(GoogleMap googleMap) {
//                                mMap = googleMap;
//                                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(currLat, currLong), 10));
//                            }
//                        });
//                    }
//                }
//            });
//        }
//        else {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
//        }
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 44){
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                Task<Location> task = fusedLocationProviderClient.getLastLocation();
//                task.addOnSuccessListener(new OnSuccessListener<Location>() {
//                    @Override
//                    public void onSuccess(Location location) {
//                        if (location != null){
//                            currLat = location.getLatitude();
//                            currLong = location.getLongitude();
//                            mapFragment.getMapAsync(new OnMapReadyCallback() {
//                                @Override
//                                public void onMapReady(GoogleMap googleMap) {
//                                    mMap = googleMap;
//                                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(currLat, currLong), 10));
//                                }
//                            });
//                        }
//                    }
//                });
//            }
//        }
//    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng place = new LatLng(-6.157146, 106.782262);
        mMap.addMarker(new MarkerOptions().position(place).title("This is the place"));
        CameraPosition cam = new CameraPosition.Builder().target(place).zoom(17).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cam));
    }

//    private class PlaceTask extends AsyncTask<String, Integer, String> {
//        @Override
//        protected String doInBackground(String... strings) {
//            String data = null;
//            try {
//                data = downloadUrl(strings[0]);
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//            return data;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            new ParserTask().execute(s);
//        }
//    }
//
//    private String downloadUrl(String string) throws IOException {
//        URL url = new URL(string);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.connect();
//        InputStream stream = connection.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//        StringBuilder builder = new StringBuilder();
//        String line = "";
//        while ((line = reader.readLine()) != null){
//            builder.append(line);
//        }
//        String data = builder.toString();
//        reader.close();
//        return  data;
//    }
//
//    private class ParserTask extends AsyncTask<String, Integer, List<HashMap<String, String>>>{
//        @Override
//        protected List<HashMap<String, String>> doInBackground(String... strings) {
//            JsonParser jsonParser = new JsonParser();
//            List<HashMap<String, String>> mapList = null;
//            JSONObject object = null;
//            try {
//                object = new JSONObject(strings[0]);
//                mapList = jsonParser.parseResult(object);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            return mapList;
//        }
//
//        @Override
//        protected void onPostExecute(List<HashMap<String, String>> hashMaps) {
//            for (int i = 0; i < hashMaps.size(); i++){
//                HashMap<String, String> hashMapList = hashMaps.get(i);
//                double lat = Double.parseDouble(hashMapList.get("lat"));
//                double lng = Double.parseDouble(hashMapList.get("lng"));
//                String name = hashMapList.get("name");
//                LatLng latLng = new LatLng(lat,lng);
//                MarkerOptions options = new MarkerOptions();
//                options.position(latLng);
//                options.title(name);
//                mMap.addMarker(options);
//            }
//        }
//    }

//    private class PlaceTask extends AsyncTask<String, Integer, String> {
//        @Override
//        protected String doInBackground(String... strings) {
//            String data = null;
//            try {
//                data = downloadUrl(strings[0]);
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//            return data;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            new ParserTask().execute(s);
//        }
//    }
//
//    private String downloadUrl(String string) throws IOException {
//        URL url = new URL(string);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.connect();
//        InputStream stream = connection.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//        StringBuilder builder = new StringBuilder();
//        String line = "";
//        while ((line = reader.readLine()) != null){
//            builder.append(line);
//        }
//        String data = builder.toString();
//        reader.close();
//        return  data;
//    }
//
//    private class ParserTask extends AsyncTask<String, Integer, List<HashMap<String, String>>>{
//        @Override
//        protected List<HashMap<String, String>> doInBackground(String... strings) {
//            JsonParser jsonParser = new JsonParser();
//            List<HashMap<String, String>> mapList = null;
//            JSONObject object = null;
//            try {
//                object = new JSONObject(strings[0]);
//                mapList = jsonParser.parseResult(object);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            return mapList;
//        }
//
//        @Override
//        protected void onPostExecute(List<HashMap<String, String>> hashMaps) {
//            for (int i = 0; i < hashMaps.size(); i++){
//                HashMap<String, String> hashMapList = hashMaps.get(i);
//                double lat = Double.parseDouble(hashMapList.get("lat"));
//                double lng = Double.parseDouble(hashMapList.get("lng"));
//                String name = hashMapList.get("name");
//                LatLng latLng = new LatLng(lat,lng);
//                MarkerOptions options = new MarkerOptions();
//                options.position(latLng);
//                options.title(name);
//                mMap.addMarker(options);
//            }
//        }
//    }
}