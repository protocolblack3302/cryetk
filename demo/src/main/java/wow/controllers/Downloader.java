package wow.controllers;

import wow.models.DBase;
import wow.models.MusicDownloader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Downloader",urlPatterns = {"/download"})
public class Downloader extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String productCode=request.getParameter("productCde");
        String url = "/index.jsp";

        if (action.equals("checkUser")) {
            url = checkUser(request, response);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action");
        String url = "/index.jsp";
        if (action.equals("add")) {
            url = registerUser(request, response);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }


    private String checkUser(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        String productCode=(String) request.getParameter("productCode");

        session.setAttribute("productCode",productCode);
        DBase user=(DBase) session.getAttribute("user");

        String url="/register.jsp";
        String email="";
        ArrayList<String> musicList = null;


        if(user==null){  //user doesnt exist in session object
            Cookie[] cookie=request.getCookies();
            for(Cookie c:cookie){
                if(c.getName().equals("emailCookie")){
                    email=c.getValue();
                }
            }

            if(email.equals("")||email==null){   //if cookies doesnt exist
            url="/register.jsp";
            }
            else {  //if cookies exist in browser

                user=DBase.getUser(email);
                session.setAttribute("user",user);
                try {
                    musicList=MusicDownloader.getList(productCode);
                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
                request.setAttribute("myList",musicList);
                url="/download.jsp";   //go to download page
            }

        }else{       //user exists in session object
            try {
                musicList=MusicDownloader.getList(productCode);
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
            request.setAttribute("myList",musicList);
            url="/download.jsp";
        }

return url;

    }


    private String registerUser(HttpServletRequest request,HttpServletResponse response){
        String message;
        String url;
String name=request.getParameter("name");
String email=request.getParameter("email");
 int age=Integer.parseInt(request.getParameter("age"));
        DBase user=new DBase(name,email,age);
        ArrayList<String> musicList=null;
        HttpSession session= request.getSession();
        String productCode=(String) session.getAttribute("productCode");

        if (name == null || email == null || email.isEmpty() || name.isEmpty() || (!((Object) age).getClass().getName().equals("java.lang.Integer"))) {
            message = "fill out all boxes correctly";
            request.setAttribute("message",message);
            url = "/register.jsp";
        } else {
            user.add();
            try {
                musicList=MusicDownloader.getList(productCode);
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
            request.setAttribute("myList",musicList);
            url = "/download.jsp";   // the "thanks" page
        }
 session.setAttribute("user",user);
 Cookie cookie=new Cookie("emailCookie",email);
 cookie.setMaxAge(60*60*24*365);
        cookie.setPath("/");
        response.addCookie(cookie);

        return url;

    }

}