<#import "../../tags.ftl" as tags>
<#assign javascript>

</#assign>
<@tags.layout.main title="菜品列表" javascript=javascript>
<div class="wrapper wrapper-content">
    <div class="ibox-content ">
        <div class="row">
            <div class="col-md-12">
                <a class="btn btn-circle btn-primary pull-left" href="/rtat/foods"><i
                        class="fa fa-chevron-left"></i></a>

                <div class="page-title">添加新菜品</div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <div class="row">
                        <form action="/rtat/foods/add" role="form" class="form-horizontal" method="post" id="foodForm">
                            <div class="col-md-6 b-r">
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>菜品名称</label>
                                        <input type="text" class="form-control required" name="name" placeholder="菜品大名">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>价格</label>
                                        <div class="input-group">
                                            <input type="text" class="form-control money" name="price" placeholder="菜品的价格">
                                            <div class="input-group-addon">元</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>口味</label>
                                        <input type="text" class="form-control" name="flavor"
                                               placeholder="如: 咸口, 甜口, 辣味, 微辣, 偏咸">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>用料</label>
                                        <input type="text" class="form-control" name="materials"
                                               placeholder="如: 盐, 胡椒, 鸡腿肉, 里脊肉, 酱油等">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>描述</label>
                                        <textarea class="form-control" name="memo" rows="4"
                                                  placeholder="50个字以内, 对菜品进行简单的描述，如: 口味适合年轻人"></textarea>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary pull-right">提交</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</@tags.layout.main>