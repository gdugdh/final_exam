package com.example.final_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class CreateCardActivity extends AppCompatActivity {
    Button skip_fin;
    Button create;
    EditText name;
    EditText fname;
    EditText surname;
    EditText date;
    EditText uhhh;
    Spinner gender;
    DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);

        skip_fin = findViewById(R.id.skipf_btn);
        skip_fin.setVisibility(View.VISIBLE);
        skip_fin.setBackgroundColor(Color.TRANSPARENT);
        create = findViewById(R.id.create_btn);
        name = findViewById(R.id.inp_name);
        fname = findViewById(R.id.inp_fathname);
        surname = findViewById(R.id.inp_surname);
        date = findViewById(R.id.inp_date);
        gender = findViewById(R.id.inp_gender);
        uhhh = findViewById(R.id.hm);
        uhhh.setVisibility(View.INVISIBLE);
        uhhh.setEnabled(false);

        setUpGender();

        name.addTextChangedListener(loginTextWatcher);
        fname.addTextChangedListener(loginTextWatcher);
        surname.addTextChangedListener(loginTextWatcher);
        date.addTextChangedListener(loginTextWatcher);

        date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    final Calendar c = Calendar.getInstance();
                    int mYear = c.get(Calendar.YEAR); // current year
                    int mMonth = c.get(Calendar.MONTH); // current month
                    int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                    // date picker dialog
                    datePickerDialog = new DatePickerDialog(CreateCardActivity.this,
                            new DatePickerDialog.OnDateSetListener() {

                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {
                                    // set day of month , month and year value in the edit text
                                    date.setText(dayOfMonth + "."
                                            + (monthOfYear + 1) + "." + year);

                                }
                            }, mYear, mMonth, mDay);
                    datePickerDialog.show();
                }
            }
        });

    }

    private void setUpGender(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //я хз что это если честно но мне лень думать можно ли это убирать
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount()-1;
            }
        };
        adapter.setDropDownViewResource(R.layout.spinner_item);
        adapter.add("Мужской");
        adapter.add("Женский");
        adapter.add("Пол");
        gender.setAdapter(adapter);
        gender.setSelection(adapter.getCount());
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(gender.getSelectedItem().toString().equals("Мужской")||gender.getSelectedItem().toString().equals("Женский")){
                    uhhh.setText(gender.getSelectedItem().toString());
                    uhhh.setVisibility(View.VISIBLE);
                    uhhh.setEnabled(true);
                    gender.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private final TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String nameInp = name.getText().toString().trim();
            String fnameInp = fname.getText().toString().trim();
            String surnameInp = surname.getText().toString().trim();
            String dateInp = date.getText().toString().trim();

            if (!nameInp.isEmpty()&&!fnameInp.isEmpty()&&!surnameInp.isEmpty()&&!dateInp.isEmpty()){
                create.setEnabled(true);
                create.setBackground(AppCompatResources.getDrawable(CreateCardActivity.this, R.color.blue));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void onHMMMMClick(View v){
        uhhh.setVisibility(View.INVISIBLE);
        uhhh.setEnabled(false);
        uhhh.setText("");
        gender.setVisibility(View.VISIBLE);
        setUpGender();
        gender.performClick();
    }

    public void onClickGETTOTHEBUSINESS(View view) {
        Intent intent = new Intent(this, TrueMainActivity.class);
        startActivity(intent);
    }


}