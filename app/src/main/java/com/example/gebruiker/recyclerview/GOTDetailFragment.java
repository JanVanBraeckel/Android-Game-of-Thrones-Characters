package com.example.gebruiker.recyclerview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gebruiker.recyclerview.models.GOTCharacter;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class GOTDetailFragment extends Fragment {

    @Bind(R.id.detail_image)
    ImageView detail_image;
    @Bind(R.id.detail_description)
    TextView detail_description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_gotdetail, container, false);

        ButterKnife.bind(this, layout);

        Bundle args = getArguments();

        if(args != null){
            if(args.containsKey("character")){
                GOTCharacter character = args.getParcelable("character");
                Glide.with(getContext())
                        .load(character.getImage())
                        .centerCrop()
                        .into(detail_image);
                detail_description.setText(character.getDescription());
            }
        }

        return layout;
    }
}
