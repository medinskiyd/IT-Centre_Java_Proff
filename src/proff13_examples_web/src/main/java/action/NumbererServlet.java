package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * User: Devian
 * Date: 01.12.13
 * Time: 17:08
 */
@WebServlet(value = "/numberer")
public class NumbererServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
        ProcessEnterString process = new ProcessEnterString();
        ArrayList<Integer> nums = process.splitString(parameterMap.get("numbers")[0]);
        Task5 task5 = new Task5();
        Task6 task6 = new Task6();
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Task4 task4 = new Task4();
        ArrayList<Integer> task5data = task5.secondHalf(nums);
        ArrayList<Integer> task4data = task4.go(nums);
        ArrayList<Integer> task3data = task3.go(nums);
        ArrayList<Integer> task2data = task2.add10(nums);
        ArrayList<Integer> task1data = task1.listback(nums);
        ArrayList<Integer> task6data = task6.sumAver(nums);

        request.setAttribute("task1Data",task1data);
        request.setAttribute("task2Data",task2data);
        request.setAttribute("task3Data",task3data);
        request.setAttribute("task4Data",task4data);
        request.setAttribute("task5Data", task5data);
        request.setAttribute("task6Data",task6data);
        RequestDispatcher dispatcher = request.getRequestDispatcher("showResult.jsp");
        dispatcher.forward(request, response);
    }


    private void printResults(HttpServletResponse response, ArrayList<String> nums) throws IOException{

    }


}
