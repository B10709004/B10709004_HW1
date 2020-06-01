package com.example.b10709004_hw1;

public class LikeFruit {
    private String dataName;
    private boolean checked = false;
    public LikeFruit(String text)
    {
        dataName = text;
    }
    public String getText(){
        return dataName;
    }
    public boolean isChecked()
    {
        return checked;
    }
    public void setChecked(boolean bechecked)
    {
        this.checked = bechecked;
    }
}
