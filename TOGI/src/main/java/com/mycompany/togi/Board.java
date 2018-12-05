package com.mycompany.togi;

public class Board {

    private Integer commentnum = 0;

    public Integer getCommentnum() {
        commentnum++;
        return commentnum;

    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

}
