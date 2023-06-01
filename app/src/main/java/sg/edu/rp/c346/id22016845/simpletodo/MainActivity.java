package sg.edu.rp.c346.id22016845.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText taskName;
    Button AddTask;
    Button DeleteTask;
    Button ClearTask;
    ListView tasksTodo;
    ArrayList<String> listViewList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskName=findViewById(R.id.editToDo);
        AddTask=findViewById(R.id.button);
        DeleteTask=findViewById(R.id.button2);
        ClearTask=findViewById(R.id.button3);
        spinner=findViewById(R.id.spinner);
        tasksTodo=findViewById(R.id.listViewList);



        listViewList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listViewList);
        tasksTodo.setAdapter(adapter);

        AddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskName.getText().toString();
                listViewList.add(task);
                taskName.setText("");
                tasksTodo.setAdapter(adapter);
            }
        });

        DeleteTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(taskName.getText().toString());
                listViewList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        ClearTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewList.clear();
                adapter.notifyDataSetChanged();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        taskName.setHint("Insert a new Task Here");
                        AddTask.setEnabled(true);
                        DeleteTask.setEnabled(false);
                        break;
                    case 1:
                        taskName.setHint("Type the Index of the Task to be removed");
                        AddTask.setEnabled(false);
                        DeleteTask.setEnabled(true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}