package com.monika.smartreaders.ModelResponse;

public class SettingsModel {
    int pic;
    String text;

    public SettingsModel(int pic, String text) {
        this.pic = pic;
        this.text = text;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
