package com.dosirak.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dosirak.hjh.web.AddBoardControl;
import com.dosirak.hjh.web.AddFormControl;
import com.dosirak.hjh.web.AddReplyControl;
import com.dosirak.hjh.web.BoardInfoControl;
import com.dosirak.hjh.web.BoardListControl;
import com.dosirak.hjh.web.ModBoardFormControl;
import com.dosirak.hjh.web.ModifyControl;
import com.dosirak.hjh.web.RemoveControl;
import com.dosirak.hjh.web.RemoveReplyControl;
import com.dosirak.hjh.web.ReplyListControl;
import com.dosirak.hjh.web.TotalCountControl;

import com.dosirak.jsb.web.CartControl;
import com.dosirak.jsb.web.GetIDControl;
import com.dosirak.jsb.web.MainControl;
import com.dosirak.jsb.web.MenuControl;
import com.dosirak.jsb.web.MypageControl;
import com.dosirak.ksh.web.AddMemberControl;
import com.dosirak.ksh.web.IdCheck;
import com.dosirak.ksh.web.LogOutControl;
import com.dosirak.ksh.web.SignupForm;
import com.dosirak.ksh.web.tLoginControl;
import com.dosirak.ksh.web.tLoginForm;
import com.dosirak.kst.web.ProductDetailControl;
import com.dosirak.kst.web.ProductListControl;






public class FrontControl extends HttpServlet{

Map<String, Control> map;
	
	// 생성자
	public FrontControl() {
		map = new HashMap<>();
	}
	// init
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 메인페이지
		map.put("/main.do", new MainControl());
		// 메뉴 구성
		map.put("/menuList.do", new MenuControl());
		// 세션 아이디 가져오는 컨트롤
		map.put("/getID.do", new GetIDControl());
		
		// 마이페이지
		map.put("/mypage.do", new MypageControl());
		
		// 장바구니 페이지
		map.put("/cartpage.do", new CartControl());
		
		// 로그인, 회원가입 관련 콘트롤
		map.put("/tloginForm.do", new tLoginForm());
		map.put("/tlogin.do", new tLoginControl());
		map.put("/signupform.do", new SignupForm());
		map.put("/signup.do", new AddMemberControl());
		map.put("/check.do", new IdCheck());
		map.put("/logout.do", new LogOutControl());
		
		//공지사항,문의사항 관련 콘트롤
		map.put("/boardList.do", new BoardListControl()); // 공지사항목록
		map.put("/addForm.do", new AddFormControl()); // 글등록 화면
		map.put("/addBoard.do", new AddBoardControl()); // 글등록 기능
		map.put("/boardInfo.do", new BoardInfoControl()); // 상세보기화면

		//게시글 수정 삭제 
		map.put("/modBoardForm.do", new ModBoardFormControl()); // 수정화면
		map.put("/updateBoard.do", new ModifyControl()); // 수정
		map.put("/deleteBoard.do", new RemoveControl()); //글삭제
		
		
		// 댓글관련
		map.put("/replyList.do", new ReplyListControl());// 댓글보기
		map.put("/removeReply.do", new RemoveReplyControl());// 댓글삭제
		map.put("/addReply.do", new AddReplyControl()); // 댓글작성
		map.put("/getTotalCnt.do", new TotalCountControl()); // 댓글갯수
		
		// 상품관련
		map.put("/productlist.do", new ProductListControl());
		map.put("/productDetail.do", new ProductDetailControl());

	}
	
	// service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// filter에서 이미 처리함
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		System.out.println("uri : "+uri+", context : "+context);
		String path = uri.substring(context.length());
		System.out.println("path : "+path);
		
		Control control = map.get(path);
		control.exec(req,resp);
	}
	
	// destroy
	@Override
	public void destroy() {
		System.out.println("destroy 호출됨. :: 인스턴스가 메모리에 사라질 때 호출.");
	}
}
