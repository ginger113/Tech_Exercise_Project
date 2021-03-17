package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PlayersFuchs")
public class PlayerFuchs {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private String id;

   @Column(name = "name")
   private String name;
   
   @Column(name = "team")
   private String team;
   
   @Column(name = "position")
   private String pos;

   @Column(name = "position_rank")
   private String posRank;
   
   @Column(name = "average_points_scored")
   private String avgPts;
   
   @Column(name = "total_points_scored")
   private String totPts;

   public PlayerFuchs() {
   }
   
   public PlayerFuchs(String name, String team, String pos, String posRank, String avgPts, String totPts) {
	      this.name = name;
	      this.team = team;
	      this.pos = pos;
	      this.posRank = posRank;
	      this.avgPts = avgPts;
	      this.totPts = totPts;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getTeam() {
	   return team;
   }
   
   public void setTeam(String team) {
	   this.team = team;
   }
   
   public String getPos() {
	   return pos;
   }
   
   public void setPos(String pos) {
	   this.pos = pos;
   }
   
   public String getPosRank() {
	   return posRank;
   }
   
   public void setPosRank(String posRank) {
	   this.posRank = posRank;
   }
   
   public String getAvgPts() {
	   return avgPts;
   }
   
   public void setAvgPts(String avgPts) {
	   this.avgPts = avgPts;
   }
   
   public String getTotPts() {
	   return totPts;
   }
   
   public void setTotPts(String totPts) {
	   this.totPts = totPts;
   }

   @Override
   public String toString() {
      return "PlayerFuchs: " + this.id + ", " + this.name + ", " + this.team + ", " + this.pos + ", " + this.posRank + ", " + this.avgPts + ", " + this.totPts;
   }
}