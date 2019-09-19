package com.example.gst_mock_englist_for_kids.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Answer")
public class Answer {

    @PrimaryKey
    @ColumnInfo(name = "idA")
    private int id;

    @ColumnInfo(name = "aA")
    private String a;

    @ColumnInfo(name = "bA")
    private String b;

    @ColumnInfo(name = "cA")
    private String c;

    @ColumnInfo(name = "dA")
    private String d;

    @ColumnInfo(name = "answerA")
    private String answer;

    public Answer(int id, String a, String b, String c, String d, String answer) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
