package com.example.volley_test;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG = "SMSBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: " + intent.getAction());

//        if (intent.getAction().equals(SMS_RECEIVED) ) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] objects = (Object[]) bundle.get("pdus");
                final SmsMessage[] messages = new SmsMessage[objects.length];

                for (int i = 0; i < objects.length; i++) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    {
                        String format = bundle.getString("format");
                        messages[i] = SmsMessage.createFromPdu((byte[]) objects[i], format);
                    }else{
                        messages[i]= SmsMessage.createFromPdu((byte[]) objects[i]);
                    }
                    String msg = messages[i].getMessageBody();
                    String phone_no = messages[i].getOriginatingAddress();

                    BroadcastActivity activity =  BroadcastActivity.getInstance();
                    activity.setSMSText(phone_no,msg);
                    Toast.makeText(context,"msg"+msg+"\nnumber" +phone_no, Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onReceive: "+msg );
                    Log.e(TAG, "onReceive: "+phone_no );
                }
            }


//        }
    }
}