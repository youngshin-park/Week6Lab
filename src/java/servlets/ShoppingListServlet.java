package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String action=request.getParameter("action");
        session.setAttribute("action", action);
        session.setAttribute("username", username);
        request.setAttribute("username", username);
        int itemNumber = 0;
        session.setAttribute("itemNumber", itemNumber);
        request.setAttribute("itemNumber", itemNumber);
        ArrayList<String> shoppingItems = new ArrayList<>();

        session.setAttribute("shoppingItems", shoppingItems);
        request.setAttribute("shoppingItems", shoppingItems);
        
        if(request.getParameterMap().containsKey("action")){
            if(action.equals("logout")){
                session.invalidate();
                session = request.getSession();
                response.sendRedirect("ShoppingList");
                return;
            }
        }
        if(username != null){
            session.setAttribute("username", username);
            request.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response);
        }else{
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        String action= request.getParameter("action");
        String username = request.getParameter("user_name");
        int itemNumber = (int) session.getAttribute("itemNumber");
        ArrayList<String> shoppingItems = (ArrayList<String>) session.getAttribute("shoppingItems");
                
        if(request.getParameterMap().containsKey("action")){
            if(action.equals("logout")){
                session.invalidate();
                session = request.getSession();
                response.sendRedirect("ShoppingList");
            }
            if(action.equals("register") && !username.equals("")){
                session.setAttribute("username", username);
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
            }else if(action.equals("register") && username.equals("")){
                String message = "Invalid login, please enter username";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
            }
            if(action.equalsIgnoreCase("add")){
                String item = request.getParameter("item");
                if(!item.equals("")){
                    shoppingItems.add(item);
                    itemNumber = shoppingItems.size();

                    request.setAttribute("shoppingItems", shoppingItems);
                    request.setAttribute("itemNumber", itemNumber);

                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                        .forward(request, response);
                }else{
                    itemNumber = shoppingItems.size();

                    request.setAttribute("shoppingItems", shoppingItems);
                    request.setAttribute("itemNumber", itemNumber);

                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                        .forward(request, response);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                        .forward(request, response);
                }
            }
            if(action.equalsIgnoreCase("delete")){
                String item = request.getParameter("shoppingItem");
                shoppingItems.remove(item);
                itemNumber = shoppingItems.size();
                
                request.setAttribute("shoppingItems", shoppingItems);
                request.setAttribute("itemNumber", itemNumber);
                
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
            }
        }else{
            session.invalidate();
            session = request.getSession();
            response.sendRedirect("ShoppingList");
        }
    

    }



}
