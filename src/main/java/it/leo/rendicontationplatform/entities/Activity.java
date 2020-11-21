package it.leo.rendicontationplatform.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "activity", schema = "rendicontation")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "title", nullable = true, length = 50)
    private String title;

    @Basic
    @Column(name = "description", nullable = true, length = 500)
    private String description;

    @Basic
    @Column(name = "date", nullable = true)
    @JsonFormat(pattern="ddMMyyyy")
    private Date date;

    @Basic
    @Column(name = "quantity_leo", nullable = true)
    private int quantityLeo;

    @Basic
    @Column(name = "lions_participation", nullable = true)
    private boolean lionsParticipation;

    @ManyToOne
    @JoinColumn(name = "satisfaction_degree")
    private SatisfactionDegree satisfactionDegree;

    @Version
    @Column(name = "version", nullable = false)
    @JsonIgnore
    private long version;

    @ManyToOne
    @JoinColumn(name = "city")
    private City city;

    @ManyToOne
    @JoinColumn(name = "club")
    private Club club;

    @ManyToMany
    @JoinTable(name = "r_type_activity", joinColumns = @JoinColumn(name = "type_activity"), inverseJoinColumns = @JoinColumn(name = "activity"))
    private Set<TypeActivity> typesActivity;


}
