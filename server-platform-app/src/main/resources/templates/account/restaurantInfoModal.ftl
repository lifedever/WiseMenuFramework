<div class="modal-dialog modal-lg">
    <div class="modal-content">
        <form id="restaurantModalForm" class=""
              action="/account/restaurant/${Session['io.github.gefangshuai.server.constant.session.RestaurantKey'].id}/save"
              method="post" enctype="multipart/form-data">
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="page-header"><h1 class="text-primary">请先将您的门店信息补充完整</h1></div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-7">


                        <div class="form-group">
                            <label>门店名称</label>
                            <input type="text" class="form-control required" name="name" value="${restaurant.name!}"
                                   placeholder="您门店的名字">
                        </div>
                        <div class="form-group">
                            <label>联系方式</label>

                            <input type="text" class="form-control" name="telNum" value="${restaurant.telNum[0]!}"
                                   placeholder="门店联系信息，常用座机或手机，座机请加区号">
                        </div>

                        <div class="form-group">
                            <label>所在地区</label>

                            <div id="cxSelect">
                                <div class="row">
                                    <div class="col-md-4">
                                        <select class="province form-control required"
                                                data-value="${restaurant.province!}" name="province"></select>
                                    </div>
                                    <div class="col-md-4">
                                        <select class="city form-control required" data-value="${restaurant.city!}"
                                                name="city" disabled="disabled"></select>
                                    </div>
                                    <div class="col-md-4">
                                        <select class="area form-control" data-value="${restaurant.district!}"
                                                name="district" disabled="disabled"></select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>详细地址</label>

                            <input type="text" class="form-control required" name="address"
                                   value="${restaurant.address!}" placeholder="具体街道门号详情">
                        </div>
                        <div class="form-group">
                            <label>门店信息</label>

                                <textarea class="form-control" name="memo" placeholder="可以对您的餐厅主打菜系或者特色口味进行描述，限100字以内."
                                          rows="4">${restaurant.memo!}</textarea>
                        </div>
                        <div>
                            <button class="btn btn-sm btn-primary pull-right m-t-n-xs" type="submit">
                                <strong>确定</strong>
                            </button>
                        </div>
                    </div>
                    <div class="col-sm-5">
                        <div class="form-group">
                            <label>门店图片</label>
                            <input type="file" name="file" id="inputImage">
                            <br>
                            <button class="btn btn-sm btn-primary" type="button" id="btnCut">确认裁剪</button>
                            <span id="cutInfo" class="text-success" style="display: none">裁剪成功！</span>
                        </div>
                        <img src="/img/profile_big.jpg" id="image">
                        <input type="hidden" id="xText" name="xText" value="0">
                        <input type="hidden" id="yText" name="yText" value="0">
                        <input type="hidden" id="widthText" name="widthText" value="0">
                        <input type="hidden" id="heightText" name="heightText" value="0">
                    </div>
                </div>
        </form>
    </div>
</div>
</div>
<script src="/js/plugins/cxSelect/jquery.cxselect.min.js"></script>
<script src="/js/plugins/cropper/cropper.js"></script>
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
        },
        error: function () {
            toastr.error(data.code + ': 门店信息保存失败!')
        }
    });

    var $image = $('#image');
    $image.cropper({
        aspectRatio: 12 / 9,
        minContainerWidth: 320,
        minContainerHeight: 300,
        crop: function (data) {

        }
    });

    var $inputImage = $("#inputImage");
    if (window.FileReader) {
        $inputImage.change(function () {
            var fileReader = new FileReader(),
                    files = this.files,
                    file;

            if (!files.length) {
                return;
            }
            file = files[0];
            if (/^image\/\w+$/.test(file.type)) {
                var blobURL = URL.createObjectURL(file);
                $image.one('built.cropper', function () {
                    URL.revokeObjectURL(blobURL); // Revoke when load complete
                }).cropper('reset', true).cropper('replace', blobURL);
            } else {
                alert('请选择图片文件！');
            }
            $('#cutInfo').hide();
        });
    }

    $('#btnCut').on('click', function () {
        var data = $image.cropper('getData');
        $('#xText').val(data.x);
        $('#yText').val(data.y);
        $('#widthText').val(data.width);
        $('#heightText').val(data.height);
        $('#cutInfo').show();
    })

</script>