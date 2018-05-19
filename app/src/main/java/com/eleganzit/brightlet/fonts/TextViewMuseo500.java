package com.eleganzit.brightlet.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by Uv on 5/19/2018.
 */

public class TextViewMuseo500 extends android.support.v7.widget.AppCompatTextView
{
    public TextViewMuseo500(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewMuseo500(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewMuseo500(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/museo500_regular.otf");
        setTypeface(tf ,1);

    }

}
