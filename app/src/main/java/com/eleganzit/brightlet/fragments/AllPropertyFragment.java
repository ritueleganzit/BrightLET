package com.eleganzit.brightlet.fragments;


import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.eleganzit.brightlet.LandlordHomeActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.PropertyAdapter;
import com.eleganzit.brightlet.utils.ImageHelper;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllPropertyFragment extends Fragment {

    RecyclerView recyclerView;
    public AllPropertyFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);

    }
    RenderScript rs;
    //Our background will not scroll
    //so cache the blurred bitmap
    Bitmap mBlurredBitmap = null;
    Bitmap mBitmap1 = null;
    Bitmap mBitmap2 = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_all_property, container, false);

        LandlordHomeActivity.title.setText("Properties");
        LandlordHomeActivity.welcome.setVisibility(View.GONE);
        setHasOptionsMenu(true);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PropertyAdapter propertyAdapter=new PropertyAdapter(new ArrayList<String>(),getActivity());

        recyclerView= (RecyclerView) view.findViewById(R.id.rc1);
        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                mBitmap1 = loadBitmap(recyclerView, LandlordHomeActivity.bottomBar);
                setBackgroundOnView(LandlordHomeActivity.bottomBar, mBitmap1);

            }
        });
        recyclerView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onScrollChanged() {
                if (mBitmap1 != null) {
                    mBitmap1.recycle();
                }
                mBitmap1 = loadBitmap(recyclerView, LandlordHomeActivity.bottomBar);
                setBackgroundOnView(LandlordHomeActivity.bottomBar, mBitmap1);
            }
        });
        rs = RenderScript.create(getActivity());

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(propertyAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private Bitmap loadBitmap(View backgroundView, View targetView) {
        Rect backgroundBounds = new Rect();
        backgroundView.getHitRect(backgroundBounds);
        if (!targetView.getLocalVisibleRect(backgroundBounds)) {
            // NONE of the imageView is within the visible window
            return null;
        }

        Bitmap blurredBitmap = captureView(backgroundView);
        //capture only the area covered by our target view
        int[] loc = new int[2];
        int[] bgLoc = new int[2];
        backgroundView.getLocationInWindow(bgLoc);
        targetView.getLocationInWindow(loc);
        int height = targetView.getHeight();
        int y = loc[1];
        if (bgLoc[1] >= loc[1]) {
            //view is going off the screen at the top
            height -= (bgLoc[1] - loc[1]);
            if (y < 0)
                y = 0;
        }
        if (y + height > blurredBitmap.getHeight()) {
            height = blurredBitmap.getHeight() - y;
            Log.d("TAG", "Height = " + height);
            if (height <= 0) {
                //below the screen
                return null;
            }
        }
        Matrix matrix = new Matrix();
        //half the size of the cropped bitmap
        //to increase performance, it will also
        //increase the blur effect.
        matrix.setScale(0.5f, 0.5f);
        Bitmap bitmap = Bitmap.createBitmap(blurredBitmap,
                (int) targetView.getX(),
                y,
                targetView.getMeasuredWidth(),
                height,
                matrix,
                true);

        return bitmap;
        //If handling rounded corners yourself.
        //Create rounded corners on the Bitmap
        //keep in mind that our bitmap is half
        //the size of the original view, setting
        //it as the background will stretch it out
        //so you will need to use a smaller value
        //for the rounded corners than you would normally
        //to achieve the correct look.
        //ImageHelper.roundCorners(
        //bitmap,
        //getResources().getDimensionPixelOffset(R.dimen.rounded_corner),
        //false);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public Bitmap captureView(View view) {
        if (mBlurredBitmap != null) {
            return mBlurredBitmap;
        }
        //Find the view we are after
        //Create a Bitmap with the same dimensions
        mBlurredBitmap = Bitmap.createBitmap(view.getMeasuredWidth(),
                view.getMeasuredHeight(),
                Bitmap.Config.ARGB_4444); //reduce quality and remove opacity
        //Draw the view inside the Bitmap
        Canvas canvas = new Canvas(mBlurredBitmap);
        view.draw(canvas);

        //blur it
        ImageHelper.blurBitmapWithRenderscript(rs, mBlurredBitmap);

        //Make it frosty
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        ColorFilter filter = new LightingColorFilter(0xFFFFFFFF, 0x00222222); // lighten
        //ColorFilter filter = new LightingColorFilter(0xFF7F7F7F, 0x00000000);    // darken
        paint.setColorFilter(filter);
        canvas.drawBitmap(mBlurredBitmap, 0, 0, paint);

        return mBlurredBitmap;
    }

    @Override
    public void onDestroy() {
        if (mBlurredBitmap != null) {
            mBlurredBitmap.recycle();
        }
        super.onDestroy();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setBackgroundOnView(View view, Bitmap bitmap) {
        Drawable d;
        if (bitmap != null) {
            d = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
            ((RoundedBitmapDrawable) d).setCornerRadius(getResources().getDimensionPixelOffset(R.dimen.rounded_corner));

        } else {
            d = getContext().getDrawable(R.drawable.white_background);
        }
        view.setBackground(d);
    }
/*
    @Override
    public void onResume() {
        super.onResume();
        LandlordHomeActivity.name.setText("Mobile Case");
        Toast.makeText(getActivity(), ""+LandlordHomeActivity.name.getText().toString(), Toast.LENGTH_SHORT).show();

    }*/
}
