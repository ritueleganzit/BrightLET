package com.eleganzit.brightlet.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by Uv on 5/17/2018.
 */

public class TextViewMSANS extends android.support.v7.widget.AppCompatTextView
{
    public TextViewMSANS(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewMSANS(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewMSANS(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/museo300_regular.otf");
        setTypeface(tf ,1);

    }

}
