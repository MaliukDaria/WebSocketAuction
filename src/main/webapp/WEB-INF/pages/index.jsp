<html>
<head>
    <title>Chat WebSocket</title>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
    <script type="text/javascript">
        var stompClient = null;

        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility
                = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }

        function connect() {
            var socket = new SockJS('/websocket/api/chat');
            var auctionId = document.getElementById('auctionId').value;
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/messages/' + auctionId, function (messageOutput) {
                    showMessageOutput(JSON.parse(messageOutput.body));
                });
            });
        }

        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        }

        function sendMessage() {
            var from = document.getElementById('from').value;
            var text = document.getElementById('text').value;
            stompClient.send("/app/websocket/api/chat", {},
                JSON.stringify({'from': from, 'text': text}));
        }

        function getAuction() {
            var auctionId = document.getElementById('auctionId').value;
            stompClient.send("/app/websocket/api/chat/get/" + auctionId, {}, '');
        }

        function makeBid() {
            var bid = document.getElementById('bitAmount').value;
            var auctionId = document.getElementById('auctionId').value;
            var from = document.getElementById('from').value;
            var quote = {"id":null,"bitAmount":bid,"customer":{"id":null,"login":from}};
            stompClient.send("/app/websocket/api/chat/makeBid/" + auctionId, {}, JSON.stringify(quote));
        }

        function showMessageOutput(messageOutput) {
            /*alert(messageOutput.toString());*/
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(messageOutput.toString()));
            response.appendChild(p);
        }
    </script>
</head>
</head>
<body onload="disconnect()">
<div>
    <div>
        <input type="text" id="from" placeholder="Choose a nickname"/>
    </div>
    <br/>
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">
            Disconnect
        </button>
    </div>
    <br/>
    <div>
        <input type="text" id="auctionId" placeholder="Enter Auction id"/>
    </div>
    <br/>
    <div>
        <button id="getAuction" onclick="getAuction();">Get Auction</button>
    </div>
    <br/>
    <br/>
    <div id="conversationDiv">
        <input type="text" id="bitAmount" placeholder="Enter bit amount"/>
        <br/>
        <br/>
        <button id="makeBid" onclick="makeBid();">Make Bid</button>
        <p id="response"></p>
    </div>
</div>

</body>
</html>
<%--<body onload="disconnect()">
<div>
    <div>
        <input type="text" id="from" placeholder="Choose a nickname"/>
    </div>
    <br/>
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">
            Disconnect
        </button>
    </div>
    <div>
        <input type="text" id="auctionId" placeholder="Enter Auction id"/>
    </div>
    <div>
        <button id="getAuction" onclick="getAuction();">Get Auction</button>
    </div>
    <br/>
    <div id="conversationDiv">
        <input type="text" id="text" placeholder="Write a message..."/>
        <button id="sendMessage" onclick="sendMessage();">Send</button>
        <p id="response"></p>
    </div>
</div>

</body>--%>
</html>
