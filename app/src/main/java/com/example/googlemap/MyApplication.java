package com.example.googlemap;

import android.app.Application;

public class MyApplication extends Application {
    private  int gValue;
       private boolean toggle;
private CompanyDTO callback_Detail_View;
    public int getgValue(){
        return gValue;
    }

    public void setgValue(int value){
        this.gValue = value;
    }
           public CompanyDTO getCallback_Detail_View() {
        return callback_Detail_View;
    }

    public void setCallback_Detail_View(CompanyDTO callback_Detail_View) {
        this.callback_Detail_View = callback_Detail_View;
    }
        public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }
}
