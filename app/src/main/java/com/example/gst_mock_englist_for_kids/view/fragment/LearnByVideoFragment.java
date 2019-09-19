package com.example.gst_mock_englist_for_kids.view.fragment;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.adapter.VideoEnglishAdapter;
import com.example.gst_mock_englist_for_kids.entities.VideoEnglish;
import com.example.gst_mock_englist_for_kids.view.LearnForVideoActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LearnByVideoFragment extends Fragment {

    private View view;

    public static String API_KEY = "AIzaSyD6W_TJyg_2vyzw3we2YOSXIod2zBBhrx4";

    private String ID_PLAYLIST = "PLQDIMgoD-XFS4JfrC6dQtlyZKJqVLr3pl";

    private String URL_GET_JSON = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId="+ID_PLAYLIST+"&key="+API_KEY+"&maxResults=50";

    private RecyclerView mRvVideo;

    private List<VideoEnglish> mListVideo = new ArrayList<>();;

    private VideoEnglishAdapter mVideoEnglishAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_learn_by_video, container, false);
        initView();
        GetJsonYoutbue(URL_GET_JSON);
        return view;
    }

    private void initView() {
        mRvVideo = view.findViewById(R.id.rv_video_english);
    }

    public void GetJsonYoutbue(String url) {
        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    String title = "";
                    String link = "";
                    String chanal = "";
                    String idVideo = "";
                    String description = "";
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObjectItem = jsonArray.getJSONObject(i);
                        JSONObject jsonObjectSnippet = jsonObjectItem.getJSONObject("snippet");
                        title = jsonObjectSnippet.getString("title");
                        description = jsonObjectSnippet.getString("description");
                        JSONObject jsonObjectThumbnail = jsonObjectSnippet.getJSONObject("thumbnails");
                        JSONObject jsonObjectMedium = jsonObjectThumbnail.getJSONObject("medium");
                        link = jsonObjectMedium.getString("url");
                        chanal = jsonObjectSnippet.getString("channelTitle");
                        JSONObject jsonResourceID = jsonObjectSnippet.getJSONObject("resourceId");
                        idVideo = jsonResourceID.getString("videoId");
                        mListVideo.add(new VideoEnglish(title, description, idVideo, link, chanal));
                        mVideoEnglishAdapter = new VideoEnglishAdapter(getContext(), mListVideo);
                        mRvVideo.setAdapter(mVideoEnglishAdapter);
                        mRvVideo.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
                        mVideoEnglishAdapter.onItemClickVideoListener(new VideoEnglishAdapter.OnItemVideoClickListener() {
                            @Override
                            public void onItemClick(final View view, int position) {
                                final ValueAnimator value = ValueAnimator.ofFloat(1.0f, 0.5f);
                                value.setDuration(600);
                                value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                    @Override
                                    public void onAnimationUpdate(ValueAnimator animation) {
                                        float progress = (float) value.getAnimatedValue();
                                        view.setScaleX(progress);
                                        view.setScaleY(progress);
                                    }
                                });
                                value.start();

                                Intent intent = new Intent(getContext(), LearnForVideoActivity.class);
                                intent.putExtra("video", mListVideo.get(position).getmIdVideo());
                                startActivity(intent);
                            }
                        });
                    }
                    mVideoEnglishAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "erross", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }


}
