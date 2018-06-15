package com.eleganzit.brightlet.fragments;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.eleganzit.brightlet.LandlordHomeActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.MyTabAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_dashboard extends Fragment {


    public Fragment_dashboard() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }
    private Boolean isFabOpen = false;
    private Animation rotate_forward,rotate_backward;
    private Boolean isOut = false;
    private Animation right_to_left,left_to_right;
    FloatingActionButton fab;
    TabLayout tabLayout;
    ViewPager viewPager;
    PopupWindow popupwindow_obj ;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_dashboard, container, false);
        LandlordHomeActivity.layout_MainMenu.getForeground().setAlpha( 0);
        LandlordHomeActivity.topframe.getForeground().setAlpha( 0);
        LandlordHomeActivity.bottomframe.getForeground().setAlpha( 0);
        LandlordHomeActivity.title.setText("Mike");
        LandlordHomeActivity.welcome.setVisibility(View.VISIBLE);
        tabLayout=v.findViewById(R.id.dashboard_tabs);
        viewPager=v.findViewById(R.id.dashboard_view_pager);
        fab=v.findViewById(R.id.fab);
        rotate_forward = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_backward);
        right_to_left = AnimationUtils.loadAnimation(getContext(),R.anim.right_to_left);
        left_to_right = AnimationUtils.loadAnimation(getContext(),R.anim.left_to_right);

        setHasOptionsMenu(true);

        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
            @Override
            public void onClick(View v) {
                animate();
                /*PopupMenu popupMenu=new PopupMenu(getContext(),fab,Gravity.END,0,R.style.MyPopupMenu);
                //popupMenu.getMenuInflater().inflate(R.menu.custom_popup_menu, popupMenu.getMenu());

                MenuBuilder menuBuilder =new MenuBuilder(getActivity());
                //MenuInflater inflater = new MenuInflater(getActivity());
                popupMenu.getMenuInflater().inflate(R.menu.custom_popup_menu, menuBuilder);
                MenuPopupHelper optionsMenu = new MenuPopupHelper(getContext(), menuBuilder, fab);
                optionsMenu.setForceShowIcon(true);
                optionsMenu.show();*/
                PopupMenu popupMenu=new PopupMenu(getActivity(),v, Gravity.END,0,R.style.MyPopupMenu);
                MenuBuilder menuBuilder =new MenuBuilder(getActivity());
                popupMenu.getMenuInflater().inflate(R.menu.custom_popup_menu, menuBuilder);
                MenuPopupHelper optionsMenu = new MenuPopupHelper(getActivity(), menuBuilder, fab);
                optionsMenu.setForceShowIcon(true);
                optionsMenu.show();

                LandlordHomeActivity.layout_MainMenu.getForeground().setAlpha( 90);
                LandlordHomeActivity.topframe.getForeground().setAlpha( 90);
                LandlordHomeActivity.bottomframe.getForeground().setAlpha( 90);

                Window window = getActivity().getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.parseColor("#FF3A1F58"));

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        Toast.makeText(getContext(), ""+ item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                /*MenuPopupHelper menuHelper = new MenuPopupHelper(getContext(), (MenuBuilder) popupMenu.getMenu(), fab);
                menuHelper.setForceShowIcon(true);
                menuHelper.show();*/
                //popupMenu.show();
                optionsMenu.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        Window window = getActivity().getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(Color.parseColor("#5a2e87"));
                        LandlordHomeActivity.layout_MainMenu.getForeground().setAlpha( 0);
                        LandlordHomeActivity.topframe.getForeground().setAlpha( 0);
                        LandlordHomeActivity.bottomframe.getForeground().setAlpha( 0);
                        fab.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{0}}, new int[]{Color.parseColor("#f39200")}));
                        fab.startAnimation(rotate_backward);
                        isFabOpen = false;
                    }
                });
            }
        });

        MyTabAdapter myTabAdapter=new MyTabAdapter(getChildFragmentManager());
        myTabAdapter.addFragment(new Fragment_reminders(),"REMINDERS");
        myTabAdapter.addFragment(new Fragment_appointment(),"APPOINTMENTS");
        myTabAdapter.addFragment(new Fragment_maintanence(),"MAINTANENCE");
        viewPager.setAdapter(myTabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }




    public void animateFAB(){

        if(isFabOpen){

            fab.startAnimation(rotate_backward);
            fab.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{0}}, new int[]{Color.parseColor("#FFD03131")}));//fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#f39200")));

            isFabOpen = false;
            Log.d("Raj", "close");

        } else {

            fab.startAnimation(rotate_forward);
            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFD03131")));

            isFabOpen = true;
            Log.d("Raj","open");

        }
    }
    public void animate(){

        if(isFabOpen){

            //fab.startAnimation(right_to_left);
            TranslateAnimation animation = new TranslateAnimation(0, 0, -100, 0);
            animation.setDuration(700); // duartion in ms
            animation.setFillAfter(true);
            fab.startAnimation(animation);
            fab.getLeft();
            fab.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{0}}, new int[]{Color.parseColor("#FFD03131")}));//fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#f39200")));

            isFabOpen = false;
            Log.d("Raj", "close");

        } else {

            //fab.startAnimation(left_to_right);
            TranslateAnimation animation = new TranslateAnimation(0, 0, 100, 0);
            animation.setDuration(700); // duartion in ms
            animation.setFillAfter(true);
            fab.startAnimation(animation);
            fab.getRight();
            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFD03131")));

            isFabOpen = true;
            Log.d("Raj","open");

        }
    }
