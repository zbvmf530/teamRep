const errMsg = {
  id: { 
    invalid: "6~20자의 영문와 숫자만 사용 가능합니다(숫자만으로 불가능)",
    success: "사용 가능한 아이디입니다",
    fail: "사용할 수 없는 아이디입니다"
  },
  pw: {
	invalid:"4~16자의 영문, 숫자, 특수문자를 모두 포함한 비밀번호를 입력해주세요",
    success: "비밀번호가 일치합니다",
    fail: "비밀번호가 일치하지 않습니다"
  },
   phone: {
	invalid:"11자의 숫자를 입력해주세요"
  },
   name: {
	invalid:"이름을 입력해주세요"
  },
   email: {
	invalid:"이메일을 입력해주세요"
  },
   birth: {
	invalid:"생년월일을 입력해주세요"
  }
}

idpass = false;
iddupass = false;
pwpass = false;
pwcheckpass = false;
namepass = false;
phonepass = false;
emailpass = false;
yearpass = false;
monthpass = false;
daypass = false;


const idInput = document.querySelector('#id')
const idError = document.querySelector('.iderr')
idInput.addEventListener('change', () => {
  const idRegExp = /^(?=.*[a-zA-Z])[a-zA-Z0-9]{6,20}$/
  //const idRegExp = /^[a-zA-Z0-9]{6,20}$/ // 6~20자의 영문 소문자와 숫자
  if(idRegExp.test(idInput.value)) { // 유효성 검사 성공
    idError.textContent = ""
    idpass = true
    iddupass = false
  } else { // 유효성 검사 실패
    idError.textContent = errMsg.id.invalid
    idpass = false
    iddupass = false
  }
 
});

document.querySelector('#check').addEventListener('click', function () {
		
		
		if(idpass==true){
				
				fetch('check.do?id='+idInput.value)
					.then(resolve => resolve.json()) // json -> 객체.
					.then(result => {
								console.log(result)
				
				if((result.check=='OK')){
						idError.textContent = errMsg.id.success
						iddupass = true
													}
				else{
					idError.textContent = errMsg.id.fail
					iddupass = false
							}
				})
				.catch();								
		}
		
})

const pwInput = document.querySelector('#pw')
const pwError = document.querySelector('.pwerr')
pwInput.addEventListener('change', () => {
  const pwRegExp = /^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{4,16}$/ // 4~16자의 영문, 숫자, 특수문자를 모두 포함한 비밀번호를 입력해주세요
  if(pwRegExp.test(pwInput.value)) { // 유효성 검사 성공
    pwError.textContent = ""
    pwpass = true;
  } else { // 유효성 검사 실패
    pwError.textContent = errMsg.pw.invalid
    pwpass = false;
  }
 
});

const checkpwInput = document.querySelector('#checkpw')
const checkpwError = document.querySelector('.checkpwerr')
checkpwInput.addEventListener('change', () => {
const pw2Input = document.querySelector('#pw')
  if((checkpwInput.value==pw2Input.value)&&(pwpass == true)) { // 유효성 검사 성공
    checkpwError.textContent = errMsg.pw.success
   pwcheckpass = true;
  } else { // 유효성 검사 실패
    checkpwError.textContent = errMsg.pw.fail
    pwcheckpass = false;
  }
 
});


const phoneInput = document.querySelector('#phone')
const phoneError = document.querySelector('.phoneerr')
phoneInput.addEventListener('change', () => {
  const pwRegExp = /^[0-9]{11}$/ 
  if(pwRegExp.test(phoneInput.value)) { // 유효성 검사 성공
    phoneError.textContent = ""
   phonepass = true;
  } else { // 유효성 검사 실패
    phoneError.textContent = errMsg.phone.invalid
    phonepass = false;
  }
 
});

const birthYearselect=false;
const birthMonthselect=false;

const birthYearEl = document.querySelector('#birth-year')
// option 목록 생성 여부 확인
isYearOptionExisted = false;


birthYearEl.addEventListener('focus', function () {
  // year 목록 생성되지 않았을 때 (최초 클릭 시)
  if(!isYearOptionExisted) {
    isYearOptionExisted = true
    for(var i = 1960; i <= 2024; i++) {
      // option element 생성
      const YearOption = document.createElement('option')
      YearOption.setAttribute('value', i)
      YearOption.setAttribute('name', 'year')
                 
      YearOption.innerText = i
      // birthYearEl의 자식 요소로 추가
      this.appendChild(YearOption);
    }
  }
});

