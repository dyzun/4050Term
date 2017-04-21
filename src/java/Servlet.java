/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import logic.LogicImpl;

/**
 *
 * @author dyzun
 */
@WebServlet(urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        LogicImpl logic = new LogicImpl(request, response); // Starts the logic layer

        // If the signin button is pressed on the login.jsp page
        if (request.getParameter("signin") != null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            // If the fields are empty, show a message
            if(username.isEmpty() || password.isEmpty()){
                String message = "One or both of the required fields are empty. Please try again.";
                request.setAttribute("message", message);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

            // If 1 (found match in database), then open the homepage
            else if (logic.checkLogin(username, password) == 1) {
                request.getRequestDispatcher("homepage.html").forward(request, response);
            } 

            // Else, send a message and re-open the login.jsp
            else {
                String message = "Incorrect username or password. Please try again.";
                request.setAttribute("message", message);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
////
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.Writer;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import edu.uga.cs4300.logiclayer.LogicImpl;
//import edu.uga.cs4300.objectlayer.Game;
//import edu.uga.cs4300.objectlayer.Review;
//import freemarker.template.Configuration;
//import freemarker.template.DefaultObjectWrapperBuilder;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//import freemarker.template.TemplateExceptionHandler;
//import javax.servlet.http.HttpSession;
//
//
//
//
///**
// * Servlet implementation class imdbServlet
// */
//@WebServlet("/Servlet")
//public class Servlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    
//	Configuration cfg = null;
//    Map<String, Object> root = new HashMap<String, Object>();
//    ArrayList<Game> gameList = new ArrayList<Game>();
//    ArrayList<Review> revList = new ArrayList<Review>();
//    ArrayList<Game> gamesForPurchase = new ArrayList<Game>();
//    private String templateDir = "/WEB-INF/templates";
//    String console="";
//    String genre="";
//    String gameId="";
//    String gameToRemove="";
//    String myCart="";
//    int totalPrice = 0;
//    boolean login=false;
//    String logIn="";
//    String logOut="";
//    String gameToCart="";
//    String register="";
//    int user_id=0;
//    String clearCart="";
//    String myReview="";
//    String score="";
//    String idForReview="";
//
//    
//    
//    
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Servlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//    
//    public void init() {
//    	// Create your Configuration instance, and specify if up to what FreeMarker
//    	// version (here 2.3.25) do you want to apply the fixes that are not 100%
//    	// backward-compatible. See the Configuration JavaDoc for details.
//    	cfg = new Configuration(Configuration.VERSION_2_3_25);
//    	
//    	// Specify the source where the template files come from.
//		cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);
//		
//		// Sets how errors will appear.
//		// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
//		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//		
//		// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
//		cfg.setLogTemplateExceptions(false);
//		
//		
//    }// init
//	
//	public void runTemplate(HttpServletRequest request, HttpServletResponse response, String templName) {
//			// You can use this structure for all of your objects to be sent to browser
//			Template template = null;
//			DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
//			
//			try {
//				String templateName = templName;
//				template = cfg.getTemplate(templateName);
//				response.setContentType("text/html");
//				Writer out = response.getWriter();
//				template.process(root, out);
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (TemplateException e) {
//				e.printStackTrace();
//			}
//	}// runTemplate
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			
//			LogicImpl logic = new LogicImpl(request, response);
//			console = request.getParameter("myConsole");
//			genre = request.getParameter("myGenre");
//			gameId = request.getParameter("myGame");
//			gameToCart = request.getParameter("gameToCart");
//			gameToRemove = request.getParameter("gameToRemove");
//			myCart = request.getParameter("myCart");
//                        logIn = request.getParameter("logIn");
//                        logOut = request.getParameter("logOut");
//                        register = request.getParameter("register");
//                        String username ="";
//			username= request.getParameter("user");
//			String password ="";
//			password = request.getParameter("passw");
//                        
//                        String street = request.getParameter("street");
//                        String email = request.getParameter("email");
//                        String state = request.getParameter("state");
//                        String city = request.getParameter("city");
//                        String zip = request.getParameter("zip");
//                        clearCart= request.getParameter("clearCart");
// 			myReview = request.getParameter("myReview");
// 			score= request.getParameter("score");
// 			idForReview = request.getParameter("idForReview");
//                        
//			gameList.clear();
//			
//			if(console != null){
//				if(console.equalsIgnoreCase("All")){
// 					gameList.addAll(logic.getAllGames());
// 				}
// 				else {
// 					gameList.addAll(logic.getGamesByConsole(console));
// 				}
//				root.put("games", gameList);
//				root.put("console", console);
//				runTemplate(request, response,"displayGames.ftl");
//			}
//			else if(genre != null){
//				gameList.addAll(logic.getGamesByGenre(genre));
//				root.put("games", gameList);
//				root.put("genre", genre);
//				runTemplate(request, response,"displayGenre.ftl");
//			}
//			else if(gameId != null){
//                            	revList.clear();
//				int id = Integer.parseInt(gameId);
//				Game gm = logic.getGameById(id);
//                                revList.addAll(logic.getReviewsByGame(id));
//				root.put("game", gm);
//                                root.put("reviews", revList);
//				runTemplate(request, response, "gamePage.ftl");
//			}
//                        else if(gameToCart != null){
//                                totalPrice=0;
// 				gamesForPurchase.clear();
//				int id = Integer.parseInt(gameToCart);
//				logic.addToCart(user_id, id);
// 				gamesForPurchase.addAll(logic.getCart(user_id));
// 				for(int i = 0; i < gamesForPurchase.size(); i++){
// 					totalPrice += gamesForPurchase.get(i).getPrice();
// 				}
//				root.put("totalPrice", totalPrice);
//				root.put("games", gamesForPurchase);
//				runTemplate(request, response, "cart.ftl");
//			}
//			else if(myCart != null){
//                               totalPrice=0;
// 				gamesForPurchase.clear();
// 				gamesForPurchase.addAll(logic.getCart(user_id));
// 				for(int i = 0; i < gamesForPurchase.size(); i++){
// 					totalPrice += gamesForPurchase.get(i).getPrice();
// 				}
//				root.put("totalPrice", totalPrice);
//				root.put("games", gamesForPurchase);
//				runTemplate(request, response, "cart.ftl");
//			}
//                        else if(logIn !=null){
//                            String output = "";
//                        
//                            if(logic.checkLoginInfo(username, password)){
//                            int userid = logic.usernameToId(username); 
//                            user_id =userid;
//                            HttpSession session = request.getSession(); //creates a new session
//                            session.setAttribute("name", username);
//                            session.setAttribute("user_id",userid);
//                            output = "User: " + username ;
//                            System.out.println("Logged in");
//                        }
//                            else output = "Account information is incorrect";
//                            
//                            root.put("input",output);
//                            runTemplate(request, response, "index.ftl");
//                        }
//                        else if(logOut != null){
//                            String output ="User: Guest";
//                            response.setContentType("text/html");  
//                            PrintWriter out=response.getWriter();  
//                            HttpSession session=request.getSession();
//                            user_id =0;
//                            session.invalidate();  
//                            root.put("input", output);
//                            runTemplate(request, response, "index.ftl");
//                        }
//                        else if(register != null){
//                            String output = "";
//                            if(logic.register(username, password, email, street, city, state, zip)) output = "Account created. Enter information above to sign in";
//                            else output = "Username is already taken";
//                            root.put("input", output);
//                            runTemplate(request, response, "index.ftl");
//                       }else if(gameToRemove != null){
// 				totalPrice=0;
// 				gamesForPurchase.clear();
// 				int id = Integer.parseInt(gameToRemove);
// 				int update =logic.removeFromCart(user_id, id);
// 				System.out.println("Update is: "+ update);
// 				gamesForPurchase.addAll(logic.getCart(user_id));
// 				for(int i = 0; i < gamesForPurchase.size(); i++){
// 					totalPrice += gamesForPurchase.get(i).getPrice();
// 				}
// 				root.put("totalPrice", totalPrice);
// 				root.put("games", gamesForPurchase);
// 				runTemplate(request, response, "cart.ftl");
// 			}
// 			else if(clearCart != null){
// 				logic.clearCart(user_id);
// 				totalPrice=0;
// 				gamesForPurchase.clear();
// 				root.put("totalPrice", totalPrice);
// 				root.put("games", gamesForPurchase);
// 				runTemplate(request, response, "cart.ftl");
// 			}
// 			else if(myReview != null && score != null){
// 				revList.clear();
// 				int num = Integer.parseInt(score);
// 				int gId = Integer.parseInt(idForReview);
// 				logic.addReview(gId, myReview, user_id, num);
// 				revList.addAll(logic.getReviewsByGame(gId));
// 				Game gm = logic.getGameById(gId);
// 				root.put("game", gm);
// 				root.put("reviews", revList);
// 				runTemplate(request, response, "gamePage.ftl");
// 			}
//
//	} // doGet
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//		
//	} //doPost
//
//}
