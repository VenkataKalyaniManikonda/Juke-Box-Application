package com.kalyani;
import java.sql.*;
import java.util.*;
public class Detail_Podcast_Searching
{

    static void detail_Podcast_Searching(int user_id)
    {
        Scanner s = new Scanner(System.in);
        String ans = null;
        System.out.println("enter your choice:" + "\n1.search podcast by name" +
                    "\n2.search podcast by language" + "\n3.search podcast by search song by genre" +
                    "\n4.search podcast by podcaster name" + "\n5.search podcast by podcast_ep_name");
            int choice3 = s.nextInt();
            switch (choice3)
            {
                case 1://search podcast by name
                    System.out.println("enter your choice" + "\n1.select the podcast to play" + "\n2.add to podcast playlist");
                    int type = s.nextInt();
                    switch (type) {
                        case 1: Main.getting_Podcast_File_Path();
                            break;
                        case 2: System.out.println("1.new playlist\n2.exit playlist");
                            int num6 = s.nextInt();
                            if (num6 == 1) {Create_Podcast_Playlist.add_new_Podcast_Playlist(user_id);}
                            if (num6 == 2) {Create_Podcast_Playlist.add_exit_Podcast_Playlist(user_id);}
                            break;
                           default:}
                    break;
                case 2://search podcast by language
                    Searching_a_Podcast.searching_a_Podcast_by_language();
                    System.out.println("enter your choice" + "\n1.select the podcast to play" + "\n2.create pod playlist");
                             type = s.nextInt();
                            switch(type)
                            {
                                case 1: Main.getting_Podcast_File_Path();
                                    break;
                                case 2:
                                    System.out.println("1.new playlist\n2.exit playlist");
                                    int num6=s.nextInt();
                                    if(num6==1) {Create_Podcast_Playlist.add_new_Podcast_Playlist(user_id);}
                                    if(num6==2) {Create_Podcast_Playlist.add_exit_Podcast_Playlist(user_id);}
                                    break;
                                default:
                            }
                    break;
                case 3://search podcast by search song by genre
                     Searching_a_Podcast.searching_a_Podcast_by_genre();
                            System.out.println("enter your choice" + "\n1.select the podcast to play" + "\n2.create pod playlist");
                             type = s.nextInt();
                            switch (type) {
                                case 1: Main.getting_Podcast_File_Path();
                                    break;
                                case 2: System.out.println("1.new playlist\n2.exit playlist");
                                    int num6 = s.nextInt();
                                    if (num6 == 1) {Create_Podcast_Playlist.add_new_Podcast_Playlist(user_id);}
                                    if (num6 == 2) {Create_Podcast_Playlist.add_exit_Podcast_Playlist(user_id);
                                    }
                                    break;
                                    default:}
                        break;
                case 4://search podcast by podcaster name
                     Searching_a_Podcast.searching_a_Podcast_by_podcasterName();
                            System.out.println("enter your choice" + "\n1.select the podcast to play" + "\n2.create pod playlist");
                             type = s.nextInt();
                            switch (type) {
                                case 1: Main.getting_Podcast_File_Path();
                                    break;
                                case 2: System.out.println("1.new playlist\n2.exit playlist");
                                    int num6 = s.nextInt();
                                    if (num6 == 1) {Create_Podcast_Playlist.add_new_Podcast_Playlist(user_id);}
                                    if (num6 == 2) {Create_Podcast_Playlist.add_exit_Podcast_Playlist(user_id);}
                            break;
                            default:

                        }

                        break;
                        case 5://search podcast by podcast_ep_name
                            Searching_a_Podcast.searching_a_Podcast_by_podcast_ep_name();
                            System.out.println("enter your choice" + "\n1.select the podcast to play" + "\n2.create pod playlist");
                             type = s.nextInt();
                            switch (type) {
                                case 1: Main.getting_Podcast_File_Path();
                                    break;
                                case 2: System.out.println("1.new playlist\n2.exit playlist");
                                    int num6 = s.nextInt();
                                    if (num6 == 1) {Create_Podcast_Playlist.add_new_Podcast_Playlist(user_id);}
                                    if (num6 == 2) {Create_Podcast_Playlist.add_exit_Podcast_Playlist(user_id);}
                                    break;
                                    default:
                            }
                            break;
                            default:
            }
    }
}
