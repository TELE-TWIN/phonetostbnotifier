/**
 *
 * @author Achraf Gazdar
 */
package com.phonetostbapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class IncomingSMSReceiver extends BroadcastReceiver {
    private toSTBnotifierService notifierService; 

    public IncomingSMSReceiver(toSTBnotifierService service) {
        notifierService = service;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Bundle bundle = intent.getExtras();
        Object[] pdus = (Object[]) bundle.get("pdus");
        SmsMessage message = SmsMessage.createFromPdu((byte[])pdus[0]);
        notifierService.notifyNewSMS(message);
    }
    
    
}
