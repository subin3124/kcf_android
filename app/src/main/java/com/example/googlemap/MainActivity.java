package com.example.googlemap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener {


    GoogleMap mMap;
    Fragment map;
    ImageView image_map;
    ImageButton button_enter;
    ImageButton button_list;
    ImageButton button_my;
    TextView text_test;
    ConstraintLayout layout_main;
    LinearLayout layout_scroll;
    View scroll;
    SearchView searchView;

    ImageButton filter_meter;
    ImageButton filter_custom;
    ImageButton filter_region;
    Button filter_1_1;
    Button filter_1_2;
    Button filter_1_3;
    Button filter_2_1;
    Button filter_2_2;
    Button filter_2_3;

    Button filter_3_1;
    Button filter_3_2;
    Button filter_3_3;


    Button.OnClickListener clickListener;


    int j=0;
    float name=0;
    boolean tri = true;
    String next;

    String state_kind="";
    int[] state_cus = new int[3];

    String[] title = new String[3];
    List<String> ttle = new ArrayList<>();
    List<String> kc = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View map = findViewById(R.id.map);

        layout_main = findViewById(R.id.layout_main);
        button_enter = findViewById(R.id.button_enter);
        button_list = findViewById(R.id.button_list);
        button_my = findViewById(R.id.button_my);
        image_map = findViewById(R.id.image_map);
        layout_scroll = findViewById(R.id.layout_scroll);
        scroll = findViewById(R.id.scroll);
        searchView = findViewById(R.id.searchView);



        filter_meter = findViewById(R.id.filter_meter);
        filter_custom = findViewById(R.id.filter_custom);
        filter_region = findViewById(R.id.filter_region);

        filter_1_1 = findViewById(R.id.filter_1_1);
        filter_1_2 = findViewById(R.id.filter_1_2);
        filter_1_3 = findViewById(R.id.filter_1_3);

        filter_2_1 = findViewById(R.id.filter_2_1);
        filter_2_2 = findViewById(R.id.filter_2_2);
        filter_2_3 = findViewById(R.id.filter_2_3);

        filter_3_1 = findViewById(R.id.filter_3_1);
        filter_3_2 = findViewById(R.id.filter_3_3);
        filter_3_3 = findViewById(R.id.filter_3_2);





        clickListener = new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button_list:
                        if(map.getVisibility()==View.VISIBLE){
                            map.setVisibility(View.GONE);
                            layout_main.setBackgroundColor(Color.parseColor("#FBFBE1"));
                            scroll.setVisibility(View.VISIBLE);
                            button_list.setImageResource(R.drawable.bottom_map);
                        }
                        else{
                            map.setVisibility(View.VISIBLE);
                            scroll.setVisibility(View.GONE);
                            button_list.setImageResource(R.drawable.list);
                        }



                        break;
                    case R.id.button_my:
                        button_my.setColorFilter(Color.parseColor("#55ff0000"));
                        Intent intent = new Intent(getApplicationContext(), Mypage.class);
                        startActivity(intent);
                        finish();
                        break;


                    case R.id.filter_meter:
                        if(filter_1_1.getVisibility() == View.GONE){
                            filter_meter.setColorFilter(Color.parseColor("#55ff0000"));
                            filter_1_1.setVisibility(View.VISIBLE);
                            filter_1_2.setVisibility(View.VISIBLE);
                            filter_1_3.setVisibility(View.VISIBLE);
                        }
                        else{
                            filter_meter.setColorFilter(null);
                            filter_1_1.setVisibility(View.GONE);
                            filter_1_2.setVisibility(View.GONE);
                            filter_1_3.setVisibility(View.GONE);
                        }
                        break;
                    case R.id.filter_custom:
                        if(filter_2_1.getVisibility() == View.GONE){
                            filter_custom.setColorFilter(Color.parseColor("#55ff0000"));
                            filter_2_1.setVisibility(View.VISIBLE);
                            filter_2_2.setVisibility(View.VISIBLE);
                            filter_2_3.setVisibility(View.VISIBLE);
                        }
                        else{
                            filter_custom.setColorFilter(null);
                            filter_2_1.setVisibility(View.GONE);
                            filter_2_2.setVisibility(View.GONE);
                            filter_2_3.setVisibility(View.GONE);
                        }
                        break;
                    case R.id.filter_region:
                        if(filter_3_1.getVisibility() == View.GONE){
                            filter_region.setColorFilter(Color.parseColor("#55ff0000"));
                            filter_3_1.setVisibility(View.VISIBLE);
                            filter_3_2.setVisibility(View.VISIBLE);
                            filter_3_3.setVisibility(View.VISIBLE);
                        }
                        else{
                            filter_region.setColorFilter(null);
                            filter_3_1.setVisibility(View.GONE);
                            filter_3_2.setVisibility(View.GONE);
                            filter_3_3.setVisibility(View.GONE);
                        }
                        break;



                    case R.id.filter_1_1:
                        if(state_kind.equals("플라스틱")){
                            filter_1_1.setTextSize(12);
                            state_kind = "";
                        }
                        else{
                            filter_1_1.setTextSize(15);
                            Toast.makeText(getApplicationContext(), "없는게없는재활용가게", Toast.LENGTH_SHORT).show();
                            state_kind = (String) filter_1_1.getText();
                        }
                        break;
                    case R.id.filter_1_2:
                        if(state_kind.equals("커피콩")){
                            filter_1_2.setTextSize(12);
                            state_kind = "";
                        }
                        else{
                            filter_1_2.setTextSize(15);
                            state_kind = (String) filter_1_2.getText();

                        }
                        break;
                    case R.id.filter_1_3:
                        if(state_kind.equals("의류")){
                            filter_1_3.setTextSize(12);
                            state_kind = "";
                        }
                        else{
                            filter_1_3.setTextSize(15);
                            state_kind = (String) filter_1_3.getText();
                        }
                        break;


                    case R.id.filter_2_1:
                        if(state_cus[0] == 1){
                            filter_2_1.setTextSize(12);
                            state_cus[0] = 0;
                        }
                        else{
                            filter_2_1.setTextSize(15);
                            state_cus[0] = 1;
                        }
                        break;
                    case R.id.filter_2_2:
                        if(state_cus[1] == 1){
                            filter_2_2.setTextSize(12);
                            state_cus[1] = 0;
                        }
                        else{
                            filter_2_2.setTextSize(15);
                            state_cus[1] = 1;
                        }
                        break;
                    case R.id.filter_2_3:
                        if(state_cus[2] == 1){
                            filter_2_3.setTextSize(12);
                            state_cus[2] = 0;
                        }
                        else{
                            filter_2_3.setTextSize(15);
                            state_cus[2] = 1;
                        }
                        break;

                }
            }
        };


        filter_region.setOnClickListener(clickListener);
        filter_custom.setOnClickListener(clickListener);
        filter_meter.setOnClickListener(clickListener);

        filter_1_1.setOnClickListener(clickListener);
        filter_1_2.setOnClickListener(clickListener);
        filter_1_3.setOnClickListener(clickListener);

        filter_2_1.setOnClickListener(clickListener);
        filter_2_2.setOnClickListener(clickListener);
        filter_2_3.setOnClickListener(clickListener);

        filter_3_1.setOnClickListener(clickListener);
        filter_3_2.setOnClickListener(clickListener);
        filter_3_3.setOnClickListener(clickListener);

        button_list.setOnClickListener(clickListener);
        button_my.setOnClickListener(clickListener);


        button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_enter.setColorFilter(Color.parseColor("#55ff0000"));

                if(tri){
                    Intent intent = new Intent(getApplicationContext(), Store1.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void createImageButton() {
        ImageButton imageButton = new ImageButton(getApplicationContext());
        imageButton.setImageResource(R.drawable.company_example);
        imageButton.setId(0);
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setBackgroundColor(Color.parseColor("#00FFFFFF"));

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,300,getResources().getDisplayMetrics());
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,250,getResources().getDisplayMetrics());
        params.width = width;
        params.height = height;
        imageButton.setLayoutParams(params);
        layout_scroll.addView(imageButton);

    }




    String[] kind_company = new String[3];
    boolean[][] cus_company = new boolean[3][3];
    Marker[] marker = new Marker[3];


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;




        System.out.println("안녕하세요");

        LatLng[] a = new LatLng[4];

        List<LatLng> latLngs = new ArrayList<>();
        for(int i=0;i<getIntent().getIntExtra("size",10);i++){
            latLngs.add(new LatLng(getIntent().getFloatExtra(i+"X",0),getIntent().getFloatExtra(i+"Y",0)));
            ttle.add(getIntent().getStringExtra(i+"cp_name"));
            kc.add(getIntent().getStringExtra(i+"kinds"));

        }
        a[0] = new LatLng(getIntent().getFloatExtra(0+"X",0),getIntent().getFloatExtra(0+"Y",0));
        a[1] = new LatLng(37.45635372073381, 126.70662043025608);
        a[2] = new LatLng(35.160219730810915, 129.0460488411893);

        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(36, 123));
        mMap.moveCamera(center);

        title[0] = getIntent().getStringExtra(0+"cp_name");//"없는게없는재활용가게";
        title[1] = "Home";
        title[2] = "Tree";

        kind_company[0] = "플라스틱";
        kind_company[1] = "커피콩";
        kind_company[2] = "의류";

        cus_company[0][0] = true;
        cus_company[0][1] = true;
        cus_company[0][2] = true;

        cus_company[0][2] = true;
        cus_company[0][2] = true;
        cus_company[0][2] = true;


        LatLng seoul = a[0];
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(seoul).title(title[j]).snippet("없는 게 없는 만능 가게입니다")
                .alpha(0.5f).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        marker[j] = mMap.addMarker(markerOptions);



        mMap.setOnMapClickListener(this);
        mMap.setOnMarkerClickListener(this);



        LatLng[] city = new LatLng[4];
        city[0] = new LatLng(37.56214048107756, 126.99193148544094);
        city[1] = new LatLng(37.45635372073381, 126.70662043025608);
        city[2] = new LatLng(35.160219730810915, 129.0460488411893);
        filter_3_1 = findViewById(R.id.filter_3_1);
        filter_3_2 = findViewById(R.id.filter_3_3);
        filter_3_3 = findViewById(R.id.filter_3_2);


        clickListener = new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.filter_3_1:
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(city[0]));
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                        break;
                    case R.id.filter_3_2:
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(city[1]));
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                        break;
                    case R.id.filter_3_3:
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(city[2]));
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                        break;
                }
            }
        };

        filter_3_1.setOnClickListener(clickListener);
        filter_3_2.setOnClickListener(clickListener);
        filter_3_3.setOnClickListener(clickListener);








    }


    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        button_enter.setVisibility(View.VISIBLE);
        next = marker.getTitle();
        tri = next.equals("없는게없는재활용가게");
        return false;
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        button_enter.setVisibility(View.GONE);
    }
}

