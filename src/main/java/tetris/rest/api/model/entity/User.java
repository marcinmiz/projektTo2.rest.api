package tetris.rest.api.model.entity;


import javax.persistence.*;
import java.security.Timestamp;
import java.sql.Time;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String login;
    private String password;
    private Integer rankingsPoints;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_At;
    @OneToOne
    private SecurityQuestion question1;
    @OneToOne
    private SecurityQuestion question2;



    private String answer1;
    private String answer2;


    public Integer getRankingsPoints() {
        return rankingsPoints;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRankingsPoints(Integer rankingsPoints) {
        this.rankingsPoints = rankingsPoints;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public SecurityQuestion getQuestion1() {
        return question1;
    }

    public void setQuestion1(SecurityQuestion question1) {
        this.question1 = question1;
    }

    public SecurityQuestion getQuestion2() {
        return question2;
    }

    public void setQuestion2(SecurityQuestion question2) {
        this.question2 = question2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }


    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
