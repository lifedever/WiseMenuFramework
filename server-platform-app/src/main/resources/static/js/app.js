(function(){
    var initToastr = function () {
        toastr.options = {
            "closeButton": true,
            "debug": false,
            "progressBar": false,
            "preventDuplicates": false,
            "positionClass": "toast-top-center",
            "onclick": null,
            "showDuration": "400",
            "hideDuration": "1000",
            "timeOut": "7000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        }
    };

    initToastr();

    $('.message').on('click', function (e) {
        e.preventDefault();
        $(this).slideUp()
    });

    $('[data-toggle="delete"]').on('click', function (e) {
        e.preventDefault();
        var $this = $(this);
        var message = $this.data('message')?$this.data('message'):'确定要删除此记录吗？';
        if(confirm(message)) {
            location.href = $this.attr('href');
        }

    });

})();