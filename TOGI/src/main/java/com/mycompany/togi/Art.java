/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.togi;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author nolan
 */
@Entity
@Table(name="Art")
public class Art implements Serializable {

    @Column(name = "Postnum")
    private Integer post;
    @Column(name = "Date_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
       
    }
    @Size(max = 45)
    @Column(name = "Title")
    private String title;
    @Size(max = 45)
    @Column(name = "Board")
    private String board;
    @Column(name = "Commentnum")
    private Integer commentnum;
    @Size(max = 9999)
    @Column(name = "Comment")
    private String comment;
    @Size(max = 500)
    @Column(name = "imglink")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
  

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
        
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCommentnum() {
        return commentnum;
        
    }

    public String getComment() {
        return comment;
    }




    public void setComment(String comment) {
        this.comment = comment;
  
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Art)) {
            return false;
        }
        Art other = (Art) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Togi.Art[ id=" + id + " ]";
    }

    public Art() {
    }

    public Art(Integer post) {
        this.post = post;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        
        this.post = post;
    }

   

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}
