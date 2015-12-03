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

if(restaurant.name == ''){
    showProfileModal();
}

$('#profileName').on('click', function () {
    showProfileModal();
});