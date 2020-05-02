package com.ds.FireAlarmMonitor.controller;

import com.ds.FireAlarmMonitor.model.FireAlarm;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



public class SmsSender {
 // Find your Account Sid and Auth Token at twilio.com/console
 public static final String ACCOUNT_SID =
         "AC736d168b60775baa4fe6173695f67dec";
 public static final String AUTH_TOKEN =
         "557ebf6e19808569e5f18fc4b3dbac9b";

 public void sendSMS(FireAlarm sms) {
     Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

     Message message = Message
             .creator(new PhoneNumber("+94766197430"), // to
                     new PhoneNumber("+12025177685"), // from
                     "Fire Alarm Monitor  Floor NO: " +sms.getFloorNo()+
                      "  Room No: "+sms.getRoomNo()+"  CO2 Level : "+sms.getCo2Level()+"  Smoke Level :"+sms.getSmokeLevel()+"  Fire Alarm Alert...! ")
             .create();

     System.out.println(message.getSid());
 }
}

