package com.strip.safetrip.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Travel")
@Table(name = "travel", uniqueConstraints =
        {@UniqueConstraint(name = "NO_UNIQUE", columnNames = {"travel_no"})})
@Getter
@Setter
public class Travel {
    public Travel() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long travel_no;

    @Column(name = "star", nullable = true)
    private float star;

    @Column(name = "ppl_no", nullable = false)
    private int ppl_no;

    @Column(name = "field_no", nullable = false)
    private int field_no;

    private String name;

}
