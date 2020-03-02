package com.example.sampledemo.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sampledemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SampleFragment extends Fragment {
    private static final int YES = 1;
    private static final int NO = 2;
    private RadioGroup mRadioGroup;
    private RatingBar mRatingBar;

    private RadioGroup.OnCheckedChangeListener mRadioGroup_checked = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            View view = radioGroup.findViewById(i);
            int index = radioGroup.indexOfChild(view);
            TextView mTextView = radioGroup.findViewById(R.id.mTextView);

            switch (index){
                case YES:
                    mTextView.setText(R.string.textview_msg_yes);
                    break;
                case NO:
                    mTextView.setText(R.string.textview_msg_no);
                    break;
                default:
                    break;
            }
        }
    };

    private RatingBar.OnRatingBarChangeListener mRatingBar_change = new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            Toast.makeText(getContext(),String.valueOf(ratingBar.getRating()),Toast.LENGTH_SHORT).show();
        }
    };

    public SampleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample, container, false);
        mRadioGroup = view.findViewById(R.id.mRadioGroup);
        mRadioGroup.setOnCheckedChangeListener(mRadioGroup_checked);
        mRatingBar = view.findViewById(R.id.mRatingBar);
        mRatingBar.setOnRatingBarChangeListener(mRatingBar_change);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
