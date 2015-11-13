<#import "../tags.ftl" as tags>
<#macro show>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <@tags.profile.show />
            <#if menus_context??>
                <#list menus_context as menu>
                    <#if menu.subMenus?exists>
                        <li>
                            <a href="${menu.url}">
                                <i class="${menu.icon}"></i>
                                <span class="nav-label">${menu.title}</span>
                                <span class="fa arrow"></span>
                            </a>
                            <ul class="nav nav-second-level collapse">
                                <#list menu.subMenus as sm>
                                    <li><a href="${sm.url}">${sm.title}</a></li>
                                </#list>
                            </ul>
                        </li>
                    <#else>
                        <li <#if menu.flag == nav_menu>class="active" </#if>>
                            <a href="${menu.url}"><i class="${menu.icon}"></i> <span
                                    class="nav-label">${menu.title}</span></a>
                        </li>
                    </#if>
                </#list>
            </#if>
            <@tags.shiro.hasRole role="admin">
                <li>
                    <a href="/admin/users">admin-users</a>
                </li>
            </@tags.shiro.hasRole>
        </ul>

    </div>
</nav>
</#macro>