/*<![CDATA[*/
$(function () {
    var offset = $("#trade-block").offset();
    var topPadding = 15;
    $(window).scroll(function () {
        if ($(window).scrollTop() > offset.top && $(document).width() > 991) {
            $("#trade-block").stop().animate({
                marginTop: $(window).scrollTop() - offset.top + topPadding
            });
        } else {
            $("#trade-block").stop().animate({
                marginTop: 0
            });
        }
    });
});
/*]]>*/