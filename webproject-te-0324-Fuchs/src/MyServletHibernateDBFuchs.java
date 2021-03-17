import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.PlayerFuchs;
import util.UtilDBFuchs;

@WebServlet("/MyServletHibernateDBFuchs")
public class MyServletHibernateDBFuchs extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MyServletHibernateDBFuchs() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");

      // #1
      UtilDBFuchs.createPlayers("Josh Allen", "Buffalo Bills", "QB", "1", "25.32", "405.06");
      UtilDBFuchs.createPlayers("Kyler Murray", "Arizona Cardinals", "QB", "2", "24.42", "390.74");
      UtilDBFuchs.createPlayers("Aaron Rodgers", "Green Bay Packers", "QB", "3", "24.20", "387.26");
      UtilDBFuchs.createPlayers("Alvin Kamara", "New Orleans Saints", "RB", "1", "25.2", "377.8");
      UtilDBFuchs.createPlayers("Dalvin Cook", "Minnesota Vikings", "RB", "2", "24.1", "337.8");
      UtilDBFuchs.createPlayers("Derrick Henry", "Tennesse Titans", "RB", "3", "20.8", "333.1");
      UtilDBFuchs.createPlayers("Davante Adams", "Green Bay Packers", "WR", "1", "25.6", "358.4");
      UtilDBFuchs.createPlayers("Tyreek Hill", "Kansas City Cheifs", "WR", "2", "21.9", "328.9");
      UtilDBFuchs.createPlayers("Stefon Diggs", "Buffalo Bills", "WR", "3", "328.6", "20.5");
      UtilDBFuchs.createPlayers("Travis Kelce", "Kansas City Chiefs", "TE", "1", "20.9", "312.8");
      UtilDBFuchs.createPlayers("Darren Waller", "Oakland Raiders", "TE", "2", "17.4", "278.6");
      UtilDBFuchs.createPlayers("Robert Tonyan", "Green Bay Packers", "TE", "3", "11.0", "176.6");
      // #2
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<PlayerFuchs> listPlayers = UtilDBFuchs.listPlayers();
      for (PlayerFuchs playerFuchs : listPlayers) {
         System.out.println("[DBG] " + playerFuchs.getId() + ", " //
               + playerFuchs.getName() + ", " //
               + playerFuchs.getTeam() + ", " //
               + playerFuchs.getPos() + ", " //
               + playerFuchs.getPosRank() + ", " //
               + playerFuchs.getAvgPts() + ", " //
         	   + playerFuchs.getTotPts());

         out.println("<li>" + playerFuchs.getName() + ", " //
               + playerFuchs.getTeam() + ", " //
               + playerFuchs.getPos() + ", " //
               + playerFuchs.getPosRank() + ", " //
               + playerFuchs.getAvgPts() + ", " //
               + playerFuchs.getTotPts() + "</li>");
      }
      out.println("</ul>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
