package com.example.gst_mock_englist_for_kids.room_database.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.gst_mock_englist_for_kids.entities.ImageAnswer;
import com.example.gst_mock_englist_for_kids.entities.ListenAnswer;
import com.example.gst_mock_englist_for_kids.entities.Topic;
import com.example.gst_mock_englist_for_kids.entities.TopicDetails;
import com.example.gst_mock_englist_for_kids.room_database.dao.IDao;
import com.example.gst_mock_englist_for_kids.utils.Constants;


@androidx.room.Database(entities = {Topic.class, TopicDetails.class, ImageAnswer.class, ListenAnswer.class}, exportSchema = false, version = 1)
public abstract class Database extends RoomDatabase {
    private static final String DB_NAME = Constants.DATABASE_NAME;
    private static Database sInstance;

    public static synchronized Database getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), Database.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }

    public abstract IDao iTopicDao();

}
