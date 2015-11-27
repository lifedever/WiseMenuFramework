<#macro js image input cutInfoLabel xText yText widthText heightText cutBtn minContainerWidth=350 minContainerHieght=300>
<script>
    var hasCut = false;
    var $image = $('#' +'${image}');
    $image.cropper({
        aspectRatio: 4 / 3,
        highlight: true,
        viewMode: 3,
        dragMode: 'move',
        cropBoxMovable: false,
        minContainerWidth: ${minContainerWidth},
        minContainerHeight: ${minContainerHieght},
        minCropBoxWidth: ${minContainerWidth},
        crop: function (data) {
            hasCut = false;
        }
    });

    var $inputImage = $("#" +'${input}');
    if (window.FileReader) {
        $inputImage.change(function () {
            var files = this.files,
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
            $('#' +'${cutInfoLabel}').hide();
        });
    }

    $('#' +'${cutBtn}').on('click', function () {
        var data = $image.cropper('getData');
        $('#' +'${xText}').val(data.x);
        $('#' +'${yText}').val(data.y);
        $('#' +'${widthText}').val(data.width);
        $('#' +'${heightText}').val(data.height);
        $('#' +'${cutInfoLabel}').show();
        hasCut = true;
    });
</script>
</#macro>
<#macro html inputId cutBtn cutInfoLabel image xText yText widthText heightText imageHeight=300>
<input type="file" name="file" id="${inputId}">
<br>
<button class="btn btn-sm btn-primary" type="button" id="${cutBtn}">确认裁剪
</button>
<span id="${cutInfoLabel}" class="text-success" style="display: none">裁剪成功！</span>
<div class="image-crop" style="height: ${imageHeight}px;">
    <img src="/img/no-pic.png" id="${image}">
</div>
<input type="hidden" id="${xText}" name="xText" value="0">
<input type="hidden" id="${yText}" name="yText" value="0">
<input type="hidden" id="${widthText}" name="widthText" value="0">
<input type="hidden" id="${heightText}" name="heightText" value="0">
</#macro>