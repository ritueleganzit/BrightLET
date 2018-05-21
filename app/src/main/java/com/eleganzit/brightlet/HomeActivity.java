package com.eleganzit.brightlet;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
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
import android.widget.ImageView;
import android.widget.Toast;

import com.eleganzit.brightlet.fragments.Fragment_dashboard;
import com.eleganzit.brightlet.utils.BottomNavigationViewHelper;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
                        } else if (id == R.id.home_b) {
                            Toast.makeText(HomeActivity.this, "home", Toast.LENGTH_SHORT).show();

                        } else if (id == R.id.manage_tenants_b) {

                            Toast.makeText(HomeActivity.this, "tenants", Toast.LENGTH_SHORT).show();
                        }
                        else if (id == R.id.messages_b) {

                            Toast.makeText(HomeActivity.this, "message", Toast.LENGTH_SHORT).show();
                        }
                        else if (id == R.id.profile_b) {

                            Toast.makeText(HomeActivity.this, "profile", Toast.LENGTH_SHORT).show();
                        }

                        return false;
                    }
                });

        ImageView fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        ImageView close = headerView.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        } else if (id == R.id.home) {

        } else if (id == R.id.manage_tenants) {

        } else if (id == R.id.messages) {

        } else if (id == R.id.reminders) {

        } else if (id == R.id.my_tradesmen) {

        } else if (id == R.id.financial_statement) {

        } else if (id == R.id.user_management) {

        } else if (id == R.id.my_orders) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
