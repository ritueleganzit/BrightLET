package com.eleganzit.brightlet.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by Uv on 5/19/2018.
 */

public class TextViewMuseo100 extends android.support.v7.widget.AppCompatTextView
{
    public TextViewMuseo100(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewMuseo100(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewMuseo100(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/museo100_regular.otf");
        setTypeface(tf ,1);

    }

}