/*
    protected void setMenuBackground(){
        // Log.d(TAG, "Enterting setMenuBackGround");
        getLayoutInflater().setFactory( new LayoutInflater.Factory() {
            public View onCreateView(String name, Context context, AttributeSet attrs) {
                if ( name.equalsIgnoreCase( "com.android.internal.view.menu.IconMenuItemView" ) ) {
                    try { // Ask our inflater to create the view
                        LayoutInflater f = getLayoutInflater();
                        final View view = f.createView( name, null, attrs );
                        *//* The background gets refreshed each time a new item is added the options menu.
                        * So each time Android applies the default background we need to set our own
                        * background. This is done using a thread giving the background change as runnable
                        * object *//*
                        new Handler().post(new Runnable() {
                            public void run () {
                                // sets the background color
                                view.setBackgroundResource( R.drawable.menu_bg);
                                // sets the text color
                                ((TextView) view).setTextColor(Color.parseColor("#FF5A5A5A"));
                                // sets the text size
                                ((TextView) view).setTextSize(15);
                            }
                        } );
                        return view;
                    }
                    catch ( InflateException e ) {}
                    catch ( ClassNotFoundException e ) {}
                }
                return null;
            }});
    }*/

    // where u want show on
    //view click event popupwindow.showAsDropDown(view, x, y);

   /* public PopupWindow popupDisplay()
    {

        final PopupWindow popupWindow = new PopupWindow(getContext());

        // inflate your layout or dynamically add view
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.popup_menu_layout, null);

        TextView item1 = view.findViewById(R.id.add_property);
        TextView item2 = view.findViewById(R.id.add_tenant);
        TextView item3 = view.findViewById(R.id.create_reminder);
        TextView item4 = view.findViewById(R.id.add_tradesman);

        *//*item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "add_property", Toast.LENGTH_SHORT).show();
            }
        });
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "add_tenant", Toast.LENGTH_SHORT).show();
            }
        });
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "create_reminder", Toast.LENGTH_SHORT).show();
            }
        });
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "add_tradesman", Toast.LENGTH_SHORT).show();
            }
        });*//*

        popupWindow.setFocusable(true);
        popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);

        return popupWindow;
    }*/
   /* private void showCustomPopupMenu()
    {
        WindowManager windowManager2 = (WindowManager)getActivity().getSystemService(WINDOW_SERVICE);
        LayoutInflater layoutInflater=(LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.popup_menu_layout, null);
        WindowManager.LayoutParams params=new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity=Gravity.CENTER|Gravity.CENTER;
        params.x=0;
        params.y=0;
        windowManager2.addView(view, params);
    }*/

}
