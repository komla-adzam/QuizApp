package com.example.kbee.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int numberOfCorrectAnswers;

    private static final int numberOfQuestions = 8;

    private static final int[] correctAnswersIds = {
            R.id.q1_option_a, R.id.q2_option_c, R.id.q3_option_c, R.id.q4_option_a,
            R.id.q5_option_b, R.id.q6_option_b, R.id.q7_option_a, R.id.q8_option_b
    };

    private static final int[] optionsRadioGroupIds = {
            R.id.q1_radio_group, R.id.q2_radio_group, R.id.q3_radio_group, R.id.q4_radio_group,
            R.id.q5_radio_group, R.id.q6_radio_group, R.id.q7_radio_group, R.id.q8_radio_group
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Called when the MARK button is pressed
     *
     * @param view
     */
    public void markQuiz(View view) {

        RadioButton answerRadioButton;

        for (int answerId : correctAnswersIds) {
            answerRadioButton = (RadioButton) findViewById(answerId);

            if (answerRadioButton.isChecked()) {
                markCorrect();

            }
        }

        displayResult();

        numberOfCorrectAnswers = 0;
    }

    /**
     * Called when the CLEAR button is clicked.
     * Clears all checked radio buttons in the various radio groups
     */
    public void clearChoices(View view) {
        RadioGroup optionsRadioGroup;
        
        for (int optionsId : optionsRadioGroupIds) {
            optionsRadioGroup = (RadioGroup) findViewById(optionsId);
            optionsRadioGroup.clearCheck();
        }

        TextView resultsTextView1 = (TextView) findViewById(R.id.result_text_view_1);
        resultsTextView1.setText("0");

        TextView resultsTextView2 = (TextView) findViewById(R.id.result_text_view_2);
        resultsTextView2.setText("Select from the options of each question");

        numberOfCorrectAnswers = 0;
    }

    /**
     * Displays the results in the appropriate TextView
     */
    private void displayResult() {
        TextView resultsTextView1 = (TextView) findViewById(R.id.result_text_view_1);
        resultsTextView1.setText("" + numberOfCorrectAnswers);

        TextView resultsTextView2 = (TextView) findViewById(R.id.result_text_view_2);
        resultsTextView2.setText("correct out of " + numberOfQuestions + " questions!");
    }

    /**
     * Mark correct by increasing the number of correct answers
     */
    private void markCorrect() {
        ++numberOfCorrectAnswers;
    }
}
