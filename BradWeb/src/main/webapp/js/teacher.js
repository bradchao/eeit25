window.onload = function(){
	let url = "ws://10.0.100.160:8080/BradWeb/mycenter";
	let webSocket = new WebSocket(url);
	
	let clear = document.getElementById("clear");
	let myDrawer = document.getElementById("myDrawer"); 
	
	let ctx = myDrawer.getContext("2d");
	let isDrag = false;
	let isConnect = false;

	//-------------------------------------------
	
	webSocket.onopen = function(){
		isConnect = true;
		let data = {
			isTeacher : true
		};
		webSocket.send(JSON.stringify(data));
		
	}
	
	webSocket.onclose = function(){
		isConnect = false;
	}
	
	//------------------------------------------
	myDrawer.onmousedown = function(e){
		isDrag = true;
		let x = e.offsetX, y = e.offsetY;
		console.log("down:" + x + " x " + y);
		
		ctx.lineWidth = 4;
		ctx.beginPath();
		ctx.moveTo(x, y);
		
		let data = {
			isClear : false,
			isNewLine : true,
			x : x,
			y : y
		};
		webSocket.send(JSON.stringify(data));
		
	}
	
	myDrawer.onmouseup = function(e){
		isDrag = false;
	}
	
	myDrawer.onmousemove = function(e){
		if (isDrag){
			let x = e.offsetX, y = e.offsetY;
			console.log("move:" + x + " x " + y);
			
			ctx.lineTo(x, y);
			ctx.stroke();
			
			let data = {
				isClear : false,
				isNewLine : false,
				x : x,
				y : y
			};
			webSocket.send(JSON.stringify(data));
			
			
		}
	}
	
	clear.addEventListener("click", function(){
		ctx.clearRect(0,0, myDrawer.width, myDrawer.height);
		
		let data = {
			isClear : true,
		};
		webSocket.send(JSON.stringify(data));
		
		
	});
	
}