
function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function (m, key, value) {
        vars[key] = value;
    });
    return vars;
}
function loadComments() {
    $.ajax({
        url: 'api/comments',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            var post = getUrlVars()["post"];
            var title = decodeURI(getUrlVars()["title"]);
            var board = decodeURI(getUrlVars()["board"]);
            document.getElementById("title").innerHTML = board + "/" + title ;
            $('#tdata').empty();
            $.each(data, function (i, r) {
                if ((r.title==title)) {
                    var tr = "<tr><td><div class = \"content\">" +
                            "<object><a href = '" + r.image + "'><div class = \"imgdiv\" style=\"background-image: url(" + r.image + ")\"></div></a></object>" +
                            "<div class = \"title\" >" +
                            r.comment +
                            "</div>" + "</div></td></tr>";
                    $('#tdata').append(tr);
                } else {

                }
            });
        },
        error: function () {
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
      var title = decodeURI(getUrlVars()["title"]);
     var board = decodeURI(getUrlVars()["board"]);
    var img = $("#image").val();
    if (img === ""){
        img = "sampleLogo.png";
    }

    var comment = $('#comment').val();

    if ( comment.length === 0 ) {
        return;
    }
    var data = JSON.stringify({
        image: img,
        comment: comment,
        board: board,
        title:title

    });
    $.ajax({
        url: 'api/comments', //this will work whenever we have only one table :)
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

