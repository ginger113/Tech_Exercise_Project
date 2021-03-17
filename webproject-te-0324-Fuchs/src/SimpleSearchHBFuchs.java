import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.PlayerFuchs;
import util.Info;
import util.UtilDBFuchs;

@WebServlet("/SimpleSearchHBFuchs")
public class SimpleSearchHBFuchs extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SimpleSearchHBFuchs() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();
      String option = request.getParameter("option").trim();

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

      List<PlayerFuchs> listPlayers = null;
      if (keyword != null && !keyword.isEmpty()) {
         listPlayers = UtilDBFuchs.listPlayers(keyword, option);
      } else {
         listPlayers = UtilDBFuchs.listPlayers();
      }
      display(listPlayers, out);
      out.println("</ul>");
      out.println("<a href=/" + "webproject-te-0324-Fuchs" + "/" + "simpleSearchHBFuchs.html" + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<PlayerFuchs> listPlayers, PrintWriter out) {
	   
	   out.println("<table>"
			   + "<tr><th>Name</th>"
			   + "<th>Team</th>"
			   + "<th>Position</th>"
			   + "<th>Position_Rank</th>"
			   + "<th>Average_Points</th>"
			   + "<th>Total_Points</th></tr>");
	   
      for (PlayerFuchs playerFuchs : listPlayers) {
         System.out.println("[DBG] " + playerFuchs.getId() + ", " //
               + playerFuchs.getName() + ", " //
               + playerFuchs.getTeam() + ", " //
               + playerFuchs.getPos() + ", " //
               + playerFuchs.getPosRank() + ", " //
               + playerFuchs.getAvgPts() + ", " //
         	   + playerFuchs.getTotPts());

         out.println("<tr><td>" + playerFuchs.getName() + "</td>" //
               + "<td>" + playerFuchs.getTeam() + "</td>" //
               + "<td>" + playerFuchs.getPos() + "</td>" //
               + "<td>" + playerFuchs.getPosRank() + "</td>" //
               + "<td>" + playerFuchs.getAvgPts() + "</td>" //
               + "<td>" + playerFuchs.getTotPts() + "</td></tr>");
      }
      out.println("</table");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
