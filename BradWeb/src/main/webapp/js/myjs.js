window.onload = function(){
	const URL = "ws://10.0.100.160:8080/BradWeb/myserver";
	
	let start = document.getElementById("start");
	let chatDiv = document.getElementById("chatDiv");
	let mesg = document.getElementById("mesg");
	let send = document.getElementById("send");
	let log = document.getElementById("log");
	
	let websocket;
	
	start.style.display = "block";
	chatDiv.style.display = "none";
	
	start.addEventListener("click", function(){connect(URL)});
	send.addEventListener("click", function(){
		let message = {
			message: mesg.value
		};
		websocket.send(JSON.stringify(message));
	});
	
	function connect(url){
		websocket = new WebSocket(url);
		
		websocket.onopen = function(){
			console.log("onopen");
			start.style.display = "none";
			chatDiv.style.display = "block";
		};
		
		websocket.onmessage = function(event){
			let mesgObj = JSON.parse(event.data);
			log.innerHTML += mesgObj.message + "<br />";
		};
		
		websocket.onclose = function(){
			console.log("onclose");
		};
		
		websocket.onerror = function(event){
			console.log("onerror");
		};
		
	}
	
	
}