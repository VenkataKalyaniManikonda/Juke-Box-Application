package com.kalyani;
import java.sql.*;
public class Display_All_Podcasts
{
    static void display_All_Podcasts()
    {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from  DISPLAY_PODCASTS");
            System.out.println(".................HERE LIST OF ALL PODCASTS.............................");
            while (rs.next()) {
                System.out.print("podcast_name :"+rs.getString(1)+ "\t\t\tpodcast_ep_id :"+rs.getInt(6)+ "\t\t\tpodcast_ep_name :"+rs.getString(5) );
                System.out.println();
            }

        }
        catch(SQLException e)
        {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }
    }
}
