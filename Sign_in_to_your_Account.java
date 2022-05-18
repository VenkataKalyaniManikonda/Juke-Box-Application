package com.kalyani;

import java.sql.*;
import java.util.Scanner;

public class Sign_in_to_your_Account
{
    static int  sign_in_to_your_account(int user_id)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("please enter your password");
        String user_password=s.next();
        int r=0;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from USER_DETAILS where user_id="+user_id+" and user_password='"+user_password+"'");
            while (rs.next())
            {
                r=rs.getInt(1);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }
        if(user_id==r) {return 1;}
        else {return 0;}
    }
}
