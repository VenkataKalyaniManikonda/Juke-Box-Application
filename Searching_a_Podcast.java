package com.kalyani;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Searching_a_Podcast
{
    //podcast_name
    static void searching_a_Podcast_by_podcastName()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter podcast_name");
        String podcast_name=sc.next();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");

            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from  DISPLAY_PODCASTS where podcast_name='" +podcast_name+"'");
            System.out.println("...................................YOUR SEARCH RESULT.............................");
            while (rs.next()) {
                System.out.format("podcast_name :%s,\t\t\tpodcast_ep_name:%s,\t\t\tpodcast_ep_id :%d",
                        rs.getString(1), rs.getString(5), rs.getInt(6));

                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //podcaster_name
    static void searching_a_Podcast_by_podcasterName()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter podcaster_name");
        String podcaster_name=sc.next();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");

            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from  DISPLAY_PODCASTS where podcaster_name='" +podcaster_name+"'");
            System.out.println("...................................YOUR SEARCH RESULT.............................");
            while (rs.next()) {
                System.out.format("podcast_name :%s,\t\t\tpodcast_ep_name:%s,\t\t\tpodcast_ep_id :%d,\t\t\tpodcaster_name:%s",
                        rs.getString(1), rs.getString(5), rs.getInt(6),rs.getString(2));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //podcast_language
    static void searching_a_Podcast_by_language()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter language name(telugu/tamil/hindi/english)");
        String podcast_language=sc.next();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");

            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from  DISPLAY_PODCASTS where podcast_language='" +podcast_language+"'");
            System.out.println("...................................YOUR SEARCH RESULT.............................");
            while (rs.next()) {
                System.out.format("podcast_name :%s,\t\t\tpodcast_ep_name:%s,\t\t\tpodcast_ep_id :%d,\t\t\tpodcast_language:%s",
                        rs.getString(1), rs.getString(5), rs.getInt(6),rs.getString(3));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }

    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    // podcast_genre_type
    static void searching_a_Podcast_by_genre()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter genre type(comedy|news and politics|health|business|culture)");
        String podcast_genre_type=sc.next();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");

            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from  DISPLAY_PODCASTS where podcast_genre_type='" +podcast_genre_type+"'");
            System.out.println("...................................YOUR SEARCH RESULT.............................");
            while (rs.next()) {
                System.out.format("podcast_name :%s,\t\t\tpodcast_ep_name:%s,\t\t\tpodcast_ep_id :%d,\t\t\tpodcast_genre_type:%s",
                        rs.getString(1), rs.getString(5), rs.getInt(6),rs.getString(4));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }

    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //podcast_ep_name
    static void searching_a_Podcast_by_podcast_ep_name()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter podcast_ep_name");
        String podcast_ep_name=sc.next();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");

            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from  DISPLAY_PODCASTS where podcast_ep_name='" +podcast_ep_name+"'");
            System.out.println("...................................YOUR SEARCH RESULT.............................");
            while (rs.next()) {
                System.out.format("podcast_name :%s,\t\t\tpodcast_ep_name:%s,\t\t\tpodcast_ep_id :%d,\t\t\tpodcast_genre_type:%s",
                        rs.getString(1), rs.getString(5), rs.getInt(6),rs.getString(4));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }
    }
}
