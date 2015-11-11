<#import "../tags.ftl" as tags>
<#macro show>
<#if Session['io.github.gefangshuai.server.constant.session.RestaurantKey'].imagePath??>
    <#assign shopImage="/account/load/shopImage/${Session['io.github.gefangshuai.server.constant.session.RestaurantKey'].id}"/>
<#else>
    <#assign shopImage="/img/profile_big.jpg"/>
</#if>
<li class="nav-header" style="height: 180px;">
    <@tags.shiro.user>
        <div class="profile-element text-center">
            <span>
                <img alt="image" class="img-circle" src="${shopImage}"/>
            </span>
            <a class="dropdown-toggle" href="#" id="profileName">
                <span class="block m-t-xs">
                    <strong class="font-bold">${Session['io.github.gefangshuai.server.constant.session.RestaurantKey'].name!}</strong>
                </span>
            </a>
        </div>
    </@tags.shiro.user>
    <div class="logo-element">
        智+
    </div>
</li>
</#macro>