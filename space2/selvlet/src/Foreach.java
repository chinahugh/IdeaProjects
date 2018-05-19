import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @Author: hugh
 * @Time: 2017/12/19 10:03 PM
 * @Discraption:
 */
//@WebService(name = "/foreach")
public class Foreach extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ArrayList<String> path = new ArrayList<>();
        path.add("img/1.jpg");
        path.add("img/1.jpg");
        path.add("img/1.jpg");
        path.add("img/1.jpg");
        path.add("img/1.jpg");
        path.add("img/1.jpg");
        path.add("img/1.jpg");
        out.print(1);
        int row = 3;
        int clum = 3;
        String[][] spath = new String[row][clum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clum; j++) {
                spath[i][j] = "img/1.jpg";
            }
        }
        System.out.println("-------------------------------------------------------------");
/*        req.getSession().setAttribute("path",path);*/
        req.getSession().setAttribute("path", "img/1.jpg");
        req.getSession().setAttribute("colum", clum);
        req.getSession().setAttribute("row", row);
        req.getRequestDispatcher("creatTable.jsp").forward(req, resp);

    }
}
