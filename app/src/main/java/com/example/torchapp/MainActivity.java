package com.example.torchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    CameraManager cameraManager;
    ToggleButton onOrOff;
    String cameriaid,result;
    TextView tvresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onOrOff = findViewById(R.id.onOrOffLight);
        tvresult = findViewById(R.id.tvresult);

        onOrOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                torch(isChecked);
            }
        });
    }
    public void torch(boolean isChecked){
        try{

            cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
            cameriaid = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameriaid,isChecked);
            result = isChecked?"ON":"OFF";
            tvresult.setText(result);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}