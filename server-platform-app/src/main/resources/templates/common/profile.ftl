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
                <#if !Session['session_key_restaurant'].opening>
                    <div id="profile-open-status" class="badge badge-danger" title="线上整顿中" style="position: absolute; margin-left: -10px; cursor: pointer;">停</div>
                <#else>
                    <div class="label label-primary" style="position: absolute; margin-left: -3px;">营业中</div>
                </#if>
            </span>
            <div class="pad10-tb">
                <a class="dropdown-toggle" id="profileName">
                <span class="block m-t-xs">
                    <strong class="font-bold">${Session['session_key_restaurant'].name!}</strong>
                </span>
                </a>
            </div>
        </div>
    </@tags.shiro.user>
    <div class="logo-element">
        智+
    </div>
</li>
</#macro>