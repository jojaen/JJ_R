let board = {
	init:function(){
		$("#boardSaveBtn").on("click",()=>{
			this.boardSave();
		});
		$("#boardDeleteBtn").on("click",()=>{
			this.boardDelete();
		});
		$("#boardUpdateBtn").on("click",()=>{
			this.boardUpdate();
		});
		$("#btn-reply-save").on("click",()=>{
			this.replySave();
		});
		$("#replyUpdate").on("click",()=>{
			this.replyUpdate();
		});
		$("#btn-reply-delete").on("click",()=>{
			this.replyDelete();
		});
	},
	
	boardSave:function(){
		let data={
			title:$("#title").val(),
			content:$("#content").val()
		};
		$.ajax({
			type:"POST",
			url:"/api/niBoardSave",
			data:JSON.stringify(data),
			contentType:"application/json;charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("글쓰기완료");
			location.href="/";
		}).fail(function(error){
			alert("글쓰기실패");
		});
	},
	
	boardUpdate:function(){
		let id=$("#id").val();
		let data={
			title:$("#title").val(),
			content:$("#content").val()
		};
		console.log(data,id);
		$.ajax({
			type:"PUT",
			url:`/api/niBoard/${id}`,
			data:JSON.stringify(data),
			contentType:"application/json;charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("글수정완료");
			location.href="/";
		}).fail(function(error){
			alert("글수정실패");
		});
	},
	
	boardDelete:function(){
		let id=$("#id").val();
		$.ajax({
			type:"DELETE",
			url:"/api/niBoard/"+id,
			dataType:"json"
		}).done(function(resp){
			alert("댓글삭제완료");
			location.href="/";
		}).fail(function(error){
			alert("댓글삭제실패");
		});
	},
	
	replySave:function(){
		let data={
			content:$("#reply-content").val()
		};
		let niBoardId=$("#id").val();
		$.ajax({
			type:"POST",
			url:"/api/niBoard/"+niBoardId+"/niReply",
			data:JSON.stringify(data),
			dataType:"json",
			contentType:"application/json;charset=utf-8"
		}).done(function(resp){
			alert("댓글입력완료");
			window.location.reload();
		}).fail(function(error){
			alert("댓글입력실패");
		});
	},
	
	replyDelete:function(){
		let niReplyId=$("#niReplyId").val();
		let niBoardId=$("#id").val();
		$.ajax({
			type:"DELETE",
			url:"/api/niBoardDetail/"+niBoardId+"/niReply/"+niReplyId,
			dataType:"json",
		}).done(function(resp){
			alert("댓글삭제완료");
			window.location.reload();
		}).fail(function(error){
			alert("댓글삭제실패");
		});
	},
}
board.init();

reupdate = document.querySelectorAll(".boardDetail_modifyButton")
recancle = document.querySelectorAll(".boardDetail_cancel")
reedit = document.querySelectorAll("#r_reply")


reupdate.forEach((target)=>{
			target.addEventListener('click',(e)=>{
				e.preventDefault();
				editzone=(e.target.parentElement.children[6]);
				cancle=(e.target.parentElement.children[4]);
				edit_re=(e.target.parentElement.children[3]);
				
				editzone.style.display="block";
				cancle.style.display="block";
				edit_re.style.display="none";
			})
		});
		
		
recancle.forEach((target)=>{
			target.addEventListener('click',(e)=>{
				e.preventDefault();
				editzone=(e.target.parentElement.children[6]);
				cancle=(e.target.parentElement.children[4]);
				edit_re=(e.target.parentElement.children[3]);
				
				editzone.style.display="none";
				cancle.style.display="none";
				edit_re.style.display="block";
			})
		});
		
reedit.forEach((target)=>{
			target.addEventListener('click',(e)=>{
				e.preventDefault();
				this.editreply(e)
				
				
			})
		});
		
function editreply(e){
	const edit_value = (e.target.parentElement.children[1]).value;
	const niReplyId = (e.target.parentElement.children[0]).value;
	
	let data={
		content : edit_value
	}
	$.ajax({
			type:"PUT",
			url:`/api/niBoardDetail/niReply/${niReplyId}`,
			data:JSON.stringify(data),
			contentType:"application/json; charset=utf-8",
			dataType:"json"
			//응답의 결과가 문자열이 아닌 json으로 변환
		}).done(function(resp){
			alert("수정이 완료되었습니다.");
			window.location.reload();
			//응답이 정상
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	
}