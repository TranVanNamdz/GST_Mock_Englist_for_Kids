package com.example.gst_mock_englist_for_kids.view.fragment;


import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.adapter.TopicAdapter;
import com.example.gst_mock_englist_for_kids.entities.Topic;
import com.example.gst_mock_englist_for_kids.executors.MyExecutors;
import com.example.gst_mock_englist_for_kids.room_database.database.Database;
import com.example.gst_mock_englist_for_kids.utils.Constants;

import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends Fragment {

    private RecyclerView mRcvTopic;

    private TopicAdapter mTopicAdapter;


    private Database mDatabase;

    public TopicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_topic, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {

        mDatabase = Database.getInstance(getContext());

        mRcvTopic = view.findViewById(R.id.rcvTopic);
        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<Topic> list = mDatabase.iTopicDao().getTopicList();
                if (list != null) {
                    Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTopicAdapter = new TopicAdapter(Objects.requireNonNull(getContext()), list);
                            mRcvTopic.setAdapter(mTopicAdapter);
                            mRcvTopic.setHasFixedSize(true);
                            mTopicAdapter.setOnItemClickListener(new TopicAdapter.ClickListener() {
                                @Override
                                public void onItemClick(final View view, int position) {
                                    final ValueAnimator value = ValueAnimator.ofFloat(1.3f, 1f);
                                    value.setDuration(100);
                                    value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                        @Override
                                        public void onAnimationUpdate(ValueAnimator animation) {
                                            float progress = (float) value.getAnimatedValue();
                                            view.setScaleX(progress);
                                            view.setScaleY(progress);
                                        }
                                    });
                                    value.start();
                                    final Bundle bundle = new Bundle();
                                    bundle.putInt(Constants.KEY_ID_TOPIC, list.get(position).getId());
                                    final TopicDetailsFragment topicDetailsFragment = new TopicDetailsFragment();
                                    topicDetailsFragment.setArguments(bundle);
                                    changeFragment(topicDetailsFragment);
                                }
                            });
                        }
                    });
                } else {
                    throw new NullPointerException();
                }
            }
        });


    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = Objects.requireNonNull(getFragmentManager()).beginTransaction();
        transaction.replace(R.id.frContent, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
