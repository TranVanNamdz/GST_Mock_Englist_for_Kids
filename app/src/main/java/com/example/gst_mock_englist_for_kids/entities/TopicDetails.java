package com.example.gst_mock_englist_for_kids.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "TopicDetails",
        foreignKeys = @ForeignKey(entity = Topic.class,
                parentColumns = "id",
                childColumns = "idTopic",
                onDelete = CASCADE))
public class TopicDetails {
    @PrimaryKey
    @ColumnInfo(name = "idTopicDetails")
    private int idTopicDetails;

    @ColumnInfo(name = "imgTopicDetails")
    private String imgTopicDetails;

    @ColumnInfo(name = "nameTopicDetails")
    private String nameTopicDetails;

    @ColumnInfo(name = "idTopic")
    private int idTopic;

    public TopicDetails(int idTopicDetails, String imgTopicDetails, String nameTopicDetails, int idTopic) {
        this.idTopicDetails = idTopicDetails;
        this.imgTopicDetails = imgTopicDetails;
        this.nameTopicDetails = nameTopicDetails;
        this.idTopic = idTopic;
    }

    public int getIdTopicDetails() {
        return idTopicDetails;
    }

    public void setIdTopicDetails(int idTopicDetails) {
        this.idTopicDetails = idTopicDetails;
    }

    public String getImgTopicDetails() {
        return imgTopicDetails;
    }

    public void setImgTopicDetails(String imgTopicDetails) {
        this.imgTopicDetails = imgTopicDetails;
    }

    public String getNameTopicDetails() {
        return nameTopicDetails;
    }

    public void setNameTopicDetails(String nameTopicDetails) {
        this.nameTopicDetails = nameTopicDetails;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }
}