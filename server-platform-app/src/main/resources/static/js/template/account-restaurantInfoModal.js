$('#cxSelect').cxSelect({
    url: '/js/plugins/cxSelect/data/cityData.min.json',  // 提示：如果服务器不支持 .json 类型文件，请将文件改为 .js 文件
    selects: ['province', 'city', 'area'],  // selects 为数组形式，请注意顺序
    nodata: 'none'
});

var hasCut = false;

var $restaurantModalForm = $('#restaurantModalForm');
var $SubmitBtn = $('#SubmitBtn');
$restaurantModalForm.validate();
$SubmitBtn.on('click', function () {
    $restaurantModalForm.ajaxSubmit({
        beforeSubmit: function () {
            if($('#inputImage').val() && !hasCut){
                toastr.warning('请对选择的图片确认裁剪!')
                return false;
            }
        },
        success: function (data) {
            if (data.code == '200') {
                $('#globalModal').modal('hide');
                location.reload();
                toastr.success('门店信息保存成功!')
            } else {
                toastr.error(data.code + ': 门店信息保存失败!')
            }
        },
        error: function (data) {
            toastr.error('门店信息保存失败: ' + data)
        }
    });
});

var $image = $('#image');
$image.cropper({
    highlight: true,
    viewMode: 3,
    minContainerWidth: 320,
    minContainerHeight: 300,
    crop: function (data) {
        hasCut = false;
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
    hasCut = true;
});