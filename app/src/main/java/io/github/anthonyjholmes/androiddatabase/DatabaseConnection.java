package io.github.anthonyjholmes.androiddatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Anthony on 1/20/2016.
 */
public class DatabaseConnection {
    public int setup(){
        String url = "jdbc:mysql://cs1.ucc.ie:3306/";
        //Change this to the database name NOT THE DATABASE TABLE NAME
        String dbName = "2016_ajh3";

        String driver = "com.mysql.jdbc.Driver";
        //insert username that you would use to connect to the database
        String userName = "";
        //insert password that you would use to connect to the database
        String password = "";
        int id =234546245;
        System.out.println("TEST");

        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM  WinLoss");

            id = res.getInt("UserID");
            int gamesPlayed = res.getInt("GamesPlayed");
            int wins = res.getInt("Win");
            int losses = res.getInt("Loss");

            System.out.println(id + "\t" + gamesPlayed + "\t" + wins + "\t" + losses);


//  always close the connection

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
