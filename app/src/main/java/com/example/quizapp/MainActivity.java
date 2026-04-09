package com.example.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "quiz_prefs";
    public static final String KEY_USER_NAME = "user_name";

    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.editTextName);
        Button startQuizButton = findViewById(R.id.buttonStartQuiz);

        loadSavedName();
        showNameFromIntent();

        startQuizButton.setOnClickListener(v -> startQuiz());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        showNameFromIntent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadSavedName();
    }

    private void startQuiz() {
        String userName = nameEditText.getText().toString().trim();

        if (userName.isEmpty()) {
            Toast.makeText(this, "Please enter your name first", Toast.LENGTH_SHORT).show();
            return;
        }

        saveName(userName);

        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        intent.putExtra("user_name", userName);
        startActivity(intent);
    }

    private void saveName(String userName) {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        preferences.edit().putString(KEY_USER_NAME, userName).apply();
    }

    private void loadSavedName() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String savedName = preferences.getString(KEY_USER_NAME, "");
        nameEditText.setText(savedName);
    }

    private void showNameFromIntent() {
        String nameFromIntent = getIntent().getStringExtra("user_name");
        if (nameFromIntent != null && !nameFromIntent.isEmpty()) {
            nameEditText.setText(nameFromIntent);
        }
    }
}
