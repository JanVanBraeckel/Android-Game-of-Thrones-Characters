package com.example.gebruiker.recyclerview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.gebruiker.recyclerview.models.GOTCharacter;
import com.example.gebruiker.recyclerview.recyclerview.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class GOTListFragment extends Fragment {

    @Bind(R.id.gotList)
    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout layout = (FrameLayout) inflater.inflate(R.layout.fragment_got_list, container, false);

        ButterKnife.bind(this, layout);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        MainAdapter mAdapter = new MainAdapter(getCharacters(), getContext());
        mAdapter.setCardClickedListener((MainAdapter.CardClickedListener) getActivity());
        mRecyclerView.setAdapter(mAdapter);

        return layout;
    }

    private List<GOTCharacter> getCharacters(){
        GOTData data = new GOTData();
        int[] ids = data.getCharacterPictures();
        String[] names = data.getCharacterNames();
        String[] details = data.getCharacterDetails();
        List<GOTCharacter> characters = new ArrayList<>();

        for(int i = 0; i < ids.length; i++){
            characters.add(new GOTCharacter(names[i], details[i],getResources().getIdentifier("character"+i, "drawable", getActivity().getPackageName())));
        }

        return characters;
    }
}
