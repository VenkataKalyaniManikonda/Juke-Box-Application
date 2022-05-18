package com.kalyani;
import java.sql.*;
import java.util.*;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Main
{

    public static void main(String[] args) throws Exception {
        String ans = null;
        Scanner s = new Scanner(System.in);
        System.out.println("......................................................");
        System.out.println("...............****************.... WELCOME TO JUKE BOX....**************.................");
        do {
            System.out.println("1.Signup\n2.SignIn");
            int choice = s.nextInt();
            if (choice == 1) {
                System.out.println(".................create your account.................");
                Create_New_Acount.create_new_acount();
                //System.out.print("go for main menu");
            }
            //.....................................................................................
            //SIGN IN
            if (choice == 2) {
                System.out.println("...............***....PLEASE SIGN IN TO YOUR ACCCOUNT...***..................");

                Sign_in_to_your_Account sn = new Sign_in_to_your_Account();
                System.out.println("please enter your user id");
                int user_id=0;
                user_id=s.nextInt();
                int i = sn.sign_in_to_your_account(user_id);

                if (i == 0) {
                    System.out.println("....................you are not regester to juke box.........................");
                    System.out.println(".................****....GO WITH SIGNUP OPTION.....***........................");
                }
                else
                {
                    //System.out.println(".................successfuly signed in your acount..................");
                    System.out.println(".............***....YOU CAN PROCEED NOW....***..............................");
                    User_Choice.user_Choice(user_id);
                    System.out.println("....****...HAPPY ENDING...****....");
                    //System.out.println("..exit");
                }
            }
            System.out.println("\\*exit(yes/no)");
            ans = s.next();
        } while (ans.equalsIgnoreCase("no"));
    }
// .........................................................................................................................................
    //TO PLAY PODCASTS
    static void getting_Song_File_Path()
    {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter song id you want to listen :");
    int  song_id=sc.nextInt();
    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select song_filepath from SONG_DETAILS where song_id="+song_id);
        String filePath=null;
        while (rs.next())
        {
            filePath=rs.getString(1);
        }

       SongAudioPlayer.main(filePath);

    }
    catch(SQLException e)
    {
        System.out.println("Failed to process:");
        System.out.println(e.getMessage());
    }
}
// .........................................................................................................................................
    // TO PLAY PODCAST
    static void getting_Podcast_File_Path()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter podcast_ep_id you want to listen :");
        int  podcast_ep_id=sc.nextInt();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java_Main_Project", "root", "password@123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select podcast_ep_path from DISPLAY_PODCASTS where podcast_ep_id ="+podcast_ep_id);
            String filePath=null;
            while (rs.next())
            {
                filePath=rs.getString(1);

            }
            SongAudioPlayer.main(filePath);

        }
        catch(SQLException e)
        {
            System.out.println("Failed to process:");
            System.out.println(e.getMessage());
        }

    }
}










