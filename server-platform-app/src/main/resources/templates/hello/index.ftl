<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h1>WebSocket 实例</h1>
<script>
    var socket = new WebSocket('/app/hello')
    socket.open = function(){
        socket.send("hello");
    };
    socket.onmessage = function(data) {
        console.log(data);
    };
</script>
</body>
</html>