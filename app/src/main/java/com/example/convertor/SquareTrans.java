package com.example.convertor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.convertor.databinding.ActivitySquareTransBinding;

import java.text.DecimalFormat;

public class SquareTrans extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySquareTransBinding binding;
    private Toolbar toolbar1;
    private EditText metr, millimetr, kilometr, mile;
    private boolean on_edit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_trans);

        binding = ActivitySquareTransBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar1 = findViewById(R.id.toolbar1);

        DecimalFormat df = new DecimalFormat("#.########");

        millimetr = findViewById(R.id.ediInputMetr);
        millimetr.setSelectAllOnFocus(true);
        metr = findViewById(R.id.ediInputMetr2);
        metr.setSelectAllOnFocus(true);
        kilometr = findViewById(R.id.ediInputMetr3);
        kilometr.setSelectAllOnFocus(true);
        mile = findViewById(R.id.ediInputMetr4);
        mile.setSelectAllOnFocus(true);

        setSupportActionBar(binding.toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("Площадь");


        millimetr.addTextChangedListener(new TextWatcher() {
            Double i1;
            public void afterTextChanged(Editable s) {
                if (millimetr.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
                    millimetr.setText("0");
                    millimetr.setSelection(1);
                }
                if (millimetr.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        millimetr.setText(TextEditor.edit(millimetr.getText().toString()));
                        millimetr.setSelection(millimetr.length());
                        on_edit = false;

                        i1 = Double.valueOf(millimetr.getText().toString());
                        metr.setText(String.valueOf(df.format(i1 / 1000000)) + " м\u00B2");
                        kilometr.setText(String.valueOf(df.format(i1 / 1000000 / 1000000)) + " км\u00B2");
                        mile.setText(String.valueOf(df.format(i1 / Math.pow(1609340, 2))) + " mi\u00B2");
                        toolbar1.setSubtitle("Миллиметр\u00B2");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        millimetr.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        metr.addTextChangedListener(new TextWatcher() {
            Double i1;
            public void afterTextChanged(Editable s) {
                if (metr.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
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
                        millimetr.setText(String.valueOf(df.format(i1 * 1000000)) + " мм\u00B2");
                        kilometr.setText(String.valueOf(df.format(i1 / 1000000)) + " км\u00B2");
                        mile.setText(String.valueOf(df.format(i1 / Math.pow(1609.340, 2))) + " mi\u00B2");
                        toolbar1.setSubtitle("Метр\u00B2");
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
                if (kilometr.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
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
                        millimetr.setText(String.valueOf(df.format(i1 * 1000000 * 1000000)) + " мм\u00B2");
                        metr.setText(String.valueOf(df.format(i1 * 1000000)) + " м\u00B2");
                        mile.setText(String.valueOf(df.format(i1 / Math.pow(1.609340, 2))) + " mi\u00B2");
                        toolbar1.setSubtitle("Километр\u00B2");
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
                if (mile.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
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
                        millimetr.setText(String.valueOf(df.format(i1 * Math.pow(1609340, 2))) + " мм\u00B2");
                        metr.setText(String.valueOf(df.format(i1 * Math.pow(1609.340, 2))) + " м\u00B2");
                        kilometr.setText(String.valueOf(df.format(i1 * Math.pow(1.609340, 2))) + " км\u00B2");
                        toolbar1.setSubtitle("Миля\u00B2");
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


        }); //*/

    }

    private void resetAll() {
        millimetr.setText("0");
        metr.setText("0");
        kilometr.setText("0");
        mile.setText("0");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}