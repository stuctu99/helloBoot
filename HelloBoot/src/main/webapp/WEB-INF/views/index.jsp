<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.requestURI }"/>
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

<h3>${path }</h3>
<c:if test="${1==1 }">
	<h3>if문 성공</h3>
</c:if>

<h3>업로드 처리하기</h3>
<form action="${pageContext.request.contextPath }/fileupload"
	method="post" enctype="multipart/form-data">
	<input type="file" name="upFile">
	<input type="file" name="upFile">
	<input type="file" name="upFile">
	<input type="file" name="upFile">
	<input type="submit" value="업로드">
</form>

<h2>채팅 접속</h2>
<button onclick="openChatting();">채팅하기</button>

<script>
	
	function openChatting(){
		open("${pageContxt.request.contextPath}/chatpage","_blank","width=400, height=500");
		
	}
	
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