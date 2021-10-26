package com.example.googlemap;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class Store1 extends AppCompatActivity {


    int REQUEST_IMAGE_CODE=1001;
    public int custom_kind = 1;
    int blue = 0;





    Button.OnClickListener clickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store1);



        ImageButton button_store_order = findViewById(R.id.button_store_order);
        ImageButton button_store_quest = findViewById(R.id.button_store_quest);
        ImageButton button_store_block = findViewById(R.id.button_store_block);
        ImageButton button_store_N = findViewById(R.id.button_store_N);
        ImageButton button_store_back = findViewById(R.id.button_store_back);
        ImageButton button_store_image = findViewById(R.id.button_store_image);
        ImageButton button_store_questend = findViewById(R.id.button_store_questend);

        ImageButton button_store_order1 = findViewById(R.id.button_store_order1);
        ImageButton button_store_order2 = findViewById(R.id.button_store_order3);
        ImageButton button_store_order3 = findViewById(R.id.button_store_order2);

        ImageButton button_store_blue = findViewById(R.id.button_store_blue);
        ImageButton button_blue_back = findViewById(R.id.button_blue_back);



        ImageView image_blue= findViewById(R.id.image_blue);

        TextView text_store_quest = findViewById(R.id.text_store_quest);

        View scroll_store = findViewById(R.id.scroll_store);
        View layout_store_quest = findViewById(R.id.layout_store_quest);
        View layout_store_order = findViewById(R.id.layout_store_order);

        View layout_store_blue = findViewById(R.id.layout_store_blue);
        View layout_store = findViewById(R.id.layout_store);




        Object object = new Object();

        clickListener = new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                switch (view.getId()){

                    case R.id.button_store_order:
                        if(layout_store_order.getVisibility()==View.VISIBLE){
                            layout_store_order.setVisibility(View.GONE);
                            button_store_order.setColorFilter(null);
                        }
                        else{
                            layout_store_order.setVisibility(View.VISIBLE);
                            layout_store_quest.setVisibility(View.GONE);
                            button_store_quest.setColorFilter(null);
                            button_store_order.setColorFilter(Color.parseColor("#55ff0000"));
                        }
                        break;
                    case R.id.button_store_quest:
                        if(layout_store_quest.getVisibility()==View.VISIBLE){
                            layout_store_quest.setVisibility(View.GONE);
                            button_store_quest.setColorFilter(null);
                        }
                        else{
                            layout_store_quest.setVisibility(View.VISIBLE);
                            layout_store_order.setVisibility(View.GONE);
                            button_store_order.setColorFilter(null);
                            button_store_quest.setColorFilter(Color.parseColor("#55ff0000"));
                        }
                        break;
                    case R.id.button_store_N:
                        button_store_N.setColorFilter(Color.parseColor("#55ff0000"));
                        Intent intent = new Intent(getApplicationContext(), Custom.class);
                        intent.putExtra("key", 1);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.button_store_block:
                        button_store_block.setColorFilter(Color.parseColor("#55ff0000"));
                        intent = new Intent(getApplicationContext(), Custom.class);
                        intent.putExtra("key", 0);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.button_store_back:
                        button_store_back.setColorFilter(Color.parseColor("#55ff0000"));
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case  R.id.button_store_image:
                        intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_IMAGE_CODE);
                        button_store_image.setColorFilter(Color.parseColor("#55ff0000"));
                        break;
                    case R.id.button_store_questend:
                        button_store_image.setColorFilter(null);
                        text_store_quest.setText(null);
                        Toast.makeText(getApplicationContext(), "성공적으로 주문되었습니다", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.button_store_order1:
                        Toast.makeText(getApplicationContext(), "GreenPoint: 200g", Toast.LENGTH_SHORT).show();
                        blue = 1;
                        object.setSincer(1);
                        break;
                    case R.id.button_store_order2:
                        Toast.makeText(getApplicationContext(), "GreenPoint: 100g", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button_store_order3:
                        Toast.makeText(getApplicationContext(), "GreenPoint: 200g", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.button_store_blue:
                        layout_store.setVisibility(View.GONE);
                        layout_store_blue.setVisibility(View.VISIBLE);
                        if(blue==1){
                            image_blue.setImageResource(R.drawable.blue5);
                        }
                        break;
                    case R.id.button_blue_back:
                        layout_store.setVisibility(View.VISIBLE);
                        layout_store_blue.setVisibility(View.GONE);
                        break;

                }
            }
        };

        button_store_back.setOnClickListener(clickListener);
        button_store_block.setOnClickListener(clickListener);
        button_store_N.setOnClickListener(clickListener);
        button_store_quest.setOnClickListener(clickListener);
        button_store_order.setOnClickListener(clickListener);
        button_store_image.setOnClickListener(clickListener);
        button_store_questend.setOnClickListener(clickListener);

        button_store_order1.setOnClickListener(clickListener);
        button_store_order2.setOnClickListener(clickListener);
        button_store_order3.setOnClickListener(clickListener);

        button_store_blue.setOnClickListener(clickListener);
        button_blue_back.setOnClickListener(clickListener);



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CODE){
            if(resultCode == RESULT_OK){
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    Toast.makeText(getApplicationContext(), "이미지가 성공적으로 업로드되었습니다", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