birthYearEl.addEventListener('change', function () {
	document.getElementById('birth-year').value=document.getElementById('birth-year').options[document.getElementById('birth-year').selectedIndex].value;
	console.log(document.getElementById('birth-year').value);
		
	yearpass = true;
})

const birthMonthEl = document.querySelector('#birth-month')
// option 목록 생성 여부 확인
isMonthOptionExisted = false;
birthMonthEl.addEventListener('focus', function () {
  // year 목록 생성되지 않았을 때 (최초 클릭 시)
  if(!isMonthOptionExisted) {
    isMonthOptionExisted = true
    for(var i = 1; i <= 12; i++) {
      // option element 생성
      const MonthOption = document.createElement('option')
      MonthOption.setAttribute('value', i)
       MonthOption.setAttribute('name', 'month')
      MonthOption.innerText = i
      // birthYearEl의 자식 요소로 추가
      this.appendChild(MonthOption);
    }
  }
});

birthMonthEl.addEventListener('change', function () {
	document.getElementById('birth-month').value=document.getElementById('birth-month').options[document.getElementById('birth-month').selectedIndex].value;
	console.log(document.getElementById('birth-month').value);
	monthpass = true;
})


const birthdayEl = document.querySelector('#birth-day')
// option 목록 생성 여부 확인


birthdayEl.addEventListener('focus', function () {
  // year 목록 생성되지 않았을 때 (최초 클릭 시)
    
const birthdayEldelete = document.querySelectorAll('#birth-day option:not(:nth-child(1))')
for (var i = 0; i < birthdayEldelete.length; i++) {
	var birthdayEldeletev = birthdayEldelete[i];
  birthdayEldeletev.remove();
 
}
   
  var Yearselect = document.getElementById('birth-year');
  var Monthselect = document.getElementById('birth-month');
  var Yearvalue = Yearselect.options[Yearselect.selectedIndex];
  var Monthvalue = Monthselect.options[Monthselect.selectedIndex];
  
  
  if((Yearvalue.value!='unselect')&& (Monthvalue.value!='unselect')) {
  
    const lastDay = new Date(Yearvalue.value, Monthvalue.value, 0).getDate();
    for(var i = 1; i <= lastDay; i++) {
      // option element 생성
      const dayOption = document.createElement('option')
      dayOption.setAttribute('value', i)
      dayOption.setAttribute('name', 'day')
      dayOption.innerText = i
      // birthYearEl의 자식 요소로 추가
      this.appendChild(dayOption);
    }
  }
});

birthdayEl.addEventListener('change', function () {
	document.getElementById('birth-day').value=document.getElementById('birth-day').options[document.getElementById('birth-day').selectedIndex].value;
	console.log(document.getElementById('birth-day').value);
	daypass = true;
})

function getselect() {
    var select = document.getElementById('domain');
    var option = select.options[select.selectedIndex];

    document.getElementById('domain').value = option.value;
    
}

const checknameError = document.querySelector('.nameerr')
document.querySelector('#name').addEventListener('change', function () {
	if(document.querySelector('#name').value==""){
		checknameError.textContent = errMsg.name.invalid
		namepass = false;		
	}
	else{
		namepass = true;
	}
})

const checkemailError = document.querySelector('.emailerr')
document.querySelector('#email').addEventListener('change', function () {
	if(document.querySelector('#email').value==""){
		checkemailError.textContent = errMsg.email.invalid
		emailpass = false;		
	}
	else{
		emailpass = true;
	}
})


document.getElementById('submit').addEventListener('click', function (e) {
	
	if(idpass == false||
iddupass == false||
pwpass == false||
pwcheckpass == false||
namepass == false||
phonepass == false||
emailpass == false||
yearpass == false||
monthpass == false||
daypass == false){
	console.log('----------------');
	console.log(idpass);
	console.log(iddupass);
	console.log(pwpass);
	console.log(pwcheckpass);
	console.log(namepass);
	console.log(phonepass);
	console.log(emailpass);
	console.log(yearpass);
	console.log(monthpass);
	console.log(daypass);
	alert('형식에 맞게 입력해주세요');
	 e.preventDefault();
	 }
})

