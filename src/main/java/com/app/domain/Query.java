package com.app.domain;


import java.util.Date;

public class Query  {

    private String serviceId;

    private String questionType;

    private Character responseType;

    private Date startDate;

    private Date finalDate;


    private int queue;


    public Query() {}

    public Query(String serviceId, String questionType, Character responseType, String date) {
        this.serviceId = serviceId;
        this.questionType = questionType;
        this.responseType = responseType;
        setDates(date);
    }

    private void setDates(String date) {
        if(date.length() < 11) {
            String[] temp = date.split("\\.");
            Date tempoDate = new Date(
                    Integer.parseInt(temp[2]),
                    Integer.parseInt(temp[1]),
                    Integer.parseInt(temp[0])
            );
            startDate = tempoDate;
            finalDate = tempoDate;
        } else if(date.length() > 15 && date.length() < 22) {
            String[] temp = date.split("-");
            String[] tempSt = temp[0].split("\\.");
            String[] tempFl = temp[1].split("\\.");
            Date tempoStDate = new Date(
                    Integer.parseInt(tempSt[2]),
                    Integer.parseInt(tempSt[1]),
                    Integer.parseInt(tempSt[0])
            );
            startDate = tempoStDate;
            Date tempoFlDate = new Date(
                    Integer.parseInt(tempFl[2]),
                    Integer.parseInt(tempFl[1]),
                    Integer.parseInt(tempFl[0])
            );
            finalDate = tempoFlDate;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Query{");
        sb.append("serviceId='").append(serviceId).append('\'');
        sb.append(", questionType='").append(questionType).append('\'');
        sb.append(", responseType=").append(responseType);
        sb.append(", startDate=").append(startDate);
        sb.append(", finalDate=").append(finalDate);
        sb.append('}');
        return sb.toString();
    }

    public String getServiceId() {
        return serviceId;
    }
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
    public String getQuestionType() {
        return questionType;
    }
    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }
    public Character getResponseType() {
        return responseType;
    }
    public void setResponseType(Character responseType) {
        this.responseType = responseType;
    }
    public int getQueue() {
        return queue;
    }
    public void setQueue(int queue) {
        this.queue = queue;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getFinalDate() {
        return finalDate;
    }
    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }
    public boolean serviceIgnore() { return serviceId.equals("*"); }
    public boolean questionIgnore() { return  serviceId.equals("*"); }
}
