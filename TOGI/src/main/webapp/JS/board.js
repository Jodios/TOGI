/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


            loadIntro();
            function loadIntro(){
                var board = decodeURI(getUrlVars()["board"]);
                let tr = "";
                let img = "";
                        $('#tintro').empty();
                        switch(board){
                            case "Politics":
                                img = "https://ilsr.org/wp-content/uploads/2013/06/Republican-democrat-symbols.jpg";
                                tr = "<tr><td><div class = \"content\">" +
                                "<object><a href = '" + img + "'><div class = \"imgdiv\" style=\"background-image: url(" + img + ")\"></div></a></object>" +
                                "<div class = \"title\" ><b>" +
                                "Welcome to Politics!!\nThis board is to discuss current political issues without the fear of others looking down on you" +
                                "</b></div>" + "</div></td></tr>";
                                break;
                            
                            case "Games":
                                img = "https://www.notebookcheck.net/fileadmin/Notebooks/News/_nc3/share_steam_logo.png";
                                tr = "<tr><td><div class = \"content\">" +
                                "<object><a href = '" + img + "'><div class = \"imgdiv\" style=\"background-image: url(" + img + ")\"></div></a></object>" +
                                "<div class = \"title\" ><b>" +
                                "Welcome to Games. This board is meant for the discussion of games or related topics." +
                                "</b></div>" + "</div></td></tr>";
                                break;
                            
                            case "Mathematics":
                                img = "https://img.icons8.com/metro/1600/sigma.png";
                                tr = "<tr><td><div class = \"content\">" +
                                "<object><a href = '" + img + "'><div class = \"imgdiv\" style=\"background-image: url(" + img + ")\"></div></a></object>" +
                                "<div class = \"title\" ><b>" +
                                "Welcome to Mathematics, where you can discuss your research and math in general. " +
                                "</b></div>" + "</div></td></tr>";
                                break;
                            
                            case "Photography":
                                img = "https://images.vexels.com/media/users/3/147931/isolated/lists/4a4ba9227247cdc577b7210741f48c95-rangefinder-camera-sketch.png";
                                tr = "<tr><td><div class = \"content\">" +
                                "<object><a href = '" + img + "'><div class = \"imgdiv\" style=\"background-image: url(" + img + ")\"></div></a></object>" +
                                "<div class = \"title\" ><b>" +
                                "Welcome to Photography! This board is for new and pro photographers. link your Flickr photo links and ask for feedback :) " +
                                "</b></div>" + "</div></td></tr>";
                                break;
                            
                            case "Random":
                                img = "https://archive-media-1.nyafuu.org/bant/image/1501/34/1501343255069.png";
                                tr = "<tr><td><div class = \"content\">" +
                                "<object><a href = '" + img + "'><div class = \"imgdiv\" style=\"background-image: url(" + img + ")\"></div></a></object>" +
                                "<div class = \"title\" ><b>" +
                                "Welcome to Random. Talk about anything here :)" +
                                "</b></div>" + "</div></td></tr>";
                                break;
                            
                            case "Technology":
                                img = "https://i.pinimg.com/originals/d9/75/10/d97510a5ba492a51b9f30c8cadeeb442.png";
                                tr = "<tr><td><div class = \"content\">" +
                                "<object><a href = '" + img + "'><div class = \"imgdiv\" style=\"background-image: url(" + img + ")\"></div></a></object>" +
                                "<div class = \"title\" ><b>" +
                                "Welcome to Technology. Purpose of this board is to discuss current technologies and current projects" +
                                "</b></div>" + "</div></td></tr>";
                                break;
                                
                            case "Art":
                                img = "https://www.freeiconspng.com/uploads/art-icon-png-artwork-page-coming-soon--1.png";
                                tr = "<tr><td><div class = \"content\">" +
                                "<object><a href = '" + img + "'><div class = \"imgdiv\" style=\"background-image: url(" + img + ")\"></div></a></object>" +
                                "<div class = \"title\" ><b>" +
                                "Welcome to Art! share links to pictures of your art or give feedback to others!" +
                                "</b></div>" + "</div></td></tr>";
                                break;
                            
                            case "Music":
                                img = "https://cdn1.iconfinder.com/data/icons/google_jfk_icons_by_carlosjj/512/music.png";
                                tr = "<tr><td><div class = \"content\">" +
                                "<object><a href = '" + img + "'><div class = \"imgdiv\" style=\"background-image: url(" + img + ")\"></div></a></object>" +
                                "<div class = \"title\" ><b>" +
                                "Welcome to Music. You can discuss your favourite bands and other related music topics" +
                                "</b></div>" + "</div></td></tr>";
                                break;
                            
                            
                        }
                        $('#tintro').append(tr);
            }
            function getUrlVars() {
                var vars = {};
                var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (m, key, value) {
                    vars[key] = value;
                });
                return vars;
            }
            function loadComments() {
                $.ajax({
                    url: 'api/posts',
                    type: 'get',
                    dataType: 'json',
                    success: function (data) {
                        var post = getUrlVars()["post"];
                        var board = decodeURI(getUrlVars()["board"]);
                        document.getElementById("boardName").innerHTML = board;
                        let thisPage = "boardTemplate.html?board=" + board;
                        $('#replyBox').attr('action', thisPage);
                        $('#tdata').empty();
                        $.each(data, function (i, r) {
//                            if (r.title !== undefined) {
//                                console.log(r.board);
                                if((r.board == board)&&(r.post!=undefined)){
                                    var tr = "<tr><td><a href = \"postTemplate.html?post="+r.post  + "&board=" + r.board + "&title=" + r.title + "&deez=nutz\"><div class = \"content\">" +
                                            "<object><a href = '" + r.image + "'><div class = \"imgdiv\" style=\"background-image: url(" + r.image + ")\"></div></a></object>" +
                                            "<div class = \"title\" ><b>" +
                                            r.title +
                                            "</b></div>" + "</div></a></td></tr>";
                                    $('#tdata').append(tr);
                                
                            }
                        });
                    },
                    error: function () {
//                        alert('Error');
                    }
                });
            }


            $(document).ready(function () {
                loadComments();
            });

            document.getElementById("buttonReply").onclick = function () {
                hideCommentBox();
            };
            function hideCommentBox() {
                var x = document.getElementById("replyBox");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
            }
            $('#buttonPost').click(function () {
                var board = decodeURI(getUrlVars()["board"]);
                
                var img = $("#image").val();
                if (img === ""){
                    img = "sampleLogo.png";
                }
                 var title = $("#title").val();
                var comment = $('#comment').val();
                var board = board;
                if ( comment.length === 0 || title.length === 0) {
                    return;
                }
                var data = JSON.stringify({
                   
                    image: img,
                    comment: comment,
                    board: board,
                    title: title
                });
                $.ajax({
                    url: 'api/posts', 
                    type: 'post',
                    data: data,
                    contentType: 'application/json',
                    dataType: 'text',
                    success: function (resp) {
                        loadComments();
                        window.location.reload();
                    },
                    error: function () {
                        
                    }
                });

                return false;
            });
