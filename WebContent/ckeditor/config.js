﻿/*
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	config.toolbar = 'Full';
	config.filebrowserBrowseUrl = 'ckfinder/ckfinder.html';  
	config.filebrowserImageBrowseUrl = 'ckfinder/ckfinder.html?type=Images';  
	config.filebrowserFlashBrowseUrl = 'ckfinder/ckfinder.html?type=Flash';  
	config.filebrowserUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';  
	config.filebrowserImageUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images';  
	config.filebrowserFlashUploadUrl = 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash';  
	// config.filebrowserWindowWidth = '1000';  
	// config.filebrowserWindowHeight = '700';  
	   config.language = 'zh-cn';  
	   config.image_previewText = '预览图片的位置！ 自己修改！！ ';
};
