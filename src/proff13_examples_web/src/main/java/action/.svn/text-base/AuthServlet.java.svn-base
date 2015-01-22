package action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 12.06.13
 */
@WebServlet(value = "/auth")
public class AuthServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();

        printLoginFromParams(response, parameterMap.get("login")[0]);
        printPassFromParams(response, parameterMap.get("pass")[0]);

    }

    private void printLoginFromParams(HttpServletResponse response, String login) throws IOException {
        System.out.println(login);
        response.getWriter().print(login);
    }
    private void printPassFromParams(HttpServletResponse response, String pass) throws IOException {
        System.out.println(pass);
        response.getWriter().print(pass);
    }
}
