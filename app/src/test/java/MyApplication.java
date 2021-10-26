import android.app.Application;

class MyApplication extends Application {
    private  int gValue;

    public int getgValue(){
        return gValue;
    }

    public void setgValue(int value){
        this.gValue = value;
    }
}
