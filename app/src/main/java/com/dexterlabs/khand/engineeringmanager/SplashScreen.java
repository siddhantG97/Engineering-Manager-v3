package com.dexterlabs.khand.engineeringmanager;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class SplashScreen extends AppCompatActivity {

    private GifImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        gifImageView=(GifImageView)findViewById(R.id.gifimageview);

        //set GifImageView Resource
        try{
            InputStream inputStream=getAssets().open("splash_screen.gif");
            byte[] bytes= IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch(IOException ex)
        {

        }
        //wait for 3 seconds and start activity main
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            SplashScreen.this.startActivity(new Intent(SplashScreen.this,WelcomeActivity.class));
            SplashScreen.this.finish();
            }
        },8000);//3000 =3 seconds
    }
}
