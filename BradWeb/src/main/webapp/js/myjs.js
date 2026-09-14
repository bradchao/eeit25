window.onload = function(){
	const URL = "ws://10.0.100.160:8080/BradWeb/myserver";
	
	let start = document.getElementById("start");
	let chatDiv = document.getElementById("chatDiv");
	let mesg = document.getElementById("mesg");
	let send = document.getElementById("send");
	let log = document.getElementById("log");
	
	let websocket;
	
	start.addEventListener("click", function(){connect(URL)});
	send.addEventListener("click", function(){});
	
	function connect(url){
		websocket = new WebSocket(url);
		
		websocket.onopen = function(){
			console.log("onopen");
		};
		websocket.onmessage = function(event){
			console.log("onmessage");
		};
		websocket.onclose = function(){
			console.log("onclose");
		};
		websocket.onerror = function(event){
			console.log("onerror");
		};
		
	}
	
	
}