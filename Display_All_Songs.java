package com.kalyani;

import java.sql.*;

public class Display_All_Songs
{
    static void displayAllSongs()
    {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from  DISPLAY_SONGS");
            System.out.println(".................HERE LIST OF ALL SONGS.............................");
            while (rs.next()) {
                System.out.format("song_id :%3d,\t\tsong_name :%s", rs.getInt(1), rs.getString(2));
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
