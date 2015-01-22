package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/serv")
public class HelloServ extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        Map nameMap = new HashMap();
        nameMap.put(0, "dima");
        nameMap.put(1, "vlad");
        nameMap.put(2, "roma");

        Map passwordMap = new HashMap();
        passwordMap.put(0, "1234");
        passwordMap.put(1, "4321");
        passwordMap.put(2, "1111");

        Map<String, String[]> paramMap= request.getParameterMap();
        String[] name = paramMap.get("login");
        String[] password = paramMap.get("password");

        String nameStr = join(name, ", ");
        String passStr = join(password, ", ");
        int a = 0;

        for(int i = 0; i < nameMap.size(); i++){
            if(nameMap.get(i).equals(nameStr) && passwordMap.get(i).equals(passStr)){
                request.setAttribute("name", nameStr);
                RequestDispatcher disp = request.getRequestDispatcher("autentification.jsp");
                disp.forward(request, response);
                //response.getWriter().println("Hi! " + nameMap.get(i));
                a = 1;
                response.getWriter().println(nameMap.toString());
                response.getWriter().println(passwordMap.toString());
            }
        }

        if(a == 0){
            RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
            request.setAttribute("name", nameStr);
            request.setAttribute("pass", passStr);
            disp.forward(request, response);
            //response.getWriter().println("Wrong name or password! Try again.!");

        }
        a = 0;

    }
    // метод создает из массива строк, 1 строку.
    public <T> String join(T[] array, String cement) {
        StringBuilder builder = new StringBuilder();

        if(array == null || array.length == 0) {
            return null;
        }
        for (T t : array) {
            builder.append(t).append(cement);
        }
        builder.delete(builder.length() - cement.length(), builder.length());

        return builder.toString();
    }
}
