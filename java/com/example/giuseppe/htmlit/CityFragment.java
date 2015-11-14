package com.example.giuseppe.htmlit;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.widget.ArrayAdapter;



public class CityFragment extends ListFragment
{
    private ArrayAdapter<String> adapter=null;
//    private CountryList l=new CountryList();

    public CityFragment() {
    }

    @Override
    public void onResume() {
        Log.d("xxx", "** CityFrag: 4.onResume /" + isInLayout());
        super.onResume();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        Bundle b=getArguments();
        if (b!=null)
        {
            String c=b.getString("country");
            onSelectedCountry(c);
        }
//        onSelectedCountry("c");
    }

    public void onSelectedCountry(String country)
    {
        String[] x = {country, "city0", "city1", "city2", "city3", "city4", "city5"};

        adapter.clear();
        adapter.addAll(x);
    }
}