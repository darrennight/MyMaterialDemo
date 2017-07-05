package com.meterial.demo.commonActivity.ship.view2;

import android.text.TextUtils;
 
public class Common { 
 
    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    } 
} 