<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="signup.do" method="post">

<div class="idrow">
<div class="id">아이디</div>
<div class="idcontent">
<div><input type="text" name="id" id="id" value=""><button type="button" id="check">중복체크</button></div>
<div class="iderr"></div>
</div>
</div>

<div class="pwrow">
<div class="pw">비밀번호</div>
<div class="pwcontent">
<div><input type="text" name="pw" id="pw" value=""></div>
<div class="pwerr"></div>
</div>
</div>

<div class="checkpwrow">
<div class="checkpw">비밀번호 확인</div>
<div class="checkpwcontent">
<div><input type="text" name="checkpw" id="checkpw"></div>
<div class="checkpwerr"></div>
</div>
</div>

<div class="namerow">
<div class="name">이름</div>
<div class="namecontent">
<div><input type="text" name="name" id="name" value=""></div>
<div class="nameerr"></div>
</div>
</div>


<div class="phonerow">
<div class="phone">전화번호</div>
<div class="phonecontent">
<div><input type="text" name="phone" id="phone" value=""></div>
<div class="phoneerr"></div>
</div>
</div>

<div class="emailrow">
<div class="email">이메일</div>
<div class="emailcontent">
<div><input type="text" name="email" id="email" value="">@
<select class="box" id="domain" name="domain" onChange="getselect()" value="">
  <option value="naver.com">naver.com</option>
  <option value="google.com">google.com</option>
  <option value="hanmail.net">hanmail.net</option>
  <option value="nate.com">nate.com</option>
  <option value="kakao.com">kakao.com</option>
</select>
</div>
<div class="emailerr"></div>
</div>
</div>


<div class="birthrow">
<div class="birth">생년월일</div>
<div class="birthcontent">
<select class="box" id="birth-year" name="birth-year" value="">
    <option disabled selected value="unselect">출생 연도</option>
  </select>
  <select class="box" id="birth-month" name="birth-month" value="">
    <option disabled selected value="unselect">월</option>
  </select>
  <select class="box" id="birth-day" name="birth-day" value="">
    <option disabled selected value="">일</option>
  </select>
</div>
<div class="birtherr"></div>
</div>

<div class="table" align="center">
   
      <input type="submit" value="회원가입" id="submit" class="btn btn-primary">
      <input type="reset" value="취소" class="btn btn-secondary">
    
  
</div>

</form>

<script src="./ksh/js/signup.js"></script>
<script>
	const totalList = JSON.parse('${json}');
	const logid = '${logId}';
	const auth = '${auth}';
</script>
