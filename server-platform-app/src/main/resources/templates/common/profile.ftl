<#import "../lib/shiro.ftl" as shiro>
<#macro show>
<li class="nav-header" style="height: 139px;">
    <@shiro.user>
        <div class="dropdown profile-element">
        <span>
            <img alt="image" class="img-circle" src="img/profile_small.jpg"/>
         </span>
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
            <span class="clear"> <span class="block m-t-xs">
                <strong class="font-bold"><@shiro.principal ></@shiro.principal></strong>
            </span>
            </a>
        </div>
    </@shiro.user>
    <div class="logo-element">
        菜+
    </div>
</li>
</#macro>