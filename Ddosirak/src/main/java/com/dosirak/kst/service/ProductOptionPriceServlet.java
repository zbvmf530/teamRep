package com.dosirak.kst.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/getOptionPrice")
public class ProductOptionPriceServlet extends HttpServlet {
	private ProductService svc = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String option = request.getParameter("option");
		int code;

		try {
			code = Integer.parseInt(request.getParameter("code"));
		} catch (NumberFormatException e) {
			// 로그 및 에러 응답 설정
			System.err.println("Invalid code: " + request.getParameter("code"));
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid code");
			return;
		}

		System.out.println("Received request: option=" + option + ", productId=" + code);

		// 여기에 실제 가격 조회 로직을 추가
		int price = getPriceFromDatabase(code, option);

		// JSON 응답 생성
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("price", price);

		// 응답 설정
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(jsonResponse.toString());
		out.flush();
	}

	// 데이터베이스 또는 기타 데이터 소스에서 가격을 조회하는 메서드
	private int getPriceFromDatabase(int productId, String option) {
		// 실제 데이터베이스 접근 로직 구현
		// 예: 임의의 가격 반환
		return 10000; // 임의의 값
	}
}