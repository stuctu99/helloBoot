<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕!!!!</title>
</head>
<body>
<h3>아아아아안녕!!!!!!!</h3>
<button id="memberall">전체 회원 조회</button>
<a href="${pageContext.request.contextPath }/board/boardList">게시글</a>
<script>
	document.querySelector("#memberall").addEventListener("click",e=>{
		fetch("${pageContext.request.contextPath}/members")
		.then(response=>{
			console.log(response);
			if(!response.status==200){
				throw new Error("에러");
			}
			return response.json();
		}).then(data=>{
			console.log(data);
		}).catch(e=>{
			alert(e);
		});
	});
</script>
</body>
</html>