package com.example.gst_mock_englist_for_kids.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gst_mock_englist_for_kids.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button mBtnStart;

    private Button mBtnViewAndChoose;

    private Button mBtnListenAndGuess;

    private Button mBtnMiniGame;

    private Button mBtnWatchVideo;

    private View.OnClickListener mBtnStartOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeFragment(new TopicFragment());
        }
    };

    private View.OnClickListener mBtnViewAndChooseOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener mBtnListenAndGuessOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener mBtnMiniGameOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener mBtnWatchVideoOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        addEvents();
        return view;
    }

    private void initViews(View view) {
        mBtnStart = view.findViewById(R.id.btnStart);

        mBtnViewAndChoose = view.findViewById(R.id.btnViewAndChoose);

        mBtnListenAndGuess = view.findViewById(R.id.btnListenAndGuess);

        mBtnMiniGame = view.findViewById(R.id.btnMiniGame);

        mBtnWatchVideo = view.findViewById(R.id.btnWatchVideo);
    }

    private void addEvents() {
        mBtnStart.setOnClickListener(mBtnStartOnClick);

        mBtnViewAndChoose.setOnClickListener(mBtnViewAndChooseOnClick);

        mBtnListenAndGuess.setOnClickListener(mBtnListenAndGuessOnClick);

        mBtnMiniGame.setOnClickListener(mBtnMiniGameOnClick);

        mBtnWatchVideo.setOnClickListener(mBtnWatchVideoOnClick);

    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frContent, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
