package org.gaaclubmanagementsystem.model;

import jakarta.persistence.*;

@Entity
public class AboutPage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String heading;
    @Column(length = 5000)
    private String paragraph1;
    @Column(length = 5000)
    private String paragraph2;

    public AboutPage(){};

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getParagraph1() {
        return paragraph1;
    }

    public void setParagraph1(String paragraph1) {
        this.paragraph1 = paragraph1;
    }

    public String getParagraph2() {
        return paragraph2;
    }

    public void setParagraph2(String paragraph2) {
        this.paragraph2 = paragraph2;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
