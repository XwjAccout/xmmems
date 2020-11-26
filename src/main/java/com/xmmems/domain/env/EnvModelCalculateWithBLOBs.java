package com.xmmems.domain.env;

public class EnvModelCalculateWithBLOBs extends EnvModelCalculate {
    private String inputParam;

    private String inputFirstFile;

    private String inputSecondFile;

    private String outputFirstFile;

    private String outputSecondFile;

    public String getInputParam() {
        return inputParam;
    }

    public void setInputParam(String inputParam) {
        this.inputParam = inputParam == null ? null : inputParam.trim();
    }

    public String getInputFirstFile() {
        return inputFirstFile;
    }

    public void setInputFirstFile(String inputFirstFile) {
        this.inputFirstFile = inputFirstFile == null ? null : inputFirstFile.trim();
    }

    public String getInputSecondFile() {
        return inputSecondFile;
    }

    public void setInputSecondFile(String inputSecondFile) {
        this.inputSecondFile = inputSecondFile == null ? null : inputSecondFile.trim();
    }

    public String getOutputFirstFile() {
        return outputFirstFile;
    }

    public void setOutputFirstFile(String outputFirstFile) {
        this.outputFirstFile = outputFirstFile == null ? null : outputFirstFile.trim();
    }

    public String getOutputSecondFile() {
        return outputSecondFile;
    }

    public void setOutputSecondFile(String outputSecondFile) {
        this.outputSecondFile = outputSecondFile == null ? null : outputSecondFile.trim();
    }
}