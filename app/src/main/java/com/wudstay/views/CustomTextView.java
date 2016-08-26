package com.wudstay.views;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTextView extends TextView {

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro_Regular.otf");
        this.setTypeface(null);
    }


}
