package com.example.gst_mock_englist_for_kids.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gst_mock_englist_for_kids.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListenAndGuessFragment extends Fragment {


    public ListenAndGuessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listen_and_guess, container, false);
    }

}
