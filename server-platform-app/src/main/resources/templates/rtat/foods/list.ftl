<#import "../../tags.ftl" as tags>
<@tags.layout.main title="菜品列表">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox-content m-b-sm border-bottom">
        <div class="row">
            <div class="col-md-12">
                <form role="form" class="form-inline pull-right">
                    <div class="form-group">
                        <input type="text" id="name" name="name" class="form-control">
                    </div>
                    <button class="btn btn-primary" type="submit"><i class="fa fa-search"></i> 查询</button>
                </form>
                <div class="btn-group">
                    <a class="btn btn-primary pull-left" href="/rtat/foods/add/0"><i class="fa fa-plus"></i> 添加新菜品</a>
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="caret"></span>
                        <span class="sr-only">Toggle Dropdown</span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#"><strong>在以下分类中添加：</strong></a></li>
                        <li class="divider"></li>
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <#list foods as food>
            <div class="col-md-3">
                <div class="ibox">
                    <div class="ibox-content product-box">

                        <div class="product-imitation">
                            <img src="/rtat/foods/img/${food.id}/thumb" style="width: 100%">
                        </div>
                        <div class="product-desc">
                                <span class="product-price">
                                    <small>￥ ${food.price} 元</small>
                                </span>
                            <small class="text-muted">Category</small>
                            <a href="#" class="product-name"> ${food.name}</a>
                            <div class="small m-t-xs">
                            ${food.memo}
                            </div>

                            <div class="m-t pad10-tb">
                                <div class="pull-left">
                                    <#if food.hot>
                                        <span class="badge badge-danger">热</span>
                                    <#else>
                                        <span class="badge badge-default">凉</span>
                                    </#if>
                                    <#if food.meat>
                                        <span class="badge badge-success">荤</span>
                                    <#else>
                                        <span class="badge badge-info">素</span>
                                    </#if>
                                    <#if food.muslim>
                                        <span class="badge badge-primary">清真</span>
                                    </#if>
                                </div>
                                <div class="pull-right">
                                    <a href="/rtat/foods/edit/${food.id}"
                                       class="btn btn-xs btn-outline btn-primary"> <i class="fa fa-edit"></i> 编辑</a>
                                    <span class="split"></span>
                                    <a href="/rtat/foods/delete/${food.id}"
                                       class="btn btn-xs btn-outline btn-danger" data-toggle="delete"> <i class="fa fa-trash"></i> 删除</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
</@tags.layout.main>