package com.example.fioalpha.testerecyclerviewanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.ClipData;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fioalpha on 28/12/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    List<MainActivity.Pessoas> array;
    int last = -1;
    boolean animationsLocked;

    public MyAdapter(List<MainActivity.Pessoas> items){
        this.array = items;
        //last = this.getItemCount();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.my_adapter, parent, false);

        Holder holder = new Holder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(final Holder holder, int position) {


        runAnimation(holder.itemView, position);

        holder.mText1.setText(this.array.get(position).nome);

        /*if(last < this.getItemCount()) {
            holder.container.animate().translationX(100).withStartAction(new Runnable() {
                @Override
                public void run() {
                    ViewCompat.animate(holder.container).rotation(360).start();
                }
            });

            //ViewCompat.animate(holder.container).cancel();
        }*/
    }

    public void runAnimation(View view, int position ){
        if(position > last){
            Log.d("sdfds", "fasfasf");
            last = position;

            view.setTranslationY(100);
            view.setAlpha(0.f);
            view.animate()
                    .translationY(0).alpha(1.f)
                    .setStartDelay(45 * (position))
                    .setInterpolator(new DecelerateInterpolator(2.f))
                    .setDuration(300)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            animationsLocked = true;
                        }
                    })
                    .start();
        }
    }

    @Override
    public int getItemCount() {
        return array.size();
    }


    @Override
    public void onViewDetachedFromWindow(Holder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.container.clearAnimation();
    }

    public void add(MainActivity.Pessoas item){
        this.array.add(this.getItemCount(),item);
       notifyItemInserted(this.getItemCount()-1);
    }
    public static class Holder extends RecyclerView.ViewHolder{

        public TextView mText1;
        public FrameLayout container;

        public Holder(View itemView) {
            super(itemView);

            mText1 = (TextView) itemView.findViewById(R.id.text);
            container = (FrameLayout) itemView.findViewById(R.id.container);
        }
    }
}
