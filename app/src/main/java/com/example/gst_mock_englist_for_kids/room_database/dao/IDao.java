package com.example.gst_mock_englist_for_kids.room_database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gst_mock_englist_for_kids.entities.Topic;
import com.example.gst_mock_englist_for_kids.entities.TopicDetails;

import java.util.List;


@Dao
public interface IDao {
    @Query("SELECT * FROM Topic ORDER BY id ASC")
    List<Topic> getTopicList();


    /**
     * Insert topic table
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTopic(List<Topic> topics);

    /**
     * Insert topicDetails table
     **/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTopicDetails(List<TopicDetails> topicDetails);

    @Query("SELECT * FROM TopicDetails WHERE idTopic=:idTopic")
    List<TopicDetails> getListTopicDetails(final int idTopic);

    /**
     * getQuestion
   /*  *//*
    @Query("SELECT image,a,b,c,d,answer FROM TopicDetails INNER JOIN AnswerImage ON TopicDetails.id = AnswerImage.idTopicDetails")
    List<QuestionAndAnswerImage> getListImageAnswer();*/

    @Update
    void updateTopic(Topic topic);

    @Delete
    void deleteTopic(List<Topic> topics);


}
