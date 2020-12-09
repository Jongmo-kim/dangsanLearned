<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=t4r2eo4aln&submodules=geocoder"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
	
		<div class="div-wrapper" style="width:80%"; margin: 0 auto;">
			<h2>1. 메일보내기</h2>
			<input type="text" id="mail">
			<button id="mailBtn" class="btn btn-primary">메일전송</button>
			<input type="text" id="mailCode" style="display:none">
			<button id="mailChk" class="btn btn-primary" style="display:none">확인</button>
			<span id="mailMsg"></span>
		</div>
		<h2>2. 다음 주소찾기 API</h2>
		<ul>
			<li>
				<input id="postCode" style="width:200px;display : inline-block;" type="text" placeholder="우편번호" class="form-control" readonly>
				<button id="addrSearchBtn" type="button" onclick="addrSearch();" class="btn btn-primary">주소검색</button>
				
			</li>
			<li>
				<input type="text" id="roadAddr" style="width:400px; display:inline-block;"placeholder="도로명주소" class="form-control" readonly>
				<input type="text" id="jibunAddr" style="width:400px; display:inline-block;"placeholder="지번주소" class="form-control" readonly>
				
			</li>
			<li>
				<input type="text" id="detailAddr" style="width:800px; display:inline-block;"placeholder="상세주소" class="form-control" >
				
			</li>
		</ul>
		<h2>3.네이버지도</h2>
		<div id="map" style="width:100%; height:500px;"></div>
		<h2>4. 결제 모듈 API(아임포트)</h2>
		<div id="pay">
			<h4>
				<label><input type="checkbox" value="70">1000원</label>
				<label><input type="checkbox" value="5000">5,000원</label>
				<label><input type="checkbox" value="10000">10,000원</label>
				<label><input type="checkbox" value="50000">50,000원</label>
				<label><input type="checkbox" value="100000">100,000원</label>
				<label><input type="checkbox" value="500000">500,000원</label>
			</h4>
			<h3>총 결제 금액 <span class=""></span>원</h3>
			<button class="btn btn-danger">결제</button>
			<p id="paymentResult"></p>
			
		</div>
		<h2>5. 영화 순위 검색</h2>
		<input type="text" id="moviceData" placeholder="20201119" value="20201119">
		<button id="movieBtn" type="button" class="btn btn-primary">영화 순위 검색</button>
		<div id="movieResult"></div>
		<form action="/test1">
			<input type="text" name="test">
			<input type="submit" value="전송">
		</form>
		
		<form action="/test2">
			<input type="text" name="test">
			<input type="submit" value="전송">
		</form>
	</section>
	<script>
		$("#movieBtn").click(function(){
			var date = $("#moviceData").val();
			$.ajax({
				url : "/movieRank",
				data : {date:date},
				type : "get",
				dataType : "json",
				success : function(data){
					console.log(data);
					$("#movieResult").empty();
					var table = $("<table class='table table-bordered'></table>");
					var titleTr = $("<tr></tr>");
					titleTr.append("<th>순위</th>");
					titleTr.append("<th>영화제목</th>");
					titleTr.append("<th>개봉일</th>");
					for(var i in data){
						var tr = $("<tr></tr>");
						tr.append($("<td>"+data[i].rank+"</td>"));
						tr.append($("<td>"+data[i].movieName+"</td>"));
						tr.append($("<td>"+data[i].openDate+"</td>"));
						table.append(tr);
					}
					$("#movieResult").append(table);
				}
			})
		});
		$(function(){
			var totalPay = 0;
			$("#pay input").change(function(){
				if($(this).is(":checked")){
					totalPay += (Number)($(this).val());
				}else {
					totalPay -= (Number)($(this).val());
				}
				$("#pay span").html(totalPay);
			});
			$("#pay button").click(function(){
				var price = $("#pay span").html();
				var d = new Date();
				var date = d.getFullYear()+''+(d.getMonth()+1)+''+(d.getDate())+''+d.getHours()+''+d.getMinutes()+''+d.getSeconds();
				IMP.init("imp59960187");
				IMP.request_pay({
					merchant_uid : '상품명_'+date, //상점거래아이디
					name : "결제테스트", //결제이름
					amount : price,		//결제금액
					buyer_email : 'wa1358@naver.com', //이메일
					buyer_name : "구매자이름",
					buyer_tel : "010-2233-2232",
					buyer_addr : "서울시 중랑구",
					buyer_postcode : "123-4567"
				},function(rsp){
					if(rsp.success){            //결제성공
						var r1 = "고유 ID : " +rsp.imp_uid;
						var r2 = '상점거래 아이디: ' +rsp.merchant_uid;
						var r3 = '결제금액: ' +rsp.paid_amount;
						var r4 = '카드승인번호: ' +rsp.applyu_num;
						$("#paymentResult").html(r1+"<br>"+r2+"<br>"+r3+"<br>"+r4);
					} else{						//결제실패
						$("#paymentResult").html("결제 실패 사유: "+rsp.error_msg);
					}
				});
			});
		});
		window.onload=function(){
			//아무값도 보내지 않으면 서울시청이 중심
			//var map = new naver.maps.Map("map");
			var map = new naver.maps.Map("map",{
				center : new naver.maps.LatLng(37.533807,126.896772),
				zoom : 18,
				zoomControl : true,
				zoomControlOption : {
					position : naver.maps.Position.TOP_RIGHT, //우측상단위치
					style : naver.maps.ZoomControlStyle.SMALL
				}
			});
			var marker = new naver.maps.Marker({
				position : new naver.maps.LatLng(37.533807,126.896772),
				map : map
			});
			var infoWindow = new naver.maps.InfoWindow();
			naver.maps.Event.addListener(map,'click',function(e){
				if(infoWindow != null && infoWindow.getMap()){
					infoWindow.close();
				} 
				marker.setPosition(e.coord);
				//위경도 좌표를 주소로 가져오는 기능 reverseCeoCode -> submodule추가해야 가능
				naver.maps.Service.reverseGeocode({
					location : new naver.maps.LatLng(e.coord.lat(), e.coord.lng()),
				}, function(status, response){
					if(status != naver.maps.Service.Status.OK){
						return alert("주소검색오류");
					}
					var result = response.result;
					var items = result.items; // json 형태로 주소값을 가지고옴
					var address = items[1].address; //0 -> 지번, 1-> 도로명
					contentString = [
						'<div class="iw_inner">',
						'<p>'+address+"</p>",
						'</div>'
					].join('');
					
				});
			});
			var contentString = [
				'<div class="iw_inner">',
				'<h3>KH정보귱</h3>',
				'<p>서울시 영등포구 선유2로 57 이레빌딩 19F,20F</p>',
				'</div>'
			].join('');
			
			naver.maps.Event.addListener(marker,'click',function(e){
				if(infoWindow.getMap()){
					infoWindow.close();
				} else {
					infoWindow = new naver.maps.InfoWindow({
						content : contentString
					})
					infoWindow.open(map,marker);
				}
			});
		}
		var mailCode="";
		$("#mailBtn").click(function(){
			var email = $("#mail");
			$.ajax({
				url:"/sendMail",
				type:"post",
				data:{email:email},
				success : function(data){
					console.log(data);
					mailCode = data;
					$("#mailCode").show();
					$("#mailChk").show();
				}
			});
		})
		function addrSearch(){
			new daum.Postcode({
				oncomplete:function(data){
					//검색해서 선택한 결과가 data라는 매개변수를 통해 들어옴
					//다양한 값이 들어오지만 그중 우편번호, 도로명주소,지번주소만 갖고옴
					$('#postCode').val(data.zonecode);
					$('#roadAddr').val(data.roadAddress);
					$('#jibunAddr').val(data.jibunAddress);
					$('#detailAddr').focus();
				}
			}).open();
		}
	</script>
</body>
</html>