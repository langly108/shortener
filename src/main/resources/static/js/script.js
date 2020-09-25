function shortenUrl() {
    let longUrl = $("#long_url").val();
    $.ajax({
        url: "/shorturl",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        method: "POST",
        data: JSON.stringify({
            "longUrl": longUrl
        })
    })
        .done(function (data) {
            console.log(data);
            $(".result").css("display","");
            $("#text_result").val(data.shortUrl);
        }).fail(function (data) {
            alert(data);
    });
}

$(document).ready(function () {
    $("#process_btn").click(function () {
        shortenUrl();
    });

    $("#basic-addon2").click(function(){
       let copyText = $("#text_result");
       copyText.select();
       document.execCommand("copy");
        if (window.getSelection) {
            if (window.getSelection().empty) {  // Chrome
                window.getSelection().empty();
            } else if (window.getSelection().removeAllRanges) {  // Firefox
                window.getSelection().removeAllRanges();
            }
        } else if (document.selection) {  // IE?
            document.selection.empty();
        }
    });
});