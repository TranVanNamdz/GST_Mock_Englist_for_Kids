package com.example.gst_mock_englist_for_kids.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "ImageAnswer")
public class ImageAnswer {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "image")
    private String img;

    @ColumnInfo(name = "a")
    private String a;

    @ColumnInfo(name = "b")
    private String b;

    @ColumnInfo(name = "c")
    private String c;

    @ColumnInfo(name = "d")
    private String d;

    @ColumnInfo(name = "correct")
    private String answer;

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

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ImageAnswer(int id, String img, String a, String b, String c, String d, String answer) {
        this.id = id;
        this.img = img;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answer = answer;
    }
}
