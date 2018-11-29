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
    hideCommentBox()
};
function hideCommentBox() {
    var x = document.getElementById("commentBox");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}