package com.xmmems.domain.site;

import java.util.Date;

public class SiteMonitoring {
    private Integer id;

    private String siteName;

    private String ad;

    private Integer deviceID;

    private Date recordingTime;

    private Date moniTime;

    private String equipmentState;

    private String communicationStatus;

    private String dataSource;

    private String reservedAIN1;

    private String accumulatedRainfall;

    private String rainfallIntensity;

    private String five_minuteRainfall;

    private String rainfallDuring;

    private String dailyPrecipitation;

    private String ten_dayRainfall;

    private String monthlyRainfall;

    private String valueCOD;

    private String zdz;

    private String valueTOC;

    private String probeTemperature;

    private String atmosphericPressure;

    private String batteryPercentage;

    private String externalVoltage;

    private String pressure;

    private String depth;

    private String rjy;

    private String oxygenPartialPressure;

    private String zd;

    private String temperature;

    private String ddl;

    private String salinity;

    private String totalDissolvedSolid;

    private String resistivity;

    private String waterDensity;

    private String ph;

    private String potentialREDOX;

    private String rainGaugeFault;

    private String rainClearAddress;

    private String communicationFailureCODanalyzer;

    private String waterQualityAnalyzer;

    private String waterUpLevelAlarm;

    private String waterDownLevelAlarm;

    private String doorSwitch;

    private String powerDetect;

    private String faultAIN1;

    private String upperLimitAlarmAIN1;

    private String lowerLimitAlarmAIN1;

    private String waterLevelState;

