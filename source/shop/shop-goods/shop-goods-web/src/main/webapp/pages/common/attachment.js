/**
 * 组件包
 */

define(function (require, exports, module) {
    'use strict';

    if (typeof jQuery === 'undefined') {
        throw new Error('JavaScript requires jQuery');
    }

    module.exports = {
		showAttachInfo: function(container, formField, attach, up) {
			//设置表单的隐藏域的值和上传组件的参数
			var formFieldVal = $("#" + formField).val();
			if(!formFieldVal) {
				$("#" + formField).val(attach.attachGroupId);
			}
			if(up) {
				up.setOption("multipart_params", {
					"attachGroupId": attach.attachGroupId
				});
			}
			
			//显示附件信息和删除按钮
			var ele = $("#" + container);
        	var content = "<span><a data-attachfileid='"+attach.attachFileId+"' href='" + root + "/attachment/view.ajax?attachFileId=" + attach.attachFileId + "' target='_blank'>"+ attach.fileName +"</a> ";
        	content += "<a class='del' data-attachfileid='"+attach.attachFileId+"' href='javascript:void(0);' style='color:red;'>删除</a><br/></span>";
        	ele.append(content);
        	ele.find(".del").on("click", function(event) {
        		var id = event.currentTarget.dataset.attachfileid;
        		$(this).parent().remove();
            	$.ajax({
    				"url": root + "/bmm/calltestwork/attachment/del.ajax?attachFileId=" + id
    			});
        	});
        },
        upload: function(uploadUrl, params, elements, custFilter, success) {
        	var filter = {
    			maxSize : "10mb",
        		ext: ""
            };
        	$.extend(filter, custFilter);
        	
        	var uploader = new plupload.Uploader({
        	    runtimes : 'html5,flash,silverlight,html4',
        	    browse_button : elements.button,
        	    url : uploadUrl,
        	    filters : {
        	        max_file_size : filter.maxSize,
        	        mime_types: [
        	            {title : "请选择附件", extensions : filter.ext}
        	        ]
        	    },
        	    multipart_params : params,
        	    flash_swf_url : root + 'js/plugin/plupload/js/Moxie.swf',
        	    silverlight_xap_url : root + 'js/plugin/plupload/js/Moxie.xap',
        	    init: {
        	        FilesAdded: function(up, files) {
        	        	showMsg("导入中,请稍后");
        	        	uploader.start();
        	        },
        	        FileUploaded: function(up, file, result) {
        	        	hideMsg();
        	        	var resp = JSON.parse(result.response);
        	        	if(resp.code == 200) {
        	        		var attach = resp.data;
        	        		if(elements.container) {
        	        			module.exports.showAttachInfo(elements.container, elements.formField, attach, up);
        	        		}
        	        	} else {
        	        		console.error("上传失败");
        	        	}
        	        	if(success) {
        	        		success(up, file, result);
        	        	}
        	        },
        	        Error: function(up, error) {
        	        	if(error.code == -600) {
        	        		$.messager.alert(error.message, "导入失败，文件大小超过上限值" + up.settings.filters.max_file_size, "error");
        	        	}
        	        }
        	    }
        	});
        	uploader.init();
        },
    	
    	/**
    	 * 上传之后的界面操作
    	 * @param up
    	 * @param selector
    	 * @param valSel
    	 * @param fileId
    	 * @param fileName
    	 */
		afterUpload: function(selector, fileId, fileName) {
        	var ele = $(selector);
//        	ele.find("button").hide();
//        	ele.find(".moxie-shim-html5").hide();
        	var content = "<span><a data-attachfileid='"+fileId+"' href='" + root + "/attachment/view.ajax?attachFileId=" + fileId + "' target='_blank'>"+ fileName +"</a> ";
        	content += "<a class='del' data-attachfileid='"+fileId+"' href='javascript:void(0);' style='color:red;'>删除</a><br/></span>";
        	ele.append(content);
        	ele.find(".del").on("click", function(event) {
        		var id = event.currentTarget.dataset.attachfileid;
        		$(this).parent().remove();
//        		ele.find("button").show();
//            	ele.find(".moxie-shim-html5").show();
            	$.ajax({
    				"url": root + "/bmm/calltestwork/attachment/del.ajax?attachFileId=" + id
    			});
        	});
        },
        /**
         * 上传组件
         * @param uploadUrl
         * @param elementId
         * @param success
         */
        attachmentCommon : function(uploadUrl, params, ext, elementId, success, maxSize) {
        	if(!maxSize) {
        		maxSize = "10mb";
        	}
        	var uploader = new plupload.Uploader({
        	    runtimes : 'html5,flash,silverlight,html4',
        	    browse_button : elementId, // you can pass in id...
        	    url : uploadUrl,
        	    filters : {
        	        max_file_size : maxSize,
        	        mime_types: [
        	            {title : "图片文件", extensions : ext}
        	        ]
        	    },
        	    multipart_params : params,
        	    flash_swf_url : root + 'js/plugin/plupload/js/Moxie.swf',
        	    silverlight_xap_url : root + 'js/plugin/plupload/js/Moxie.xap',
        	    init: {
        	        FilesAdded: function(up, files) {
        	        	uploader.start();
        	        },
        	        FileUploaded: success
        	    }
        	});
        	uploader.init();
        }
    };
});
