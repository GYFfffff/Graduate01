/**
 * Created by GYF on 2017/1/19.
 */
$(function() {
    $('.pgwMenu').pgwMenu({
        dropDownLabel: '菜单',
        viewMoreLabel: '更多<span class="icon"></span>'
    });

    $('.pgwMenuCustom').pgwMenu({
        mainClassName: 'pgwMenuCustom',
        dropDownLabel: '菜单',
        viewMoreLabel: '更多<span class="icon"></span>'
    });
    /*//筛选
    $("#screenLi").mouseover(function () {
        $(".screenItem").toggle();
    });
    $("#screenLi").mouseout(function () {
        $(".screenItem").toggle();
    });*/ 
    $(".screenCss").mouseover(function () {
        // $(".screenItem").toggle();
        $(this).find(".screenItem").toggle();
        $(this).find("li:first").css("background","#242529");
    });

    $(".screenCss").mouseout(function () {
        // $(".screenItem").toggle();
        $(this).find(".screenItem").toggle();
        $(this).find("li:first").css("background","#333");
    });
    
    $(".screenType").click(function () {
        $(this).siblings().css("background","#242529");
        $(this).css("background","#000000");
    });
    
});

$(document).ready(function(){
    $(".pgwMenuCustom li").hover(function(){
        $(this).find("ul").slideDown("slow");
    },function(){
        $(this).find("ul").slideUp("fast");
    });
});