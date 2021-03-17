import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Info;
import util.UtilDBFuchs;

@WebServlet("/SimpleInsertHBFuchs")
public class SimpleInsertHBFuchs extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SimpleInsertHBFuchs() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name").trim();
      String team = request.getParameter("team").trim();
      String pos = request.getParameter("pos").trim();
      String posRank = request.getParameter("posRank").trim();
      String avgPts = request.getParameter("avgPts").trim();
      String totPts = request.getParameter("totPts").trim();
      UtilDBFuchs.createPlayers(name, team, pos, posRank, avgPts, totPts);

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      out.println("<li> Name: " + name);
      out.println("<li> Team: " + team);
      out.println("<li> Position: " + pos);
      out.println("<li> Position Rank: " + posRank);
      out.println("<li> Average Points Scored: " + avgPts);
      out.println("<li> Total Points Scored: " + totPts);
      out.println("</ul>");
      out.println("<a href=/" + "webproject-te-0324-Fuchs" + "/" + "simpleSearchHBFuchs.html" + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
