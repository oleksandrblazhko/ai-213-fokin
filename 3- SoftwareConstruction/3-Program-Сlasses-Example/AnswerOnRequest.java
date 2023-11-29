package com.example.blazkolab9.model;

import jakarta.persistence.*;

@Entity
public class AnswerOnRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private float measuredLightLevel;

    private String answerTime;

    private String answerStatus;

    @ManyToOne
    @JoinColumn (name = "requestlightquality_id")
    private RequestLightLevel requestLightLevel;

    @ManyToOne
    @JoinColumn (name = "safeLightBot_id")
    private safeLightBot safeLightBot;

    public AnswerOnRequest() {
    }

    public AnswerOnRequest(float measuredLightLevel, String answerTime, String answerStatus, RequestLightLevel requestLightLevel, safeLightBot safeLightBot) {
        this.measuredLightLevel = measuredLightLevel;
        this.answerTime = answerTime;
        this.answerStatus = answerStatus;
        this.requestLightLevel = requestLightLevel;
        this.safeLightBot = safeLightBot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getMeasuredLightLevel() {
        return measuredLightLevel;
    }

    public void setMeasuredLightLevel(float measuredLightLevel) {
        this.measuredLightLevel = measuredLightLevel;
    }

    public String getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }

    public String getAnswerStatus() {
        return answerStatus;
    }

    public void setAnswerStatus(String answerStatus) {
        this.answerStatus = answerStatus;
    }

    public RequestLightLevel getRequestLightLevel() {
        return requestLightLevel;
    }

    public void setRequestLightLevel(RequestLightLevel requestLightLevel) {
        this.requestLightLevel = requestLightLevel;
    }

    public SafeLightBot getSafeLightBot() {
        return SafeLightBot;
    }

    public void setSafeLightBot(SafeLightBot SafeLightBot) {
        this.SafeLightBot = SafeLightBot;
    }

    @Override
    public String toString() {
        return "AnswerOnRequest{" +
                "id=" + id +
                ", measuredLightLevel=" + measuredLightLevel +
                ", answerTime='" + answerTime + '\'' +
                ", answerStatus='" + answerStatus + '\'' +
                ", requestLightLevel=" + requestLightLevel +
                ", safeLightBot=" + SafeLightBot +
                '}';
    }
}
