package com.example.activityone;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activityone.ui.gallery.GalleryFragment;
import com.example.activityone.ui.home.HomeFragment;
import com.example.activityone.ui.slideshow.SlideshowFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.activityone.databinding.ActivityNavigationBinding;

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener{

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    TextView home, feed, people, upload, recent, downloads, files, starred, backup;
    FrameLayout fl;

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        fl = findViewById(R.id.nav_host_fragment_content_navigation);

        NavigationView navigationView = findViewById(R.id.nav_view);
//        View hView = navigationView.getHeaderView(0);

        home = findViewById(R.id.element1);
        feed = findViewById(R.id.element2);
        people = findViewById(R.id.element3);
        upload = findViewById(R.id.element4);
        recent = findViewById(R.id.element5);
        downloads = findViewById(R.id.element6);
        files = findViewById(R.id.element7);
        starred = findViewById(R.id.element8);
        backup = findViewById(R.id.element9);

        ImageView menu = (ImageView) findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        
        

        setDrawer();

        home.setOnClickListener(this);
        feed.setOnClickListener(this);
        people.setOnClickListener(this);
        upload.setOnClickListener(this);
        recent.setOnClickListener(this);
        downloads.setOnClickListener(this);
        files.setOnClickListener(this);
        starred.setOnClickListener(this);
        backup.setOnClickListener(this);

//        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

//        setSupportActionBar(binding.appBarNavigation.toolbar);
//        binding.appBarNavigation.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        DrawerLayout drawer = binding.drawerLayout;
//        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
//                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void setDrawer() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Fragment fragment = new HomeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_navigation, fragment).addToBackStack("HomePage").commit();
//        pagetitle.setText("Home");
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
//        Bundle args;
        switch (v.getId()) {
            case R.id.element1:
//                pagetitle.setText("Home");
//                fragment = new HomeFragment();
//                callFragment(fragment);
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.element2:
//                pagetitle.setText("NPCI Tags");
                fragment = new GalleryFragment();
                callFragment(fragment);
                Toast.makeText(this, "Feed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.element3:
//                pagetitle.setText("Tag Activation");
//                fragment = new SlideshowFragment();
//                callFragment(fragment);
                Toast.makeText(this, "People", Toast.LENGTH_SHORT).show();

                break;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    public void callFragment(Fragment fragmentClass) {
        fl.removeAllViews();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_navigation, fragmentClass).addToBackStack("adds").commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}