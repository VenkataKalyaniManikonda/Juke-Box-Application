package com.kalyani;
import java.sql.*;
import java.util.Scanner;

public class Create_New_Acount
{
    static void create_new_acount() {
        Scanner s = new Scanner(System.in);
        System.out.println("enter your name");
        String name = s.next();
        //for name
        String reg = "[a-zA-Z]+$";
        if (name.matches(reg)) {
            System.out.println("enter your phone number");
            String phoneNumber = s.next();
            //for phno
            String regex = "(0/91)?[7-9][0-9]{9}";
            if (phoneNumber.matches(regex)) {
                System.out.println("enter your mailId");
                String mailId = s.next();
                //for mail
                String regex1 = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
                if (mailId.matches(regex1)) {

//                    System.out.println("create your password as below" +
//                            "\n...............................1.itscontains at least 8 characters and at most 20 characters.\n" +
//                            "...............................2.It contains at least one digit.\n" +
//                            "...............................3.It contains at least one upper case alphabet.\n" +
//                            "...............................4.It contains at least one lower case alphabet.\n" +
//                            "...............................5.It contains at least one special character which includes !@#$%&*()-+=^.\n" +
//                            "...............................6.It doesn’t contain any white space.");
                    System.out.println("enter a valid password");
                    String password = s.next();
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");
                        PreparedStatement st = con.prepareStatement("insert into USER_DETAILS(user_name,user_phno,user_email,user_password) values(?,?,?,?)");
                        st.setString(1, name);
                        st.setString(2, phoneNumber);
                        st.setString(3, mailId);
                        st.setString(4, password);
                        int i = st.executeUpdate();
                        if (i > 0)
                            System.out.println("successfully created your acount");
                        Statement st1 = con.createStatement();
                        ResultSet rs = st1.executeQuery("select * from USER_DETAILS where user_password='" + password + "'");
                        int id = 0;
                        while (rs.next()) {
                            id = rs.getInt(1);
                            System.out.println("your standard user id is :" + rs.getInt(1));
                        }
                    } catch (SQLException e) {
                        System.out.println("Failed to process:");
                        System.out.println(e.getMessage());
                    }
//                }
//                else
//                {
//                    System.out.println("please set your password according to insructions");
//                }
                } else {System.out.println("please enter a valid mail id");}
            } else {System.out.println("please enter a valid phone number");}
        } else {System.out.println("please enter a valid name");}
    }
}
