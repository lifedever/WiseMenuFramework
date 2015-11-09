<div class="modal-dialog" xmlns="http://www.w3.org/1999/html">
    <div class="modal-content">
        <div class="modal-header bg-warning">
            <h3 class="m-t-none m-b">请先将您的店铺信息补充完整!</h3>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-sm-12">
                    <form role="form" action="/account/saveRestaurant" method="post">
                        <div class="form-group">
                            <label>名称</label>
                            <input type="text" class="form-control" placeholder="您店铺的名字">
                        </div>
                        <div class="form-group">
                            <label>地址</label>
                            <input type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>详细地址</label>
                            <input type="text" class="form-control" placeholder="具体街道门号">
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <textarea class="form-control" placeholder="可以对您的餐厅主打菜系或者特色口味进行描述，限100字以内." rows="3"></textarea>
                        </div>
                        <div>
                            <button class="btn btn-sm btn-primary pull-right m-t-n-xs" type="submit">
                                <strong>确定</strong>
                            </button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>