!function() {

    page({
        box:'page',//存放分页的容器
        href:'#?page=',//跳转连接
        page:10,//当前页码
        count:30,//总页数
        num:5,//页面展示的页码个数
    })
}