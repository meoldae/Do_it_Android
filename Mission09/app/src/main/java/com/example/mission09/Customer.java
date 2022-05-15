package com.example.mission09;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Customer extends Fragment {
    Button button;
    EditText nameInput;
    EditText ageInput;
    Button birthInput;
    Date selectedDate;

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_customer, container, false);

        nameInput = rootView.findViewById(R.id.nameInput);
        ageInput = rootView.findViewById(R.id.ageInput);

        birthInput = rootView.findViewById(R.id.birthday);
        birthInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        button = rootView.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name;
                String age;
                String birthday;

                name = nameInput.getText().toString();
                age = ageInput.getText().toString();
                birthday = birthInput.getText().toString();

                Toast.makeText(getActivity().getApplicationContext(), "이름 : " +name + "\n나이 : "+ age +
                "// 생년월일 : "+ birthday, Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

    private void showDateDialog(){
        String birthday = birthInput.getText().toString();

        Calendar calendar = Calendar.getInstance();
        Date today = new Date();

        try {
            today = dateFormat.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.setTime(today);
        DatePickerDialog dialog = new DatePickerDialog(getContext(), birthdaySetListener, year, month, day);
        dialog.show();
    }

    private DatePickerDialog.OnDateSetListener birthdaySetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            Calendar selected = Calendar.getInstance();
            selected.set(Calendar.YEAR, i);
            selected.set(Calendar.MONTH, i1);
            selected.set(Calendar.DAY_OF_MONTH, i2);

            Date today = selected.getTime();
            setSelectedDate(today);
        }
    };

    private void setSelectedDate(Date today){
        selectedDate = today;

        String todayStr = dateFormat.format(today);
        birthInput.setText(todayStr);
    }
}