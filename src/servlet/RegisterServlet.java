package servlet;

import db.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/Register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决网络乱码问题
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");//设置编码

        String name = request.getParameter("name");
        String password = ("password");
        String password2 = request.getParameter("password2");
        PrintWriter out = response.getWriter();
        if (password.equals(password2)){
            try{
                Database database = new Database();
                database.insert(name,password);
                out.println("注册成功");
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("注册失败");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                out.println("注册失败");
            }
        }else{
            out.println("两次输入密码不一致");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
