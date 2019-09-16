package com.example.gst_mock_englist_for_kids.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Topic")
public class Topic implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int idTopic;

    @ColumnInfo(name = "name")
    private String nameTopic;

    @ColumnInfo(name = "image")
    private String imgTopic;

    public Topic(int idTopic, String nameTopic, String imgTopic) {
        this.idTopic = idTopic;
        this.nameTopic = nameTopic;
        this.imgTopic = imgTopic;
    }

    @Ignore
    public Topic(String nameTopic, String imgTopic) {
        this.nameTopic = nameTopic;
        this.imgTopic = imgTopic;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public String getNameTopic() {
        return nameTopic;
    }

    public void setNameTopic(String nameTopic) {
        this.nameTopic = nameTopic;
    }

    public String getImgTopic() {
        return imgTopic;
    }

    public void setImgTopic(String imgTopic) {
        this.imgTopic = imgTopic;
    }
}
