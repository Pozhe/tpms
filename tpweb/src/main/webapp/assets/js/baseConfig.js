require.config({
    baseUrl:'assets/js/',
    paths:{
        'ace' : 'ace.min',
        'sys' : 'menu/menu',
        'jquery':'jquery-2.0.3.min',
        'bootstrap' : 'bootstrap.min',
        'ace-elements' : 'ace-elements.min',
        'template':'artTemplate/template-web',
        'jquery_dataTables':'jquery.dataTables.min',
        'jquery_dataTables_bootstrap':'jquery.dataTables.bootstrap',
        'zTree':'zTree_v3/js/jquery.ztree.core',
        'zTree_excheck':'zTree_v3/js/jquery.ztree.excheck'
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
        },
        'jquery_dataTables' : {
            deps : ['jquery'],
            exports :'jquery_dataTables'
        },
        'jquery_dataTables_bootstrap' : {
            deps : ['jquery','bootstrap','jquery_dataTables'],
            exports :'jquery_dataTables_bootstrap'
        },
        'zTree' : {
            deps : ['jquery'],
            exports :'zTree'
        },
        'zTree_excheck' : {
            deps : ['jquery','zTree'],
            exports :'zTree_excheck'
        }
    }
});
require(['sys','jquery','bootstrap','ace-elements','ace'],function (sys,$) {
    sys.init();
    $(".nav").on("click",".mainMenuATag",function () {
        sys.reqUrl($(this).data("url"),$(this).data("id"));
    });
});