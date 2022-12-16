package com.example.convertor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.convertor.databinding.ActivityTimeTransBinding;

import java.text.DecimalFormat;

public class TimeTrans extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTimeTransBinding binding;
    private Toolbar toolbar1;
    private EditText ms, sec, min, hour;
    private boolean on_edit = false;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_trans);

        binding = ActivityTimeTransBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar1 = findViewById(R.id.toolbar1);

        DecimalFormat df = new DecimalFormat("#.####");

        ms = findViewById(R.id.ediInputMetr);
        ms.setSelectAllOnFocus(true);
        sec = findViewById(R.id.ediInputMetr2);
        sec.setSelectAllOnFocus(true);
        min = findViewById(R.id.ediInputMetr3);
        min.setSelectAllOnFocus(true);
        hour = findViewById(R.id.ediInputMetr4);
        hour.setSelectAllOnFocus(true);

        setSupportActionBar(binding.toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("Время");


        ms.addTextChangedListener(new TextWatcher() {
            Double i1;

            public void afterTextChanged(Editable s) {
                if (ms.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
                    ms.setText("0");
                    ms.setSelection(1);
                }
                if (ms.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        ms.setText(TextEditor.edit(ms.getText().toString()));
                        ms.setSelection(ms.length());
                        on_edit = false;

                        i1 = Double.valueOf(ms.getText().toString());
                        sec.setText(String.valueOf(df.format(i1 / 1000 )) + " сек");
                        min.setText(String.valueOf(df.format(i1 / 1000 / 60)) + " мин");
                        hour.setText(String.valueOf(df.format(i1 / 1000 / 3600)) + " ч");

                        toolbar1.setSubtitle("Миллисекунда");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        ms.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        sec.addTextChangedListener(new TextWatcher() {
            Double i1;

            public void afterTextChanged(Editable s) {
                if (sec.getText().length() == 0) {
                    sec.setText("0");
                    sec.setSelection(1);
                }
                if (sec.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        sec.setText(TextEditor.edit(sec.getText().toString()));
                        sec.setSelection(sec.length());
                        on_edit = false;

                        i1 = Double.valueOf(sec.getText().toString());
                        ms.setText(String.valueOf(df.format(i1 * 1000)) + " мс");
                        min.setText(String.valueOf(df.format(i1 / 60)) + " мин");
                        hour.setText(String.valueOf(df.format(i1 * 60)) + " ч");
                        toolbar1.setSubtitle("Секунда");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        sec.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        min.addTextChangedListener(new TextWatcher() {
            Double i1;

            public void afterTextChanged(Editable s) {
                if (min.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
                    min.setText("0");
                    min.setSelection(1);
                }
                if (min.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        min.setText(TextEditor.edit(min.getText().toString()));
                        min.setSelection(min.length());
                        on_edit = false;

                        i1 = Double.valueOf(min.getText().toString());
                        ms.setText(String.valueOf(df.format(i1 * 1000 * 60)) + " мс");
                        sec.setText(String.valueOf(df.format(i1 * 60)) + " сек");
                        hour.setText(String.valueOf(df.format(i1 / 60)) + " ч");
                        toolbar1.setSubtitle("Минута");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        min.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        hour.addTextChangedListener(new TextWatcher() {
            Double i1;

            public void afterTextChanged(Editable s) {
                if (hour.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
                    hour.setText("0");
                    hour.setSelection(1);
                }
                if (hour.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        hour.setText(TextEditor.edit(hour.getText().toString()));
                        hour.setSelection(hour.length());
                        on_edit = false;

                        i1 = Double.valueOf(hour.getText().toString());
                        ms.setText(String.valueOf(df.format(i1 * 8 * 3600)) + " мс");
                        sec.setText(String.valueOf(df.format(i1 * 3600)) + " сек");
                        min.setText(String.valueOf(df.format(i1 * 60)) + " мин");
                        toolbar1.setSubtitle("Час");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        hour.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    private void resetAll() {
        ms.setText("0");
        sec.setText("0");
        min.setText("0");
        hour.setText("0");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}