    private String waterLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad == null ? null : ad.trim();
    }

    public Integer getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(Integer deviceID) {
        this.deviceID = deviceID;
    }

    public Date getRecordingTime() {
        return recordingTime;
    }

    public void setRecordingTime(Date recordingTime) {
        this.recordingTime = recordingTime;
    }

    public Date getMoniTime() {
        return moniTime;
    }

    public void setMoniTime(Date moniTime) {
        this.moniTime = moniTime;
    }

    public String getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(String equipmentState) {
        this.equipmentState = equipmentState == null ? null : equipmentState.trim();
    }

    public String getCommunicationStatus() {
        return communicationStatus;
    }

    public void setCommunicationStatus(String communicationStatus) {
        this.communicationStatus = communicationStatus == null ? null : communicationStatus.trim();
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    public String getReservedAIN1() {
        return reservedAIN1;
    }

    public void setReservedAIN1(String reservedAIN1) {
        this.reservedAIN1 = reservedAIN1 == null ? null : reservedAIN1.trim();
    }

    public String getAccumulatedRainfall() {
        return accumulatedRainfall;
    }

    public void setAccumulatedRainfall(String accumulatedRainfall) {
        this.accumulatedRainfall = accumulatedRainfall == null ? null : accumulatedRainfall.trim();
    }

    public String getRainfallIntensity() {
        return rainfallIntensity;
    }

    public void setRainfallIntensity(String rainfallIntensity) {
        this.rainfallIntensity = rainfallIntensity == null ? null : rainfallIntensity.trim();
    }

    public String getFive_minuteRainfall() {
        return five_minuteRainfall;
    }

    public void setFive_minuteRainfall(String five_minuteRainfall) {
        this.five_minuteRainfall = five_minuteRainfall == null ? null : five_minuteRainfall.trim();
    }

    public String getRainfallDuring() {
        return rainfallDuring;
    }

    public void setRainfallDuring(String rainfallDuring) {
        this.rainfallDuring = rainfallDuring == null ? null : rainfallDuring.trim();
    }

    public String getDailyPrecipitation() {
        return dailyPrecipitation;
    }

    public void setDailyPrecipitation(String dailyPrecipitation) {
        this.dailyPrecipitation = dailyPrecipitation == null ? null : dailyPrecipitation.trim();
    }

    public String getTen_dayRainfall() {
        return ten_dayRainfall;
    }

    public void setTen_dayRainfall(String ten_dayRainfall) {
        this.ten_dayRainfall = ten_dayRainfall == null ? null : ten_dayRainfall.trim();
    }

    public String getMonthlyRainfall() {
        return monthlyRainfall;
    }

    public void setMonthlyRainfall(String monthlyRainfall) {
        this.monthlyRainfall = monthlyRainfall == null ? null : monthlyRainfall.trim();
    }

    public String getValueCOD() {
        return valueCOD;
    }

    public void setValueCOD(String valueCOD) {
        this.valueCOD = valueCOD == null ? null : valueCOD.trim();
    }

    public String getZdz() {
        return zdz;
    }

    public void setZdz(String zdz) {
        this.zdz = zdz == null ? null : zdz.trim();
    }

    public String getValueTOC() {
        return valueTOC;
    }

    public void setValueTOC(String valueTOC) {
        this.valueTOC = valueTOC == null ? null : valueTOC.trim();
    }

    public String getProbeTemperature() {
        return probeTemperature;
    }

    public void setProbeTemperature(String probeTemperature) {
        this.probeTemperature = probeTemperature == null ? null : probeTemperature.trim();
    }

    public String getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(String atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure == null ? null : atmosphericPressure.trim();
    }

    public String getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(String batteryPercentage) {
        this.batteryPercentage = batteryPercentage == null ? null : batteryPercentage.trim();
    }

    public String getExternalVoltage() {
        return externalVoltage;
    }

    public void setExternalVoltage(String externalVoltage) {
        this.externalVoltage = externalVoltage == null ? null : externalVoltage.trim();
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure == null ? null : pressure.trim();
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth == null ? null : depth.trim();
    }

    public String getRjy() {
        return rjy;
    }

    public void setRjy(String rjy) {
        this.rjy = rjy == null ? null : rjy.trim();
    }

    public String getOxygenPartialPressure() {
        return oxygenPartialPressure;
    }

    public void setOxygenPartialPressure(String oxygenPartialPressure) {
        this.oxygenPartialPressure = oxygenPartialPressure == null ? null : oxygenPartialPressure.trim();
    }

    public String getZd() {
        return zd;
    }

    public void setZd(String zd) {
        this.zd = zd == null ? null : zd.trim();
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public String getDdl() {
        return ddl;
    }

    public void setDdl(String ddl) {
        this.ddl = ddl == null ? null : ddl.trim();
    }

    public String getSalinity() {
        return salinity;
    }

    public void setSalinity(String salinity) {
        this.salinity = salinity == null ? null : salinity.trim();
    }

    public String getTotalDissolvedSolid() {
        return totalDissolvedSolid;
    }

    public void setTotalDissolvedSolid(String totalDissolvedSolid) {
        this.totalDissolvedSolid = totalDissolvedSolid == null ? null : totalDissolvedSolid.trim();
    }

    public String getResistivity() {
        return resistivity;
    }

    public void setResistivity(String resistivity) {
        this.resistivity = resistivity == null ? null : resistivity.trim();
    }

    public String getWaterDensity() {
        return waterDensity;
    }

    public void setWaterDensity(String waterDensity) {
        this.waterDensity = waterDensity == null ? null : waterDensity.trim();
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph == null ? null : ph.trim();
    }

    public String getPotentialREDOX() {
        return potentialREDOX;
    }

    public void setPotentialREDOX(String potentialREDOX) {
        this.potentialREDOX = potentialREDOX == null ? null : potentialREDOX.trim();
    }

    public String getRainGaugeFault() {
        return rainGaugeFault;
    }

    public void setRainGaugeFault(String rainGaugeFault) {
        this.rainGaugeFault = rainGaugeFault == null ? null : rainGaugeFault.trim();
    }

    public String getRainClearAddress() {
        return rainClearAddress;
    }

    public void setRainClearAddress(String rainClearAddress) {
        this.rainClearAddress = rainClearAddress == null ? null : rainClearAddress.trim();
    }

    public String getCommunicationFailureCODanalyzer() {
        return communicationFailureCODanalyzer;
    }

    public void setCommunicationFailureCODanalyzer(String communicationFailureCODanalyzer) {
        this.communicationFailureCODanalyzer = communicationFailureCODanalyzer == null ? null : communicationFailureCODanalyzer.trim();
    }

    public String getWaterQualityAnalyzer() {
        return waterQualityAnalyzer;
    }

    public void setWaterQualityAnalyzer(String waterQualityAnalyzer) {
        this.waterQualityAnalyzer = waterQualityAnalyzer == null ? null : waterQualityAnalyzer.trim();
    }

    public String getWaterUpLevelAlarm() {
        return waterUpLevelAlarm;
    }

    public void setWaterUpLevelAlarm(String waterUpLevelAlarm) {
        this.waterUpLevelAlarm = waterUpLevelAlarm == null ? null : waterUpLevelAlarm.trim();
    }

    public String getWaterDownLevelAlarm() {
        return waterDownLevelAlarm;
    }

    public void setWaterDownLevelAlarm(String waterDownLevelAlarm) {
        this.waterDownLevelAlarm = waterDownLevelAlarm == null ? null : waterDownLevelAlarm.trim();
    }

    public String getDoorSwitch() {
        return doorSwitch;
    }

    public void setDoorSwitch(String doorSwitch) {
        this.doorSwitch = doorSwitch == null ? null : doorSwitch.trim();
    }

    public String getPowerDetect() {
        return powerDetect;
    }

    public void setPowerDetect(String powerDetect) {
        this.powerDetect = powerDetect == null ? null : powerDetect.trim();
    }

    public String getFaultAIN1() {
        return faultAIN1;
    }

    public void setFaultAIN1(String faultAIN1) {
        this.faultAIN1 = faultAIN1 == null ? null : faultAIN1.trim();
    }

    public String getUpperLimitAlarmAIN1() {
        return upperLimitAlarmAIN1;
    }

    public void setUpperLimitAlarmAIN1(String upperLimitAlarmAIN1) {
        this.upperLimitAlarmAIN1 = upperLimitAlarmAIN1 == null ? null : upperLimitAlarmAIN1.trim();
    }

    public String getLowerLimitAlarmAIN1() {
        return lowerLimitAlarmAIN1;
    }

    public void setLowerLimitAlarmAIN1(String lowerLimitAlarmAIN1) {
        this.lowerLimitAlarmAIN1 = lowerLimitAlarmAIN1 == null ? null : lowerLimitAlarmAIN1.trim();
    }

    public String getWaterLevelState() {
        return waterLevelState;
    }

    public void setWaterLevelState(String waterLevelState) {
        this.waterLevelState = waterLevelState == null ? null : waterLevelState.trim();
    }

    public String getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(String waterLevel) {
        this.waterLevel = waterLevel == null ? null : waterLevel.trim();
    }
}