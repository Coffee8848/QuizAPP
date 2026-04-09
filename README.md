# Quiz APP

This project is an Android quiz application developed in Android Studio for SIT305 Task 3.1.

## Features

- Enter user name before starting the quiz
- Answer multiple-choice quiz questions
- Show visual feedback after submission
- Correct answer turns green
- Wrong selected answer turns red
- Prevent changing the answer after submission
- Show quiz progress with a progress bar
- Display final score on the results screen
- Keep the user name when starting a new quiz
- Finish button closes the application

## Project Structure

- `MainActivity.java`: main screen for entering the user name
- `QuizActivity.java`: quiz logic, answer checking, and progress tracking
- `ResultActivity.java`: final score screen
- `Question.java`: question data model
- `activity_main.xml`: main screen layout
- `activity_quiz.xml`: quiz screen layout
- `activity_result.xml`: result screen layout

## Tools Used

- Android Studio
- Java
- XML
- SharedPreferences
- Intent

## Notes

This app was created to match the main requirements of SIT305 Task 3.1.  
The dark mode and light mode feature for SIT708 was not included.
