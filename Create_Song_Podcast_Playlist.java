package com.kalyani;
import java.util.*;
import java.sql.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Create_Song_Podcast_Playlist
{
    static void create_Song_Podcast_Playlist(int user_id)
    {

        Display_All_Songs ds = new Display_All_Songs();
        ds.displayAllSongs();
        System.out.println("..................................................");
        System.out.println("..................................................");
        Display_All_Podcasts.display_All_Podcasts();
        System.out.println("..................................................");
        System.out.println("..................................................");
        Scanner sc=new Scanner(System.in);
        //System.out.println("enter your user id");
        //int user_id=sc.nextInt();
        System.out.println("enter song id you want to add");
        int song_id=sc.nextInt();
        System.out.println("enter podcast_ep_id you want to add");
        int podcast_ep_id=sc.nextInt();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");
            PreparedStatement st = con.prepareStatement("insert into PLAYLIST_DETAILS(user_id,song_id,podcast_ep_id) values(?,?,?)");
            st.setInt(1, user_id);
            st.setInt(2, song_id);
            st.setInt(3, podcast_ep_id);
            int i = st.executeUpdate();
            if (i > 0)
                System.out.println("playlist created successfully");
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from PLAYLIST_DETAILS where user_id="+user_id);
            while (rs.next())
            {
                System.out.println( "playlist_id :"+rs.getInt(1)+ "\tuser_id :"+ rs.getInt(2)+
                        "\tsong_id:%d :"+rs.getInt(3)+ "\tpodcast_ep_id :"+ rs.getInt(4));
            }
            int num=0;
            do {
                System.out.println("press\n1.to play song\n2.to play podcast\n3.exit");
                num = sc.nextInt();
                if (num == 1)
                {
                    Main.getting_Song_File_Path();
                }
                if (num == 2)
                {
                    Main.getting_Podcast_File_Path();
                }
            } while (num == 1 || num==2);

        }
        catch(SQLException e)
        {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }
    }
}
