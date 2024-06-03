package com.example.sotaydientu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
   private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_DON = 1;
    private static final int FRAGMENT_CAUHOI = 2;
    private int curent = FRAGMENT_HOME;
    private DrawerLayout drawerLayout;

    Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_drawer_open,R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.naviga);
        navigationView.setNavigationItemSelectedListener(this);
        replaceFrament(new HomeFrament());
        navigationView.getMenu().findItem(R.id.naviga_home).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.naviga_home)
        {
            if(curent != FRAGMENT_HOME){
                replaceFrament(new HomeFrament());
                curent= FRAGMENT_HOME;
            }
        }
        else if(id == R.id.naviga_maudon)
        {
            if(curent != FRAGMENT_DON){
                replaceFrament(new MauDonFrament());
                curent= FRAGMENT_DON;
            }
        }else  if (id==R.id.naviga_cauhoi)
        {
            if(curent != FRAGMENT_CAUHOI){
                replaceFrament(new CauHoiFrament());
                curent= FRAGMENT_CAUHOI;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
    private void replaceFrament(Fragment fragment)
    {
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fame,fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_saerch,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.sear){
            Intent intent = new Intent(MainActivity.this,MainActivity4.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}