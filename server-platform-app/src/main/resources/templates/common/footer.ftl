<#import "../tags.ftl" as tags>
<#macro jsShow>
<@tags.static.js />
<@tags.shiro.hasRole role='restaurant'>
<script src="/js/restaurant.js"></script>
</@tags.shiro.hasRole>
<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    });

    <@tags.shiro.user>
    var noticeSocket = function () {
        var s = new SockJS('/socket');
        var stompClient = Stomp.over(s);
        stompClient.connect({}, function () {
            stompClient.subscribe('/topic/notice', function (data) {
                $('.message span.content').html(data.body);
            });
        });
    };
    noticeSocket();
    </@tags.shiro.user>
</script>
</#macro>