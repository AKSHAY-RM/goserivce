package com.user.goservice;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.user.goservice.navigation.NavigationActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database extends AsyncTask<Void, Void, Void> {

    public String query = "";
    public String retrieve = "get", update = "set";
    public String queryType = retrieve;
    public int flag = 0;
    public ResultSet resultSet = null;

    public void setQuery(String query, String queryType) {
        this.query = query;
        this.queryType = queryType;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://192.168.43.8:3306/goservicedb",
                            "admin", "1234");
            Statement statement = connection.createStatement();
            System.out.println("Error: Hello");
            if (queryType.equals(update)) {
                flag = statement.executeUpdate(query);
                Log.e("Error: DATABASE", "Query type is update");
            }
            if (queryType.equals(retrieve)) {
                Log.e("Error: DATABASE", "Query type is retrieve");
                resultSet = statement.executeQuery(query);

            }


        } catch (Exception e) {
            Log.e("Error", e.getLocalizedMessage());
        }

        return null;
    }
}