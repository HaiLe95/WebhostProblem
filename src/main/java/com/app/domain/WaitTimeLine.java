package com.app.domain;


import java.util.Date;

public class WaitTimeLine {

    private String serviceId;

    private String questionType;

    private Character responseType;

    private Date timeLineDate;

    private Integer waitTime;

    private int queue;

    public WaitTimeLine() {}

    public WaitTimeLine(String serviceId, String questionType, Character responseType, String date, Integer waitTime) {
        this.serviceId = serviceId;
        this.questionType = questionType;
        this.responseType = responseType;
        this.waitTime = waitTime;
        if(date.length() == 10) {
            String [] temp = date.split("\\.");
            timeLineDate = new Date(
                    Integer.parseInt(temp[2]),
                    Integer.parseInt(temp[1]),
                    Integer.parseInt(temp[0])
            );
        }
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
    public Integer getWaitTime() {
        return waitTime;
    }
    public void setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
    }
    public int getQueue() {
        return queue;
    }
    public void setQueue(int queue) {
        this.queue = queue;
    }
    public Date getTimeLineDate() {
        return timeLineDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WaitTimeLine{");
        sb.append("serviceId='").append(serviceId).append('\'');
        sb.append(", questionType='").append(questionType).append('\'');
        sb.append(", responseType=").append(responseType);
        sb.append(", timeLineDate=").append(timeLineDate);
        sb.append(", waitTime=").append(waitTime);
        sb.append('}');
        return sb.toString();
    }
}
