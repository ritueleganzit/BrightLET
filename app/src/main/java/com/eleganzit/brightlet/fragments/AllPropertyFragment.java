package com.eleganzit.brightlet.fragments;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eleganzit.brightlet.LandlordHomeActivity;
import com.eleganzit.brightlet.LandlordServicesActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.SelectTenantActivity;
import com.eleganzit.brightlet.SelectTradespersonActivity;
import com.eleganzit.brightlet.adapters.PropertyAdapter;
import com.eleganzit.brightlet.utils.ImageHelper;

import java.lang.reflect.Field;
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
    Menu search_menu;
    MenuItem item_search;
    public static FrameLayout layout_MainMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_all_property, container, false);
        layout_MainMenu=v.findViewById(R.id.mainmenu);
        layout_MainMenu.getForeground().setAlpha(0);
        LandlordHomeActivity.bottomframe.getForeground().setAlpha(0);
        LandlordHomeActivity.topframe.getForeground().setAlpha(0);

        LandlordHomeActivity.title.setText("Properties");
        LandlordHomeActivity.welcome.setVisibility(View.GONE);
        setHasOptionsMenu(true);
        setSearchtollbar();

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PropertyAdapter propertyAdapter=new PropertyAdapter(new ArrayList<String>(),getActivity());

        recyclerView= view.findViewById(R.id.rc1);

       /* recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                mBitmap1 = loadBitmap(recyclerView, LandlordHomeActivity.bottomBar);
                //setBackgroundOnView(LandlordHomeActivity.bottomBar, mBitmap1);

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
        rs = RenderScript.create(getActivity());*/

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(propertyAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();

        if (id == R.id.menu_search) {
            Toast.makeText(getContext(), "Search", Toast.LENGTH_SHORT).show();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                circleReveal(R.id.searchtoolbar, 1, true, true);
                layout_MainMenu.getForeground().setAlpha( 90);
                LandlordHomeActivity.bottomframe.getForeground().setAlpha( 90);
                LandlordHomeActivity.topframe.getForeground().setAlpha(0);




                Window window = getActivity().getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.parseColor("#FF3A1F58"));
            }

            else
                LandlordHomeActivity.searchtollbar.setVisibility(View.VISIBLE);
            layout_MainMenu.getForeground().setAlpha( 90);
            LandlordHomeActivity.bottomframe.getForeground().setAlpha( 90);
            LandlordHomeActivity.topframe.getForeground().setAlpha(0);





            item_search.expandActionView();
            return true;
        }

        if (id == R.id.menu_add) {
            Toast.makeText(getContext(), "add", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
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
    public void setSearchtollbar()
    {
        LandlordHomeActivity.searchtollbar = getActivity().findViewById(R.id.searchtoolbar);
        if (LandlordHomeActivity.searchtollbar != null) {
            LandlordHomeActivity.searchtollbar.inflateMenu(R.menu.menu_search);
            search_menu=LandlordHomeActivity.searchtollbar.getMenu();

            LandlordHomeActivity.searchtollbar.setNavigationOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        circleReveal(R.id.searchtoolbar, 1, true, false);

                    }
                    else
                        LandlordHomeActivity.searchtollbar.setVisibility(View.GONE);

                }
            });

            item_search = search_menu.findItem(R.id.action_filter_search);

            MenuItemCompat.setOnActionExpandListener(item_search, new MenuItemCompat.OnActionExpandListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public boolean onMenuItemActionCollapse(MenuItem item) {
                    // Do something when collapsed
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    {
                        circleReveal(R.id.searchtoolbar,1,true,false);
                        Window window = getActivity().getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(Color.parseColor("#5a2e87"));
                        layout_MainMenu.getForeground().setAlpha(0);
                        LandlordHomeActivity.bottomframe.getForeground().setAlpha(0);
                        LandlordHomeActivity.topframe.getForeground().setAlpha(0);

                    }
                    else
                        LandlordHomeActivity.searchtollbar.setVisibility(View.GONE);
                        layout_MainMenu.getForeground().setAlpha(0);
                        LandlordHomeActivity.bottomframe.getForeground().setAlpha(0);
                        LandlordHomeActivity.topframe.getForeground().setAlpha(0);


                    return true;
                }

                @Override
                public boolean onMenuItemActionExpand(MenuItem item) {
                    // Do something when expanded
                    return true;
                }
            });

            initSearchView();


        } else
            Log.d("toolbar", "setSearchtollbar: NULL");
    }
    public void initSearchView()
    {
        final SearchView searchView =
                (SearchView) search_menu.findItem(R.id.action_filter_search).getActionView();

        // Enable/Disable Submit button in the keyboard

        searchView.setSubmitButtonEnabled(false);

        // Change search close button image

        ImageView closeButton = searchView.findViewById(R.id.search_close_btn);
        closeButton.setImageResource(R.drawable.search_dark);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Search tenant!", Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    circleReveal(R.id.searchtoolbar,1,true,false);
                    Window window = getActivity().getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#5a2e87"));
                    layout_MainMenu.getForeground().setAlpha(0);
                    LandlordHomeActivity.bottomframe.getForeground().setAlpha(0);
                    LandlordHomeActivity.topframe.getForeground().setAlpha(0);


                }
                else
                    LandlordHomeActivity.searchtollbar.setVisibility(View.GONE);
                layout_MainMenu.getForeground().setAlpha(0);
                LandlordHomeActivity.bottomframe.getForeground().setAlpha(0);
                LandlordHomeActivity.topframe.getForeground().setAlpha(0);



            }
        });

        // set hint and the text colors

        EditText txtSearch = ((EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text));
        txtSearch.setHint("Search...");
        txtSearch.setHintTextColor(Color.parseColor("#A0A0A0"));
        /*txtSearch.setTextColor(Color.parseColor("#000000"));
        txtSearch.setTextSize(15);
        txtSearch.setBackgroundColor(Color.parseColor("#ffffff"));
        txtSearch.setBackground(null);*/

        // set the cursor

        AutoCompleteTextView searchTextView = (AutoCompleteTextView) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        try {
            Field mCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
            mCursorDrawableRes.setAccessible(true);
            mCursorDrawableRes.set(searchTextView, R.drawable.search_cursor); //This sets the cursor resource ID to 0 or @null which will make it visible on white background
        } catch (Exception e) {
            e.printStackTrace();
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                callSearch(query);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                callSearch(newText);
                return true;
            }

            public void callSearch(String query) {
                //Do searching
                Log.i("query", "" + query);

            }

        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void circleReveal(int viewID, int posFromRight, boolean containsOverflow, final boolean isShow)
    {
        final View myView = getActivity().findViewById(viewID);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        //int width=myView.getWidth();

        if(posFromRight>0)
            width-=(posFromRight*getResources().getDimensionPixelSize(R.dimen.abc_action_button_min_width_material))-(getResources().getDimensionPixelSize(R.dimen.abc_action_button_min_width_material)/ 2);
        if(containsOverflow)
            width-=getResources().getDimensionPixelSize(R.dimen.abc_action_button_min_width_overflow_material);

        int cx=width;
        int cy=myView.getHeight()/2;

        Animator anim;
        if(isShow)
            anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0,(float)width);
        else
            anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, (float)width, 0);

        anim.setDuration((long)220);

        // make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if(!isShow)
                {
                    super.onAnimationEnd(animation);
                    myView.setVisibility(View.INVISIBLE);
                }
            }
        });

        // make the view visible and start the animation
        if(isShow)
            myView.setVisibility(View.VISIBLE);

        // start the animation
        anim.start();


    }
/*
    @Override
    public void onResume() {
        super.onResume();
        LandlordHomeActivity.name.setText("Mobile Case");
        Toast.makeText(getActivity(), ""+LandlordHomeActivity.name.getText().toString(), Toast.LENGTH_SHORT).show();

    }*/
}
