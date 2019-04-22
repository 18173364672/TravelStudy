$(function(){

    var urls = [];
    $("[role_module_href]").each(function(){
        var url = $(this).attr("url");
        urls.push(url);
    });

    $.ajax({
        url:"checkUrls",
        dataType:"json",
        type:"post",
        data:{
            urls:urls+""
        },
        success:function(data){
            $.each(data,function(){
                $("[url='"+this.url+"']").remove();
            });
        }
    });


})




