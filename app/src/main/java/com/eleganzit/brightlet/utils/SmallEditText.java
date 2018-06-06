package com.eleganzit.brightlet.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by Uv on 6/4/2018.
 */

public class SmallEditText extends android.support.v7.widget.AppCompatEditText {

    private Context context;
    private AttributeSet attrs;
    private int defStyle;

    public SmallEditText(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public SmallEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        this.attrs=attrs;
        init();
    }

    public SmallEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context=context;
        this.attrs=attrs;
        this.defStyle=defStyle;
        init();
    }

    private void init() {
        Typeface font=Typeface.createFromAsset(getContext().getAssets(), "fonts/museosans_300.otf");
        this.setTypeface(font);
        this.setTextSize(15);
    }
    @Override
    public void setTypeface(Typeface tf, int style) {
        tf=Typeface.createFromAsset(getContext().getAssets(), "fonts/museosans_300.otf");
        super.setTypeface(tf, style);
    }

    @Override
    public void setTypeface(Typeface tf) {
        tf= Typeface.createFromAsset(getContext().getAssets(), "fonts/museosans_300.otf");
        super.setTypeface(tf);
    }

    @Override
    public void setTextSize(float size) {
        super.setTextSize(size);
    }
}
