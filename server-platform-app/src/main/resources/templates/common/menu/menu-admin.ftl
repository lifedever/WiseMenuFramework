<#import "../../tags.ftl" as tags>
<div class="sidebar-collapse">
    <ul class="nav metismenu" id="side-menu">
        <li class="nav-header" style="height: 155px;">
        <@tags.shiro.user>
            <div class="profile-element text-center">
                <h1 class=" text-white">极智菜单</h1>

                <h2 class=" text-white">管理中心</h2>

                <small id="currentDate">
                    <script>
                        Date.prototype.format = function (format) {
                            var o = {
                                "M+": this.getMonth() + 1, //month
                                "d+": this.getDate(),    //day
                                "h+": this.getHours(),   //hour
                                "m+": this.getMinutes(), //minute
                                "s+": this.getSeconds(), //second
                                "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
                                "S": this.getMilliseconds() //millisecond
                            };
                            if (/(y+)/.test(format))
                                format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
                            for (var k in o)
                                if (new RegExp("(" + k + ")").test(format))
                                    format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
                            return format;
                        };

                        var ddd = new Date();
                        document.write (ddd.format('日期：yyyy-MM-dd'));
                    </script>
                </small>
            </div>
        </@tags.shiro.user>
            <div class="logo-element">
                智+
            </div>
        </li>
        <li <#if !nav_menu?exists || nav_menu == 'index'>class="active" </#if>>
            <a href="/"><i class="fa fa-th-large"></i> <span class="nav-label">首页</span></a>
        </li>
        <li <#if nav_menu?? && nav_menu?starts_with('admin-restaurants')>class="active" </#if> >
            <a href="/admin/restaurants"><i class="fa fa-home"></i> 店铺列表</a>
        </li>
        <li <#if nav_menu?? && nav_menu?starts_with('admin-settings')>class="active" </#if> >
            <a href="/admin/settings"><i class="fa fa-gears"></i> 系统设定</a>
        </li>
        <li>
            <a href="/admin/logs"><i class="fa fa-newspaper-o"></i> 系统日志</a>
        </li>
    </ul>

</div>