package com.example.giuseppe.htmlit;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class CountryFragment extends ListFragment
{
    interface OnFragmentEventListener
    {
        void selectCountry(String c);
    }
    private OnFragmentEventListener listener=null;
//    private CountryList l=new CountryList();
    private String[] countries = new String[4];

    public CountryFragment()
    {
//        Log.d("xxx", "## ContryFrag: 0.constructor /" + isInLayout() );
//        countries=new String[l.getCountries().size()];
//        l.getCountries().toArray(countries);
        countries[0] = "italia";
        countries[1] = "francia";
        countries[2] = "spagna";
        countries[3] = "germania";
    }
    @Override
    public void onAttach(Activity activity)
    {
        Log.d("xxx", "## ContryFrag: 1.onAttach /" + isInLayout() );
        super.onAttach(activity);
        listener=(OnFragmentEventListener) activity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        Log.d("xxx", "## ContryFrag: 2.onCreateView /" + isInLayout() );
        ArrayAdapter<String> adapter=new ArrayAdapter<String>((Context) listener,android.R.layout.simple_list_item_1,countries);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("xxx", "## ContryFrag: 3.onStart /" + isInLayout() );
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("xxx", "## ContryFrag: 4.onResume /" + isInLayout() );
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("xxx", "## ContryFrag: -4.onPause /" + isInLayout() );
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("xxx", "## ContryFrag: -3.onStop /" + isInLayout() );
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("xxx", "## ContryFrag: -2.onDestroyView /" + isInLayout() );
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.d("xxx", "## ContryFrag: -1.onDetach /" + isInLayout() );
        super.onDetach();
    }


    @Override
    public void onListItemClick(ListView lv, View v, int position, long id)
    {
        listener.selectCountry(countries[position]);
    }
}