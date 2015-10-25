package ba.bitcamp.android.homeworkandroid;

import android.support.v7.app.AppCompatActivity;
import android.text.Editable;

import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

/**
 * Created by User on 10/24/2015.
 */
public class User extends AppCompatActivity {

    private String name;
    private String surname;
    private String date;
    private UUID id;

//    @Override
//    public int compareTo(User user1) {
//        if (this.name == null || user1.name == null) {
//            return 0;
//        }
//        return this.name.compareTo(user1.name);
//    }

    public User(Editable name, Editable surname) {
        this.name = name.toString();
        this.surname = surname.toString();
        this.date = new Date().toString();
        id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id.toString();
    }



}