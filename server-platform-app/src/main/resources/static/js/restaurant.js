$('#online-open-status-switch').on('click', function(e){
    var $checked = this.checked;
    var url = '/rtat/open-status/' + $checked;
    $.get(url, function (data) {
        if($checked){
            $('#online-open-status-text').text('火爆营业中')
        }else{
            $('#online-open-status-text').text('线上整顿中')
        }
    });
});

var showProfileModal = function(){
    $.get('/account/additional/' + restaurant.id, function(data){
        $('#globalModal').html(data).modal('show')
    });
};
if(restaurant.name == undefined || restaurant.name == ''){
    showProfileModal();
}

$('#profileName').on('click', function () {
    showProfileModal();
});

if(!restaurant.opening && (!$.cookie('closeOpenWarning'))) {
    toastr.error(
        '您的店铺正在线上整顿中，如果整顿完成，<strong>请及时更改营业状态</strong>，以免造成不必要的损失！ <a href="#" id="closeOpenWarning" class="btn btn-danger pull-right btn-xs">一天内不再提醒</a>',
        '注意',
        {
            "positionClass": "toast-top-full-width",
        }
    )
}

$('#closeOpenWarning').on('click', function (e) {
    e.stopPropagation();
    $.cookie('closeOpenWarning', true, { expires: 1, path: 'gefangshuai.github.io' });
    toastr.remove(0)
});