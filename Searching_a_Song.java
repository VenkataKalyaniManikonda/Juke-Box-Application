package com.kalyani;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Searching_a_Song
{
    static void Searching_a_Song_by_name()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter song name ");
        String song_name = sc.next();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");

            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from  DISPLAY_SONGS where song_name='" + song_name + "'");
            System.out.println("...................................YOUR SEARCH RESULT.............................");
            while (rs.next()) {
                System.out.format("song_id :%d,\t\tsong_name :%s", rs.getInt(1), rs.getString(2));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }
    }
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    static void Searching_a_Song_by_genre()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter genre type(pop,melody)");
        String song_genre = sc.next();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");

            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from  DISPLAY_SONGS where song_genre_type='" + song_genre + "'");
            System.out.println("...................................YOUR SEARCH RESULT..............................");
            while (rs.next()) {
                System.out.format("song_id :%d,\t\tsong_name  :%s,\t\t\tsong_genre_type  :%s", rs.getInt(1),
                        rs.getString(2), rs.getString(6));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }

    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    static void Searching_a_Song_by_atrist_name()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter  artist name ");
        String artist_name = sc.next();
        int count=0;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");

            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from  DISPLAY_SONGS where artist_name='" + artist_name + "'");
            System.out.println("...................................YOUR SEARCH RESULT..............................");
            while (rs.next()) {
                System.out.format("song_id   :%d,\t\tsong_name    :%s,\t\t\tartist_name    :%s",
                        rs.getInt(1), rs.getString(2), rs.getString(7));
                count++;
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }
    }
    static void Searching_a_Song_by_album_name()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter  album name ");
        String album_name = sc.next();
        int count=0;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");

            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from  DISPLAY_SONGS where album_name='" + album_name + "'");
            System.out.println("...................................YOUR SEARCH RESULT..............................");
            while (rs.next()) {
                System.out.format("song_id  :%d,\t\tsong_name  :%s,\t\t\talbum_name  :%s",
                        rs.getInt(1), rs.getString(2), rs.getString(8));
                count++;
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }
    }
    static void Searching_a_Song_by_language()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter  language(telugu/tamil/english)");
        String language = sc.next();
        int count=0;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");

            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from  DISPLAY_SONGS where song_language='" + language + "'");
            System.out.println("...................................YOUR SEARCH RESULT..............................");
            while (rs.next()) {
                System.out.format("song_id  :%d,song_name  :%s,song_language  :%s",
                        rs.getInt(1), rs.getString(2), rs.getString(5));
                count++;
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }
    }
}
