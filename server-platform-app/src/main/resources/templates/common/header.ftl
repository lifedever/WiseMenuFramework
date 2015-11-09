<#import "../tags.ftl" as tags>

<#macro show title="">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title><@tags.spring.message code="app.title"/> </title>
    <@tags.static.css />
</head>
</#macro>