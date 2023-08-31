import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class queriesClass extends  connectionClass{
    connectionClass c=new connectionClass();
    public PreparedStatement insertQuery(){
        try{
            Connection con=c.connectionMeathod();
            PreparedStatement ps=con.prepareStatement("insert into bank2 values(?,?,?,?)");
            return ps;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public PreparedStatement deleteQuery(){
        try{
            Connection con=c.connectionMeathod();
            PreparedStatement ps=con.prepareStatement("DELETE FROM bank2 WHERE MOBILENUMBER=?");
            return ps;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public PreparedStatement updateQuery(){
        try{
            Connection con=c.connectionMeathod();
            PreparedStatement ps=con.prepareStatement("UPDATE bank2 SET AMOUNT = ? WHERE MOBILENUMBER = ?");
            return  ps;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public PreparedStatement getRecordQuery(){
        try{
            Connection con=c.connectionMeathod();
            PreparedStatement ps=con.prepareStatement("select * from bank2 where MOBILENUMBER=?");
            return ps;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public PreparedStatement autheticateUser(){
        try{
            ResultSet rs = null;
            Connection con=c.connectionMeathod();
            PreparedStatement ps=con.prepareStatement("select * from bank2 where MOBILENUMBER=? and password=?");
            return ps;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }

    }
}
