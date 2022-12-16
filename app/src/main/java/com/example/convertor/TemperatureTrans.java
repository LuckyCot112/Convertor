package com.example.convertor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.convertor.databinding.ActivityTemperatureTransBinding;

import java.text.DecimalFormat;

public class TemperatureTrans extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTemperatureTransBinding binding;
    private Toolbar toolbar1;
    private EditText celsiym, kelvin, farengate;
    private boolean on_edit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_trans);

        binding = ActivityTemperatureTransBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar1 = findViewById(R.id.toolbar1);

        DecimalFormat df = new DecimalFormat("#.####");

        celsiym = findViewById(R.id.ediInputMetr);
        celsiym.setSelectAllOnFocus(true);
        kelvin = findViewById(R.id.ediInputMetr2);
        kelvin.setSelectAllOnFocus(true);
        farengate = findViewById(R.id.ediInputMetr3);
        farengate.setSelectAllOnFocus(true);

        setSupportActionBar(binding.toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("Температура");


        celsiym.addTextChangedListener(new TextWatcher() {
            Double i1;
            public void afterTextChanged(Editable s) {
                if (celsiym.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
                    celsiym.setText("0");
                    celsiym.setSelection(1);
                }
                if (celsiym.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        celsiym.setText(TextEditor.edit(celsiym.getText().toString()));
                        celsiym.setSelection(celsiym.length());
                        on_edit = false;

                        i1 = Double.valueOf(celsiym.getText().toString());
                        kelvin.setText(String.valueOf(df.format(i1 + 273.15)) + " \u212A");
                        farengate.setText(String.valueOf(df.format(i1 * 1.8 + 32)) + " \u2109");
                        toolbar1.setSubtitle("Цельсий");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        celsiym.setText("0");
                        farengate.setText("32");
                        kelvin.setText("273.15");
                        celsiym.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        kelvin.addTextChangedListener(new TextWatcher() {
            Double i1;
            public void afterTextChanged(Editable s) {
                if (kelvin.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
                    kelvin.setText("0");
                    kelvin.setSelection(1);
                }
                if(kelvin.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        kelvin.setText(TextEditor.edit(kelvin.getText().toString()));
                        kelvin.setSelection(kelvin.length());
                        on_edit = false;

                        i1 = Double.valueOf(kelvin.getText().toString());
                        celsiym.setText(String.valueOf(df.format(i1 - 273.15)) + " \u2103");
                        farengate.setText(String.valueOf(df.format((i1 - 273.15) * 1.8 + 32)) + " \u2109");
                        toolbar1.setSubtitle("Кельвин");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        celsiym.setText("-273.15");
                        farengate.setText("-459,67");
                        kelvin.setText("0");
                        kelvin.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });

        farengate.addTextChangedListener(new TextWatcher() {
            Double i1;
            public void afterTextChanged(Editable s) {
                if (farengate.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
                    farengate.setText("0");
                    farengate.setSelection(1);
                }
                if (farengate.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        farengate.setText(TextEditor.edit(farengate.getText().toString()));
                        farengate.setSelection(farengate.length());
                        on_edit = false;

                        i1 = Double.valueOf(farengate.getText().toString());
                        celsiym.setText(String.valueOf(df.format((i1 - 32) / 1.8)) + " \u2103");
                        kelvin.setText(String.valueOf(df.format(((i1 - 32) / 1.8) + 273.15)) + " \u212A");
                        toolbar1.setSubtitle("Фаренгейт");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        celsiym.setText("-17.777");
                        farengate.setText("0");
                        kelvin.setText("275.372");
                        farengate.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}