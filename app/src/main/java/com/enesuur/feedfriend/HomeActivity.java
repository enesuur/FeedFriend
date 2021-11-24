package com.enesuur.feedfriend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    ActionBarDrawerToggle drawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    PartnershipFragment partnershipFragment = new PartnershipFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    TicketFragment ticketFragment = new TicketFragment();
    FaqFragment faqFragment = new FaqFragment();
    SocialMFragment socialMFragment = new SocialMFragment();
    ContactFragment contactFragment = new ContactFragment();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        super.onCreate(savedInstanceState);

        // Connection part
        toolbar = findViewById(R.id.home_activity_toolbar);
        navigationView = findViewById(R.id.home_activity_navigationView);
        drawerLayout = findViewById(R.id.homeactivity_drawerlayout);


        // DrawerToggle ...
        setSupportActionBar(toolbar);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        // Navigation

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_faq:
                        setFragment(faqFragment);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.nav_partnership:
                        setFragment(partnershipFragment);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.nav_social:
                        setFragment(socialMFragment);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.nav_contact:
                        setFragment(contactFragment);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                        return true;
                    case R.id.nav_exit:

                        return true;
                }
                return false;
            }
        });
    }
    void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_activity_frame,fragment);
        transaction.commit();

    }
}