package com.example.giuseppe.htmlit;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements CountryFragment.OnFragmentEventListener{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d("xxx", "Activity: 1.onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d("xxx", " ---- ");

        if (findViewById(R.id.container) != null)
        {
            if (savedInstanceState != null)
                return;
            Log.d("xxx", " +++ " );
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new CountryFragment()).commit();

//            android.support.v4.app.FragmentManager mFragmentManager = getSupportFragmentManager();
//            CountryFragment fragment = (CountryFragment) mFragmentManager.findFragmentById(R.id.container);
//
//            if (fragment == null) {
//                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
//                fragmentTransaction.add(R.id.container, new CountryFragment());
//                fragmentTransaction.commit();
//            }




        }
    }

    @Override
    public void selectCountry(String c)
    {
        CityFragment cityFrag = (CityFragment)
                getSupportFragmentManager().findFragmentById(R.id.cityfrag);

        if (cityFrag != null && cityFrag.isInLayout())
        {
            cityFrag.onSelectedCountry(c);
        }
        else
        {
            // Siamo in SINGLE-PANE, quindi le FragmentTransaction
            // operano lo switch tra Fragment.

            CityFragment frag= new CityFragment();
            Bundle b=new Bundle();
            b.putString("country", c);
            frag.setArguments(b);
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, frag);
            ft.addToBackStack(null);
            ft.commit();
        }
    }


    @Override
    protected void onStart() {
        Log.d("xxx", "Activity: 2.onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        int count = getSupportFragmentManager().getFragments().size();


        Log.d("xxx", "Activity: 3.onResume " + count);
        super.onResume();
    }


    @Override
    protected void onPause() {
        Log.d("xxx", "Activity: -3.onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("xxx", "Activity: -2.onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("xxx", "Activity: -1.onDestroy");
        super.onDestroy();
    }



}