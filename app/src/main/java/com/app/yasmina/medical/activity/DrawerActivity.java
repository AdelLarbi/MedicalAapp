package com.app.yasmina.medical.activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.app.yasmina.medical.R;
import com.app.yasmina.medical.fragment.AboutFragment;
import com.app.yasmina.medical.fragment.KysteFragment;
import com.app.yasmina.medical.fragment.MacrocalcificationFragment;
import com.app.yasmina.medical.fragment.NoduleHyperFragment;
import com.app.yasmina.medical.fragment.NoduleHypoFragment;
import com.app.yasmina.medical.fragment.NoduleIsoFragment;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static public AssetManager assetManager;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        drawer.openDrawer(GravityCompat.START);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // The application's asset manager. Helper for font customisation
        assetManager = getApplicationContext().getAssets();
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_about) {
            setTitle(getResources().getText(R.string.about));
            AboutFragment fragment = new AboutFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.content_drawer, fragment).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_kyste) {

            setTitle(getResources().getText(R.string.kyste));
            KysteFragment fragment = new KysteFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.content_drawer, fragment).commit();

        } else if (id == R.id.nav_macrocalcification) {

            setTitle(getResources().getText(R.string.macro));
            MacrocalcificationFragment fragment = new MacrocalcificationFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.content_drawer, fragment).commit();

        } else if (id == R.id.nav_nodule_hyper) {

            setTitle(getResources().getText(R.string.nodule_hyper));
            NoduleHyperFragment fragment = new NoduleHyperFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.content_drawer, fragment).commit();

        } else if (id == R.id.nav_nodule_iso) {

            setTitle(getResources().getText(R.string.nodule_iso));
            NoduleIsoFragment fragment = new NoduleIsoFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.content_drawer, fragment).commit();

        } else if (id == R.id.nav_nodule_hypo) {

            setTitle(getResources().getText(R.string.nodule_hypo));
            NoduleHypoFragment fragment = new NoduleHypoFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.content_drawer, fragment).commit();

        } else if (id == R.id.nav_about) {

            setTitle(getResources().getText(R.string.about));
            AboutFragment fragment = new AboutFragment();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.content_drawer, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
