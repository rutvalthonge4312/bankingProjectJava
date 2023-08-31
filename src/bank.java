import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bank {
    bank(){
        System.out.println("Welcome To BOI..");
    }
    queriesClass query=new queriesClass();
    public void openAccount(int mobileNumber, String password, String Name, int initialAmount){


        try{
            PreparedStatement ps = query.insertQuery();
            ps.setString(1,Name);
            ps.setInt(2,mobileNumber);
            ps.setString(3,password);
            ps.setInt(4,initialAmount);
            if(ps.executeUpdate()==1){
                System.out.println("Data added");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    };
    public void deleteAccount(int mobileNumber, String password){
        try{
            int che=authenticate(mobileNumber,password);
            if (che==1){
                try{
                    PreparedStatement ps=query.deleteQuery();
                    ps.setInt(1,mobileNumber);
                    if(ps.executeUpdate()>0){
                        System.out.println("Deleted Account Successfully");
                    }
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                System.out.println("Incoorect Username Or Password");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    };
    public void creditAmount(int mobileNumber,int amount){
        int initialAmount;
        try{
            ResultSet rs;
            PreparedStatement pss=query.getRecordQuery();
            pss.setInt(1,mobileNumber);
            rs=pss.executeQuery();

            if(rs.next()){
                initialAmount=rs.getInt("amount");
                try{
                    PreparedStatement ps=query.updateQuery();
                    ps.setInt(2,mobileNumber);
                    ps.setInt(1,(amount+initialAmount));
                    System.out.println(ps.executeUpdate());
                    if(ps.executeUpdate()>0){
                        System.out.println("Amount Added!");
                    }
                    else{
                        System.out.println("HI");
                        System.out.println("Check Mobile Number");
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                    System.out.println("Check Mobile Number");
                }
            }
            else{
                System.out.println("No Account Found!");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }


    };
    public void withdrawAmount(int mobileNumber, String password,int amount) throws SQLException {
        if(authenticate(mobileNumber,password)==1){
            int initialAmount;
            try{
                ResultSet rs;
                PreparedStatement pss=query.getRecordQuery();
                pss.setInt(1,mobileNumber);
                rs=pss.executeQuery();

                if(rs.next()){
                    initialAmount=rs.getInt("amount");
                    if(initialAmount<amount){
                        System.out.println("Insufficient Bank Balance!");
                    }
                    else{
                        try{
                            PreparedStatement ps=query.updateQuery();
                            ps.setInt(2,mobileNumber);
                            ps.setInt(1,(initialAmount-amount));
                            System.out.println(ps.executeUpdate());
                            if(ps.executeUpdate()>0){
                                System.out.println("Amount Withdrawn!");
                            }
                            else{
                                System.out.println("HI");
                                System.out.println("Check Mobile Number");
                            }
                        }
                        catch(Exception e){
                            System.out.println(e);
                            System.out.println("Check Mobile Number");
                        }

                    }
                }
                else{
                    System.out.println("No Account Found!");
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else{
            System.out.println("Wrong Username or Password!");
        }


    };
    public void seeDetails(int mobileNumber, String password) throws SQLException {
        if(authenticate(mobileNumber,password)==1){
            PreparedStatement ps=query.getRecordQuery();
            ps.setInt(1,mobileNumber);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                System.out.println("Name\t\tMobile NUmber\t\tAmount\n");
                System.out.println(rs.getString("name")+"\t\t"+rs.getInt("mobileNumber")+"\t\t"+rs.getInt("amount"));
            }

        }
        else{
            System.out.println("Wrong Username or Password!");
        }
    };
    public int authenticate(int mobileNumber, String password) throws SQLException {

        String userEnteredPass;
        int mobileNUmberuser;
        PreparedStatement ps= query.autheticateUser();
        ps.setInt(1,mobileNumber);
        ps.setString(2,password);
        if (ps.executeUpdate()>0){

            return 1;
        }
        else{
            System.out.println("No");
            return 0;
        }

    };
}
