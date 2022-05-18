package com.kalyani;
import java.sql.*;
import java.util.*;
public class User_Choice
{
    static void user_Choice(int user_id)
    {
        String ans=null;
        Scanner s=new Scanner(System.in);
        do {
            System.out.println("enter your choice:" + "\n1.View all songs" + "\n2.view all podcasts" +
                    "\n3.View all playlists" + "\n4.Go for search option");
            int choice2 = s.nextInt();
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            //VIEW ALL SONGS
            if (choice2 == 1) {
                int num = 0;
                    Display_All_Songs.displayAllSongs();
                    do {
                        System.out.println("press\n1.play any song\n2.add song to playlist\n3.exit");
                        num = s.nextInt();
                        if (num == 1) {Main.getting_Song_File_Path();}
                        if(num==2)
                        {
                            System.out.println("1.new playlist\n2.existing playlist");
                                int num3=s.nextInt();
                                if(num3==1) {Create_Song_Playlist.add_new_song_playlist(user_id);}
                                if(num3==2) {Create_Song_Playlist.add_exit_song_playlist(user_id);}
                        }
                    } while (num == 1 || num==2);
            }
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            //VIEW ALL PODCATS
            if (choice2 == 2) {

                    int num = 0;
                    Display_All_Podcasts.display_All_Podcasts();
                    do {
                        System.out.println("press\n1.play any podcast\n2.add podcast playlist\n3.exit");
                        num = s.nextInt();
                        if (num == 1) {Main.getting_Podcast_File_Path();}
                        if(num==2)
                        {
                            System.out.println("1.new playlist\n2.existing playlist");
                            int num6=s.nextInt();
                            if(num6==1) {Create_Podcast_Playlist.add_new_Podcast_Playlist(user_id);}
                            if(num6==2) {Create_Podcast_Playlist.add_exit_Podcast_Playlist(user_id);}
                        }
                    } while (num == 1 || num==2);
            }
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            //PLAYLISTS
            if (choice2 == 3)
            {
                System.out.println("1.songs playlist\n2.podcats playlist");
                    int num1=s.nextInt();
                    //SONGS
                    if(num1==1) {
                        System.out.println("1.add song to playlist\n2.play song from playlist");
                        int num2=s.nextInt();
                        //add
                        if(num2==1) {
                            System.out.println("1.new playlist\n2.existing playlist");
                            int num3=s.nextInt();
                            if(num3==1) {Create_Song_Playlist.add_new_song_playlist(user_id);}
                            if(num3==2) {Create_Song_Playlist.add_exit_song_playlist(user_id);}}
                        //play
                        if(num2==2) {Create_Song_Playlist.play_playlist(user_id);}
                    }
                    //PODCASTS
                    if(num1==2) {
                        System.out.println("1.add podcast playlist\n2.play podcast from playlist");
                        int num5=s.nextInt();
                        //add
                        if(num5==1) {
                            System.out.println("1.new playlist\n2.existing playlist");
                            int num6=s.nextInt();
                            if(num6==1) {Create_Podcast_Playlist.add_new_Podcast_Playlist(user_id);}
                            if(num6==2) {Create_Podcast_Playlist.add_exit_Podcast_Playlist(user_id);}}
                        //play
                        if(num5==2) {Create_Podcast_Playlist.play_playlist(user_id);}}
            }
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            //SEARCHING
            if (choice2 == 4) {
                do {
                    System.out.println("option\n1.search for song\n2.search for podcast");
                    int option = s.nextInt();
                    //SONG SEARCHING
                    if (option == 1) {Detail_Song_Searching.detail_Song_Searching(user_id);}
                    //PODCAST SEARCHING
                    if (option == 2) {Detail_Podcast_Searching.detail_Podcast_Searching(user_id);}
                    System.out.println("repeat searching(yes/no)");
                    ans = s.next();
                } while (ans.equalsIgnoreCase("yes"));
            }
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            System.out.println("do you want to view home page(yes/no)");
            ans = s.next();
        } while (ans.equalsIgnoreCase("yes"));
    }

}
