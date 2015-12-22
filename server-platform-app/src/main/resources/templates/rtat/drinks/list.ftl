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
<@tags.layout.main title="酒水列表" javascript=javascript>
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
                                <li><a href="/rtat/drinks?key=${key!}">全部分类</a></li>
                                <#list drinksTypes as drinksType>
                                    <li>
                                        <a href="/rtat/drinks?key=${key!}&typeId=${drinksType.id}">${drinksType.name}</a>
                                    </li>
                                </#list>
                            </ul>
                            <button class="btn btn-primary" type="submit"><i class="fa fa-search"></i> 查询</button>
                        </span>
                    </div>
                </form>
                <div class="btn-group">
                    <a class="btn btn-primary pull-left" href="/rtat/drinks/edit/0"><i class="fa fa-plus"></i> 添加新酒水</a>
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                        <span class="caret"></span>
                        <span class="sr-only">Toggle Dropdown</span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#"><strong>在以下分类中添加：</strong></a></li>
                        <li class="divider"></li>
                        <#list drinksTypes as drinksType>
                            <li><a href="/rtat/drinks/edit/0?typeId=${drinksType.id}">${drinksType.name}</a></li>
                        </#list>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <#list recordPage.content as drinks>
        <#if drinks_index%4==0>
        <div class="row">
        </#if>
        <div class="col-md-3">
            <div class="ibox">
                <div class="ibox-content product-box">

                    <div class="product-imitation">
                        <#if drinks.thumbPath??>
                            <img src="/rtat/drinks/img/${drinks.id}" style="width: 100%">
                        <#else>
                            <img src="/img/no-pic.png" style="width: 100%">
                        </#if>
                    </div>
                    <div class="product-desc">
                                <span class="product-price">
                                    <small>￥ ${drinks.price} 元</small>
                                </span>
                        <small class="text-muted"><strong>分类:</strong> ${drinks.drinksType?default('无分类')}</small>
                        <a href="#" class="product-name">
                        ${drinks.name}
                            <#if !drinks.published>
                                <span class="label label-danger">已下架</span>
                            </#if>
                        </a>

                        <div class="small m-t-xs">
                            <div class="memo" data-toggle="tooltip" title="${drinks.memo}">
                                <#if drinks.memo??&&drinks.memo != ''>
                                    <span class="text-primary">
                                    ${drinks.memo}
                                    </span>
                                <#else>
                                    <span class="text-danger">
                                            无定义!
                                        </span>
                                </#if>
                            </div>
                        </div>

                        <div class="m-t pad10-b">
                            <#if drinks.hot>
                                <span class="badge badge-danger">加热</span>
                            </#if>
                            <#if drinks.alcohol>
                                <span class="badge badge-success">含酒精</span>
                            <#else>
                                <span class="badge badge-info">无酒精</span>
                            </#if>
                            <#if drinks.frozen>
                                <span class="badge badge-default">冰镇</span>
                            </#if>
                        </div>
                        <div class="text-right">
                            <#if drinks.published>
                                <a href="/rtat/drinks/published/${drinks.id}/false" class="btn btn-xs btn-outline btn-success"> <i class="fa fa-angle-double-down"></i> 下架</a>
                            <#else>
                                <a href="/rtat/drinks/published/${drinks.id}/true" class="btn btn-xs btn-outline btn-success"> <i class="fa fa-angle-double-up"></i> 上架</a>
                            </#if>
                            <a href="/rtat/drinks/edit/${drinks.id}"
                               class="btn btn-xs btn-outline btn-primary"> <i class="fa fa-edit"></i> 编辑</a>
                            <span class="split"></span>
                            <a href="/rtat/drinks/delete/${drinks.id}"
                               class="btn btn-xs btn-outline btn-danger" data-toggle="delete"> <i
                                    class="fa fa-trash"></i> 删除</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <#if (drinks_index + 1)%4==0>
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