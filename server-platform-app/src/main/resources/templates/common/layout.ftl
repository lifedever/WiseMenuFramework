<#import "../tags.ftl" as tags>
<#macro main title="">
<!DOCTYPE html>
<html>
    <@tags.header.show title="${title}"/>
<body class="">
<div id="wrapper">
    <@tags.sidebar.show/>
<div id="page-wrapper" class="gray-bg">

    <div class="row border-bottom">
        <@tags.navTop.show />
    </div>

    <#nested>
    <@tags.footer.show/>
</#macro>
