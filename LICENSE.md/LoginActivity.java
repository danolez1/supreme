
package com.example.daniel.career;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread introSlider = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                boolean firstUse = preferences.getBoolean("use",true);
                if(firstUse) startActivity(new Intent(getApplicationContext(),IntroSlider.class));
                SharedPreferences.Editor preferEdit = preferences.edit();
                preferEdit.putBoolean("use",false);
                preferEdit.apply();
            }
        });
        introSlider.start();
    }
}
