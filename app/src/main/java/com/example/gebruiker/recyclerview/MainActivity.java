package com.example.gebruiker.recyclerview;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.gebruiker.recyclerview.models.GOTCharacter;
import com.example.gebruiker.recyclerview.recyclerview.MainAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainAdapter.CardClickedListener{

    @Bind(R.id.rootView)
    LinearLayout rootView;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if(fragmentManager == null){
            fragmentManager = getSupportFragmentManager();
        }
        if(savedInstanceState == null){
            fragmentManager.beginTransaction().add(R.id.rootView, new GOTListFragment(), "list").commit();
        }else{
            if(savedInstanceState.containsKey("title")){
                getSupportActionBar().setTitle(savedInstanceState.getString("title"));
            }
        }
        if(fragmentManager.findFragmentByTag("details") != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void cardClicked(GOTCharacter character) {
        if(fragmentManager == null){
            fragmentManager = getSupportFragmentManager();
        }

        Bundle args = new Bundle();
        args.putParcelable("character", character);

        GOTDetailFragment fragment = new GOTDetailFragment();
        fragment.setArguments(args);

        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
                .replace(R.id.rootView, fragment, "details")
                .addToBackStack(null)
                .commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(character.getName());
    }

    @Override
    public boolean onSupportNavigateUp() {
        if(fragmentManager == null)
            fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle(R.string.activity_main_activity);

        return true;
    }

    @Override
    public void onBackPressed() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle(R.string.activity_main_activity);

        super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("title", getSupportActionBar().getTitle().toString());
        super.onSaveInstanceState(outState);
    }
}
