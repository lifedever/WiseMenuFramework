<#import "header.ftl" as header>
<#import "footer.ftl" as footer>
<#import "sidebar.ftl" as side>
<#import "navTop.ftl" as navTop>
<#import "../lib/shiro.ftl" as shiro>
<#import "/spring.ftl" as spring>
<#macro main title>
<!DOCTYPE html>
<html>
    <@header.show title="${appSettings.title}"/>
<body class="md-skin">

<div id="wrapper">
<@side.show />
<div id="page-wrapper" class="gray-bg">
    <div class="row border-bottom">
        <@navTop.show></@navTop.show>
    </div>
    <div class="row wrapper border-bottom white-bg page-heading">
        <#nested />
    </div>

    <div class="wrapper wrapper-content">
        <div class="middle-box text-center animated fadeInRightBig">
            <h3 class="font-bold">This is page content</h3>

            <div class="error-desc">
                You can create here any grid layout you want. And any variation layout you imagine:) Check out
                main dashboard and other site. It use many different layout.
                <br/><a href="index.html" class="btn btn-primary m-t">Dashboard</a>
            </div>
        </div>
    </div>
    <@footer.show/>

</#macro>
