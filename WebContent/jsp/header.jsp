<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<!--[if gt IE 8]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <![endif]-->

<title>禹慕科技综合管理平台</title>

<link href="css/stylesheets.css" rel="stylesheet" type="text/css" />
<!--[if lt IE 8]>
        <link href="css/ie7.css" rel="stylesheet" type="text/css" />
    <![endif]-->
<link rel='stylesheet' type='text/css' href='css/fullcalendar.print.css' media='print' />
<link rel='stylesheet' type='text/css' href='css/main.css' />
<link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />

</head>
<body>
	<div id="progressDialogDivId" style="display: none; position: absolute;">
		<img alt="image" src="img/icons/loading_big.gif">
	</div>
	<div id="messageDiv" style="display: none;">
		<s:actionmessage />
	</div>
	<div id="openModal" style="display: none;"></div>