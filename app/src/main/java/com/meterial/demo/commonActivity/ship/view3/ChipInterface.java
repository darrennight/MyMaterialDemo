package com.meterial.demo.commonActivity.ship.view3;

import android.graphics.drawable.Drawable;
import android.net.Uri;
 
public interface ChipInterface { 
 
    Object getId();
    Uri getAvatarUri();
    Drawable getAvatarDrawable();
    String getLabel();
    String getInfo();
} 