package com.example.gst_mock_englist_for_kids.view.fragment;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.DialogFragment;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.entities.TopicDetails;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class CheckAnswerDialogFragment extends DialogFragment {

    private View view;

    @SuppressWarnings("FieldCanBeLocal")
    private Button btnCancle, btnCheck;

    private EditText mEdtInputAnswer;

    @SuppressWarnings("FieldCanBeLocal")
    private AppCompatImageView mImgCloseCheckAnswer;

    @SuppressWarnings("FieldCanBeLocal")
    private MediaPlayer mMediaPlayer;

    private ImageView mImgPicture;

    @SuppressWarnings("FieldCanBeLocal")
    private Bundle mBundle = null;

    private TopicDetails mTopicDetails = null;

    private final View.OnClickListener onClickCheckListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mTopicDetails != null) {
                String inputAnswer = mEdtInputAnswer.getText().toString().trim();
                if (inputAnswer.isEmpty()) {
                    mEdtInputAnswer.setError("Please enter the answer");
                } else {
                    if (inputAnswer.equalsIgnoreCase(mTopicDetails.getName())) {
                        mMediaPlayer = MediaPlayer.create(getContext(), R.raw.correct);
                        mMediaPlayer.start();
                        if (mListener != null) {
                            mListener.onCheckItem();
                        }
                        dismiss();
                    } else {
                        mMediaPlayer = MediaPlayer.create(getContext(), R.raw.wrong);
                        mMediaPlayer.start();
                        if (mListener != null) {
                            mListener.onCheckedItemFalse();
                        }
                        dismiss();
                    }

                }

            }
        }
    };

    private Bitmap getBitmapFromAssets(String img) {
        AssetManager am = Objects.requireNonNull(getContext()).getAssets();
        InputStream is = null;
        try {

            is = am.open(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return BitmapFactory.decodeStream(is);
    }

    private final View.OnClickListener onClickCancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
        }
    };

    private final View.OnClickListener onClickCloseListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
        }
    };

    private CheckAnswerListener mListener;

    CheckAnswerDialogFragment(CheckAnswerListener listener) {
        mListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_fragment_check_result, container, false);
        mBundle = getArguments();
        if (mBundle != null) {
            mTopicDetails = (TopicDetails) mBundle.getSerializable("data");
            initView();
            mImgPicture.setImageBitmap(getBitmapFromAssets(mTopicDetails.getImg()));
        }
        return view;
    }

    private void initView() {

        Objects.requireNonNull(getDialog()).requestWindowFeature(Window.FEATURE_NO_TITLE);
        btnCancle = view.findViewById(R.id.btnCancel);
        btnCheck = view.findViewById(R.id.btnCheckAnswer);
        mEdtInputAnswer = view.findViewById(R.id.etInputAnswer);
        mImgCloseCheckAnswer = view.findViewById(R.id.ivCloseCheckResult);
        mImgPicture = view.findViewById(R.id.img_pic);

        btnCheck.setOnClickListener(onClickCheckListener);
        btnCancle.setOnClickListener(onClickCancelListener);
        mImgCloseCheckAnswer.setOnClickListener(onClickCloseListener);
    }


    interface CheckAnswerListener {
        void onCheckItem();

        void onCheckedItemFalse();
    }
}
