package com.example.gst_mock_englist_for_kids.view.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.adapter.TopicAdapter;
import com.example.gst_mock_englist_for_kids.entities.Topic;
import com.example.gst_mock_englist_for_kids.executors.MyExecutors;
import com.example.gst_mock_englist_for_kids.room_database.database.Database;
import com.example.gst_mock_englist_for_kids.utils.Constants;
import com.example.gst_mock_englist_for_kids.utils.DataForDatabase;

import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends Fragment {

    private static final String TAG = TopicFragment.class.getSimpleName();

    @SuppressWarnings("FieldCanBeLocal")
    private RecyclerView mRcvTopic;

    @SuppressWarnings("FieldCanBeLocal")
    private TopicAdapter mTopicAdapter;


    private Database mDatabase;

    @SuppressWarnings("FieldCanBeLocal")
    private DataForDatabase mDataForDatabase;


    public TopicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_topic, container, false);
        initViews(view);
        insertDataToDatabase();
        return view;
    }

    private void initViews(View view) {
        mDatabase = Database.getInstance(getContext());

        mRcvTopic = view.findViewById(R.id.rcvTopic);
        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<Topic> list = mDatabase.iTopicDao().getTopicList();
                Log.d(TAG, list.size() + " get list");
                Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTopicAdapter = new TopicAdapter(Objects.requireNonNull(getContext()), list);
                        mRcvTopic.setAdapter(mTopicAdapter);
                        mRcvTopic.setHasFixedSize(true);
                        mTopicAdapter.setOnItemClickListener(new TopicAdapter.ClickListener() {
                            @Override
                            public void onItemClick(final View view, int position) {
                                final Bundle bundle = new Bundle();
                                bundle.putInt(Constants.KEY_ID_TOPIC, list.get(position).getId());
                                TopicDetailsFragment topicDetailsFragment = new TopicDetailsFragment();
                                topicDetailsFragment.setArguments(bundle);
                                changeFragment(topicDetailsFragment);
                            }
                        });
                    }
                });
            }
        });


    }

    private void insertDataToDatabase() {
        mDataForDatabase = new DataForDatabase(getActivity());
        mDataForDatabase.addDataTopicTable();
        mDataForDatabase.addDataTopicDetailsTable();
    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frContent, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
