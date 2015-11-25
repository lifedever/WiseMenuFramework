<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h1>WebSocket 实例</h1>

<div>
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
    </div>
    <div id="conversationDiv">
        <p>
            <label>notice content?</label>
        </p>
        <p>
            <textarea id="name" rows="5"></textarea>
        </p>
        <button id="sendName" onclick="sendName();">Send</button>
        <p id="response"></p>
    </div>
</div>

<script src="/js/sockjs-0.3.4.min.js"></script>
<script src="/js/stomp.min.js"></script>
<script>
    var stompClient = null;

    function setConnected(connected) {
        document.getElementById('connect').disabled = connected;
        document.getElementById('disconnect').disabled = !connected;
        document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
        document.getElementById('response').innerHTML = '';
    }

    function connect() {
        var socket = new SockJS('/socket');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
            /*console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/greetings', function (greeting) {
                showGreeting(JSON.parse(greeting.body).content);
            });*/
        });
    }

    function disconnect() {
        if (stompClient != null) {
            stompClient.disconnect();
        }
        setConnected(false);
        console.log("Disconnected");
    }

    function sendName() {
        var value = document.getElementById('name').value;
        stompClient.send("/app/change-notice", {}, value);
    }
    connect();
</script>
</body>
</html>