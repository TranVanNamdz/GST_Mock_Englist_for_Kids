package com.example.gst_mock_englist_for_kids.utils;

public final class Constants {

    public static final String DATABASE_NAME = "mydata_db";

    public static final String LIST_ITEM_VN = "Viet Nam";

    public static final String LIST_ITEM_EN = "English";

    public static final String LOCALE_VI = "vi";

    public static final String LOCALE_EN = "en";

    public static final String TITLE_DIALOG_LANGUAGE = "Choose Language...";

    public static final String KEY_SHARED_STRING = "My_Lang";

    public static final String KEY_SHAREDPRRFERENCES = "Setting";


    public static final String KEY_ID_TOPIC = "key_id_topic";

    public static final String BACK_STACK_HOME_FRAGMENT = "home_fragment";

    public static final String TAG_FRAGMENT_LISTEN = "tag1";

    public static final String TAG_FRAGMENT_LOOK = "tag2";

    public static final String TAG_FRAGMENT_DIALOG_LISTEN = "tag3";

    public static final String RESULT_FRAGMENT = "Result fragment";

    public static final String DATA_FOR_VIDEO = "video";

    public static final String API_KEY = "AIzaSyD6W_TJyg_2vyzw3we2YOSXIod2zBBhrx4";

    private static final String ID_PLAYLIST = "PLQDIMgoD-XFS4JfrC6dQtlyZKJqVLr3pl";

    public static final String URL_GET_JSON = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=" + ID_PLAYLIST + "&key=" + API_KEY + "&maxResults=50";

    public static int FLAG_HOME_FRAGMENT = 1;


    private Constants() {

    }

}
