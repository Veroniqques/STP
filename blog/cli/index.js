$(document).ready(function(){
	$("#btn1").click(function(){
		$.ajax({
			url: "http://localhost:8080/tags",
			type: "GET",
			dataType: "json",
			success: function (response){
				console.log(response);
			},
			error: function(response) {
				console.log("Что-то поло не так", error);
			}
		});
	});
	
	$("#btn2").click(async function(){
		let varData = {
			"name": "NAME2",
			"slug": "SLUGNAME"
		};
		let response = await fetch("http://localhost:8080/tags", {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json;charset=utf-8'
			},
			body: JSON.stringify(varData)
		});
	});
});