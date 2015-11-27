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
                <a class="btn btn-primary pull-left" href="/rtat/foods/add/0"><i class="fa fa-plus"></i> 添加新菜品</a>
            </div>
        </div>
    </div>
    <div class="row">
        <#list foods as food>
            <div class="col-md-3">
                <div class="ibox">
                    <div class="ibox-content product-box">

                        <div class="product-imitation">
                            <img src="/rtat/foods/img/${food.id}" style="width: 100%; height:50%;">
                        </div>
                        <div class="product-desc">
                                <span class="product-price">
                                    ${food.price} 元
                                </span>
                            <small class="text-muted">Category</small>
                            <a href="#" class="product-name"> ${food.name}</a>


                            <div class="small m-t-xs">
                                ${food.memo}
                            </div>
                            <div class="m-t text-righ">

                                <a href="/rtat/foods/edit/${food.id}" class="btn btn-xs btn-outline btn-primary">edit <i
                                        class="fa fa-long-arrow-right"></i> </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
</@tags.layout.main>