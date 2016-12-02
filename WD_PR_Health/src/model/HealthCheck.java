package model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HealthCheck
 */
@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HealthCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("HealthCheck.jsp") ;
		dispatcher.forward(request,response) ;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//リクエストパラメータを取得 
		String weight = request.getParameter("weight") ; //体重
		String height = request.getParameter("height"); //身長

		//入力値をプロパティに設定 
		Health health = new Health();
		health.setHeight(Double.parseDouble(height));
		health.setWeight(Double.parseDouble(weight));

		
		//健康診断を実行．結果を設定 
		HealthCheckLogic healthCheckLogic = new HealthCheckLogic() ;
		healthCheckLogic.execute(health); //参照渡し
		
		//リクエストスコープに保存 
		request.setAttribute("health",health);

		//フォワート
		RequestDispatcher dispatcher = request.getRequestDispatcher("HealthCheckResults.jsp") ;
		dispatcher.forward(request,response);

	}

}
