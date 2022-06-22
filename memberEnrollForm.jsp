<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    <!-- 메뉴바 -->
    <jsp:include page="../common/header.jsp" />

    <div class="content">
        <br><br>
        <div class="innerOuter">
            <h2>회원가입</h2>
            <br>

            <form action="insert.me" method="post" id="enrollForm">
                <div class="form-group">
                    <label for="userId">* ID : </label>
                    <input type="text" class="form-control" id="userId" placeholder="Please Enter ID" name="userId" required> <br>
                    <div id="checkResult" style="font-size:0.8em; display:none;"></div>     
                    <br>     
                         
                    <label for="userPwd">* Password : </label>
                    <input type="password" class="form-control" id="userPwd" placeholder="Please Enter Password" name="userPwd" required> <br>

                    <label for="checkPwd">* Password Check : </label>
                    <input type="password" class="form-control" id="checkPwd" placeholder="Please Enter Password" required> <br>

                    <label for="userName">* Name : </label>
                    <input type="text" class="form-control" id="userName" placeholder="Please Enter Name" name="userName" required> <br>

                    <label for="email"> &nbsp; Email : </label>
                    <input type="text" class="form-control" id="email" placeholder="Please Enter Email" name="email"> <br>

                    <label for="age"> &nbsp; Age : </label>
                    <input type="number" class="form-control" id="age" placeholder="Please Enter Age" name="age"> <br>

                    <label for="phone"> &nbsp; Phone : </label>
                    <input type="tel" class="form-control" id="phone" placeholder="Please Enter Phone (-없이)" name="phone"> <br>
                    
                    <label for="address"> &nbsp; Address : </label>
                    <input type="text" class="form-control" id="address" placeholder="Please Enter Address" name="address"> <br>
                    
                    <label for=""> &nbsp; Gender : </label> &nbsp;&nbsp;
                    <input type="radio" id="Male" value="M" name="gender" checked>
                    <label for="Male">남자</label> &nbsp;&nbsp;
                    <input type="radio" id="Female" value="F" name="gender">
                    <label for="Female">여자</label> &nbsp;&nbsp;
                </div> 
                <br>
                <div class="btns" align="center">
                    <button type="submit" class="btn btn-primary" disabled>회원가입</button>
                    <button type="reset" class="btn btn-danger">초기화</button>
                </div>
            </form>
        </div>
        <br><br>
        
        <script>
          $(function() {
        	  
        	  //아이디를 입력하는 input 요소 객체 자체를 변수에 담아두기
        	  var $idInput = $("#enrollForm input[name=userId]");
        	  
        	  $idInput.keyup(function() {
        		 // console.log($idInput.val());
        		 
        		 // 우선 최소5글자 이상으로 입력되어야지만 ajax를 요청 할 수 있게끔 막아주자
        		 if($idInput.val().length >= 5){
        			 
        			 $.ajax({
        				 url : "idCheck.me",
        				 data : {checkId : $idInput.val()},
        				 success : function(result) {
        					 
        					 if(result == "NNNNN"){ //사용 불가능
        						 
        						 // 빨간색 메세지(사용불가능) 출력
        						 $("#checkResult").show();
        					     $("#checkResult").css("color","red").text("중복된 아이디가 존재합니다. 다시 입력해주세요.");
        						 
        					     // 회원가입버튼 비활성
        					     $("#enrollForm :submit").attr("disabled",true);
        					     
        					 }
        					 else{ //사용 가능
        						 
        						 //초록색 메세지(사용가능) 출력
        						 $("#checkResult").show();
        					     $("#checkResult").css("color","green").text("멋진 아아디네요!");
        						 
        					     //회원가입버튼 활성
        					     $("#enrollForm :submit").attr("disabled",false);
        					     
        					 }
        					 
        				 },
        				 error : function() {
        					 console.log("아이디 중복 체크용 ajax 통신 실패!");
        				 }
        			 });
        			 
        		 }
        		 else{ //5글자 미만일때 => 회원가입버튼 비활성, 메세지 숨기기
        			 
        			 $("#checkResult").hide();
        		     $("#enrollForm :submit").attr("disabled",true);
        			 
        		 }
        		 
        	  });
        	  
          });   
        </script>

    </div>

    <!-- 푸터바 -->
    <jsp:include page="../common/footer.jsp" />

</body>
</html>