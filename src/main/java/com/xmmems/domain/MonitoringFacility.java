package com.xmmems.domain;

public class MonitoringFacility {
    private Integer id;

    private Integer unitID;

    private String equipmentName;

    private String equipmentModel;

    private String analysisWay;

    private String testOption;

    private String reagent;

    private String detection;

    private  double price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnitID() {
        return unitID;
    }

    public void setUnitID(Integer unitID) {
        this.unitID = unitID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel == null ? null : equipmentModel.trim();
    }

    public String getAnalysisWay() {
        return analysisWay;
    }

    public void setAnalysisWay(String analysisWay) {
        this.analysisWay = analysisWay == null ? null : analysisWay.trim();
    }

    public String getTestOption() {
        return testOption;
    }

    public void setTestOption(String testOption) {
        this.testOption = testOption == null ? null : testOption.trim();
    }

    public String getReagent() {
        return reagent;
    }

    public void setReagent(String reagent) {
        this.reagent = reagent == null ? null : reagent.trim();
    }

    public String getDetection() {
        return detection;
    }

    public void setDetection(String detection) {
        this.detection = detection;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}