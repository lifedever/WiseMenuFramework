<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-body">
            <div class="row">
                <div class="col-sm-12">
                    <div class="page-header"><h1 class="text-primary">请先将您的门店信息补充完整</h1></div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <form id="restaurantModalForm" class="form-horizontal"
                          action="/account/restaurant/${Session['io.github.gefangshuai.server.constant.session.RestaurantKey'].id}/save"
                          method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label class="control-label col-sm-2">门店名称</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control required" name="name" value="${restaurant.name!}" placeholder="您门店的名字">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">联系方式</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="telNum"  value="${restaurant.telNum[0]!}"
                                       placeholder="门店联系信息，常用座机或手机，座机请加区号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">门店图片</label>

                            <div class="col-sm-10">
                                <input type="file" name="file">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">所在地区</label>

                            <div class="col-sm-10" id="cxSelect">
                                <div class="row">
                                    <div class="col-md-4">
                                        <select class="province form-control required" data-value="${restaurant.province!}" name="province"></select>
                                    </div>
                                    <div class="col-md-4">
                                        <select class="city form-control required" data-value="${restaurant.city!}" name="city" disabled="disabled"></select>
                                    </div>
                                    <div class="col-md-4">
                                        <select class="area form-control" data-value="${restaurant.district!}" name="district" disabled="disabled"></select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">详细地址</label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control required" name="address" value="${restaurant.address!}" placeholder="具体街道门号详情">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">门店信息</label>

                            <div class="col-sm-10">
                                <textarea class="form-control" name="memo" placeholder="可以对您的餐厅主打菜系或者特色口味进行描述，限100字以内."
                                          rows="4">${restaurant.memo!}</textarea>
                            </div>
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
<script src="/js/plugins/cxSelect/jquery.cxselect.min.js"></script>
<script>
    $('#cxSelect').cxSelect({
        url: '/js/plugins/cxSelect/data/cityData.min.json',  // 提示：如果服务器不支持 .json 类型文件，请将文件改为 .js 文件
        selects: ['province', 'city', 'area'],  // selects 为数组形式，请注意顺序
        nodata: 'none'
    });
    var $restaurantModalForm = $('#restaurantModalForm');
    $restaurantModalForm.validate();
    $restaurantModalForm.ajaxForm({
        success: function (data) {
            if (data.code == '200') {
                $('#globalModal').modal('hide');
                location.reload();
                toastr.success('门店信息保存成功!')
            } else {
                toastr.error(data.code + ': 门店信息保存失败!')
            }
        }
    })

</script>