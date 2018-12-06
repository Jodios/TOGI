package com.mycompany.togi;

public class Board {

    private Integer commentnum = 0;
    private String currentboard = "";

    public Integer getCommentnum() {
        commentnum++;
        return commentnum;

    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;

    }

    public String getCurrentboard() {
        return currentboard;
    }

    public void setCurrentboard(String currentboard) {
        this.currentboard = currentboard;
    }
}
