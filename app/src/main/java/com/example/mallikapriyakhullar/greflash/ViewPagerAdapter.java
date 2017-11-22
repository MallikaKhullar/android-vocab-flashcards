package com.example.mallikapriyakhullar.greflash;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mallikapriyakhullar on 17/11/17.
 */
public class ViewPagerAdapter extends PagerAdapter {


    private ArrayList<WordModel> words;

    private LayoutInflater inflater;
    private Context context;
    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;
    private boolean mIsBackVisible = false;
    private TextView tvWord, tvMeaning;


    public ViewPagerAdapter(Context context,ArrayList<WordModel> words) {
        this.context = context;
        this.words = words;
        inflater = LayoutInflater.from(context);
        loadAnimations();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return words.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View layout = inflater.inflate(R.layout.view_flashcard, view, false);
        assert layout != null;

        View mCardBackLayout = layout.findViewById(R.id.card_back);
        View mCardFrontLayout = layout.findViewById(R.id.card_front);
        tvWord = mCardFrontLayout.findViewById(R.id.card_front_word);
        tvMeaning = mCardBackLayout.findViewById(R.id.card_back_meaning);

        tvWord.setText(words.get(position).getWord());
        tvMeaning.setText(words.get(position).getMeaning());

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard(v.findViewById(R.id.card_back), v.findViewById(R.id.card_front));
            }
        });

        view.addView(layout, 0);

        return layout;
    }

    private void loadAnimations() {
        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(context, R.animator.in_animation);
        mSetRightOut.setDuration(500);
        mSetLeftIn.setDuration(500);
    }


    public void flipCard(View back, View front) {

        if (!mIsBackVisible) {
            mSetRightOut.setTarget(front);
            mSetLeftIn.setTarget(back);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = true;
        } else {
            mSetRightOut.setTarget(back);
            mSetLeftIn.setTarget(front);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = false;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}