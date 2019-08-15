package com.dotplays.moneylover;

import android.os.Bundle;

import com.dotplays.moneylover.fragment.ThuFragment;
import com.dotplays.moneylover.model.ThuChi;
import com.dotplays.moneylover.sqlite.ThuChiSqlite;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        ThuChiSqlite thuChiSqlite = new ThuChiSqlite(this);

        ThuChi thuChi = new ThuChi();

        thuChi.tc_ten = "Di Bar";
        thuChi.tc_tien = 1000000;
        thuChi.tc_thoiGian = "2019-08-15 08:20:00";
        thuChi.tc_khoanThuChi = thuChi.CHI;
        thuChi.tc_loaiThuChi = "8800";

        long kq = thuChiSqlite.insertThuChi(thuChi);

        if (kq > 0){
            Toast.makeText(this,"THANH CONG!!!",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"KHONG THANH CONG!!!",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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

        if (id == R.id.nav_thu) {
            // Handle the camera action
            ThuFragment thuFragment = new ThuFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.myContainer, thuFragment).commit();


        } else if (id == R.id.nav_chi) {

        } else if (id == R.id.nav_thong_ke) {

        } else if (id == R.id.nav_gioi_thieu) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_exit) {
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
