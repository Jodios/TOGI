<%-- 
    Document   : politics
    Created on : Dec 3, 2018, 7:15:16 PM
    Author     : jortiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TŌGI - Image Boards</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet"> 
        <link rel="stylesheet" href="Styles/post.css">
        <link rel="stylesheet" href="Styles/board.css">
    </head>
    <body>
        <!--this is the banner on the top of the page-->
        <div class="header" id="myHeader">
            <h2 class="boardName">Politics</h2>
            <a href="index.html">
                <div class = "logo"></div>
            </a>
            <button type="button" class="newPost" id="buttonReply">Create Post</button>
            <form action="politics.jsp" style="display:none" method="post" id="postBox">
                Image URL: <input type="text" name="image" id="image">
                <fieldset>
                    <legend>Title</legend>
                    <textarea rows="5" cols="50" name="title"
                              placeholder="Enter your title here..."></textarea>
                </fieldset>
                <button onClick="javascript:window.location.href = 'politics.jsp'" id="buttonPost">Create Post</button>
            </form>
        </div>

        <!--this is the different threads--> 
            <table id="tdata"><tbody>
                    <tr><td><a href="index.html">
                <div class="content">
                    <div class="imgdiv"></div>
                    <div class="title">
                        This board is mean to discuss politics. 
                    </div>
                </div>
                            </a></td></tr>
                </tbody></table>

        <script>
            window.onscroll = function () {
                myFunction();
            };
            document.getElementById("buttonPost").onclick = function () {
                hideCommentBox();
            };
            function hideCommentBox() {
                var x = document.getElementById("postBox");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
            }

            var header = document.getElementById("myHeader");
            var sticky = header.offsetTop;

            function myFunction() {
                if (window.pageYOffset > sticky) {
                    header.classList.add("sticky");
                } else {
                    header.classList.remove("sticky");
                }
            }
            function loadComments() {
                $.ajax({
                    url: 'api/polcomments/post',
                    type: 'get',
                    dataType: 'json',
                    success: function (data) {
                        $('#tdata').empty();
                        $.each(data, function (i, r) {
                            var tr = "<tr><td><a href = 'post.html'><div class = \"content\">" +
                                    "<object><a href='"+r.image+"'><div class = \"imgdiv\" style=\"background-image: url(" + r.image + ")\"></div></a></object>" +
                                    "<div class = \"title\" >" +
                                    r.comment +
                                    "</div>" + "</div></a></td></tr>";
                            $('#tdata').append(tr);
                        });
                    },
                    error: function () {
                        alert('Error');
                    }
                });
            }


            $(document).ready(function () {
                loadComments();
            });

            window.onscroll = function () {
                stickyHeader();
            };

            var header = document.getElementById("myHeader");
            var sticky = header.offsetTop;

            function stickyHeader() {
                if (window.pageYOffset > sticky) {
                    header.classList.add("sticky");
                } else {
                    header.classList.remove("sticky");
                }
            }
           
    
            document.getElementById("buttonReply").onclick = function () {
                hideCommentBox();
            };
            
            function hideCommentBox() {
                var x = document.getElementById("postBox");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
            }
            
            $('#buttonPost').click(function () {
                window.location.reload();
                var img = $("#image").val();
                var comment = $('#comment').val();
                $('#errorc').html('');
                $('#error').html('');
                if (img.length === 0 || comment.length === 0) {
                    if (img.length === 0) {
                        $('#errorc').html('Invalid Image URL');
                    }
                    if (comment.length === 0) {
                        $('#error').html('Invalid Comment');
                    }
                    return;
                }
                var data = JSON.stringify({
                    image: img,
                    comment: comment
                });
                $.ajax({
                    url: 'api/polcomments',
                    type: 'post',
                    data: data,
                    contentType: 'application/json',
                    dataType: 'text',
                    success: function (resp) {
                        alert('success');
                        loadComments();
//                      

                    },
                    error: function () {
                        alert('Error');
                    }
                });

                return false;
            });

        </script>
    </body>
</html>
