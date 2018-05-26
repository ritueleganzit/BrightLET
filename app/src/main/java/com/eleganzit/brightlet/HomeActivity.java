package com.eleganzit.brightlet;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.eleganzit.brightlet.fragments.AllPropertyFragment;
import com.eleganzit.brightlet.fragments.Fragment_FinancialStatement;
import com.eleganzit.brightlet.fragments.Fragment_dashboard;
import com.eleganzit.brightlet.fragments.Fragment_messages;
import com.eleganzit.brightlet.fragments.Fragment_profile;
import com.eleganzit.brightlet.fragments.Fragment_tenants;
import com.eleganzit.brightlet.utils.BottomNavigationViewHelper;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static ActionBar.Tab name;
    public static FrameLayout layout_MainMenu;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#5a2e87"));
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        layout_MainMenu = findViewById( R.id.mainmenu);

        Fragment_dashboard fragment_dashboard=new Fragment_dashboard();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container,fragment_dashboard);
        fragmentTransaction.commit();

        final BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottomsheet);

        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();

                        if (id == R.id.dashboard_b) {
                            Fragment_dashboard fragment_dashboard=new Fragment_dashboard();
                            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.main_container,fragment_dashboard);
                            fragmentTransaction.commit();
                        } else if (id == R.id.properties_b) {
                            AllPropertyFragment allPropertyFragment=new AllPropertyFragment();
                            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.main_container,allPropertyFragment);
                            fragmentTransaction.commit();
                        } else if (id == R.id.manage_tenants_b) {

                            Fragment_tenants fragment_tenants=new Fragment_tenants();
                            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.main_container,fragment_tenants);
                            fragmentTransaction.commit();
                        }
                        else if (id == R.id.messages_b) {

                            Fragment_messages fragment_messages=new Fragment_messages();
                            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.main_container,fragment_messages);
                            fragmentTransaction.commit();
                        }
                        else if (id == R.id.profile_b) {

                            Fragment_profile fragment_profile=new Fragment_profile();
                            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.main_container,fragment_profile);
                            fragmentTransaction.commit();

                        }

                        return false;
                    }
                });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                try {
                    //int currentapiVersion = android.os.Build.VERSION.SDK_INT;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                        // Do something for lollipop and above versions

                        Window window = getWindow();

                        // clear FLAG_TRANSLUCENT_STATUS flag:
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

                        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

                        // finally change the color to any color with transparency

                        window.setStatusBarColor(Color.parseColor("#9EFFFFFF"));}

                } catch (Exception e) {


                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {


                           }

            @Override
            public void onDrawerClosed(View drawerView) {
                try {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        // Do something for lollipop and above versions

                        Window window = getWindow();

                        // clear FLAG_TRANSLUCENT_STATUS flag:
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

                        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

                        // finally change the color again to dark
                        window.setStatusBarColor((Color.parseColor("#5a2e87")));
                    }
                } catch (Exception e) {
                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {



            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.inflateHeaderView(R.layout.nav_header_home);
        LinearLayout navbarheader=headerView.findViewById(R.id.navbar_header);
        ImageView close = headerView.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        navbarheader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_profile fragment_profile=new Fragment_profile();
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,fragment_profile);
                fragmentTransaction.commit();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.dashboard) {
            Fragment_dashboard fragment_dashboard=new Fragment_dashboard();
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container,fragment_dashboard);
            fragmentTransaction.commit();

        } else if (id == R.id.properties) {
            AllPropertyFragment allPropertyFragment=new AllPropertyFragment();
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container,allPropertyFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.manage_tenants) {
            Fragment_tenants fragment_tenants=new Fragment_tenants();
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container,fragment_tenants);
            fragmentTransaction.commit();

        } else if (id == R.id.messages) {
            Fragment_messages fragment_messages=new Fragment_messages();
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container,fragment_messages);
            fragmentTransaction.commit();

        } else if (id == R.id.reminders) {

        } else if (id == R.id.my_tradesmen) {

        } else if (id == R.id.financial_statement) {
            Fragment_FinancialStatement fragment_financialStatement=new Fragment_FinancialStatement();
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container,fragment_financialStatement);
            fragmentTransaction.commit();

        } else if (id == R.id.user_management) {

        } else if (id == R.id.my_orders) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
