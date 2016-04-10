package com.tom.fragmentlifecycle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SwapActivity extends AppCompatActivity {
    private FragmentManager fragManager;
    private ContactFragment contact;
    private DetailFragment detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);
        contact = ContactFragment.newInstance("a","b");
        detail = DetailFragment.newInstance("a","b");
        fragManager = getSupportFragmentManager();
        FragmentTransaction trans = fragManager.beginTransaction();
        trans.add(R.id.fragment_container, contact);
        trans.commit();
    }

    public void swap(View v){
        FragmentTransaction trans = fragManager.beginTransaction();
        trans.replace(R.id.fragment_container, detail);
        trans.addToBackStack(null);
        trans.commit();
    }
}
