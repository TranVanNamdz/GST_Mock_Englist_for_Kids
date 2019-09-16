package com.example.gst_mock_englist_for_kids.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gst_mock_englist_for_kids.R;

public class HomeActivity extends AppCompatActivity {

    private Button mBtnStart;

    private Button mBtnViewAndChoose;

    private Button mBtnListenAndGuess;

    private Button mBtnMiniGame;

    private Button mBtnWatchVideo;

    private View.OnClickListener mBtnStartOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(HomeActivity.this, TopicActivity.class);
            startActivity(intent);
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        initViews();
        addEvents();
    }

    private void addEvents() {
        mBtnStart.setOnClickListener(mBtnStartOnClick);

        mBtnViewAndChoose.setOnClickListener(mBtnViewAndChooseOnClick);

        mBtnListenAndGuess.setOnClickListener(mBtnListenAndGuessOnClick);

        mBtnMiniGame.setOnClickListener(mBtnMiniGameOnClick);

        mBtnWatchVideo.setOnClickListener(mBtnWatchVideoOnClick);

    }

    private void initViews() {
        mBtnStart = findViewById(R.id.btnStart);

        mBtnViewAndChoose = findViewById(R.id.btnViewAndChoose);

        mBtnListenAndGuess = findViewById(R.id.btnListenAndGuess);

        mBtnMiniGame = findViewById(R.id.btnMiniGame);

        mBtnWatchVideo = findViewById(R.id.btnWatchVideo);
    }
}
