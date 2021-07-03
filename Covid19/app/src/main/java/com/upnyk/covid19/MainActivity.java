package com.upnyk.covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.upnyk.covid19.kasuscovid.KasusCovidFragment;
import com.upnyk.covid19.rumahsakit.RumahSakitFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView botNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botNav = findViewById(R.id.bot_nav);
        botNav.setOnNavigationItemSelectedListener(this);
        createFragment(new KasusCovidFragment());
    }

    private boolean createFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_covid_list:
                return createFragment(new KasusCovidFragment());
            case R.id.nav_rumah_sakit:
                return createFragment(new RumahSakitFragment());
            default:
                return createFragment(new Fragment());
        }
    }


}