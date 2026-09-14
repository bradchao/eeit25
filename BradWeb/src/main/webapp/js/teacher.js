window.onload = function(){
	let clear = document.getElementById("clear");
	let myDrawer = document.getElementById("myDrawer"); 
	
	let ctx = myDrawer.getContext("2d");
	let isDrag = false;
	
	myDrawer.onmousedown = function(e){
		isDrag = true;
		let x = e.offsetX, y = e.offsetY;
		console.log("down:" + x + " x " + y);
		
		ctx.lineWidth = 4;
		ctx.beginPath();
		ctx.moveTo(x, y);
		
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
			
		}
	}
	
	clear.addEventListener("click", function(){
		ctx.clearRect(0,0, myDrawer.width, myDrawer.height);
	});
	
}