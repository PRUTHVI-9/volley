package com.example.volley_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BroadcastActivity extends AppCompatActivity {
    private static BroadcastActivity instance;
    TextView tv_mobile,tv_message;
    public static BroadcastActivity getInstance(){
        return instance;
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {


        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver,new IntentFilter("android.provider.Telyphony.SMS_RECEIVED"));
        instance=this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        tv_mobile = findViewById(R.id.tv_mobile);
        tv_message = findViewById(R.id.tv_message);


        tv_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.provider.Telyphony.SMS_RECEIVED");
                intent.putExtra("msg","hello");
                sendBroadcast(intent);
            }
        });
    }
    public void setSMSText(String num, String message){
        tv_mobile.setText(num);
        tv_message.setText(message);
    }
}