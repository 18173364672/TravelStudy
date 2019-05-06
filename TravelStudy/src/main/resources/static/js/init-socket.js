/**
 * 
 * 
 * initSocket({
		url:"ws://localhost:9527/mywebsocket",
		callback:function(msg){
			var div = $("<div>").html(msg);
			$("#resultMsg").append(div);
		}
	});
 * 
 * 
 */

var initSocket = function(option) {
    //服务器地址
    var locate = window.location;
    var url = option.url ? option.url : "ws://" + locate.hostname + ":" + locate.port + _get_basepath() + "/mywebsocket";
    //回调函数
    var callback = option.callback;
    if (typeof callback !== "function") {
        console.log('callback 必须为函数');
        return false;
    }
    //一些对浏览器的兼容已经在插件里面完成
    var websocket = new ReconnectingWebSocket(url);
    //var websocket = new WebSocket(url);

    //连接发生错误的回调方法
    websocket.onerror = function () {
        console.log("websocket.error");
    };

    //连接成功建立的回调方法
    websocket.onopen = function (event) {
        console.log("onopen");
        var param = {
            id: "1",
            name: "天王盖帝湖",
            act: "produceNewUser",
            msg: ""
        }
        websocket.send(JSON.stringify(param));
        //建立连接后可以发生消息
//        websocket.send("{}");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        callback(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        websocket.close();
        console.log("websocket.onclose");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        websocket.close();
    }
    return websocket;
}