package com.example.tinytoes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;



public class EyeDetectionScreen extends AppCompatActivity{

    ImageView imageView;
    String api = "http://saqib0494.pythonanywhere.com//sleepy/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_detection_screen);
        imageView = findViewById(R.id.imageView17);
        getSupportActionBar().hide();


        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));

        }
        final TextView textView = findViewById(R.id.Response);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{

                    String str = "";
                    Python py = Python.getInstance();


                    PyObject obj = py.getModule("API_Function");

                    String url = "http://saqib0494.pythonanywhere.com//sleepy/";
                    String file_path = "F:/temp.jpg";


                    PyObject temp  = obj.callAttr("API_Call",url,file_path);


//                    str = temp.toString();

                    Thread.sleep(7000);
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(temp.toString());
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    public void ClassifyAudioButtonPressed(View v){

        Intent i = new Intent(EyeDetectionScreen.this, RecordAudio.class);
        startActivity(i);
    }

    public void ProfileButtonPressed(View v){

        Intent i = new Intent(EyeDetectionScreen.this, Profile.class);
        startActivity(i);
    }
    public void MoreButtonPressed(View v){

        Intent i = new Intent(EyeDetectionScreen.this, more_page.class);
        startActivity(i);
    }
    public void HomeButtonPressed(View v){

        Intent i = new Intent(EyeDetectionScreen.this, MainMenu.class);
        startActivity(i);
    }
    public void CameraButtonPressed(View v){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK){
            if(requestCode == 10){
                imageView.setImageURI(data.getData());
            }
            if(requestCode == 100){
                Bitmap img = (Bitmap) (data.getExtras().get("data"));
                imageView.setImageBitmap(img);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}