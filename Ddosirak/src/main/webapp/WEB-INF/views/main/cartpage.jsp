<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
.table {
  caption-side: bottom;
  border-collapse: collapse;
}

.caption {
  padding-top: 0.5rem;
  padding-bottom: 0.5rem;
  color: #6c757d;
  text-align: left;
}

.th {
  text-align: inherit;
  text-align: -webkit-match-parent;
}

.thead,
.tbody,
.tfoot,
.tr,
.td,
.th {
  border-color: inherit;
  border-style: solid;
  border-width: 0;
}

.basketdiv {
    width: 100%;
    border-top: 1px solid #e0e0e0;
    float: left;
    font-size: 0.9375em;
    margin-bottom: 20px;
}
    .basketdiv .row.head {
        border-bottom: 2px solid #888;
        box-sizing: border-box;
        background-color: #f4f4f4;
        font-weight: 500;
    }
    .basketdiv .data {
        border-bottom: 1px dashed #888;
        box-sizing: border-box;
        cursor: pointer;
        float: left;
        width: 100%;
    }
    .basketdiv .data .empty{
        text-align: center;
        padding: 12px 0;
    }
    .basketdiv .row.head .subdiv {
        background-color: #f4f4f4;
    }
    .basketdiv .row > .subdiv {
        display: block;
        float: left;
    }
    .basketdiv .row > .subdiv:nth-child(1) {
        width: 50%;
    }
    .basketdiv .row > .subdiv:nth-child(2) {
        width: 40%;
    }
    .basketdiv .row > .subdiv:nth-child(3) {
        width: 10%;
    }
    .basketdiv2 .row > .subdiv:nth-child(1) {
        width: 60%;
    }
    .basketdiv2 .row > .subdiv:nth-child(2) {
        width: 40%;
    }
    .basketdiv .row > div > div {
        display: block;
        float: left;
        text-align: center;
        margin: 0;
        padding: 12px 0;
    }
    .basketdiv .row.data > div > div {
        height: 60px;
        line-height: 60px;
    }
        .basketdiv .data .num .updown {
            color: #0075ff;
            font-size: 2em;
            letter-spacing: -5px;
        }
        .basketdiv .check {
            width: 10%;
        }
    .basketdiv .check input[type=checkbox] {
        transform: scale(1.5);
    }
    .basketdiv .img{
        width: 20%;
    }
    .basketdiv .pname{
        width: 70%;
    }
    .basketdiv2 .pname {
        width: 80%;
    }
    .basketdiv .basketprice {
        width: 33%;
    }
    .basketdiv .num {
        width: 33%;
      min-width: 105px;
    }
    .basketdiv .sum {
        width: 34%;
      max-width: 80px;
        color: #0000aa;
    }
    .basketdiv .point {
        width: 50%;
    }
    .basketdiv2 .basketprice {
        width: 25%;
    }

    .basketdiv2 .num {
        width: 25%;
    }

    .basketdiv2 .sum {
        width: 25%;
        color: #0000aa;
    }

    .basketdiv2 .point {
        width: 25%;
    }
    .basketdiv .basketcmd{
        width: 100%;
    }
    .basketdiv .data .pname {
        text-align: left !important;
      line-height: 1.2 !important;
    }
    .basketdiv .data .price, .basketdiv .data .sum, .basketdiv .data .point {
        text-align: right;
    }
    .baseform > tbody > tr > td:first-child {
        width: 100px;
    }

.buttongroup {
    padding: 11px 0;
    margin: 50px 0;
}
.narrowbuttongroup{
    margin: 15px 0;
}
    .buttongroup.center {
        text-align: center;
    }
    .buttongroup input[type=text], .buttongroup input[type=password] {
        height: 30px;
    }
    .buttongroup button, .buttongroup a {
        margin-right: 5px;
    }
        .buttongroup button:last-child, .buttongroup a:last-child {
            margin-right: 0;
        }

    .abutton, .abutton:link, .abutton:visited, .abutton:active, input[type=button] {
        background-color: #383838;
        border: 1px solid #888888;
        color: #ffffff;
        cursor: pointer;
        letter-spacing: -1px;
        padding: 3px 5px;
        margin: 2px 3px;
        width: auto;
        word-break: keep-all;
        border-radius: 5px;
        text-decoration: none;
        font-size: 0.9375em;
    }

