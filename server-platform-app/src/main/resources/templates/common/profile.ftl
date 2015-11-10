<#import "../tags.ftl" as tags>
<#macro show>
<li class="nav-header" style="height: 139px;">
    <@tags.shiro.user>
        <div class="dropdown profile-element">
        <span>
            <img alt="image" class="img-circle" src="img/profile_small.jpg"/>
         </span>
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
            <span class="clear"> <span class="block m-t-xs">
                <strong class="font-bold"><@tags.shiro.principal ></@tags.shiro.principal></strong>

            </span>
            </a>
        </div>
    </@tags.shiro.user>
    <div class="logo-element">
        菜+
    </div>
</li>
</#macro>