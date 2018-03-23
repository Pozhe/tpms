define(function (require,exports,module) {
    var $ = require("jquery");
    var template = require("template");
    var baseUrl;
    var init = function () {
        $.ajax({
            method: "GET",
            url: "/tpms/menu",
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            success: function (data) {
                console.log(data);
                baseUrl = data.basePath;
                handleMenu(data.list, $(".nav"));
            },
            error: function (e) {
                console.log(e);
            }
        });
    };
    var handleMenu = function (arr,_ul) {
        $.each(arr, function (index, item) {
            var li_1 = '<li id="li_' + item.id + '"><a class="mainMenuATag" href="javascript:void(0);" data-url="'+item.url+'" data-id="'+item.id+'"><i class="' + item.icon + '"></i>' + item.name + '</a></li>';
            var li_2 = '<li><a href="#" class="dropdown-toggle"><i class="' + item.icon + '"></i><span class="menu-text">' + item.name + '</span><b class="arrow icon-angle-down"></b></a></li>';
            if (item.submenu.length > 0) {
                var __ul = $('<ul class="submenu"></ul>');
                $(li_2).append(__ul).appendTo(_ul);
                handleMenu(item.submenu, __ul);
            } else {
                $(li_1).appendTo(_ul);
            }
        });
    };
    var reqUrl = function (url, id) {
        $("li").removeClass("active");
        $("#li_" + id).addClass("active");
        $.ajax({
            method: "GET",
            url: url,
            success: function (data) {
                $("#fillContent").html(data);
            },
            error: function (e) {
                console.log(e);
            }
        });
    };
    module.exports = {
        init : init,
        handleMenu : handleMenu,
        reqUrl : reqUrl,
        baseUrl : baseUrl
    };
});