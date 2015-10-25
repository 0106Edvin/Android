package ba.bitcamp.android.homeworkandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static List<User> users = new ArrayList<>();

    private Button add;
    private EditText nameInput;
    private EditText surnameInput;
    private RecyclerView listOfUsers;
    private UserAdapter adapter;
    private Button delete;
//    private RadioButton sortbyname;
//    private RadioButton sortbysurname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = (EditText) findViewById(R.id.name);
        surnameInput = (EditText) findViewById(R.id.surname);
        add = (Button) findViewById(R.id.button);
        listOfUsers = (RecyclerView) findViewById(R.id.listOfUsers);
        adapter = new UserAdapter();
//        sortbyname = (RadioButton)findViewById(R.id.sortbyname);
//        sortbysurname = (RadioButton) findViewById(R.id.sortbysurname);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable name = nameInput.getText();
                Editable surname = surnameInput.getText();

                User user = new User(name, surname);

                users.add(0, user);
                adapter.notifyDataSetChanged();

                nameInput.setText("");
                surnameInput.setText("");
            }
        });

//        sortbyname.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Collections.sort(users);
//            }
//        });

        listOfUsers.setLayoutManager(new LinearLayoutManager(this));

        listOfUsers.setAdapter(adapter);
    }


    private class UserHolder extends RecyclerView.ViewHolder {

        private TextView nameView;
        private TextView surnameView;
        private TextView userdateView;
        private Button deleteView;
        private TextView idView;

        private User user;

        public UserHolder(View itemView) {
            super(itemView);

            nameView = (TextView) itemView.findViewById(R.id.name);
            surnameView = (TextView) itemView.findViewById(R.id.surname);
            userdateView = (TextView) itemView.findViewById(R.id.userdate);
            deleteView = (Button) itemView.findViewById(R.id.delete);
            idView = (TextView)itemView.findViewById(R.id.idperson);

            deleteView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i=0; i <users.size(); i++){
                        String id = idView.getText().toString();
                        if (users.get(i).getId().equals(id));
                        users.remove(i);
                    }
                   updateList();
                }
            });
        }
    }

    private class UserAdapter extends RecyclerView.Adapter<UserHolder> {

        @Override
        public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
            View view = layoutInflater.inflate(R.layout.user_layout, parent, false);
            return new UserHolder(view);
        }

        @Override
        public void onBindViewHolder(UserHolder holder, int position) {
            User user = users.get(position);

            holder.nameView.setText(user.getName());
            holder.surnameView.setText(user.getSurname());
            holder.userdateView.setText(user.getDate());
            holder.user = user;

        }

        @Override
        public int getItemCount() {
            return users.size();
        }
    }
    public void updateList() {
        adapter = new UserAdapter();
        listOfUsers.setAdapter(adapter);
    }
}