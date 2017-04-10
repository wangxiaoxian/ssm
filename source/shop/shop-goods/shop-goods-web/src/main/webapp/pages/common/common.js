/**
 * 组件包
 */

define(function (require, exports, module) {
    'use strict';

    if (typeof jQuery === 'undefined') {
        throw new Error('JavaScript requires jQuery');
    }

    module.exports= {
    	confirm: function(title, content, callback, yes, no) {
    		var opt = {
    			"title": title || "提示",
    			"content": content,
    			"yes": yes || "确定",
    			"no": no || "取消",
    		};
    		
    		$("#pop_win .no").show();
    		$("#pop_win .yes").text(opt.yes);
    		$("#pop_win .no").text(opt.no);
    		$("#pop_win .title").text(opt.title);
    		$("#pop_win .content").text(opt.content);
    		
    		$("#pop_win .yes").off("click");
    		$("#pop_win .no").off("click");
    		$("#pop_win .pop_close").off("click");
    		
    		$('#pop_win .pop_close').on("click", close);
    		$("#pop_win .no").on("click", function() {
    			close();
    			if(opt.callback) {
    				opt.callback(false);
    			}
    		});
    		$("#pop_win .yes").on("click", function() {
    			close();
    			if(opt.callback) {
    				opt.callback(true);
    			}
    		});
    		$('#pop_win .pop_inner').hide().show();
    		$('#pop_win').popupOpen();
    		
    		function close() {
    			$('#pop_win').hide();
    			$('#pop_win').popupClose();
    		}
    	},
    	info: function(title, content, callback, yes) {
    		var opt = {
    			"title": title || "提示",
    			"content": content,
    			"yes": yes || "确定"
    		};
    		
    		$("#pop_win .yes").text(opt.yes);
    		$("#pop_win .title").text(opt.title);
    		$("#pop_win .content").text(opt.content);
    		
    		$("#pop_win .yes").off("click");
    		$("#pop_win .pop_close").off("click");
    		
    		$('#pop_win .pop_close').on("click", close);
    		$("#pop_win .yes").on("click", function() {
    			close();
    			if(opt.callback) {
    				opt.callback();
    			}
    		});
    		$('#pop_win .pop_inner').hide().show();
    		$('#pop_win').popupOpen();
    		
    		function close() {
    			$('#pop_win').hide();
    			$('#pop_win').popupClose();
    		}
    	},
    	sendAjax: function(custOpt) {
    		var opt = {
				"type": "POST",
				"dataType":"json",
    		};
    		$.extend(opt, custOpt);
    		$.ajax(opt);
    	},
    	serializeObject: function (obj) {
            $.fn.serializeJson = function () {
                var serializeObj = {};
                var array = this.serializeArray();
                $(array).each(function () {
                    if (serializeObj[this.name]) {
                        if ($.isArray(serializeObj[this.name])) {
                            serializeObj[this.name].push(this.value);
                        } else {
                            serializeObj[this.name] = [serializeObj[this.name], this.value];
                        }
                    } else {
                        serializeObj[this.name] = this.value;
                    }
                });
                return serializeObj;
            };
            return obj.serializeJson();
        },
		wrapData2Form: function (data, seletor) {
			if (!data) {
				return;
			}
			for (var attr in data) {
				$(seletor + " [name='" + attr + "']").val(data[attr]);
			}
		},

        /* ========================================================================
         * getUrlVal
         * 获取url传递的参数
         * http://www.XXXX.com?{name}="123"&{name}="123123"
         * ======================================================================== */
        getUrlParam:function(name){
            var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if(r!=null)return decodeURIComponent(r[2]); return null;
        }
    };
});
