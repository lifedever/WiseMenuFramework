<#import "../../tags.ftl" as tags>
<#assign javascript>
<script src="/js/jquery.dotdotdot.min.js"></script>
<script>
    $('div.memo').dotdotdot({
        /*	The text to add as ellipsis. */
        ellipsis: '... ',

        /*	How to cut off the text/html: 'word'/'letter'/'children' */
        wrap: 'letter',

        /*	Wrap-option fallback to 'letter' for long words */
        fallbackToLetter: true,

        /*	jQuery-selector for the element to keep and put after the ellipsis. */
        after: null,

        /*	Whether to update the ellipsis: true/'window' */
        watch: false,

        /*	Optionally set a max-height, if null, the height will be measured. */
        height: 19,

        /*	Deviation for the height-option. */
        tolerance: 0,

        /*	Callback function that is fired after the ellipsis is added,
         receives two parameters: isTruncated(boolean), orgContent(string). */
        callback: function (isTruncated, orgContent) {
        },

        lastCharacter: {

            /*	Remove these characters from the end of the truncated text. */
            remove: [' ', ',', ';', '.', '!', '?'],

            /*	Don't add an ellipsis if this array contains
             the last character of the truncated text. */
            noEllipsis: []
        }
    });
</script>
</#assign>
<@tags.layout.main title="菜品列表" javascript=javascript>
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="ibox-content m-b-sm border-bottom">
        <div class="row">
            <div class="col-md-12">
                <form role="form" class="form-inline">
                    <div class="input-group pull-right">
                        <input type="text" id="name" name="key" class="form-control" value="${key!}">
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">
                                <#if currentType??>
                                ${currentType.name}
                                    <input type="hidden" name="typeId" value="${currentType.id}">
                                <#else>
                                    全部分类
                                </#if>
                                <span class="caret"></span>
                                <span class="sr-only">Toggle Dropdown</span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="#"><strong>选择分类：</strong></a></li>
                                <li class="divider"></li>
                                <li><a href="/rtat/foods?key=${key!}">全部分类</a></li>
                                <#list foodTypes as foodType>
                                    <li><a href="/rtat/foods?key=${key!}&typeId=${foodType.id}">${foodType.name}</a>
                                    </li>
                                </#list>
                            </ul>
                            <button class="btn btn-primary" type="submit"><i class="fa fa-search"></i> 查询</button>
                        </span>
                    </div>
                </form>
                <div class="btn-group">
                    <a class="btn btn-primary pull-left" href="/rtat/foods/edit/0"><i class="fa fa-plus"></i> 添加新菜品</a>
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                        <span class="caret"></span>
                        <span class="sr-only">Toggle Dropdown</span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#"><strong>在以下分类中添加：</strong></a></li>
                        <li class="divider"></li>
                        <#list foodTypes as foodType>
                            <li><a href="/rtat/foods/edit/0?typeId=${foodType.id}">${foodType.name}</a></li>
                        </#list>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <#list recordPage.content as food>
        <#if food_index%4==0>
        <div class="row">
        </#if>
        <div class="col-md-3">
            <div class="ibox">
                <div class="ibox-content product-box">
                    <div class="product-imitation">
                        <#if food.thumbPath??>
                            <img src="/rtat/foods/img/${food.id}/thumb" style="width: 100%;">
                        <#else>
                            <img src="/img/no-pic.png" style="width: 100%">
                        </#if>
                    </div>
                    <div class="product-desc">
                                <span class="product-price">
                                    <small>￥ ${food.price} 元</small>
                                </span>
                        <small class="text-muted"><strong>分类:</strong> ${food.foodType?default('无分类')}</small>
                        <a href="#" class="product-name"> ${food.name}</a>

                        <div class="small m-t-xs">
                            <div class="memo" data-toggle="tooltip" title="${food.memo}">
                                <#if food.memo??&&food.memo != ''>
                                    <span class="text-primary">
                                    ${food.memo}
                                    </span>
                                <#else>
                                    <span class="text-danger">
                                            无定义!
                                        </span>
                                </#if>
                            </div>
                        </div>

                        <div class="m-t pad10-b">
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
                        <div class="text-right">
                            <a href="/rtat/foods/edit/${food.id}"
                               class="btn btn-xs btn-outline btn-primary"> <i class="fa fa-edit"></i> 编辑</a>
                            <span class="split"></span>
                            <a href="/rtat/foods/delete/${food.id}"
                               class="btn btn-xs btn-outline btn-danger" data-toggle="delete"> <i
                                    class="fa fa-trash"></i> 删除</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <#if (food_index + 1)%4==0>
        </div>
        </#if>
    </#list>
    <div class="row">
        <div class="col-md-12">
            <#if currentType??>
                <@tags.data.pagination recordPage=recordPage key=key typeId=currentType.id></@tags.data.pagination>
            <#else>
                <@tags.data.pagination recordPage=recordPage key=key></@tags.data.pagination>
            </#if>

        </div>
    </div>
</div>
</@tags.layout.main>