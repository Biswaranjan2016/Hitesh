package com.learncodeonline.courses.interviewpreparation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.learncodeonline.courses.interviewpreparation.jsonProcessing.PrepareJson;
import com.learncodeonline.courses.interviewpreparation.jsonProcessing.TemporaryData;
import com.learncodeonline.courses.interviewpreparation.recyclerCardlayout.Others;
import com.learncodeonline.courses.interviewpreparation.recyclerCardlayout.SubjectiveLearning;
import com.learncodeonline.courses.interviewpreparation.recyclerCardlayout.SubjectiveLearningFarg;
import com.learncodeonline.courses.interviewpreparation.recyclerCardlayout.WelcomeFrag;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Setting the drawer layout
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        //Adding listener to drawer
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Initiate the fragment transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction myFragmentTransaction = fragmentManager.beginTransaction();
        myFragmentTransaction.replace(R.id.ll_frags,new WelcomeFrag());
        myFragmentTransaction.commit();

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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = new Intent(this,SubjectiveLearning.class);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction myFragmentTransaction = fragmentManager.beginTransaction();

        if (id == R.id.nav_ds) {
            myFragmentTransaction.replace(R.id.ll_frags,new SubjectiveLearningFarg());
            myFragmentTransaction.commit();
            setTitle("Data Structure");
        } else {
            myFragmentTransaction.replace(R.id.ll_frags,new Others());
            myFragmentTransaction.commit();

            if (id == R.id.nav_db)
                setTitle("Data Base");
            else if (id == R.id.nav_os)
                setTitle("Operating System");
            else if (id == R.id.nav_se)
                setTitle("Software Engineering");
            else if (id == R.id.nav_java)
                setTitle("Java");
            else if (id == R.id.nav_c)
                setTitle("C");

//            Intent intent1 = new Intent(this,PrepareJson.class);
//            startActivity(intent1);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
