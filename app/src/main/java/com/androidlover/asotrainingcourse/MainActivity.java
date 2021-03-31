package com.androidlover.asotrainingcourse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView level0,level1,level2,level3,level4,level5,level6,level7,level8,help;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-5348647911544430~1297940157" );
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        level0 = (CardView) findViewById(R.id.level0);
        level1 = (CardView) findViewById(R.id.level1);
        level2 = (CardView) findViewById(R.id.level2);
        level3 = (CardView) findViewById(R.id.level3);
        level4 = (CardView) findViewById(R.id.level4);
        level5 = (CardView) findViewById(R.id.level5);
        level6 = (CardView) findViewById(R.id.level6);
        level7 = (CardView) findViewById(R.id.level7);
        level8 = (CardView) findViewById(R.id.level8);
        help=(CardView)findViewById(R.id.help);

        level0.setOnClickListener(this);
        level1.setOnClickListener(this);
        level2.setOnClickListener(this);
        level3.setOnClickListener(this);
        level4.setOnClickListener(this);
        level5.setOnClickListener(this);
        level6.setOnClickListener(this);
        level7.setOnClickListener(this);
        level8.setOnClickListener(this);
        help.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.level0:
                i = new Intent(this, level0.class);
                startActivity(i);
                break;
            case R.id.level1:
                i = new Intent(this, level1.class);
                startActivity(i);
                break;
            case R.id.level2:
                i = new Intent(this, level2.class);
                startActivity(i);
                break;
            case R.id.level3:
                i = new Intent(this, level3.class);
                startActivity(i);
                break;
            case R.id.level4:
                i = new Intent(this, level4.class);
                startActivity(i);
                break;
            case R.id.level5:
                i = new Intent(this, level5.class);
                startActivity(i);
                break;
            case R.id.level6:
                i = new Intent(this, level6.class);
                startActivity(i);
                break;
            case R.id.level7:
                i = new Intent(this, level7.class);
                startActivity(i);
                break;
            case R.id.level8:
                i = new Intent(this, level8.class);
                startActivity(i);
                break;
            case R.id.help:
                i = new Intent(this, help.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if (id==R.id.about_us){
            Intent i=new Intent(MainActivity.this,About_Us.class);
            startActivity(i);
            return true;
        }
        if (id==R.id.rate_us){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            try {
                startActivity(i);
            } catch (Exception e) {
                Toast.makeText(this, "Unable to open", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        if(id==R.id.share)
        {
            Intent shareintent=new Intent();
            shareintent.setAction(Intent.ACTION_SEND);
            shareintent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
            shareintent.setType("text/plain");
            startActivity(Intent.createChooser(shareintent,"Share Via"));
            return true;
        }
        return true;

    }
}