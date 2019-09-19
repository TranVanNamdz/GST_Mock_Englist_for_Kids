package com.example.gst_mock_englist_for_kids.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button mBtnStart;

    private Button mBtnViewAndChoose;

    private Button mBtnListenAndGuess;

    private Button mBtnMiniGame;

    private Button mBtnWatchVideo;

    private final View.OnClickListener mBtnStartOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeFragment(new TopicFragment(), null, null);
        }
    };

    private final View.OnClickListener mBtnLockAndChooseOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeFragment(new LookAndChooseFragment(), Constants.BACK_STACK_HOME_FRAGMENT, Constants.TAG_FRAGMENT_LOOK);
        }
    };

    private final View.OnClickListener mBtnListenAndGuessOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeFragment(new ListenAndGuessFragment(), Constants.BACK_STACK_HOME_FRAGMENT, Constants.TAG_FRAGMENT_LISTEN);
        }
    };

    private final View.OnClickListener mBtnMiniGameOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeFragment(new GuessThePictureFragment(), null, null);
        }
    };

    private final View.OnClickListener mBtnWatchVideoOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeFragment(new LearnByVideoFragment(), null, null);
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

        mBtnViewAndChoose.setOnClickListener(mBtnLockAndChooseOnClick);

        mBtnListenAndGuess.setOnClickListener(mBtnListenAndGuessOnClick);

        mBtnMiniGame.setOnClickListener(mBtnMiniGameOnClick);

        mBtnWatchVideo.setOnClickListener(mBtnWatchVideoOnClick);

    }

    private void changeFragment(Fragment fragment, String backStack, String tag) {
        assert getFragmentManager() != null;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frContent, fragment, tag);
        transaction.addToBackStack(backStack);
        transaction.commit();
    }
}
