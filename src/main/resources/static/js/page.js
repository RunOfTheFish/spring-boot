page({
    box:'page',//存放分页的容器
    href:'?current=',//跳转连接
    page:$('#page').attr('current'),//当前页码
    count: $('#page').attr('pages'),//总页数
    num:5,//页面展示的页码个数
})
