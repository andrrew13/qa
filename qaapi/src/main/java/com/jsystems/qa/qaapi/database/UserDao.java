package com.jsystems.qa.qaapi.database;
/////////BRAKI//////////
import com.jsystems.qa.qaapi.model.user.UserDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {


    public static UserDb getoneByid(Long id){
        String sql = "select * from usertest where id = " +id;
        UserDb userDb = new UserDb();
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            ResultSet wynik = statement.executeQuery(sql);

            while (wynik.next()) {

                userDb.setId(wynik.getLong(1));
                userDb.setName(wynik.getLong(2));
                userDb.setSurname(wynik.getLong(3));
            }


            wynik.close();
            statement.close();

        catch (SQLException e);
        e.printStackTrace();

        }



    }
}
