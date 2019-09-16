package com.example.gst_mock_englist_for_kids.room_database.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.gst_mock_englist_for_kids.entities.Topic;
import com.example.gst_mock_englist_for_kids.entities.TopicDetails;
import com.example.gst_mock_englist_for_kids.room_database.dao.IDao;


@androidx.room.Database(entities = {Topic.class, TopicDetails.class}, exportSchema = false, version = 2)
public abstract class Database extends RoomDatabase {
    private static final String DB_NAME = "mydata_db";
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
