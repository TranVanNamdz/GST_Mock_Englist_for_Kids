package com.example.gst_mock_englist_for_kids.room_database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gst_mock_englist_for_kids.entities.ImageAnswer;
import com.example.gst_mock_englist_for_kids.entities.ListenAnswer;
import com.example.gst_mock_englist_for_kids.entities.Topic;
import com.example.gst_mock_englist_for_kids.entities.TopicDetails;

import java.util.List;


@Dao
public interface IDao {
    //get topic
    @Query("SELECT * FROM Topic ORDER BY id ASC")
    List<Topic> getTopicList();

    //Insert topic table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTopic(List<Topic> topics);

    // Insert topicDetails table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTopicDetails(List<TopicDetails> topicDetails);

    //get topic details follow by topic
    @Query("SELECT * FROM TopicDetails WHERE idTopic=:idTopic")
    List<TopicDetails> getListTopicDetails(final int idTopic);


    //insert ImageAnswer
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertImageAnswer(List<ImageAnswer> list);

    //getImageQuestion
    @Query("SELECT * FROM ImageAnswer ORDER BY RANDOM() LIMIT 2")
    List<ImageAnswer> getListImageAnswer();

    //insert ListenAnswer
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertListenAnswer(List<ListenAnswer> list);

    //getListenImageAnswer
    @Query("SELECT * FROM ListenAnswer ORDER BY RANDOM() LIMIT 2")
    List<ListenAnswer> getListListenAnswer();

    //getRandom CheckTopicDetails
    @Query("SELECT * FROM TopicDetails ORDER BY RANDOM() LIMIT 21")
    List<TopicDetails> getListGuessThePicture();
    /*@Update
    void updateTopic(Topic topic);

    @Delete
    void deleteTopic(List<Topic> topics);*/
}
