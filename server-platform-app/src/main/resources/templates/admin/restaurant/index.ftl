<#import "../../tags.ftl" as tags>
<@tags.layout.main title="店铺列表">
<div class="ibox">
    <div class="ibox-title">
        <h3>所有店铺列表</h3>
    </div>
    <div class="ibox-content">
        <div class="row m-b-sm m-t-sm">
            <div class="col-md-8"></div>
            <div class="col-md-4">
                <div class="input-group">
                    <input type="text" placeholder="Search" class="input-sm form-control">
                    <span class="input-group-btn">
                        <button type="button" class="btn btn-sm btn-primary"> Go!</button>
                    </span>
                </div>
            </div>
        </div>

        <div class="project-list">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th width="60">&nbsp;</th>
                    <th>状态</th>
                    <th>名称</th>
                    <th>配额</th>
                    <th>详情</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <#list restaurants as rtat>
                        <#if rtat.imagePath??>
                            <#assign shopImage="/account/load/shopImage/${rtat.id}"/>
                        <#else>
                            <#assign shopImage="/img/profile_big.jpg"/>
                        </#if>
                        <#if rtat.status?? && rtat.status == 'VALID'>
                            <#assign status=true>
                        <#else>
                            <#assign status=false>
                        </#if>
                    <tr>
                        <td class="project-image">
                            <img alt="image" class="img-circle" src="${shopImage}">
                        </td>
                        <td class="project-status">
                            <#if status>
                                <span class="label label-primary">Active</span>
                            <#else>
                                <span class="label label-default">Unactive</span>
                            </#if>

                        </td>
                        <td class="project-title">
                            <a href="#">${rtat.name?default('<span class="text-danger">信息尚未完善!</span>')}</a>
                            <br>
                            <small>注册日期 ${rtat.createdTime?string('yyyy.MM.dd')}</small>
                            <br>
                            <small></small>
                        </td>
                        <td class="project-completion">
                            <small>剩余有效订单数: 48</small>
                            <div class="progress progress-mini">
                                <div style="width: 48%;" class="progress-bar"></div>
                            </div>
                        </td>
                        <td class="project-people">
                        ${rtat.memo!}
                        </td>
                        <td class="project-actions">
                            <#if status>
                                <a href="#" class="btn btn-warning btn-sm"><i class="fa fa-ban"></i> 禁用 </a>
                            <#else>
                                <a href="#" class="btn btn-primary btn-sm"><i class="fa fa-ban"></i> 启用 </a>
                                <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i> 删除 </a>
                            </#if>
                        </td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</@tags.layout.main>