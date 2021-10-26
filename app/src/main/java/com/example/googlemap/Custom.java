package com.example.googlemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Custom extends AppCompatActivity {


    Button.OnClickListener clickListener;

    float oldXvalue;
    float oldYvalue;
    int stage=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        MyApplication myApp = (MyApplication) getApplication();

        ImageButton n_sche = findViewById(R.id.n_sche);
        ImageButton n_back = findViewById(R.id.n_back);
        ImageButton n_option1 = findViewById(R.id.n_option1);
        ImageButton n_option2 = findViewById(R.id.n_option2);
        ImageButton n_option3 = findViewById(R.id.n_option3);
        ImageButton n_finish = findViewById(R.id.n_finish);
        ImageButton n_image1 = findViewById(R.id.n_image1);
        ImageButton n_image2 = findViewById(R.id.n_image2);
        ImageButton n_image3 = findViewById(R.id.n_image3);
        ImageButton n_image4 = findViewById(R.id.n_image4);
        ImageButton n_n = findViewById(R.id.n_n);
        ImageButton n_suntac = findViewById(R.id.n_suntac);


        ImageView n_image = findViewById(R.id.n_image);
        ImageView n_move = findViewById(R.id.n_move);
        ImageView n_move2 = findViewById(R.id.n_move2);

        ImageButton button_custom_back = findViewById(R.id.button_custom_back);



        View layout_n_fade = findViewById(R.id.layout_n_fade);
        View layout_n_main = findViewById(R.id.layout_n_main);
        View layout_custom = findViewById(R.id.layout_custom);
        View layout_custom_finish = findViewById(R.id.layout_custom_finish);
        LinearLayout n_scroll = findViewById(R.id.n_scroll);

        TextView text_custom_green = findViewById(R.id.text_custom_green);




        Intent intent = getIntent();
        int key = intent.getIntExtra("key", 0);
        if(key==0){
            n_move.setVisibility(View.VISIBLE);
            n_image1.setImageResource(R.drawable.block_che1);
            n_image2.setImageResource(R.drawable.block_sche2);
        }
        else{
            n_move.setVisibility(View.GONE);
        }

        Object object = new Object();



        clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.n_back:
                        Intent intent = new Intent(getApplicationContext(), Store1.class);
                        startActivity(intent);
                        break;
                    case R.id.n_finish:
                        object.setX(n_move.getX());
                        object.setY(n_move.getY());
                        object.setX2(n_move2.getX());
                        object.setY2(n_move2.getY());
                        object.setX3(n_image.getX());
                        object.setY3(n_image.getY());
                        layout_custom.setVisibility(View.GONE);
                        layout_custom_finish.setVisibility(View.VISIBLE);
                        if(key==1){
                            text_custom_green.setText("담배 90개비만큼\n탄소배출을 줄였습니다");
                        }

                        break;
                    case R.id.button_custom_back:
                        intent = new Intent(getApplicationContext(), Store1.class);
                        startActivity(intent);
                        break;




                    case R.id.n_image1:
                        if(stage==0) {
                            Toast.makeText(getApplicationContext(), "GreenPoint: 500g", Toast.LENGTH_SHORT).show();
                            n_sche.setVisibility(View.GONE);
                            if (key == 1) {
                                n_image1.setImageResource(R.drawable.n_cup2);
                                n_image2.setImageResource(R.drawable.n_cup1);
                                layout_n_fade.setVisibility(View.VISIBLE);
                                n_n.setVisibility(View.VISIBLE);
                                n_option1.setColorFilter(Color.parseColor("#55ff0000"));
                            } else {
                                n_image1.setImageResource(R.drawable.block_1);
                                n_image2.setImageResource(R.drawable.block_2);
                                n_image3.setImageResource(R.drawable.block_4);
                                n_image4.setImageResource(R.drawable.block_3);
                                n_suntac.setVisibility(View.VISIBLE);
                                n_image.setImageResource(R.drawable.block_sche_res);
                                n_image.setVisibility(View.VISIBLE);
                            }
                        }
                        if(stage==1){
                            Toast.makeText(getApplicationContext(), "GreenPoint: 300g", Toast.LENGTH_SHORT).show();
                            if(key==1){
                                n_image.setImageResource(R.drawable.n_cup2);
                                n_image.setVisibility(View.VISIBLE);
                            }
                            if(key==0){
                                n_move.setVisibility(View.VISIBLE);
                                n_move.setImageResource(R.drawable.block_1_1);
                            }
                        }
                        stage = 1;
                        break;
                    case R.id.n_image2:
                        Toast.makeText(getApplicationContext(), "GreenPoint: 100g", Toast.LENGTH_SHORT).show();
                        n_image.setImageResource(R.drawable.n_re3);
                        break;
                    case R.id.n_image3:
                        Toast.makeText(getApplicationContext(), "GreenPoint: 50g", Toast.LENGTH_SHORT).show();
                        n_move2.setVisibility(View.VISIBLE);
                        n_move2.setImageResource(R.drawable.block_3_3);
                        break;


                    case R.id.n_option1:
                        n_option1.setColorFilter(Color.parseColor("#55ff0000"));
                        n_option2.setColorFilter(null);
                        n_option3.setColorFilter(null);
                        if(key==1){
                            n_image1.setImageResource(R.drawable.n_cup1);
                            n_image2.setImageResource(R.drawable.n_cup2);
                        }
                        else{
                            n_image1.setImageResource(R.drawable.block_1);
                            n_image2.setImageResource(R.drawable.block_2);
                            n_image3.setImageResource(R.drawable.block_3);
                            n_image4.setImageResource(R.drawable.block_4);
                        }
                        break;
                    case R.id.n_option2:
                        n_option2.setColorFilter(Color.parseColor("#55ff0000"));
                        n_option1.setColorFilter(null);
                        n_option3.setColorFilter(null);
                        n_image1.setImageResource(R.drawable.n_cloud);
                        n_image2.setImageResource(R.drawable.n_umbr);
                        break;
                    case R.id.n_option3:
                        n_option3.setColorFilter(Color.parseColor("#55ff0000"));
                        n_option1.setColorFilter(null);
                        n_option2.setColorFilter(null);
                        n_image1.setImageResource(R.drawable.n_orange);
                        n_image2.setImageResource(R.drawable.n_blue);
                        break;

                }

            }
        };

        n_back.setOnClickListener(clickListener);
        n_option1.setOnClickListener(clickListener);
        n_option2.setOnClickListener(clickListener);
        n_option3.setOnClickListener(clickListener);
        n_finish.setOnClickListener(clickListener);
        n_image1.setOnClickListener(clickListener);
        n_image2.setOnClickListener(clickListener);
        n_image3.setOnClickListener(clickListener);
        n_n.setOnClickListener(clickListener);
        n_suntac.setOnClickListener(clickListener);
        button_custom_back.setOnClickListener(clickListener);


        n_move.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int parentWidth = ((ViewGroup)v.getParent()).getWidth();    // 부모 View 의 Width
                int parentHeight = ((ViewGroup)v.getParent()).getHeight();    // 부모 View 의 Height

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    // 뷰 누름
                    oldXvalue = event.getX();
                    oldYvalue = event.getY();
                    Log.d("viewTest", "oldXvalue : "+ oldXvalue + " oldYvalue : " + oldYvalue);    // View 내부에서 터치한 지점의 상대 좌표값.
                    Log.d("viewTest", "v.getX() : "+v.getX());    // View 의 좌측 상단이 되는 지점의 절대 좌표값.
                    Log.d("viewTest", "RawX : " + event.getRawX() +" RawY : " + event.getRawY());    // View 를 터치한 지점의 절대 좌표값.
                    Log.d("viewTest", "v.getHeight : " + v.getHeight() + " v.getWidth : " + v.getWidth());    // View 의 Width, Height

                }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    // 뷰 이동 중
                    v.setX(v.getX() + (event.getX()) - (v.getWidth()/2));
                    v.setY(v.getY() + (event.getY()) - (v.getHeight()/2));

                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    // 뷰에서 손을 뗌

                    if(v.getX() < 0){
                        v.setX(0);
                    }else if((v.getX() + v.getWidth()) > parentWidth){
                        v.setX(parentWidth - v.getWidth());
                    }

                    if(v.getY() < 0){
                        v.setY(0);
                    }else if((v.getY() + v.getHeight()) > parentHeight){
                        v.setY(parentHeight - v.getHeight());
                    }



                }
                return true;
            }
        });

        n_move2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int parentWidth = ((ViewGroup)v.getParent()).getWidth();    // 부모 View 의 Width
                int parentHeight = ((ViewGroup)v.getParent()).getHeight();    // 부모 View 의 Height

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    // 뷰 누름
                    oldXvalue = event.getX();
                    oldYvalue = event.getY();
                    Log.d("viewTest", "oldXvalue : "+ oldXvalue + " oldYvalue : " + oldYvalue);    // View 내부에서 터치한 지점의 상대 좌표값.
                    Log.d("viewTest", "v.getX() : "+v.getX());    // View 의 좌측 상단이 되는 지점의 절대 좌표값.
                    Log.d("viewTest", "RawX : " + event.getRawX() +" RawY : " + event.getRawY());    // View 를 터치한 지점의 절대 좌표값.
                    Log.d("viewTest", "v.getHeight : " + v.getHeight() + " v.getWidth : " + v.getWidth());    // View 의 Width, Height

                }else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    // 뷰 이동 중
                    v.setX(v.getX() + (event.getX()) - (v.getWidth()/2));
                    v.setY(v.getY() + (event.getY()) - (v.getHeight()/2));

                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    // 뷰에서 손을 뗌

                    if(v.getX() < 0){
                        v.setX(0);
                    }else if((v.getX() + v.getWidth()) > parentWidth){
                        v.setX(parentWidth - v.getWidth());
                    }

                    if(v.getY() < 0){
                        v.setY(0);
                    }else if((v.getY() + v.getHeight()) > parentHeight){
                        v.setY(parentHeight - v.getHeight());
                    }



                }
                return true;
            }
        });



    }


    private void createImageButton() {
        ImageButton imageButton = new ImageButton(getApplicationContext());
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setBackgroundColor(Color.parseColor("#00FFFFFF"));

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,300,getResources().getDisplayMetrics());
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,250,getResources().getDisplayMetrics());
        params.width = width;
        params.height = height;
        imageButton.setLayoutParams(params);

        LinearLayout n_scroll = findViewById(R.id.n_scroll);


        switch(stage){
            case 0:
                imageButton.setImageResource(R.drawable.n_cup1);
                n_scroll.addView(imageButton);
                break;
            case 1:
                imageButton.setImageResource(R.drawable.n_cup2);
                n_scroll.addView(imageButton);
                break;
            case 2:
                imageButton.setImageResource(R.drawable.n_re1);
                n_scroll.addView(imageButton);
                break;
            case 3:
                imageButton.setImageResource(R.drawable.n_re2);
                n_scroll.addView(imageButton);
                break;
            case 4:
                imageButton.setImageResource(R.drawable.n_orange);
                n_scroll.addView(imageButton);
                break;
            case 5:
                imageButton.setImageResource(R.drawable.n_blue);
                n_scroll.addView(imageButton);
                break;
        }







    }
}