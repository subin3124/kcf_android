package com.example.googlemap;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Object extends AppCompatActivity {
    public static float x, y;
    public static float x2, y2;
    public  static  float x3, y3, sincer, mypages=0;

    public static float getX3() {
        return x3;
    }

    public static float getY3() {
        return y3;
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getX2() {
        return x2;
    }

    public float getY2() {
        return y2;
    }

    public float getSincer() {
        return sincer;
    }

    public void setSincer(float sincer) {
        Object.sincer = sincer;
    }

    public static void setX3(float x3) {
        Object.x3 = x3;
    }

    public static void setY3(float y3) {
        Object.y3 = y3;
    }
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }
}

