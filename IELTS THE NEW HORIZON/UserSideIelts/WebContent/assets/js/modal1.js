

var modalBtns = document.querySelectorAll(".modal-open11");

var modalBtns1 = document.querySelectorAll(".modal-open2");

var modalBtns2 = document.querySelectorAll(".modal-open3");


modalBtns.forEach(function(btn){
	btn.onclick=function(){
		var modal=btn.getAttribute("data-modal");

		document.getElementById(modal).style.display="block";
	};
});

modalBtns1.forEach(function(btn){
	btn.onclick=function(){
		var modal=btn.getAttribute("data-modal");

		document.getElementById(modal).style.display="block";
	};
});

modalBtns2.forEach(function(btn){
	btn.onclick=function(){
		var modal=btn.getAttribute("data-modal");

		document.getElementById(modal).style.display="block";
	};
});
var closeBtns = document.querySelectorAll(".modal-close");

closeBtns.forEach(function(btn){
		btn.onclick=function(){
			var modal=(btn.closest(".modal").style.display="none");
};
});

window.onclick=function(e)
{
	if(e.target.className==="modal")
	{
		e.target.style.display="none";
	}
};