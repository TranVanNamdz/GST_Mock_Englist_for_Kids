package com.example.gst_mock_englist_for_kids.view.fragment;


import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.transition.ArcMotion;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.utils.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button mBtnStart;

    private Button mBtnViewAndChoose;

    private Button mBtnListenAndGuess;

    private Button mBtnMiniGame;

    private Button mBtnWatchVideo;

    private FloatingActionButton mBtnLanguage;

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

    private final View.OnClickListener mBtnLanguageOnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showDialogLanguage();
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
        loadLocale();
        return view;
    }

    private void initViews(View view) {
        mBtnStart = view.findViewById(R.id.btnStart);

        mBtnViewAndChoose = view.findViewById(R.id.btnViewAndChoose);

        mBtnListenAndGuess = view.findViewById(R.id.btnListenAndGuess);

        mBtnMiniGame = view.findViewById(R.id.btnMiniGame);

        mBtnWatchVideo = view.findViewById(R.id.btnWatchVideo);

        mBtnLanguage = view.findViewById(R.id.btnLanguage);

        actionAnimation();
    }

    private void actionAnimation() {

    }

    private void addEvents() {
        mBtnStart.setOnClickListener(mBtnStartOnClick);

        mBtnViewAndChoose.setOnClickListener(mBtnLockAndChooseOnClick);

        mBtnListenAndGuess.setOnClickListener(mBtnListenAndGuessOnClick);

        mBtnMiniGame.setOnClickListener(mBtnMiniGameOnClick);

        mBtnWatchVideo.setOnClickListener(mBtnWatchVideoOnClick);

        mBtnLanguage.setOnClickListener(mBtnLanguageOnclick);

    }

    private void changeFragment(Fragment fragment, String backStack, String tag) {
        if (getFragmentManager() != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frContent, fragment, tag);
            transaction.addToBackStack(backStack);
            transaction.commit();
        }
    }

    private void showDialogLanguage() {
        final String[] listItem = {Constants.LIST_ITEM_VN, Constants.LIST_ITEM_EN};
        final AlertDialog.Builder mbBuilder = new AlertDialog.Builder(getActivity());
        mbBuilder.setTitle(Constants.TITLE_DIALOG_LANGUAGE);
        mbBuilder.setSingleChoiceItems(listItem, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    setLocale(Constants.LOCALE_VI);
                    Objects.requireNonNull(getActivity()).recreate();

                }
                if (which == 1) {
                    setLocale(Constants.LOCALE_EN);
                    Objects.requireNonNull(getActivity()).recreate();
                }
                dialog.dismiss();
            }
        });
        AlertDialog mDialog = mbBuilder.create();
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        Objects.requireNonNull(getContext()).getResources().updateConfiguration(config, getContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = Objects.requireNonNull(getContext()).getSharedPreferences(Constants.KEY_SHAREDPRRFERENCES, Context.MODE_PRIVATE).edit();
        editor.putString(Constants.KEY_SHARED_STRING, lang);
        editor.apply();

    }

    private void loadLocale() {
        SharedPreferences prefs = Objects.requireNonNull(getContext()).getSharedPreferences(Constants.KEY_SHAREDPRRFERENCES, Context.MODE_PRIVATE);
        String language = prefs.getString(Constants.KEY_SHARED_STRING, "");
        if (language != null) {
            if (language.equals(Constants.LOCALE_VI)) {
                mBtnLanguage.setImageResource(R.drawable.ic_vn);
                setLocale(language);
            }
            if (language.equals(Constants.LOCALE_EN)) {
                mBtnLanguage.setImageResource(R.drawable.ic_england);
                setLocale(language);
            }
        }
    }

}
