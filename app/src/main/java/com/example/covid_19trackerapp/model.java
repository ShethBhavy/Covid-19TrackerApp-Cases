package com.example.covid_19trackerapp;

public class model {

    private String flag, contryName, todayCases, totalCases, totalDeaths, todayDeaths, recoverdCases, activeCases, criticalCases;

    public model() {}
    public model(String flag, String contryName, String todayCases, String totalCases, String totalDeaths, String todayDeaths, String recoverdCases, String activeCases, String criticalCases) {
        this.flag = flag;
        this.contryName = contryName;
        this.todayCases = todayCases;
        this.totalCases = totalCases;
        this.totalDeaths = totalDeaths;
        this.todayDeaths = todayDeaths;
        this.recoverdCases = recoverdCases;
        this.activeCases = activeCases;
        this.criticalCases = criticalCases;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getContryName() {
        return contryName;
    }

    public void setContryName(String contryName) {
        this.contryName = contryName;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getRecoverdCases() {
        return recoverdCases;
    }

    public void setRecoverdCases(String recoverdCases) {
        this.recoverdCases = recoverdCases;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getCriticalCases() {
        return criticalCases;
    }

    public void setCriticalCases(String criticalCases) {
        this.criticalCases = criticalCases;
    }
}
