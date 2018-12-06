///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.togi;
//
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//
//@Entity
//@Table(name = "Politics")
//
//public class Politics implements Serializable {
//    public static Integer pcounter=0;
//
//
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }
//
//    @Column(name = "Postnum")
//    private Integer post;
//    @Column(name = "Date_")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date date;
//
//    public void setCommentnum(Integer commentnum) {
//        this.commentnum = commentnum;
//
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    @Size(max = 45)
//    @Column(name = "Title")
//    private String title;
//    @Size(max = 45)
//    @Column(name = "Board")
//    private String board;
//    @Column(name = "Commentnum")
//    private Integer commentnum;
//    @Size(max = 9999)
//    @Column(name = "Comment")
//    private String comment;
//    @Size(max = 500)
//    @Column(name = "imglink")
//    private String image;
//    
// 
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Override
//    public int hashCode() {
//       
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Politics)) {
//            return false;
//        }
//        Politics other = (Politics) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "Togi.Politics[ id=" + id + " ]";
//    }
//
//    public Politics() {
//    }
//
//    public Politics(Integer post) {
//        this.post = post;
//    }
//
//    public Integer getPost() {
//        return post;
//    }
//
//    public void setPost(Integer post) {
//        this.post = post;
//        pcounter=this.post;
//        System.out.println(pcounter);
//    }
//
//    public static void setPcounter(Integer pcounter) {
//        Politics.pcounter = pcounter;
//    }
//
//    public String getBoard() {
//        return board;
//    }
//
//    public void setBoard(String board) {
//        this.board = board;
//    }
//
//    public Integer getCommentnum() {
//        return commentnum;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//}
