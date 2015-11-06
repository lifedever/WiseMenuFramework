<#import "profile.ftl" as profile>
<#import "../lib/shiro.ftl" as shiro>
<#macro show>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <@profile.show></@profile.show>
            <li>
                <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Dashboards</span> <span
                        class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="index.html">Dashboard v.1</a></li>
                    <li><a href="dashboard_2.html">Dashboard v.2</a></li>
                    <li><a href="dashboard_3.html">Dashboard v.3</a></li>
                    <li><a href="dashboard_4_1.html">Dashboard v.4</a></li>
                    <li><a href="dashboard_5.html">Dashboard v.5 <span
                            class="label label-primary pull-right">NEW</span></a></li>
                </ul>
            </li>
            <li>
                <a href="/users"><i class="fa fa-diamond"></i> <span class="nav-label">Layouts</span></a>
            </li>
            <@shiro.hasRole role="admin">
                <li>
                    <a href="/admin/users">admin-users</a>
                </li>
            </@shiro.hasRole>
        </ul>

    </div>
</nav>
</#macro>