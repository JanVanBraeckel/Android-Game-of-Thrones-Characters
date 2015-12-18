package com.example.gebruiker.recyclerview.recyclerview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.gebruiker.recyclerview.R;

/**
 * Created by Jan on 18/12/2015.
 */
public class MainAdapterTouchHelper extends ItemTouchHelper.SimpleCallback {

    private MainAdapter mMainAdapter;

    public MainAdapterTouchHelper(MainAdapter mainAdapter) {
        super(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        mMainAdapter = mainAdapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction) {
        final int TIMEOUT = 2000;

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mMainAdapter.remove(viewHolder.getAdapterPosition());
            }
        };

        viewHolder.itemView.postDelayed(runnable, TIMEOUT);
        Snackbar snackbar = Snackbar.make(viewHolder.itemView, R.string.deleted, Snackbar.LENGTH_INDEFINITE);
        snackbar.setDuration(TIMEOUT);
        snackbar.setAction(R.string.undo, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.itemView.removeCallbacks(runnable);
                mMainAdapter.notifyItemChanged(viewHolder.getAdapterPosition());
            }
        });
        snackbar.show();
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View itemView = viewHolder.itemView;
        String text = "R.I.P.";

        Paint p = new Paint();
        Rect bounds = new Rect(itemView.getLeft(), itemView.getTop(), itemView.getRight(), itemView.getBottom());
        p.setTextSize(200);
        p.setTextAlign(Paint.Align.CENTER);

        Rect b = new Rect();
        p.getTextBounds(text, 0, text.length(), b);

        c.drawText(text, bounds.centerX(), bounds.exactCenterY()+b.height()/2, p);

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
