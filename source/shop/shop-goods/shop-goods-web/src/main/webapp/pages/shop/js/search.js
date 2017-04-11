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
            $("#main_form input[name='goodsSearchName']").autocomplete({
                minLength: 1,
                source: function(request, response) {
                    common.sendAjax({
                        "url": root + '/goods/queryByName.ajax',
                        "data": {"goodsSearchName" : request.term},
                        "success": function(resp) {
                            response($.map(resp.data, function( item ) {
                                return {
                                    label: item.goodsName + (item.price ? "(" + item.price + "元/斤)" : ""),
                                    value: item.goodsName
                                }
                            }));
                        }
                    });
                }
            });
        }
    };
});
