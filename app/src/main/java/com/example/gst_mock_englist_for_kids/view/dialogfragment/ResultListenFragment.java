package com.example.gst_mock_englist_for_kids.view.dialogfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.utils.Constants;


public class ResultListenFragment extends DialogFragment {

    @SuppressWarnings("FieldCanBeLocal")
    private Button mBtnTryAgain, mBtnExit;

    private final View.OnClickListener mBtnTryAgainClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment fragment;
            if (getFragmentManager() != null) {
                fragment = getFragmentManager().findFragmentByTag(Constants.TAG_FRAGMENT_LISTEN);
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                if (fragment != null) {
                    ft.detach(fragment);
                    ft.attach(fragment);
                    ft.commit();
                }
            }

        }
    };
    private final View.OnClickListener mBtnExitClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack(Constants.BACK_STACK_HOME_FRAGMENT, Constants.FLAG_HOME_FRAGMENT);
                dismiss();
            }
        }
    };

    public ResultListenFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_listen, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mBtnTryAgain = view.findViewById(R.id.btnTryAgain);
        mBtnTryAgain.setOnClickListener(mBtnTryAgainClick);

        mBtnExit = view.findViewById(R.id.btnExit);
        mBtnExit.setOnClickListener(mBtnExitClick);
    }
}
