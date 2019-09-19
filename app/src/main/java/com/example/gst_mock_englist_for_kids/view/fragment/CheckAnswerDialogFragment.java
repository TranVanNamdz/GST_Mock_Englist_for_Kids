package com.example.gst_mock_englist_for_kids.view.fragment;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.DialogFragment;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.entities.TopicDetails;

import java.io.IOException;
import java.io.InputStream;

public class CheckAnswerDialogFragment extends DialogFragment {

    private View view;

    private Button btnCancle, btnCheck;

    private EditText mEdtInputAnswer;

    private AppCompatImageView mImgCloseCheckAnswer;

    private MediaPlayer mMediaPlayer;

    private ImageView mImgPicture;

    private Bundle mBundle = null;

    private TopicDetails mTopicDetails = null;

    private final View.OnClickListener onClickCheckListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mTopicDetails != null) {
                String inputAnswer = mEdtInputAnswer.getText().toString().trim();
               if (inputAnswer.isEmpty() || inputAnswer.length() == 0 || inputAnswer.equals("") || inputAnswer == null){
                   mEdtInputAnswer.setError("Please enter the answer");
               }
               else {
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

    /**
     * @param @get url from data asset
     * @return @type bitmap
     */
    private Bitmap getBitmapFromAssets(String img) {
        AssetManager am = getContext().getAssets();
        InputStream is = null;
        try {

            is = am.open(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return BitmapFactory.decodeStream(is);
    }

    private final View.OnClickListener onClickCancleListener = new View.OnClickListener() {
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

    public CheckAnswerDialogFragment(CheckAnswerListener listener) {
        mListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_fragment_check_result, container, false);
        mBundle = getArguments();
        mTopicDetails = (TopicDetails) mBundle.getSerializable("data");
        initView();
        mImgPicture.setImageBitmap(getBitmapFromAssets(mTopicDetails.getImg()));

        return view;
    }

    private void initView() {

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        btnCancle = view.findViewById(R.id.btnCancel);
        btnCheck = view.findViewById(R.id.btnCheckAnswer);
        mEdtInputAnswer = view.findViewById(R.id.etInputAnswer);
        mImgCloseCheckAnswer = view.findViewById(R.id.ivCloseCheckResult);
        mImgPicture = view.findViewById(R.id.img_pic);

        btnCheck.setOnClickListener(onClickCheckListener);
        btnCancle.setOnClickListener(onClickCancleListener);
        mImgCloseCheckAnswer.setOnClickListener(onClickCloseListener);
    }


    interface CheckAnswerListener {
        void onCheckItem();

        void onCheckedItemFalse();
    }
}
