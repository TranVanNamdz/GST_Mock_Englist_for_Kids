package com.example.gst_mock_englist_for_kids.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ListenAnswer")
public class ListenAnswer {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "imageA")
    private String imgA;

    @ColumnInfo(name = "imageB")
    private String imgB;

    @ColumnInfo(name = "imageC")
    private String imgC;

    @ColumnInfo(name = "imageD")
    private String imgD;

    @ColumnInfo(name = "answer")
    private String answer;

    public ListenAnswer(int id, String name, String imgA, String imgB, String imgC, String imgD, String answer) {
        this.id = id;
        this.name = name;
        this.imgA = imgA;
        this.imgB = imgB;
        this.imgC = imgC;
        this.imgD = imgD;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgA() {
        return imgA;
    }

    public void setImgA(String imgA) {
        this.imgA = imgA;
    }

    public String getImgB() {
        return imgB;
    }

    public void setImgB(String imgB) {
        this.imgB = imgB;
    }

    public String getImgC() {
        return imgC;
    }

    public void setImgC(String imgC) {
        this.imgC = imgC;
    }

    public String getImgD() {
        return imgD;
    }

    public void setImgD(String imgD) {
        this.imgD = imgD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
