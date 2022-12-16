package com.example.convertor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.convertor.databinding.ActivityLengthTransBinding;

import java.text.DecimalFormat;

public class LengthTrans extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityLengthTransBinding binding;
    private Toolbar toolbar1;
    private EditText metr, millimetr, kilometr, mile, sm;
    private boolean on_edit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_trans);

        binding = ActivityLengthTransBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar1 = findViewById(R.id.toolbar1); //Закрепляет за переменной панель toolbar

        DecimalFormat df = new DecimalFormat("#.####"); //Формат числа

        millimetr = findViewById(R.id.ediInputMetr);
        millimetr.setSelectAllOnFocus(true);
        metr = findViewById(R.id.ediInputMetr2);
        metr.setSelectAllOnFocus(true);
        kilometr = findViewById(R.id.ediInputMetr3);
        kilometr.setSelectAllOnFocus(true);
        sm = findViewById(R.id.ediInputMetr5);
        sm.setSelectAllOnFocus(true);
        mile = findViewById(R.id.ediInputMetr4);
        mile.setSelectAllOnFocus(true); //Закрепляет соответствующие поля ввода за переменными. Затем включает выделение всего текста при нажатии на поле ввода

        setSupportActionBar(binding.toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true); //Тулбар ставится как ActionBar

        setTitle("Длина");


        millimetr.addTextChangedListener(new TextWatcher() { //Listener триггерится на изменение текста в поле ввода
            Double i1;
            public void afterTextChanged(Editable s) {
                if (millimetr.getText().length() == 0) {
                    millimetr.setText("0");
                    millimetr.setSelection(1); //Если поле пустое, то ставит 0 SetSelection перемещает курсор
                }
                if (millimetr.hasFocus() && on_edit == false) { //Проверяет, в фокусе ли поле и переменную on_edit. Без них код зависает
                    try {
                        on_edit = true;
                        millimetr.setText(TextEditor.edit(millimetr.getText().toString()));
                        millimetr.setSelection(millimetr.length());
                        on_edit = false; //Редактирует строку через TextEditor (отдельный класс)

                        i1 = Double.valueOf(millimetr.getText().toString());
                        metr.setText(String.valueOf(df.format(i1 / 1000)) + " м");
                        kilometr.setText(String.valueOf(df.format(i1 / 1000000)) + " км");
                        mile.setText(String.valueOf(df.format(i1 / 1609340)) + " mi"); //Считает и устанавливает значения в остальные поля
                        toolbar1.setSubtitle("Миллиметр");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        millimetr.setSelection(1);
                        on_edit = false; // В случае ошибки обнуляет все поля до нуля
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        metr.addTextChangedListener(new TextWatcher() {
            Double i1;
            public void afterTextChanged(Editable s) {
                if (metr.getText().length() == 0) {
                    metr.setText("0");
                    metr.setSelection(1);
                }
                if(metr.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        metr.setText(TextEditor.edit(metr.getText().toString()));
                        metr.setSelection(metr.length());
                        on_edit = false;

                        i1 = Double.valueOf(metr.getText().toString());
                        millimetr.setText(String.valueOf(df.format(i1 * 1000)) + " мм");
                        kilometr.setText(String.valueOf(df.format(i1 / 1000)) + " км");
                        mile.setText(String.valueOf(df.format(i1 / 1609.340)) + " mi");
                        toolbar1.setSubtitle("Метр");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        metr.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        kilometr.addTextChangedListener(new TextWatcher() {
            Double i1;
            public void afterTextChanged(Editable s) {
                if (kilometr.getText().length() == 0) {
                    kilometr.setText("0");
                    kilometr.setSelection(1);
                }
                if (kilometr.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        kilometr.setText(TextEditor.edit(kilometr.getText().toString()));
                        kilometr.setSelection(kilometr.length());
                        on_edit = false;

                        i1 = Double.valueOf(kilometr.getText().toString());
                        millimetr.setText(String.valueOf(df.format(i1 * 1000000)) + " мм");
                        metr.setText(String.valueOf(df.format(i1 * 1000)) + " м");
                        mile.setText(String.valueOf(df.format(i1 / 1.609340)) + " mi");
                        toolbar1.setSubtitle("Километр");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        kilometr.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        mile.addTextChangedListener(new TextWatcher() {
            Double i1;
            public void afterTextChanged(Editable s) {
                if (mile.getText().length() == 0) {
                    mile.setText("0");
                    mile.setSelection(1);
                }
                if (mile.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        mile.setText(TextEditor.edit(mile.getText().toString()));
                        mile.setSelection(mile.length());
                        on_edit = false;

                        i1 = Double.valueOf(mile.getText().toString());
                        millimetr.setText(String.valueOf(df.format(i1 * 1609340)) + " мм");
                        metr.setText(String.valueOf(df.format(i1 * 1609.340)) + " м");
                        kilometr.setText(String.valueOf(df.format(i1 * 1.609340)) + " км");
                        toolbar1.setSubtitle("Миля");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        mile.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        sm.addTextChangedListener(new TextWatcher() { //Listener триггерится на изменение текста в поле ввода
            Double i1;
            public void afterTextChanged(Editable s) {
                if (sm.getText().length() == 0) {
                    sm.setText("0");
                    sm.setSelection(1); //Если поле пустое, то ставит 0 SetSelection перемещает курсор
                }
                if (sm.hasFocus() && on_edit == false) { //Проверяет, в фокусе ли поле и переменную on_edit. Без них код зависает
                    try {
                        on_edit = true;
                        sm.setText(TextEditor.edit(sm.getText().toString()));
                        sm.setSelection(sm.length());
                        on_edit = false; //Редактирует строку через TextEditor (отдельный класс)

                        i1 = Double.valueOf(sm.getText().toString());
                        millimetr.setText(String.valueOf(df.format(i1 * 10)) + " м");
                        metr.setText(String.valueOf(df.format(i1 / 100)) + " м");
                        kilometr.setText(String.valueOf(df.format(i1 / 100000)) + " км");
                        mile.setText(String.valueOf(df.format(i1 / 160934)) + " mi"); //Считает и устанавливает значения в остальные поля
                        toolbar1.setSubtitle("Миллиметр");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        sm.setSelection(1);
                        on_edit = false; // В случае ошибки обнуляет все поля до нуля
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });


    }

    private void resetAll() {
        millimetr.setText("0");
        metr.setText("0");
        kilometr.setText("0");
        mile.setText("0");
        sm.setText("0");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}