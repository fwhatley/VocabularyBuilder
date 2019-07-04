package com.example.vbuilder;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Dictionary dictionary;
    private int currentItemInView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initDictionary();

        // handle next button
        final Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextButton.getText().toString() == "RESTART") {
                    currentItemInView = -1;
                    setNextButtonText("NEXT");
                }
                displayNextDictionaryWord();
            }
        });
    }

    public void initDictionary() {
        dictionary = new Dictionary(this);
        currentItemInView = -1;
        displayNextDictionaryWord();
    }

    public void displayNextDictionaryWord() {
        TextView word = findViewById(R.id.word_text);
        TextView definition = findViewById(R.id.definition_text);
        TextView sentence = findViewById(R.id.sentence_text);
        int nextItemLocation = ++currentItemInView;

        if (currentItemInView < dictionary.getDictionaryEntries().size()) {
            DictionaryEntry entry = dictionary.getDictionaryEntries().get(nextItemLocation);

            word.setText(entry.getWord());
            definition.setText(entry.getDefinition());
            sentence.setText(entry.getSentence());
        } else {
            word.setText("You finished all the words. You are awesome!");
            definition.setText("");
            sentence.setText("");
            setNextButtonText("RESTART");
        }
    }

    public void setNextButtonText(String text) {
        Button nextButton = findViewById(R.id.next_button);
        nextButton.setText(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
