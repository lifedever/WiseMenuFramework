<#import "../../tags.ftl" as tags>
<#import "../../common/cropper.ftl" as cropper>
<#setting number_format="#"/>
<#assign javascript>
<script src="/js/plugins/cropper/cropper.js"></script>
<script>
    var $foodForm = $('#foodForm');
    $foodForm.validate();
    $foodForm.submit(function () {
        if ($('#inputFoodImage').val() && !hasCut) {
            toastr.warning('请对选择的图片确认裁剪!');
            return false;
        }
    });
</script>
    <@cropper.js image="foodImage" input="inputFoodImage" cutInfoLabel="cutFoodInfo" xText="xFoodText" yText="yFoodText" widthText="widthFoodText" heightText="heightFoodText" cutBtn="btnFoodCut"  />
</#assign>
<@tags.layout.main title="菜品列表" javascript=javascript>
<div class="wrapper wrapper-content">
    <div class="ibox-content ">
        <div class="row">
            <div class="col-md-12">
                <a class="btn btn-circle btn-primary pull-left" href="/rtat/foods"><i
                        class="fa fa-chevron-left"></i></a>

                <div class="page-title">菜品信息</div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <div class="row">
                        <form action="/rtat/foods/save/${food.id}" role="form" class="form-horizontal" method="post"
                              id="foodForm" enctype="multipart/form-data">
                            <div class="col-md-6 b-r">
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>菜品名称</label>
                                        <input type="text" class="form-control required" name="name" placeholder="菜品大名"
                                               value="${food.name!}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>价格</label>

                                        <div class="input-group">
                                            <input type="text" class="form-control {required:true, money:true, min:1}"
                                                   name="price" value="${food.price!}"
                                                   placeholder="菜品的价格">

                                            <div class="input-group-addon">元</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>口味</label>
                                        <input type="text" class="form-control" name="flavor" value="${food.flavor!}"
                                               placeholder="如: 咸口, 甜口, 辣味, 微辣, 偏咸">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>用料</label>
                                        <input type="text" class="form-control" name="materials"
                                               value="${food.materials!}"
                                               placeholder="如: 盐, 胡椒, 鸡腿肉, 里脊肉, 酱油等">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>是否为热菜</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="hot" value="true" <#if food.hot>checked</#if>> 是
                                            </label>
                                            <label>
                                                <input type="radio" name="hot" value="false" <#if !food.hot>checked</#if>> 否
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>是否为荤菜</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="meat" value="true" <#if food.meat>checked</#if>> 是
                                            </label>
                                            <label>
                                                <input type="radio" name="meat" value="false" <#if !food.meat>checked</#if>> 否
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>是否为清真</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="muslim" value="true" <#if food.muslim>checked</#if>> 是
                                            </label>
                                            <label>
                                                <input type="radio" name="muslim" value="false" <#if !food.muslim>checked</#if>> 否
                                            </label>
                                        </div>
                                    </div>
                                </div>

                                <button type="submit" class="btn btn-primary pull-right">提交</button>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>菜品图片</label>
                                        <@cropper.html inputId="inputFoodImage" cutBtn="btnFoodCut"
                                        cutInfoLabel="cutFoodInfo" image="foodImage"
                                        xText="xFoodText" yText="yFoodText" widthText="widthFoodText" heightText="heightFoodText" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label>描述</label>
                                        <textarea class="form-control required" name="memo" rows="4"
                                                  placeholder="50个字以内, 对菜品进行简单的描述，如: 口味适合年轻人">${food.memo!}</textarea>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</@tags.layout.main>