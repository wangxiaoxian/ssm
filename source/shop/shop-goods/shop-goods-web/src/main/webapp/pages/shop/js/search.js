define(function (require, exports, module) {
    var common = require("../../common/common");
    var attachment = require("../../common/attachment");

    var _this;

    module.exports = {
        init:function() {
            _this = this;

            _this.bindAutoComplete();
        },
        bindAutoComplete : function() {
            var availableTags = [
                "ActionScript",
                "AppleScript",
                "Asp",
                "BASIC",
                "C",
                "C++",
                "Clojure",
                "COBOL",
                "ColdFusion",
                "Erlang",
                "Fortran",
                "Groovy",
                "Haskell",
                "Java",
                "JavaScript",
                "Lisp",
                "Perl",
                "PHP",
                "Python",
                "Ruby",
                "Scala",
                "Scheme"
            ];
            $("#main_form input[name='goodsSearchName']").autocomplete({
                source: root + '/goods/queryByName.ajax'
                //source: availableTags
            });
        }
    };
});
