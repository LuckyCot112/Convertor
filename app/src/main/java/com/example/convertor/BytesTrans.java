package com.example.convertor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.convertor.databinding.ActivityBytesTransBinding;

import java.text.DecimalFormat;

public class BytesTrans extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityBytesTransBinding binding;
    private Toolbar toolbar1;
    private EditText bit, bytes, kilobytes, megabyte, gigabyte, terabyte;
    private boolean on_edit = false;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bytes_trans);

        binding = ActivityBytesTransBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar1 = findViewById(R.id.toolbar1);

        DecimalFormat df = new DecimalFormat("#.####");

        bit = findViewById(R.id.ediInputMetr);
        bit.setSelectAllOnFocus(true);
        bytes = findViewById(R.id.ediInputMetr2);
        bytes.setSelectAllOnFocus(true);
        kilobytes = findViewById(R.id.ediInputMetr3);
        kilobytes.setSelectAllOnFocus(true);
        megabyte = findViewById(R.id.ediInputMetr4);
        megabyte.setSelectAllOnFocus(true);
        gigabyte = findViewById(R.id.ediInputMetr5);
        gigabyte.setSelectAllOnFocus(true);
        terabyte = findViewById(R.id.ediInputMetr6);
        terabyte.setSelectAllOnFocus(true);

        setSupportActionBar(binding.toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("Объём");


        bit.addTextChangedListener(new TextWatcher() {
            Double i1;

            public void afterTextChanged(Editable s) {
                if (bit.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
                    resetAll();
                    bit.setSelection(1);
                }
                if (bit.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        bit.setText(TextEditor.edit(bit.getText().toString()));
                        bit.setSelection(bit.length());
                        on_edit = false;

                        i1 = Double.valueOf(bit.getText().toString());
                        bytes.setText(String.valueOf(df.format(i1 / 8 / Math.pow(1024, 0))) + " B");
                        kilobytes.setText(String.valueOf(df.format(i1 / 8 / Math.pow(1024, 1))) + " KB");
                        megabyte.setText(String.valueOf(df.format(i1 / 8 / Math.pow(1024, 2))) + " MB");
                        gigabyte.setText(String.valueOf(df.format(i1 / 8 / Math.pow(1024, 3))) + " GB");
                        terabyte.setText(String.valueOf(df.format(i1 / 8 / Math.pow(1024, 4))) + " TB");

                        toolbar1.setSubtitle("Бит");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        bit.setSelection(1);
                        on_edit = false;

                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        bytes.addTextChangedListener(new TextWatcher() {
            Double i1;

            public void afterTextChanged(Editable s) {
                if (bytes.getText().length() == 0) {
                    bytes.setText("0");
                    bytes.setSelection(1);
                }
                if (bytes.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        bytes.setText(TextEditor.edit(bytes.getText().toString()));
                        bytes.setSelection(bytes.length());
                        on_edit = false;

                        i1 = Double.valueOf(bytes.getText().toString());
                        bit.setText(String.valueOf(df.format(i1 * 8 * Math.pow(1024, 0))) + " bit");
                        kilobytes.setText(String.valueOf(df.format(i1 / Math.pow(1024, 1))) + " KB");
                        megabyte.setText(String.valueOf(df.format(i1 / Math.pow(1024, 2))) + " MB");
                        gigabyte.setText(String.valueOf(df.format(i1 / Math.pow(1024, 3))) + " GB");
                        terabyte.setText(String.valueOf(df.format(i1 / Math.pow(1024, 4))) + " TB");
                        toolbar1.setSubtitle("Байт");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        bytes.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        kilobytes.addTextChangedListener(new TextWatcher() {
            Double i1;

            public void afterTextChanged(Editable s) {
                if (kilobytes.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
                    kilobytes.setText("0");
                    kilobytes.setSelection(1);
                }
                if (kilobytes.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        kilobytes.setText(TextEditor.edit(kilobytes.getText().toString()));
                        kilobytes.setSelection(kilobytes.length());
                        on_edit = false;

                        i1 = Double.valueOf(kilobytes.getText().toString());
                        bit.setText(String.valueOf((i1 * 8 * Math.pow(1024, 1))) + " bit");
                        bytes.setText(String.valueOf((i1 * Math.pow(1024, 1))) + " KB");
                        megabyte.setText(String.valueOf((i1 / Math.pow(1024, 1))) + " MB");
                        gigabyte.setText(String.valueOf((i1 / Math.pow(1024, 2))) + " GB");
                        terabyte.setText(String.valueOf((i1 / Math.pow(1024, 3))) + " TB");
                        toolbar1.setSubtitle("Килобайт");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        kilobytes.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        megabyte.addTextChangedListener(new TextWatcher() {
            Double i1;

            public void afterTextChanged(Editable s) {
                if (megabyte.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
                    megabyte.setText("0");
                    megabyte.setSelection(1);
                }
                if (megabyte.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        megabyte.setText(TextEditor.edit(megabyte.getText().toString()));
                        megabyte.setSelection(megabyte.length());
                        on_edit = false;

                        i1 = Double.valueOf(megabyte.getText().toString());
                        bit.setText(String.valueOf((i1 * 8 * Math.pow(1024, 2))) + " bit");
                        bytes.setText(String.valueOf((i1 * Math.pow(1024, 2))) + " KB");
                        kilobytes.setText(String.valueOf((i1 * Math.pow(1024, 1))) + " MB");
                        gigabyte.setText(String.valueOf((i1 / Math.pow(1024, 1))) + " GB");
                        terabyte.setText(String.valueOf((i1 / Math.pow(1024, 2))) + " TB");
                        toolbar1.setSubtitle("Мегабайт");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        megabyte.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }


        });

        gigabyte.addTextChangedListener(new TextWatcher() {
            Double i1;

            public void afterTextChanged(Editable s) {
                if (gigabyte.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
                    gigabyte.setText("0");
                    gigabyte.setSelection(1);
                }
                if (gigabyte.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        gigabyte.setText(TextEditor.edit(gigabyte.getText().toString()));
                        gigabyte.setSelection(gigabyte.length());
                        on_edit = false;

                        i1 = Double.valueOf(gigabyte.getText().toString());
                        bit.setText(String.valueOf((i1 * 8 * Math.pow(1024, 3))) + " bit");
                        bytes.setText(String.valueOf((i1 * Math.pow(1024, 3))) + " KB");
                        kilobytes.setText(String.valueOf((i1 * Math.pow(1024, 2))) + " MB");
                        megabyte.setText(String.valueOf((i1 * Math.pow(1024, 1))) + " GB");
                        terabyte.setText(String.valueOf((i1 / Math.pow(1024, 1))) + " TB");
                        toolbar1.setSubtitle("Гигабайт");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        gigabyte.setSelection(1);
                        on_edit = false;
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }


        });

        terabyte.addTextChangedListener(new TextWatcher() {
            Double i1;

            public void afterTextChanged(Editable s) {
                if (terabyte.getText().length() == 0) { //count определяет кол-во символов для удаления. 1 выдает кнопка B (стирает 1 символ в конце. Справка: B - от Backspace)
                    terabyte.setText("0");
                    terabyte.setSelection(1);
                }
                if (terabyte.hasFocus() && on_edit == false) {
                    try {
                        on_edit = true;
                        terabyte.setText(TextEditor.edit(terabyte.getText().toString()));
                        terabyte.setSelection(terabyte.length());
                        on_edit = false;

                        i1 = Double.valueOf(terabyte.getText().toString());
                        bit.setText(String.valueOf(df.format(i1 * 8 * Math.pow(1024, 4))) + " bit");
                        bytes.setText(String.valueOf(df.format(i1 * Math.pow(1024, 4))) + " KB");
                        kilobytes.setText(String.valueOf(df.format(i1 * Math.pow(1024, 3))) + " MB");
                        megabyte.setText(String.valueOf(df.format(i1 * Math.pow(1024, 2))) + " GB");
                        gigabyte.setText(String.valueOf(df.format(i1 * Math.pow(1024, 1))) + " TB");
                        toolbar1.setSubtitle("Терабайт");
                    }
                    catch (Exception e) {
                        on_edit = true;
                        resetAll();
                        terabyte.setSelection(1);
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
        bit.setText("0");
        bytes.setText("0");
        kilobytes.setText("0");
        megabyte.setText("0");
        gigabyte.setText("0");
        terabyte.setText("0");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}