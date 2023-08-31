import java.sql.SQLException;
import java.util.Scanner;
public class Main extends bank{
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Scanner ss = new Scanner(System.in);
        bank b=new bank();

        try{
            int sel;
            System.out.println("Select The Choice:\n1:Open Account\n2:Delete Account\n3:Credit Amount\n4:Debit Amount\nOther key For Close");
            sel=sc.nextInt();
            if(sel==1){

                int mobileNumber;String password;String Name;int initialAmount;
                System.out.println("Enter the Name:");
                Name = ss.nextLine();
                System.out.println("Enter the Mobile Number:");
                mobileNumber = sc.nextInt();
                System.out.println("Enter the Password for transcations:");
                password = ss.nextLine();
                System.out.println("Enter the Amount to Credit:");
                initialAmount = sc.nextInt();
                b.openAccount(mobileNumber,password,Name,initialAmount);

            } else if (sel==2) {
                int mobileNumber;String password;
                System.out.println("Enter the Mobile Number:");
                mobileNumber = sc.nextInt();
                System.out.println("Enter the Password for transcations:");
                password = ss.nextLine();
                b.deleteAccount(mobileNumber,password);

            } else if (sel==3) {
                int mobileNumber;int amountToCredit;
                System.out.println("Enter the Mobile Number:");
                mobileNumber = sc.nextInt();
                System.out.println("Enter the Amount to Credit:");
                amountToCredit = sc.nextInt();
                b.creditAmount(mobileNumber,amountToCredit);

            } else if (sel==4) {
                int mobileNumber;String password;int amountToWithdraw;
                System.out.println("Enter the Mobile Number:");
                mobileNumber = sc.nextInt();
                System.out.println("Enter the Amount to Credit:");
                amountToWithdraw = sc.nextInt();
                System.out.println("Enter the Password:");
                password = ss.nextLine();
                b.withdrawAmount(mobileNumber,password,amountToWithdraw);
            }
            else{
                System.out.println("Thank You..");
            }
        }
        catch (Exception e){
            System.out.println("Error Happened");
        }


    }
}