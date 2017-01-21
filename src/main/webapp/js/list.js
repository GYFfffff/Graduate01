/**
 * Created by GYF on 2017/1/15.
 */
$(function () {
    var isLoadList=false;   //是否已发送加载主题的请求
    //var menuH=$(".pgwMenu").offset().top;     //获取导航条到顶部的距离
    $(window).scroll(function () {

        var scroH=$(this).scrollTop();    //滚动条滑动距离
        var documentHeight=$(document).height();  //页面文档的高度
        var windowHeight=$(window).height();    //浏览器显示区域的高度

        //将导航条固定在页面顶部
        //滚动条滑动大于等于定位元素距离浏览器顶部的距离，就固定，反之就不固定
        /*if(scroH>=menuH){
            console.log($(".pgwMenu"));
            $(".pgwMenu").css({ "position": "fixed", "top": 0 });
        }else {
            $(".pgwMenu").css({ "position": "static"});
        }*/
        //瀑布流实现
        //滚动条即将到页面底部并且还未发送请求时
        if(scroH+windowHeight>documentHeight-30 && (!isLoadList)){
            isLoadList=true;
            //下一页页数
            var currentPage=parseInt($("#currentPage").val())+1;
            var sendData={'qo.currentPage':currentPage};
            $.ajax({
                type:"GET",
                url:"/invitation_getListWithJson.action",
                data:sendData,
                dataType:"json",
                beforeSend:function () {
                    /*var div="<div id='lodding' class='related' style='font-size: 40px; font-family: 微软雅黑'>" +
                        "<h4>数据加载中....</h4></div>";
                    $(div).insertBefore(".related");*/
                    //发送请求前显示加载数据的元素
                    $("#lodding").toggle();
                },
                success:function (msg) {
                    console.log(msg);
                    if(msg.length>0){
                        //还能取到数据
                        $.each(msg,function (i,val) {
                            /*var tr="<li class='cd-item'><a href='item.jsp'>" +
                                "<div><h2>"+val.userName+"</h2>" +
                                "<p>"+val.content+"</p>" +
                                "<b>View More</b></div></a></li>";*/
                            //克隆模板节点，这样才能拥有默认的点击事件
                            var tr=$("#listMode").clone(true);
                            //此时地址无法使用s标签动态生成，迁移项目时需注意
                            tr.find("a").prop("href","/invitation_getItemById.action?invitation.id="+val.id+"");
                            tr.find("h2").text(val.userName);
                            tr.find("p").text(val.content);
                            tr.appendTo(".cd-gallery");
                            tr.toggle();
                            console.log(tr);
                        });
                        //修改当前页大小
                        $("#currentPage").val(currentPage);
                        $("#lodding").toggle();
                        isLoadList=false;
                    }else {
                        //已没有数据了
                        var div="<div id='lodding' class='related' style='font-size: 40px; font-family: 微软雅黑'>" +
                            "<h4>最后一页</h4></div>";
                        $("#lodding").remove();
                        $(div).insertBefore(".related");
                    }
                },
                error:function (msg) {
                    var div="<div id='lodding' class='related' style='font-size: 40px; font-family: 微软雅黑'>" +
                        "<h4>服务器繁忙</h4></div>";
                    $("#lodding").remove();
                    $(div).insertBefore(".related");
                }
            })
        }
    });
});
/*
var isLoadList=false;   //是否已加载主题
$(window).scroll(function () {
    //瀑布流
    var top=$(this).scrollTop();    //滚动高度
    var documentHeight=$(document).height();  //页面文档的高度
    var windowHeight=$(window).height();    //浏览器显示区域的高度
    if(top+windowHeight>documentHeight-30 && (!isLoadList)){
        isLoadList=true;
        //下一页页数
        var currentPage=parseInt($("#currentPage").val())+1;
        var sendData={'qo.currentPage':currentPage};
        $.ajax({
            type:"GET",
            url:"/invitation_getListWithJson.action",
            data:sendData,
            dataType:"json",
            beforeSend:function () {
                var div="<div id='lodding' class='related' style='font-size: 40px; font-family: 微软雅黑'>" +
                    "<h4>数据加载中....</h4></div>";
                $(div).insertBefore(".related");
            },
            success:function (msg) {
                console.log(msg);
                if(msg.length>0){
                    //还能取到数据
                    $.each(msg,function (i,val) {
                        var tr="<li class='cd-item'><a href='item.jsp'>" +
                        "<div><h2><s:property value='user.userName'/></h2>" +
                        "<p>"+val.content+"</p>" +
                        "<b>View More</b></div></a></li>";
                        $(tr).appendTo(".cd-gallery");
                    });
                    //修改当前页大小
                    $("#currentPage").val(currentPage);
                    $("#lodding").remove();
                    isLoadList=false;
                }else {
                    //已没有数据了
                    var div="<div id='lodding' class='related' style='font-size: 40px; font-family: 微软雅黑'>" +
                        "<h4>最后一页</h4></div>";
                    $("#lodding").remove();
                    $(div).insertBefore(".related");
                }
            },
            error:function (msg) {
                var div="<div id='lodding' class='related' style='font-size: 40px; font-family: 微软雅黑'>" +
                    "<h4>服务器繁忙</h4></div>";
                $("#lodding").remove();
                $(div).insertBefore(".related");
            }
        })
    }
});*/
