package com.example.gebruiker.recyclerview.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gebruiker.recyclerview.R;
import com.example.gebruiker.recyclerview.models.GOTCharacter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Jan on 18/12/2015.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<GOTCharacter> mCharacters = new ArrayList<>();
    private Context mContext;
    private CardClickedListener mListener;

    public MainAdapter(List<GOTCharacter> characters, Context context) {
        mContext = context;
        mCharacters = characters;
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        private final TextView mCardName;
        private final ImageView mCardImage;

        public MainViewHolder(View v) {
            super(v);
            mCardImage = ButterKnife.findById(v, R.id.card_image);
            mCardName = ButterKnife.findById(v, R.id.card_name);
        }
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_character, parent, false));
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        final GOTCharacter character = mCharacters.get(position);
        holder.mCardName.setText(character.getName());
        Glide.with(mContext)
                .load(character.getImage())
                .centerCrop()
                .into(holder.mCardImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cardClicked(character);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCharacters.size();
    }

    public void remove(int position){
        if(position > 0 && position < mCharacters.size()){
            mCharacters.remove(position);
            notifyItemRemoved(position);
        }
    }

    public interface CardClickedListener{
        void cardClicked(GOTCharacter character);
    }

    public void setCardClickedListener(CardClickedListener listener){
        mListener = listener;
    }
}
