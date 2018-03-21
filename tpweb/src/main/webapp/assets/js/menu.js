function handleMenu(arr,_ul) {
    $.each(arr,function(index,item) {
        var li_1 = '<li><a href="javascript:reqUrl(\''+item.url+'\','+item.id+')"><i class="'+item.icon+'"></i>'+item.name+'</a></li>';
        var li_2 = '<li><a href="#" class="dropdown-toggle"><i class="'+item.icon+'"></i><span class="menu-text">'+item.name+'</span><b class="arrow icon-angle-down"></b></a></li>';
        if(item.submenu.length > 0){
            var __ul = $('<ul class="submenu"></ul>');
            $(li_2).append(__ul).appendTo(_ul);
            handleMenu(item.submenu,__ul);
        }else{
            $(li_1).appendTo(_ul);
        }
    });
}
function reqUrl(url,id){
    $("li").removeClass("active");
    console.log(url);
    $("#li_"+id).addClass("active");
}