let user = {
	init: function(){
		$("#joinBtn").on("click",()=>{
			this.save();
		});
	},
	
	save:function(){
		let data={
			username:$("#userid").val(),
			password:$("#userpwd").val(),
			name:$("#username").val()
		};
		$.ajax({
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			url:"/auth/joinProc",
			type:"POST",
			dataType:"json"
		}).done(function(resp){
			alert("회원가입완료");
			location.href="/";
		}).fail(function(error){
			alert("회원가입실패");
		});
	},
}
user.init();