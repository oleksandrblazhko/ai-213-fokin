package com.example.blazkolab9.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SafeLightBot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private float measuredLightLevel;
    private String provideRecommendation;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<User> user;

    public String checkLight(String requestor, String location) {
        String result = "";
        int lightQualityIndex = 7;

        if (location.length() > 20 || !requestor.matches("^[a-zA-Z\\s]+$") || requestor.isBlank()) {
            result = "Помилка авторизації";
        } else {
            result = "The city of Miami today has excellent light quality. " +
                    "Index of Light Quality today is " + airQualityIndex;
        }
        return result;
    }



    public SafeLightBot() {
    }

    public SafeLightBot(float measuredLightLevel, String provideRecommendation, List<User> user) {
        this.measuredLightLevel = measuredLightLevel;
        this.provideRecommendation = provideRecommendation;
        this.user = user;
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

    public String getProvideRecommendation() {
        return provideRecommendation;
    }

    public void setProvideRecommendation(String provideRecommendation) {
        this.provideRecommendation = provideRecommendation;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SafeLightBot{" +
                "id=" + id +
                ", measuredLightLevel=" + measuredLightLevel +
                ", provideRecommendation='" + provideRecommendation + '\'' +
                ", user=" + user +
                '}';
    }
}
