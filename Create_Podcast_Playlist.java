package com.kalyani;
import java.util.*;
import java.sql.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Create_Podcast_Playlist
{
    static void add_new_Podcast_Playlist(int user_id)
    {
        Scanner sc=new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");
            //CREATING PLAYLIST
            PreparedStatement st = con.prepareStatement("insert into PLAYLIST_DETAILS(user_id) values(?)");
            st.setInt(1,user_id);
            int i = st.executeUpdate();
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from PLAYLIST_DETAILS where user_id="+user_id+" and (playlist_id=(select max(playlist_id) from PLAYLIST_DETAILS))");
            int k=0;
            while (rs.next()) {
                k=rs.getInt(1);
                System.out.format(" your new playlist_id :%d", rs.getInt(1));
                System.out.println();
            }
            //all podcasts
            Display_All_Podcasts.display_All_Podcasts();
            System.out.println();
            System.out.println("enter  podcast_ep_id from above list");
            int podcast_ep_id=sc.nextInt();
            PreparedStatement s= con.prepareStatement("insert into PODCAST_PLAYLIST_DETAILS(playlist_id,podcast_ep_id) values(?,?)");
            s.setInt(1,k);
            s.setInt(2,podcast_ep_id);
            int j = s.executeUpdate();
            if (j >0)
                System.out.println("successfully created podcast playlist");
            //DIPLAYING CREATED PLAYLISTS
            Statement st7 = con.createStatement();
            ResultSet rs7 = st7.executeQuery("select * from playlist_details join PODCAST_PLAYLIST_DETAILS using(playlist_id)   join PODCAST_EPISODE_DETAILS  using(podcast_ep_id) join user_details using(user_id) where user_id="+user_id);
            System.out.println(".......******......ALL YOUR PLAYLISTS....******........");
            while (rs7.next())
            {
                System.out.format("playlist_id :%d,\tpodcast_ep_id :%d,\t\tpodcast_ep_name :%s",  rs7.getInt(3),rs7.getInt(2),rs7.getString(5));
                System.out.println();
            }
        }
        catch(SQLException e)
        {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }
    }
    static void add_exit_Podcast_Playlist(int user_id)
    {
        Scanner sc=new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");
            //DISPLAYING USER PLAYLISTS
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from playlist_details join PODCAST_PLAYLIST_DETAILS using(playlist_id)   join PODCAST_EPISODE_DETAILS  using(podcast_ep_id) join user_details using(user_id) where user_id="+user_id);
            int s1=0;
            System.out.println(".......******......ALL YOUR PLAYLIST....******........");
            while (rs.next())
            {
                s1=rs.getInt(1);
                System.out.format("playlist_id :%d,\tpodcast_ep_id :%d,\t\tpodcast_ep_name :%s",  rs.getInt(3),rs.getInt(2),rs.getString(5));
                System.out.println();
            }
            //CONDITION TO CHECK USER INFO
            if(s1==user_id) {
                System.out.println("enter your playlist id ");
                int playlist_id = sc.nextInt();
                //int podcast_ep_id = sc.nextInt();
                Statement st3 = con.createStatement();
                ResultSet rs3 = st3.executeQuery("select playlist_id,user_id from playlist_details where playlist_id="+playlist_id+" and user_id="+user_id);
                int p_id=0;
                int u=0;
                while (rs3.next()) {
                    p_id=rs3.getInt(1);
                    u=rs3.getInt(2);
                }
                //CONDITION TO CHECK USER AND PLAYLIST
                if(p_id==playlist_id && u==user_id)
                {
                    Display_All_Podcasts.display_All_Podcasts();
                    System.out.println("                         ");
                    System.out.println("enter podcaste episode id from above list");
                    int podcast_ep_id = sc.nextInt();
                    Statement st2 = con.createStatement();
                    ResultSet rs2 = st2.executeQuery("select podcast_ep_id,playlist_id from PODCAST_PLAYLIST_DETAILS where podcast_ep_id=" + podcast_ep_id + " and playlist_id=" + playlist_id);
                    int p_id1= 0;
                    int pl_id = 0;
                    while (rs2.next()) {
                        p_id = rs2.getInt(1);
                        pl_id = rs2.getInt(2);
                    }
                    //CONDITION TO CHECK PLAYLIST ID AND EPISODE ID
                    if (p_id == podcast_ep_id && pl_id == playlist_id) {
                        System.out.println("podcast is already exist in playlist");
                    }
                    else
                    {
                        PreparedStatement s = con.prepareStatement("insert into PODCAST_PLAYLIST_DETAILS(playlist_id,podcast_ep_id) values(?,?)");

                        s.setInt(1, playlist_id);
                        s.setInt(2, podcast_ep_id);
                        int j = s.executeUpdate();
                        if (j > 0)
                            System.out.println("successfully created songs playlist");
                        //DIPLAYING CREATED PLAYLISTS
                        Statement st7 = con.createStatement();
                        ResultSet rs7 = st7.executeQuery("select * from playlist_details join PODCAST_PLAYLIST_DETAILS using(playlist_id)   join PODCAST_EPISODE_DETAILS  using(podcast_ep_id) join user_details using(user_id) where user_id="+user_id);
                        System.out.println(".......******......ALL YOUR PLAYLISTS....******........");
                        while (rs7.next())
                        {
                            System.out.format("playlist_id :%d,\tpodcast_ep_id :%d,\t\tpodcast_ep_name :%s",  rs7.getInt(3),rs7.getInt(2),rs7.getString(5));
                            System.out.println();
                        }
                    }
                }
                else {System.out.println(" playlist not exist");}
            }else {System.out.println("no playlist on this id");}
        }
        catch(SQLException e)
        {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }
    }
    static void play_playlist(int user_id)
    {
        Scanner sc=new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from PLAYLIST_DETAILS where user_id="+user_id);
            int s1=0;
            while (rs.next())
            {
                s1=rs.getInt(2);
            }
            if(s1==user_id)
            {
                Statement st = con.createStatement();
                ResultSet rs1 = st.executeQuery("select * from playlist_details join PODCAST_PLAYLIST_DETAILS using(playlist_id)   join PODCAST_EPISODE_DETAILS  using(podcast_ep_id) join user_details using(user_id) where user_id="+user_id);
                while (rs1.next())
                {
                    System.out.format("playlist_id :%d,\tpodcast_ep_id :%d,\tpodcast_ep_name :%s",rs.getInt(3),rs.getInt(2),rs.getString(5));
                    System.out.println();
                }
                Main.getting_Podcast_File_Path();
            }else
            {
                System.out.println("no playlist on this id");
            }
        }
        catch(SQLException e)
        {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }
    }
}
