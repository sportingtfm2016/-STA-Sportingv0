package com.sporting.cristianpr.sportingv0;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int MODEMAP_OK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {ChronoPlay();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
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
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_activity) {
            // Handle the camera action
        } else if (id == R.id.nav_calendar) {

        } else if (id == R.id.nav_challenges) {

        } else if (id == R.id.nav_goals) {

        } else if (id == R.id.nav_stats) {

        } else if (id == R.id.nav_user) {

        } else if (id == R.id.nav_conexions) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Funcion que inicia Intent -> Nuevo mensaje, llama a la otra actividad (MAPSACTIVITY)
    public void MapMode(View v)
    {
        Intent i = new Intent(this, MapsActivity.class);
        startActivityForResult(i,MODEMAP_OK);
    }

    public void ChronoPlay ()
    {
        Chronometer CDur =  (Chronometer) findViewById(R.id.CDur);
        CDur.setBase(SystemClock.elapsedRealtime());
        CDur.start();

        /*
        You are gonna need a variable that keeps track on the time that has passed since the Chronometer was started:

long timeWhenStopped = 0;
Update the value of the variable when you stop the chronometer like this:

timeWhenStopped = mChronometer.getBase() - SystemClock.elapsedRealtime();
mChronometer.stop();
We will also use this variable to adjust the chronometer before starting it:

mChronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
mChronometer.start();
And finally if you have a way to reset your chronometer then you should remember to also reset the timeWhenStopped variable. Something like this:

mChronometer.setBase(SystemClock.elapsedRealtime());
timeWhenStopped = 0;

        */
    }
}
