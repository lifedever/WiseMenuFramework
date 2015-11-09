<#import "../tags.ftl" as tags>
<#macro main title="">
<!DOCTYPE html>
<html>
    <@tags.header.show title="${title}"/>
<body class="md-skin">
<div id="wrapper">
    <@tags.sidebar.show />
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <@tags.navTop.show />
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
    <@tags.footer.show/>
</#macro>
