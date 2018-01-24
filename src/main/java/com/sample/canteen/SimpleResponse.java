package com.sample.canteen;

public class SimpleResponse {

    private String textToSpeech;
    private String displayText;

    public SimpleResponse() {
    }

    public SimpleResponse(String textToSpeech, String displayText) {
        this.textToSpeech = textToSpeech;
        this.displayText = displayText;
    }

    public String getTextToSpeech() {
        return textToSpeech;
    }

    public String getDisplayText() {
        return displayText;
    }
}
