<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학원 조회 페이지</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
	<h2>학생 정보 조회하기</h2>
	<hr>
		<input type="text" name="name"><button id="submit">조회하기</button>	
		<div id="test">
		</div>
	<script>
		const submitBtn = document.querySelector("#submit");
		const inputTag = document.querySelector("input[name='name']");
		submitBtn.addEventListener('click',function(e){
			const inputVal = $(inputTag).val();
			$.ajax({
				url : "/searchKH",
				data : {inputVal : inputVal},
				success : function(data){
					$('#test').html('');
					$('#test').append('<ul>');
					if(data =='null'){
						$('#test').append('<li>정보가 없습니다.</li>');
					}else{
						
						$('#test').append('<li>'+data.name +'</li>');
						$('#test').append('<li>'+data.addr+'</li>');
						$('#test').append('<li>'+data.fax+'</li>');
					}
					$('#test').append('</ul>');
					
				}
			});
			
			 
		});
		
	</script>
</body>
</html>