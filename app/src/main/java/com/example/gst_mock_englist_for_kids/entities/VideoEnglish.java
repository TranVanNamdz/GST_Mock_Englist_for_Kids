package com.example.gst_mock_englist_for_kids.entities;

import java.io.Serializable;

public class VideoEnglish implements Serializable {

    private String mTitle;

    private String mIdVideo;

    private String mThumbnail;

    private String mChanalTitle;

private String mDescription;

public VideoEnglish(){

    }

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

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmIdVideo() {
        return mIdVideo;
    }

    public void setmIdVideo(String mIdVideo) {
        this.mIdVideo = mIdVideo;
    }

    public String getmThumbnail() {
        return mThumbnail;
    }

    public void setmThumbnail(String mThumbnail) {
        this.mThumbnail = mThumbnail;
    }

    public String getmChanalTitle() {
        return mChanalTitle;
    }

    public void setmChanalTitle(String mChanalTitle) {
        this.mChanalTitle = mChanalTitle;
    }
}
