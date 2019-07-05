package com.whatley.vbuilder;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private List<DictionaryEntry> dictionaryEntries;

    public Dictionary(Context context) {
        initDictionaryEntries(context);
    }

    private void initDictionaryEntries(Context context) {
        dictionaryEntries = new ArrayList<>();

        // https://o7planning.org/en/10459/android-json-parser-tutorial
        // https://stackoverflow.com/questions/18192891/conversion-from-string-to-json-object-android
        try {
            // Read content of dictionary_entries.json
            String jsonText = readText(context, R.raw.dictionary_entries);
            JSONArray jsonArray = new JSONArray(jsonText);

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject entryObj = new JSONObject(jsonArray.getString(i));
                String word = entryObj.getString("word");
                String defintion = entryObj.getString("definition");
                String sentence = entryObj.getString("sentence");
                DictionaryEntry entry = new DictionaryEntry(word, defintion, sentence);
                dictionaryEntries.add(entry);
            }
        } catch (Exception e) {
            Log.w("FW", "FW - dictionary didn't get loaded");
        }
    }

    public Dictionary(List<DictionaryEntry> dictionaryEntries) {
        this.dictionaryEntries = dictionaryEntries;
    }

    public List<DictionaryEntry> getDictionaryEntries() {
        return dictionaryEntries;
    }

    public void setDictionaryEntries(List<DictionaryEntry> dictionaryEntries) {
        this.dictionaryEntries = dictionaryEntries;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "dictionaryEntries=" + dictionaryEntries +
                '}';
    }

    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while((  s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
