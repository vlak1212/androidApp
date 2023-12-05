package com.example.java_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    private TextInputEditText password;
    private TextInputEditText confirmPassword;
    private TextInputLayout confirmPasswordLayout;
    private TextInputLayout passwordLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        password = findViewById(R.id.passwordInput);
        passwordLayout = findViewById(R.id.passwordInputLayout);
        confirmPassword = findViewById(R.id.confirmPasswordInput);
        confirmPasswordLayout = findViewById(R.id.confirmPasswordInputLayout);
        password.addTextChangedListener(new TextWatcher() { // watch thằng text
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // bth
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // Đang nhập
                checkPasswordComplexity(charSequence.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {
                // Sau khi nhập
            }
        });
        confirmPassword.addTextChangedListener(new TextWatcher() { // watch thằng text
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // bth
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                // Đang nhập
                checkPasswordMatch();
            }
            @Override
            public void afterTextChanged(Editable editable) {
                // Sau khi nhập
            }
        });
    }


    private void checkPasswordMatch() { // ktra nếu trùng
        String pass = password.getText().toString();
        String confirmPass = confirmPassword.getText().toString();

        if (!pass.equals(confirmPass)) {
            confirmPasswordLayout.setError("Mật khẩu không khớp");
        } else {
            confirmPasswordLayout.setError(null);
        }

    }

    private void checkPasswordComplexity(String password) { // ktra yêu cầu về pass
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (password.length() < 6) {
            passwordLayout.setError("Mật khẩu phải có ít nhất 6 ký tự");
            return;
        }
        if (!matcher.matches()) {
            passwordLayout.setError("Mật khẩu phải có ít nhất một chữ hoa, một chữ số và một kí tự đặc biệt");
        } else {
            passwordLayout.setError(null);
        }
    }
}
