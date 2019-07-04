package com.example.vbuilder;

public class DictionaryEntry {
    private String word;
    private String definition;
    private String sentence;

    public DictionaryEntry() {
    }

    public DictionaryEntry(String word, String definition, String sentence) {
        this.word = word;
        this.definition = definition;
        this.sentence = sentence;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return "DictionaryEntry{" +
                "word='" + word + '\'' +
                ", definition='" + definition + '\'' +
                ", sentence='" + sentence + '\'' +
                '}';
    }
}
