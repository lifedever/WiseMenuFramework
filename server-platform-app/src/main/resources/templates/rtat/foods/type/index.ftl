<#import "../../../tags.ftl" as tags>
<#assign css>
<style>

</style>
</#assign>
<#assign javascript>
<script>
    var targetId;
    var srcId;
    function dragStart(ev) {
        ev.dataTransfer.effectAllowed = 'move';
        srcId = ev.target.getAttribute('data-id');
        return true;
    }

    function dragEnter(event) {
        event.preventDefault();
        return false;
    }
    function dragOver(e) {
        var t = $(e.target);
        var $tar;
        if (t.hasClass('col-md-4')) {
            targetId = t.data('id');
            $tar = t;
        } else {
            $tar = t.closest('.col-md-4');
            targetId = $tar.data('id');
        }
        if (targetId == srcId)
            return true;
        $('div.ibox').removeClass('active');
        $tar.find('div.ibox').addClass('active');
        return false;
    }
    function dragDrop(ev) {
        ev.stopPropagation();
        location.href = "/rtat/foods/type/order/" + srcId + '-' + targetId;
        return false;
    }

</script>
</#assign>
<@tags.layout.main title="菜品分类列表" css=css javascript=javascript>
<div class="wrapper wrapper-content ">
    <div class="ibox-content m-b-sm border-bottom">
        <div class="row">
            <div class="col-md-12">
                <form role="form" class="form-inline" action="/rtat/foods/type/save" method="post">
                    <label>
                        添加新分类:
                    </label>

                    <div class="form-group">
                        <input type="text" id="name" name="name" class="form-control" placeholder="输入分类名称">
                    </div>
                    <button class="btn btn-primary" type="submit"><i class="fa fa-plus"></i> 添加</button>
                    <p class="pull-right text-info"> <i class="fa fa-bullhorn"></i> <strong>可拖放分类进行顺序调整.</strong></p>
                </form>
            </div>
        </div>
    </div>

    <div class="row">
        <#list foodTypes as foodType>
            <div class="col-md-4 animated fadeInDown" draggable="true" ondragstart="return dragStart(event)"
                 ondragenter="return dragEnter(event)"
                 ondrop="return dragDrop(event)"
                 ondragover="return dragOver(event)"
                 data-id="${foodType.id}">
                <div class="ibox">
                    <div class="ibox-content">
                        <h2>${foodType.name}</h2>

                        <div class="agile-detail">
                            <a href="/rtat/foods/type/delete/${foodType.id}" class="pull-right btn btn-xs btn-danger"
                               data-toggle="delete"> <i class="fa fa-trash"></i> 删除</a>
                            <i class="fa fa-clock-o"></i> ${foodType.createTime?string('yyyy.MM.dd')}
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
</@tags.layout.main>