.abutton-alt {
    background-color: #d3e2c6;
}

.red {
    color:#b00;
}
.blue {
  color: #0075ff;
}
.basketrowcmd, .sumcount, .summoney{
  text-align: right;
  margin-bottom: 10px;
}
.sumcount, .summoney{
  font-size: 1.25em;
    font-weight: bold;
}
.buttongroup{
  text-align: center;
}
.buttongroup a{
  text-decoration: none;
}
.cmd a, .cmd span {
    padding: 12px 30px;
    box-sizing: border-box;
    margin-top: 10px;
    font-size: 1.2em;
    color: #000;
    background-color: #f4f4f4;
    border: 1px solid #e0e0e0;
    text-align: center;
}
.cmd.small a, .cmd.small span {
    padding: 6px 20px;
    font-size: 0.8125em;
}

.orderform .p_num {
    text-align: right;
    width: 40px;
    font-size: 1em;
}
</style>

 <form name="orderform" id="orderform" method="post" class="orderform" action="/Page">

    <input type="hidden" name="cmd" value="order">

    <div class="basketdiv" id="basket">

      <!-- 헤더부분. -->
      <div class="row head">
        <div class="subdiv">
          <div class="check">선택</div>
          <div class="img">이미지</div>
          <div class="pname">상품명</div>
        </div>
        <div class="subdiv">
          <div class="basketprice">가격</div>
          <div class="num">수량</div>
          <div class="sum">합계</div>
        </div>
        <div class="subdiv">
          <div class="basketcmd">삭제</div>
        </div>
        <div class="split"></div>
      </div>
      <!-- 헤더부분. -->

      <!-- 데이터 부분. -->
      <div class="row data" data-id="0" style="display: none;">
        <div class="subdiv">
          <div class="check"><input type="checkbox" name="buy" value="260" checked="checked">&nbsp;</div>
          <div class="img"><img src="./images/과테말라 안티구아.jpg" width="60"></div>
          <div class="pname"> <span>찜마마(XJ-92214/1)</span> </div>
        </div>
        <div class="subdiv">
          <div class="basketprice">
            <input type="hidden" name="p_price" id="p_price0" class="p_price" value="20000">20,000원
          </div>
          <div class="num">
            <div class="updown">
              <input type="text" name="p_num0" id="p_num0" size="2" maxlength="4" class="p_num" value="2"
                onkeyup="javascript: basket.changePNum(0);">
              <span onclick="javascript: basket.changePNum(0);">
                <i class="fas fa-arrow-alt-circle-up up"></i>
              </span>
              <span onclick="javascript: basket.changePNum(0);">
                <i class="fas fa-arrow-alt-circle-down down"></i>
              </span>
            </div>
          </div>
          <div class="sum">40,000원</div>
        </div>
        <div class="subdiv">
          <div class="basketcmd">
            <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a>
          </div>
        </div>
      </div>
      <!-- 데이터 부분. -->

    </div>

    <!-- 선택삭제. -->
    <div class="right-align basketrowcmd">
      <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delCheckedItem();">선택상품삭제</a>
      <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delAllItem();">장바구니비우기</a>
    </div>

    <!-- 합계정보보여주기. -->
    <div class="bigtext right-align sumcount" id="sum_p_num">상품갯수: <span>4</span>개</div>
    <div class="bigtext right-align box blue summoney" id="sum_p_price">합계금액: <span>74,200</span>원</div>

    <div id="goorder" class="">
      <div class="clear"></div>
      <div class="buttongroup center-align cmd">
        <a href="javascript:void(0);">선택한 상품 주문</a>
      </div>
    </div>
</form>
    <script>
	const totalList = JSON.parse('${json}');
	const logid = '${logId}';
	const auth = '${auth}';
</script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="./jsb/js/cartService.js"></script>
  <script src="./jsb/js/cart.js"></script>
