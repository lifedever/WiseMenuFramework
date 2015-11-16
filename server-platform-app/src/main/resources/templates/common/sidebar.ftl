<#import "../tags.ftl" as tags>
<#macro show>
<nav class="navbar-default navbar-static-side" role="navigation">

    <@tags.shiro.hasRole role="administrator">
        <#include "menu/menu-admin.ftl"/>
    </@tags.shiro.hasRole>
        <@tags.shiro.hasRole role="restaurant">
    <#include "menu/menu-restaurant.ftl"/>
</@tags.shiro.hasRole>
</nav>
</#macro>