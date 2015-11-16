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
                    <button class="btn btn-primary" type="submit"> <i class="fa fa-search"></i> 查询</button>
                </form>
                <a class="btn btn-primary pull-left" href="/rtat/foods/add/0"><i class="fa fa-plus"></i> 添加新菜品</a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <div class="ibox">
                <div class="ibox-content product-box">

                    <div class="product-imitation">
                        [ INFO ]
                    </div>
                    <div class="product-desc">
                                <span class="product-price">
                                    $10
                                </span>
                        <small class="text-muted">Category</small>
                        <a href="#" class="product-name"> Product</a>


                        <div class="small m-t-xs">
                            Many desktop publishing packages and web page editors now.
                        </div>
                        <div class="m-t text-righ">

                            <a href="#" class="btn btn-xs btn-outline btn-primary">Info <i
                                    class="fa fa-long-arrow-right"></i> </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="ibox">
                <div class="ibox-content product-box">

                    <div class="product-imitation">
                        [ INFO ]
                    </div>
                    <div class="product-desc">
                                <span class="product-price">
                                    $10
                                </span>
                        <small class="text-muted">Category</small>
                        <a href="#" class="product-name"> Product</a>


                        <div class="small m-t-xs">
                            Many desktop publishing packages and web page editors now.
                        </div>
                        <div class="m-t text-righ">

                            <a href="#" class="btn btn-xs btn-outline btn-primary">Info <i
                                    class="fa fa-long-arrow-right"></i> </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="ibox">
                <div class="ibox-content product-box active">

                    <div class="product-imitation">
                        [ INFO ]
                    </div>
                    <div class="product-desc">
                                <span class="product-price">
                                    $10
                                </span>
                        <small class="text-muted">Category</small>
                        <a href="#" class="product-name"> Product</a>


                        <div class="small m-t-xs">
                            Many desktop publishing packages and web page editors now.
                        </div>
                        <div class="m-t text-righ">

                            <a href="#" class="btn btn-xs btn-outline btn-primary">Info <i
                                    class="fa fa-long-arrow-right"></i> </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</@tags.layout.main>