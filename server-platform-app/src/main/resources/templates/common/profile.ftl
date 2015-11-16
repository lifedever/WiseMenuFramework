<#import "../tags.ftl" as tags>
<#macro show>
<#if Session['session_key_restaurant'].imagePath??>
    <#assign shopImage="/account/load/shopImage/${Session['session_key_restaurant'].id}"/>
<#else>
    <#assign shopImage="/img/profile_big.jpg"/>
</#if>
<li class="nav-header" style="height: 155px;">
    <@tags.shiro.user>
        <div class="profile-element text-center">
            <span>
                <img alt="image" class="img-circle" src="${shopImage}"/>
            </span>
            <a class="dropdown-toggle" id="profileName">
                <span class="block m-t-xs">
                    <strong class="font-bold">${Session['session_key_restaurant'].name!}</strong>
                </span>
            </a>
        </div>
    </@tags.shiro.user>
    <div class="logo-element">
        智+
    </div>
</li>
</#macro>