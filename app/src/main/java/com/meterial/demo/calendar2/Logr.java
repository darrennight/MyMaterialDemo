package com.meterial.demo.calendar2;

import android.support.v4.BuildConfig;
import android.util.Log;
 
/** Log utility class to handle the log tag and DEBUG-only logging. */ 
final class Logr { 
  public static void d(String message) {
    if (BuildConfig.DEBUG) {
      Log.d("TimesSquare", message);
    } 
  } 
 
  public static void d(String message, Object... args) {
    if (BuildConfig.DEBUG) {
      d(String.format(message, args));
    } 
  } 
} 