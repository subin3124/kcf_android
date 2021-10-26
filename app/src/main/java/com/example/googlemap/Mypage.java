package com.example.googlemap;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class Mypage extends AppCompatActivity {


    String id_log = "Hello";
    String text_server_store = "땡이네 소곱창";
    String text_server_menu = "소곱창";
    String text_server_ingre = "곱창, 고추장, 고추";
    String text_server_num = "100근, 10g, 2개";

    int num=1;

    int REQUEST_IMAGE_CODE = 1001;
    boolean order=false, quest=false, block=false, n=false;


    Button.OnClickListener clickListener;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        ImageButton button_my_back = findViewById(R.id.button_my_back);
        ImageButton button_my_order = findViewById(R.id.button_my_order);
        ImageButton button_my_company = findViewById(R.id.button_my_company);

        ImageButton button_my_login = findViewById(R.id.button_my_login);
        ImageButton button_my_useradd = findViewById(R.id.button_my_useradd);
        ImageButton button_my_companyadd = findViewById(R.id.button_my_companyadd);

        ImageButton button_my_check_order = findViewById(R.id.button_my_check_order);
        ImageButton button_my_check_quest = findViewById(R.id.button_my_check_quest);
        ImageButton button_my_check_n = findViewById(R.id.button_my_check_n);
        ImageButton button_my_check_block = findViewById(R.id.button_my_check_block);
        ImageButton button_my_companyadd_image = findViewById(R.id.button_my_companyadd_image);
        ImageButton button_my_finish_companyadd = findViewById(R.id.button_my_finish_companyadd);
        ImageButton button_my_finish_useradd = findViewById(R.id.button_my_finish_useradd);

        Button button_my_red = findViewById(R.id.button_my_red);
        Button button_my_product = findViewById(R.id.button_my_product);
        ImageButton button_my_productadd = findViewById(R.id.button_my_productadd);

        ImageButton button_my_joomoon = findViewById(R.id.button_my_joomoon);
        ImageButton button_my_sunda = findViewById(R.id.button_my_sunda);
        ImageButton button_my_blok = findViewById(R.id.button_my_blok);
        ImageButton button_my_finish_product = findViewById(R.id.button_my_finish_product);

        ImageButton button_my_image1 = findViewById(R.id.button_my_image1);
        ImageButton button_my_image2 = findViewById(R.id.button_my_image2);
        ImageButton button_my_image3 = findViewById(R.id.button_my_image3);
        ImageButton button_my_image4 = findViewById(R.id.button_my_image4);
        ImageButton button_my_image5 = findViewById(R.id.button_my_image5);
        ImageButton button_my_image = findViewById(R.id.button_my_image);


        ImageButton button_my_cad = findViewById(R.id.button_my_cad);
        ImageButton button_my_cad1 = findViewById(R.id.button_my_cad1);
        ImageButton button_my_cad2 = findViewById(R.id.button_my_cad2);
        ImageButton button_my_cad3 = findViewById(R.id.button_my_cad3);
        ImageButton button_my_cad_back = findViewById(R.id.button_my_cad_back);

        ImageButton button_my_red1 = findViewById(R.id.button_my_red1);
        ImageButton button_my_red2 = findViewById(R.id.button_my_red2);
        ImageButton button_my_red3 = findViewById(R.id.button_my_red3);
        ImageButton button_my_red4 = findViewById(R.id.button_my_red4);
        ImageButton button_my_red5 = findViewById(R.id.button_my_red5);
        ImageButton button_my_redend = findViewById(R.id.button_my_redend);
        ImageButton button_my_green = findViewById(R.id.button_my_green);
        ImageButton button_my_green_back = findViewById(R.id.button_my_greenback);

        ImageButton button_my_no1 = findViewById(R.id.button_my_no1);
        ImageButton button_my_no2 = findViewById(R.id.button_my_Addsunda);
        Button button_my_addn1 = findViewById(R.id.button_my_addn1);
        Button button_my_addn2 = findViewById(R.id.button_my_addn2);
        Button button_my_addn3 = findViewById(R.id.button_my_addn3);
        ImageButton button_my_addblock = findViewById(R.id.button_my_addblock);
        ImageButton button_my_addsunda = findViewById(R.id.button_my_Addsunda);
        ImageButton button_my_product_example = findViewById(R.id.button_my_product_example);




        TextView text_my_x = findViewById(R.id.text_my_x);
        TextView text_my_y = findViewById(R.id.text_my_y);
        TextView text_my_green = findViewById(R.id.text_my_green);


        ImageView image_my_green = findViewById(R.id.image_my_green);
        ImageView image_my_green2 = findViewById(R.id.image_my_green2);







        View layout_my_top = findViewById(R.id.layout_my_top);
        View layout_my_login = findViewById(R.id.layout_my_login);
        View layout_my_signup_user = findViewById(R.id.layout_my_signup_user);
        View layout_my_signup_company = findViewById(R.id.layout_my_signup_company);
        View layout_my_order = findViewById(R.id.layout_my_order);
        View layout_my_company = findViewById(R.id.layout_my_company);
        View layout_my_company1 = findViewById(R.id.layout_my_company1);
        View layout_my_company2 = findViewById(R.id.layout_my_company2);
        View layout_my_custom = findViewById(R.id.layout_my_custom);

        View layout_my_orderinfo = findViewById(R.id.layout_my_orderinfo);
        View layout_my_product = findViewById(R.id.layout_my_prduct);

        View layout_my_ordercus = findViewById(R.id.layout_my_ordercus);
        View layout_my_blockcus = findViewById(R.id.layout_my_blockcus);
        View layout_my_ncus = findViewById(R.id.layout_my_ncus);

        View layout_my_cad = findViewById(R.id.layout_my_cad);
        View layout_my_red = findViewById(R.id.layout_my_red);
        View layout_my_green = findViewById(R.id.layout_my_green);


        Object object = new Object();

        button_my_joomoon.setColorFilter(Color.parseColor("#55ff0000"));


        if(object.mypages==1){
            layout_my_login.setVisibility(View.GONE);
            layout_my_company1.setVisibility(View.GONE);
            layout_my_company2.setVisibility(View.VISIBLE);
            button_my_product_example.setImageResource(R.drawable.x);
        }

        button_my_product.setTextColor(Color.RED);


        clickListener = new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.button_my_back:
                        object.mypages = 1;
                        button_my_back.setColorFilter(Color.parseColor("#55ff0000"));
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.button_my_order:
                        button_my_order.setColorFilter(Color.parseColor("#55ff0000"));
                        button_my_company.setColorFilter(null);
                        layout_my_order.setVisibility(View.VISIBLE);
                        layout_my_company.setVisibility(View.GONE);
                        break;
                    case R.id.button_my_company:
                        button_my_company.setColorFilter(Color.parseColor("#55ff0000"));
                        button_my_order.setColorFilter(null);
                        layout_my_company.setVisibility(View.VISIBLE);
                        layout_my_order.setVisibility(View.GONE);
                        break;


                    case R.id.button_my_login:
                        layout_my_login.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "우리앱에 오신 걸 환경합니다", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button_my_useradd:
                        layout_my_login.setVisibility(View.GONE);
                        layout_my_signup_user.setVisibility(View.VISIBLE);
                        break;
                    case R.id.button_my_companyadd:
                        button_my_companyadd.setColorFilter(Color.parseColor("#55ff0000"));
                        layout_my_top.setVisibility(View.GONE);
                        layout_my_company.setVisibility(View.GONE);
                        layout_my_signup_company.setVisibility(View.VISIBLE);
                        break;


                    case R.id.button_my_finish_useradd:
                        Toast.makeText(getApplicationContext(), "앞으로 오래오래 봐요", Toast.LENGTH_SHORT).show();
                        layout_my_signup_user.setVisibility(View.GONE);
                        break;
                    case R.id.button_my_finish_companyadd:
                        Toast.makeText(getApplicationContext(), "대박나세요", Toast.LENGTH_SHORT).show();
                        layout_my_signup_company.setVisibility(View.GONE);
                        layout_my_top.setVisibility(View.VISIBLE);
                        layout_my_company.setVisibility(View.VISIBLE);
                        layout_my_company1.setVisibility(View.GONE);
                        layout_my_company2.setVisibility(View.VISIBLE);
                        break;
                    case R.id.button_my_check_block:
                        if(button_my_check_block.getColorFilter()==null)
                        button_my_check_block.setColorFilter(Color.parseColor("#55ff0000"));
                        else
                            button_my_check_block.setColorFilter(null);
                        break;
                    case R.id.button_my_check_n:
                        if(button_my_check_n.getColorFilter()==null)
                            button_my_check_n.setColorFilter(Color.parseColor("#55ff0000"));
                        else
                            button_my_check_n.setColorFilter(null);
                        break;
                    case R.id.button_my_check_quest:
                        if(button_my_check_quest.getColorFilter()==null)
                            button_my_check_quest.setColorFilter(Color.parseColor("#55ff0000"));
                        else
                            button_my_check_quest.setColorFilter(null);
                        break;
                    case R.id.button_my_check_order:
                        if(button_my_check_order.getColorFilter()==null)
                            button_my_check_order.setColorFilter(Color.parseColor("#55ff0000"));
                        else
                            button_my_check_order.setColorFilter(null);
                        break;
                    case R.id.button_my_companyadd_image:
                        intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_IMAGE_CODE);
                        button_my_companyadd_image.setColorFilter(Color.parseColor("#55ff0000"));
                        break;



                    case R.id.button_my_red:
                        button_my_red.setTextColor(Color.RED);
                        button_my_product.setTextColor(Color.BLACK);

                        layout_my_red.setVisibility(View.VISIBLE);
                        layout_my_orderinfo.setVisibility(View.GONE);
                        layout_my_product.setVisibility(View.GONE);

                        break;
                    case R.id.button_my_product:
                        button_my_product.setTextColor(Color.RED);
                        button_my_red.setTextColor(Color.BLACK);

                        layout_my_product.setVisibility(View.VISIBLE);
                        layout_my_orderinfo.setVisibility(View.GONE);
                        layout_my_red.setVisibility(View.GONE);
                        break;
                    case R.id.button_my_productadd:
                        layout_my_top.setVisibility(View.GONE);
                        layout_my_company.setVisibility(View.GONE);
                        layout_my_custom.setVisibility(View.VISIBLE);
                        break;
                    case R.id.button_my_joomoon:
                        if(button_my_joomoon.getColorFilter()==null){
                            button_my_joomoon.setColorFilter(Color.parseColor("#55ff0000"));
                            button_my_sunda.setColorFilter(null);
                            button_my_blok.setColorFilter(null);
                        }
                        layout_my_ordercus.setVisibility(View.VISIBLE);
                        layout_my_blockcus.setVisibility(View.GONE);
                        layout_my_ncus.setVisibility(View.GONE);
                        break;
                    case R.id.button_my_sunda:
                        if(button_my_sunda.getColorFilter()==null){
                            button_my_sunda.setColorFilter(Color.parseColor("#55ff0000"));
                            button_my_blok.setColorFilter(null);
                            button_my_joomoon.setColorFilter(null);
                        }
                        layout_my_ncus.setVisibility(View.VISIBLE);
                        layout_my_ordercus.setVisibility(View.GONE);
                        layout_my_blockcus.setVisibility(View.GONE);
                        break;
                    case R.id.button_my_blok:
                        if(button_my_blok.getColorFilter()==null){
                            button_my_blok.setColorFilter(Color.parseColor("#55ff0000"));
                            button_my_joomoon.setColorFilter(null);
                            button_my_sunda.setColorFilter(null);
                        }
                        layout_my_blockcus.setVisibility(View.VISIBLE);
                        layout_my_ordercus.setVisibility(View.GONE);
                        layout_my_ncus.setVisibility(View.GONE);
                        break;
                    case R.id.button_my_finish_product:
                        layout_my_custom.setVisibility(View.GONE);
                        layout_my_company.setVisibility(View.VISIBLE);
                        layout_my_top.setVisibility(View.VISIBLE);
                        button_my_product_example.setImageResource(R.drawable.n_cup1);
                        createImageButton();
                        break;


                    case R.id.button_my_image1:
                        intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_IMAGE_CODE);
                        button_my_image1.setColorFilter(Color.parseColor("#55ff0000"));
                        break;
                    case R.id.button_my_image2:
                        intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_IMAGE_CODE);
                        button_my_image2.setColorFilter(Color.parseColor("#55ff0000"));
                        break;
                    case R.id.button_my_image3:
                        intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_IMAGE_CODE);
                        button_my_image3.setColorFilter(Color.parseColor("#55ff0000"));
                        break;
                    case R.id.button_my_image4:
                        intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_IMAGE_CODE);
                        button_my_image4.setColorFilter(Color.parseColor("#55ff0000"));
                        break;
                    case R.id.button_my_image5:
                        intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_IMAGE_CODE);
                        button_my_image5.setColorFilter(Color.parseColor("#55ff0000"));
                        break;
                    case R.id.button_my_image:
                        intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_IMAGE_CODE);
                        button_my_image.setColorFilter(Color.parseColor("#55ff0000"));
                        break;


                    case R.id.button_my_cad:
                        layout_my_order.setVisibility(View.GONE);
                        layout_my_top.setVisibility(View.GONE);
                        layout_my_cad.setVisibility(View.VISIBLE);

                        button_my_cad1.setImageResource(R.drawable.block_sche1);
                        button_my_cad1.setX(object.getX3());
                        button_my_cad1.setY(object.getY3());

                        button_my_cad2.setImageResource(R.drawable.block_1);
                        button_my_cad2.setX(object.getX());
                        button_my_cad2.setY(object.getY());

                        button_my_cad3.setImageResource(R.drawable.block_4);
                        button_my_cad3.setX(object.getX2());
                        button_my_cad3.setY(object.getY2());
                        break;
                    case R.id.button_my_cad1:
                        text_my_x.setText(Float.toString(object.getX()));
                        text_my_y.setText(Float.toString(object.getY()));
                        break;
                    case R.id.button_my_cad2:
                        text_my_x.setText(Float.toString(object.getX2()));
                        text_my_y.setText(Float.toString(object.getY2()));
                        break;
                    case R.id.button_my_cad3:
                        text_my_x.setText(Float.toString(object.getX3()));
                        text_my_y.setText(Float.toString(object.getY3()));
                        break;
                    case R.id.button_my_cad_back:
                        layout_my_top.setVisibility(View.VISIBLE);
                        layout_my_cad.setVisibility(View.GONE);
                        layout_my_order.setVisibility(View.VISIBLE);
                        break;


                    case R.id.button_my_red1:
                        intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_IMAGE_CODE);
                        button_my_red1.setColorFilter(Color.parseColor("#55ff0000"));
                        break;
                    case R.id.button_my_red2:
                        intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_IMAGE_CODE);
                        button_my_red2.setColorFilter(Color.parseColor("#55ff0000"));
                        break;
                    case R.id.button_my_red3:
                        intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_IMAGE_CODE);
                        button_my_red3.setColorFilter(Color.parseColor("#55ff0000"));
                        break;
                    case R.id.button_my_red4:
                        intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_IMAGE_CODE);
                        button_my_red4.setColorFilter(Color.parseColor("#55ff0000"));
                        break;
                    case R.id.button_my_red5:
                        intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_IMAGE_CODE);
                        button_my_red5.setColorFilter(Color.parseColor("#55ff0000"));
                        break;
                    case R.id.button_my_redend:
                        Toast.makeText(getApplicationContext(), "성공적으로 등록되었습니다", Toast.LENGTH_SHORT).show();
                        button_my_redend.setColorFilter(Color.parseColor("#55ff0000"));
                        break;
                    case R.id.button_my_green:
                        layout_my_green.setVisibility(View.VISIBLE);
                        layout_my_order.setVisibility(View.GONE);
                        layout_my_company.setVisibility(View.GONE);
                        layout_my_top.setVisibility(View.GONE);
                        if(Object.sincer >= 1){
                            image_my_green.setImageResource(R.drawable.green5);
                            float a = image_my_green2.getX();
                            image_my_green2.setX(a+Object.sincer*100);
                            text_my_green.setText("2794g의 탄소배출을 줄였습니다\n0개의 행성을 구했습니다");
                        }
                        break;
                    case R.id.button_my_greenback:
                        layout_my_green.setVisibility(View.GONE);
                        layout_my_top.setVisibility(View.VISIBLE);
                        break;

                    case R.id.button_my_no1:
                        if(num==1){
                            button_my_addn1.setVisibility(View.VISIBLE);
                        }
                        if(num==2){
                            button_my_addn2.setVisibility(View.VISIBLE);
                        }
                        if(num==3){
                            button_my_addn3.setVisibility(View.VISIBLE);
                        }
                        num++;
                        break;



                    case R.id.button_my_addblock:
                        Toast.makeText(getApplicationContext(), "성공적으로 등록되었습니다", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button_my_Addsunda:
                        Toast.makeText(getApplicationContext(), "성공적으로 등록되었습니다", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        button_my_back.setOnClickListener(clickListener);
        button_my_order.setOnClickListener(clickListener);
        button_my_company.setOnClickListener(clickListener);

        button_my_login.setOnClickListener(clickListener);
        button_my_useradd.setOnClickListener(clickListener);
        button_my_companyadd.setOnClickListener(clickListener);

        button_my_check_order.setOnClickListener(clickListener);
        button_my_check_n.setOnClickListener(clickListener);
        button_my_check_quest.setOnClickListener(clickListener);
        button_my_check_block.setOnClickListener(clickListener);
        button_my_companyadd_image.setOnClickListener(clickListener);
        button_my_finish_companyadd.setOnClickListener(clickListener);
        button_my_finish_useradd.setOnClickListener(clickListener);

        button_my_product.setOnClickListener(clickListener);
        button_my_red.setOnClickListener(clickListener);
        button_my_productadd.setOnClickListener(clickListener);

        button_my_joomoon.setOnClickListener(clickListener);
        button_my_sunda.setOnClickListener(clickListener);
        button_my_blok.setOnClickListener(clickListener);
        button_my_finish_product.setOnClickListener(clickListener);
        button_my_image1.setOnClickListener(clickListener);
        button_my_image2.setOnClickListener(clickListener);
        button_my_image3.setOnClickListener(clickListener);
        button_my_image4.setOnClickListener(clickListener);
        button_my_image5.setOnClickListener(clickListener);
        button_my_image.setOnClickListener(clickListener);

        button_my_cad.setOnClickListener(clickListener);
        button_my_cad1.setOnClickListener(clickListener);
        button_my_cad2.setOnClickListener(clickListener);
        button_my_cad3.setOnClickListener(clickListener);
        button_my_cad_back.setOnClickListener(clickListener);

        button_my_red1.setOnClickListener(clickListener);
        button_my_red2.setOnClickListener(clickListener);
        button_my_red3.setOnClickListener(clickListener);
        button_my_red4.setOnClickListener(clickListener);
        button_my_red5.setOnClickListener(clickListener);
        button_my_redend.setOnClickListener(clickListener);
        button_my_green.setOnClickListener(clickListener);
        button_my_green_back.setOnClickListener(clickListener);

        button_my_no1.setOnClickListener(clickListener);
        button_my_no2.setOnClickListener(clickListener);
        button_my_addblock.setOnClickListener(clickListener);
        button_my_addsunda.setOnClickListener(clickListener);

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

        LinearLayout layout_my_scroll = findViewById(R.id.layout_my_scroll);
        layout_my_scroll.addView(imageButton);

    }

}