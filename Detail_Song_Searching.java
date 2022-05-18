package com.kalyani;
import java.sql.*;
import java.util.*;
public class Detail_Song_Searching
{
    static void detail_Song_Searching(int user_id)
    {
        Scanner s= new Scanner(System.in);
        String ans=null;

            System.out.println("enter your choice:" +
                    "\n1.search song by name" +
                    "\n2.search songs by language" +
                    "\n3.search songs by  genre" +
                    "\n4.search songs by album name" +
                    "\n5.search songs by artist");
            int choice3 = s.nextInt();
            switch (choice3) {
                case 1://search song by name
                    Searching_a_Song.Searching_a_Song_by_name();
                        System.out.println("enter your choice" + "\n1.select the song to play" + "\n2.add song to playlist");
                        int type = s.nextInt();
                        switch (type) {
                            case 1: Main.getting_Song_File_Path();
                                break;
                            case 2: System.out.println("1.new playlist\n2.exit playlist");
                                int num3 = s.nextInt();
                                if (num3 == 1) {Create_Song_Playlist.add_new_song_playlist(user_id);}
                                if (num3 == 2) {Create_Song_Playlist.add_exit_song_playlist(user_id);}
                                break;
                                default:}
                    break;
                case 2: Searching_a_Song.Searching_a_Song_by_language();
                        System.out.println("enter your choice" + "\n1.select the song to play" + "\n2.create song playlist");
                            int type1 = s.nextInt();
                            switch (type1)
                            {
                                case 1: Main.getting_Song_File_Path();
                                    break;
                                case 2:
                                    System.out.println("1.new playlist\n2.exit playlist");
                                    int num3 = s.nextInt();
                                    if (num3 == 1) {Create_Song_Playlist.add_new_song_playlist(user_id);}
                                    if (num3 == 2) {Create_Song_Playlist.add_exit_song_playlist(user_id);}
                                    break;
                                default:
                            }
                    break;
                case 3: Searching_a_Song.Searching_a_Song_by_genre();
                        System.out.println("enter your choice" + "\n1.select the song to play" + "\n2.create song playlist");
                            int type2 = s.nextInt();
                            switch (type2)
                            {
                                case 1: Main.getting_Song_File_Path();
                                    break;
                                case 2:
                                    System.out.println("1.new playlist\n2.exit playlist");
                                    int num3 = s.nextInt();
                                    if (num3 == 1) {Create_Song_Playlist.add_new_song_playlist(user_id);}
                                    if (num3 == 2) {Create_Song_Playlist.add_exit_song_playlist(user_id);}
                                    break;
                                default:
                            }
                    break;
                case 4: Searching_a_Song.Searching_a_Song_by_album_name();
                        System.out.println("enter your choice" + "\n1.select the song to play" + "\n2.create song playlist");
                            int type3= s.nextInt();
                            switch (type3)
                            {
                                case 1: Main.getting_Song_File_Path();
                                    break;
                                case 2:
                                    System.out.println("1.new playlist\n2.exit playlist");
                                    int num3 = s.nextInt();
                                    if (num3 == 1) {Create_Song_Playlist.add_new_song_playlist(user_id);}
                                    if (num3 == 2) {Create_Song_Playlist.add_exit_song_playlist(user_id);}
                                    break;
                                default:
                            }
                            break;
                case 5: Searching_a_Song.Searching_a_Song_by_atrist_name();
                        System.out.println("enter your choice" + "\n1.select the song to play" + "\n2.create song playlist");
                            int type5 = s.nextInt();
                            switch (type5)
                            {
                                case 1: Main.getting_Song_File_Path();
                                    break;
                                case 2: System.out.println("1.new playlist\n2.exit playlist");
                                    int num3 = s.nextInt();
                                    if (num3 == 1) {Create_Song_Playlist.add_new_song_playlist(user_id);}
                                    if (num3 == 2) {Create_Song_Playlist.add_exit_song_playlist(user_id);}
                                    break;
                                default:
                            }
                            break;
                            default:
            }
    }
}
