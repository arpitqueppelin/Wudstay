package com.wudstay.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * Created by Administrator on 25-Nov-15.
 */
public class CustomTextViewBold extends TextView {

    public CustomTextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
//        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro_Semibold.otf");
        this.setTypeface(null, Typeface.BOLD);
    }

}
