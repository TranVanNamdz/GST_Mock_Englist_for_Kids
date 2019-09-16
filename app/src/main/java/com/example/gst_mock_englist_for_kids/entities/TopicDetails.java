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
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "image")
    private String img;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "idTopic",index =true)
    private int idTopic;

    public TopicDetails(int id, String img, String name, int idTopic) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.idTopic = idTopic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }
}