<#import "../../tags.ftl" as tags>
<#import "../../common/cropper.ftl" as cropper>
<#setting number_format="#"/>
<#assign javascript>
<script src="/js/plugins/cropper/cropper.js"></script>
<script>
    var $drinksForm = $('#drinksForm');
    $drinksForm.validate();
    $drinksForm.submit(function () {
        if ($('#inputDrinksImage').val() && !hasCut) {
            toastr.warning('请对选择的图片确认裁剪!');
            return false;
        }
    });
</script>
    <@cropper.js image="drinksImage" input="inputDrinksImage" cutInfoLabel="cutDrinksInfo" xText="xDrinksText" yText="yDrinksText" widthText="widthDrinksText" heightText="heightDrinksText" cutBtn="btnDrinksCut"  />
</#assign>
<@tags.layout.main title="添加酒水" javascript=javascript>
<div class="wrapper wrapper-content">
    <form action="/rtat/drinks/save/${drinks.id}" role="form" class="form-horizontal" method="post"
          id="drinksForm" enctype="multipart/form-data">
        <div class="ibox">
        <div class="ibox-title">
            <div class="row">
                <div class="col-md-12">
                    <a class="btn btn-circle btn-primary pull-left" href="/rtat/drinks"><i
                            class="fa fa-chevron-left"></i></a>
                    <div class="page-title ">
                        酒水信息
                        <div class="col-xs-3  pull-right">
                            <select class="form-control" name="typeId">
                                <option value="0">全部分类</option>
                                <#list drinksTypes as type>
                                    <option value="${type.id}" <#if drinks.drinksType?? && drinks.drinksType.id == type.id>selected="selected"</#if> >${type.name}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="pull-right">
                            <small>选择分类:</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="ibox-content">
            <div class="row">
                <div class="col-md-6 b-r">
                    <div class="form-group">
                        <div class="col-sm-12">
                            <label>酒水名称</label>
                            <input type="text" class="form-control required" name="name" placeholder="酒水大名"
                                   value="${drinks.name!}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <label>价格</label>

                            <div class="input-group">
                                <input type="text" class="form-control {required:true, money:true, min:1}"
                                       name="price" value="${drinks.price!}"
                                       placeholder="酒水的价格">

                                <div class="input-group-addon">元</div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <label>是否含酒精</label>

                            <div class="radio">
                                <label>
                                    <input type="radio" name="alcohol" value="true" <#if drinks.alcohol>checked</#if>>
                                    是
                                </label>
                                <label>
                                    <input type="radio" name="alcohol" value="false"
                                           <#if !drinks.alcohol>checked</#if>> 否
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <label>是否加热</label>

                            <div class="radio">
                                <label>
                                    <input type="radio" name="hot" value="true"
                                           <#if drinks.hot>checked</#if>> 是
                                </label>
                                <label>
                                    <input type="radio" name="hot" value="false"
                                           <#if !drinks.hot>checked</#if>> 否
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <label>是否冰镇</label>

                            <div class="radio">
                                <label>
                                    <input type="radio" name="frozen" value="true"
                                           <#if drinks.frozen>checked</#if>> 是
                                </label>
                                <label>
                                    <input type="radio" name="frozen" value="false"
                                           <#if !drinks.frozen>checked</#if>> 否
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <label>描述</label>
                                        <textarea class="form-control" name="memo" rows="4"
                                                  placeholder="50个字以内, 对酒水进行简单的描述，如: 口味适合年轻人">${drinks.memo!}</textarea>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary pull-right">提交</button>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <div class="col-sm-12">
                            <label>酒水图片</label>
                            <#if drinks.imagePath?exists>
                                <a href="#" class="thumbnail">
                                    <img src="/rtat/drinks/img/${drinks.id}">
                                </a>
                            </#if>
                            <@cropper.html inputId="inputDrinksImage" cutBtn="btnDrinksCut"
                            cutInfoLabel="cutDrinksInfo" image="drinksImage"
                            xText="xDrinksText" yText="yDrinksText" widthText="widthDrinksText" heightText="heightDrinksText" />
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    </form>
</div>
</@tags.layout.main>