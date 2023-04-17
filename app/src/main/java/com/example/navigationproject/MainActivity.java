package com.example.navigationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
//import android.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;



import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigation_view);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.ClDrawer);


        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        loadFragment(new AFragment());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();
                if(id==R.id.optsports){

                    Toast.makeText(MainActivity.this, "sports", Toast.LENGTH_SHORT).show();
                }else if (id==R.id.optmovies){
//                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    loadFragment(new AFragment());
                } else if (id==R.id.optshows) {
                    Toast.makeText(MainActivity.this, "shows", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "settings", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });



    }

    @Override
    public void onBackPressed(){
       if(drawerLayout.isDrawerOpen(GravityCompat.START)){
           drawerLayout.closeDrawer(GravityCompat.START);
       } else{
           super.onBackPressed();
       }
    }


//    private void setSupportActionBar(Toolbar toolbar) {
//    }

    private void loadFragment(AFragment aFragment) {
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();


        ft.add(R.id.container, aFragment);
        ft.commit();

    }
}