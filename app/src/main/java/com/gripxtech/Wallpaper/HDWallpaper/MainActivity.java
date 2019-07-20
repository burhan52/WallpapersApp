package com.gripxtech.Wallpaper.HDWallpaper;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;



import com.gripxtech.Wallpaper.HDWallpaper.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private List<Custom_Items> list;
    public CustomAdapter adapter;
    private Toolbar toolbar;
    private TextView textView;
    NetworkInfo info;
    ProgressDialog dialog;
    private AdView mAdView;
    AdView adView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this,"ca-app-pub-5381909867950154~5324435299");
        AdView adView = new AdView(this);

        adView.setAdUnitId("ca-app-pub-5381909867950154/7069170922");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);






        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);



        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        dialog = new ProgressDialog(this);


        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        info = cm.getActiveNetworkInfo();
        if (info != null) {


            Toast.makeText(MainActivity.this, "Loading..", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "No Internet Connection!", Toast.LENGTH_LONG).show();

        }

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        list = new ArrayList<>();


        list.add(new Custom_Items("https://i.pinimg.com/564x/ed/86/c2/ed86c25cc7a80e26ac998dff198fb5a3.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/92/a2/d4/92a2d4a6e6e139f793b7e90707610f54.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/da/19/d2/da19d2c0cce9af758c15c8890c309357.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/17/6b/71/176b7117c8bee224911b8362407b9891.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/1b/a0/6c/1ba06c9a1da2031dee1529052e2e44d0.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/a3/80/90/a3809091fa490ce5299ce4977023bd15.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/39/79/02/3979021279a5717d9833f4e8a766eb95.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/3e/b1/6c/3eb16c07ff522972843e954a019ad09e.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/b6/46/78/b64678b848b660dbc86a75a8fad6aa22.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/6c/82/5e/6c825e944dfccf395c5b2f9d6ccf1adf.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://www.vactualpapers.com/web/images/Abstract/Abstract%20HD%20Wallpaper%20for%20Mobile%20Devices%2014.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/4c/e6/64/4ce664ad5e5104f61cf997bb8d9ae95f.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/66/9e/49/669e491d4b7b4d7c3081cd17d7440a5a.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/48/20/b1/4820b1b0cb074261f04538be6eafd0de.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/43/d3/f4/43d3f4008287a34cd59f7cdbcc92a7b9.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/2c/1f/eb/2c1feb66a7d3be7b6762f888a73baf15.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/a4/0e/3e/a40e3eb7c3e880573b178bad6d9d3b69.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/8e/f6/09/8ef6098015693c51449a32b3f5b309fa.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/07/39/7a/07397acbf39b189d764ca5163e836e57.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/f8/19/a6/f819a6216a9b3c10ccf128cd6af9e905.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/23/64/d8/2364d88af283950e2715d9db51ac5169.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/87/ab/ce/87abce2317c1f17ce00a611206b934d8.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/2f/30/ad/2f30ad0a939f131af722194ebd3e89b6.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/e8/cb/6e/e8cb6e6c32b8a0e2376bae1639b167e9.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/15/f1/91/15f1916fa60de4e4b7de182798357351.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/9f/55/43/9f55431ef216866e16ae25d537af5573.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/82/c7/d1/82c7d1255d96ace466d00a493ab3d5b8.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/a5/c3/52/a5c3529ea24f4e3df45b40b7b6ebfbc5.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/0f/55/5d/0f555dddacebb8d018c8a6b390cf9b15.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/8d/f2/b9/8df2b9ee3edf89ae1928c4e8e98eb5fd.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/ae/97/ac/ae97ac017da133c88ac17d735098afab.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/5b/ca/2c/5bca2cfa508808bcfe4db599df5844b4.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/1b/85/a7/1b85a779fa36a5a13d1ab3b73ca79e8d.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/dd/c5/13/ddc5138c1cb701dd4bb1a356a8b39c12.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/97/04/64/970464144c30b9caf8d7892a3718106e.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/a2/5d/a4/a25da4b88f26fb96b358c297933b2123.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/32/01/ab/3201ab072f3066a1ea0aa688fe58ef55.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/27/9d/bb/279dbb7ecf53add4d8d7e9bf16ec0056.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/49/15/5d/49155d4b9f88e2e3a098e3bf7db37444.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/39/86/44/39864444c3414af9229a0b3c67d9089f.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/91/53/30/9153308bd8364e63332e14d9de47fa67.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/c7/e0/6d/c7e06d39938247e46fde93fb54720228.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/7d/97/61/7d9761db35681412d1b4239fa972836f.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/46/b8/2a/46b82a6a78ad7ee879271bf86c0b0f41.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/7c/ba/16/7cba16e46c4090c9b5b76a024b4d0fb6.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/75/f4/9c/75f49c37a25104266952ebd696d713b0.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/7f/45/f8/7f45f8d28ef5ec685cac8e5c3c4ea948.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/f0/60/d4/f060d45d3047e8e307fcf41d97186fdf.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/4f/17/31/4f1731e34d4a968a7cd9a567bf691d34.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/ba/7a/09/ba7a099b5407c1cf41cdbfe277d63f7b.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/f3/20/30/f32030e4b988aa9403576973671de1ad.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/c4/64/80/c46480e66d8407d897215a27653877d4.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/61/04/3b/61043b4f9655a81b6e61fe2b0f333c69.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/39/52/0a/39520a1eb15c45d5d4e258b52953d138.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/46/d9/15/46d915f51e10fccfbce9d6cb5df326b1.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/22/47/52/2247528581990e6e00954a3916042272.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/d3/c2/a9/d3c2a95294425b98752037f27830d2a0.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/d3/a9/18/d3a918b108c35b119ee8edd88242daab.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/53/5e/b5/535eb58844e053f08e771e9f54b967f8.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/13/0e/db/130edbface9c511032e41d070563710a.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/c1/58/2d/c1582de46e403810acaf24fe06c85f40.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/0f/cc/1c/0fcc1cc1de6bd3e97c9ac551368441c0.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/d7/bd/36/d7bd36912b4a30cc40ac97a5ca20d5b6.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/03/11/26/03112633794c2b258420b2bf7e5856e6.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/4a/22/8d/4a228d4bd88ce996339743e0f6a48348.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/54/f6/2f/54f62f5f02123d8d8adbaeecab680e2d.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/b1/78/68/b17868028a6cb85e30a0e5e79915ab44.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/8a/82/78/8a82787f42c3e96a527f3a18b99307b6.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/52/d4/8a/52d48a2e1cb69da394a68072ce096169.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/96/01/70/9601707d2d61438100d6a352b4131a42.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/e6/75/c0/e675c04dec65f619c969a69839a751ef.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/ac/d7/52/acd7527a939bde3e72dee153e81ee049.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/2d/8e/00/2d8e00a600f5d0f9695b6d49cabdf162.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/4e/8e/0e/4e8e0e63331e70b3ddb19886874e7bf0.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/25/b6/ed/25b6ed9612fc6bb49b59f02dc5bdee62.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/e1/28/ce/e128ce1ee0ba1d67223b1366ba0c23d7.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/40/89/6c/40896cd8035b352ceefb5d5d80382f32.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/3d/0c/c6/3d0cc699c5bbe7fdb1369e702a3987d3.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/32/63/91/3263912e7e3f2c9516fee7dcd6552e4b.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/d7/5f/74/d75f740087de01f3130b39c9ba77a7d1.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/f3/6f/4e/f36f4ea57dd19d60b3e3adffed5279f3.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/88/81/43/8881433eb14ae637de0677a8ada4fc72.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/88/81/43/8881433eb14ae637de0677a8ada4fc72.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/ad/e2/4f/ade24f0edaafbe4d6c787144a4442fdd.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/df/2a/52/df2a523a2aa0330c08eee33665e6b9b6.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/8f/ee/31/8fee31c5a9b9695002bbf0c52599267d.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/b8/0b/4e/b80b4e551c40ee5a421ec5d46ecf7cce.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/16/f9/8a/16f98a301ccc16639241656869e60d7c.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/b4/c8/c4/b4c8c407ebe018c96f7df529aff813bd.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/78/1e/07/781e07bfa3a9004fef700df675864b96.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/1e/52/a5/1e52a5e903af3b733941bf5eee23257c.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/8e/35/d4/8e35d4f34515e983db686a9af34516c5.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/51/a4/b5/51a4b598707cd63190e2cd13e2ca3514.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/38/a5/db/38a5db09261ee648d2dae7c430192c89.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/f4/31/91/f43191b2036194213fa5777dbea47b06.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/8a/fb/ab/8afbabf4a7f366082ab1eb62a3a50203.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/af/8d/63/af8d63a477078732b79ff9d9fc60873f.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/25/67/f8/2567f84f01f884ce19bbeaaa08f1b261.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/a5/34/e8/a534e8d8c121645489db6bc05561a1bf.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/f3/24/79/f32479d82f72fc127f94a2ebe08c008d.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
        list.add(new Custom_Items("https://i.pinimg.com/564x/1f/82/7d/1f827d6c388950332dd5c114d486dced.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));









        getdata();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    private void getdata() {


        adapter = new CustomAdapter(list, this);
        recyclerView.setAdapter(adapter);

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
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));

        }
        if (id == R.id.action_exit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });
            AlertDialog d = builder.create();
            d.show();

        }

        if (id == R.id.action_search) {

            finish();
            startActivity(getIntent());
            if (info != null) {
                getdata();

            } else {


                Toast.makeText(this, "Internet Not Connected!", Toast.LENGTH_SHORT).show();
            }


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.wallpaper) {

            getdata();


        } else if (id == R.id.favorites) {

            getdata();

        } else if (id == R.id.Settings) {

            startActivity(new Intent(MainActivity.this, SettingsActivity.class));


        } else if (id == R.id.rate_us) {
            //rateme();
        } else if (id == R.id.more_app) {

            //MoreApp();


        }


        //Shere


        else if (id == R.id.shere) {


            Intent myintent = new Intent(Intent.ACTION_SEND);
            myintent.setType("text/plan");

            String shereBoday = "Your Boday Here";

            String shereSub = "\"http://play.google.com/store/apps/details?id=" + getPackageName();
            myintent.putExtra(Intent.EXTRA_SUBJECT, shereBoday);
            myintent.putExtra(Intent.EXTRA_TEXT, shereSub);
            startActivity(Intent.createChooser(myintent, "shere Using"));

        }


        //Exit


        else if (id == R.id.exit) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Exit?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });
            AlertDialog d = builder.create();
            d.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void MoreApp() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://developer?id=" + "Account Name!")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/developer?id=" + "Account Name!")));


        }
    }


    public void rateme() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + "Your Package name!")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }

    }




}