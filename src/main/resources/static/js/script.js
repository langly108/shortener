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
});