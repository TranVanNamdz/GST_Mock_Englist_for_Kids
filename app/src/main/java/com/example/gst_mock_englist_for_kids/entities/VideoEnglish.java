package com.example.gst_mock_englist_for_kids.entities;

import java.io.Serializable;

public class VideoEnglish implements Serializable {

    private String mTitle;

    private String mIdVideo;

    private String mThumbnail;

    private String mChanalTitle;

    private String mDescription;

    public VideoEnglish(String mTitle, String mDescription, String mIdVideo, String mThumbnail, String mChanalTitle) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mIdVideo = mIdVideo;
        this.mThumbnail = mThumbnail;
        this.mChanalTitle = mChanalTitle;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmIdVideo() {
        return mIdVideo;
    }

    public String getmThumbnail() {
        return mThumbnail;
    }
}
