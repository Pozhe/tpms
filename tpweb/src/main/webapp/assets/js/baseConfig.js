require.config({
    baseUrl:'assets/js/',
    paths:{
        'ace' : 'ace.min',
        'jquery':'jquery-2.0.3.min',
        'bootstrap' : 'bootstrap.min',
        'ace-elements' : 'ace-elements.min',
        'template':'artTemplate/template-web',
        'sys' : 'menu/menu'
    },
    shim:{
        'jquery' : {
            exports : 'jquery'
        },
        'bootstrap' : {
            deps : ['jquery'],
            exports :'bootstrap'
        },
        'ace-elements' : {
            deps : ['jquery'],
            exports :'ace-elements'
        },
        'ace' : {
            deps : ['jquery','ace-elements'],
            exports :'ace'
        },
        'template' : {
            exports :'template'
        }
    }
});
require(['sys','jquery','bootstrap','ace-elements','ace'],function (sys,$) {
    sys.init();
    $(".nav").on("click",".mainMenuATag",function () {
        sys.reqUrl($(this).data("url"),$(this).data("id"));
    });
});