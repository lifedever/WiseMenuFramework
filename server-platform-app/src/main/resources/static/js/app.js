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
            "timeOut": "5000",
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

    var noticeSocket = function(){
        var s = new SockJS('/socket');
        var stompClient = Stomp.over(s);
        stompClient.connect({}, function () {
            console.log('notice socket connected!');
            stompClient.subscribe('/topic/notice', function (data) {
                $('.message span.content').html(data.body);
            });
        });
    }
    noticeSocket();
})();