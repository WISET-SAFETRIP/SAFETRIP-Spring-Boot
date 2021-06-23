package com.strip.safetrip.domain;

import com.strip.safetrip.BooleanTo10Converter;
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
    private Long travel_no;

    @Column(name = "star", nullable = true)
    private float star;

    @Column(name = "ppl_no", nullable = false)
    private int ppl_no = 0;

    @Column(name = "field_no", nullable = false)
    private int field_no;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "inside", nullable = false)
    @Convert(converter = BooleanTo10Converter.class)
    private boolean inside;

    public Long getTravel_no() {
        return travel_no;
    }

    public void setTravel_no(Long travel_no) {
        this.travel_no = travel_no;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public int getPpl_no() {
        return ppl_no;
    }

    public void setPpl_no(int ppl_no) {
        this.ppl_no = ppl_no;
    }

    public int getField_no() {
        return field_no;
    }

    public boolean getInside() {
        return inside;
    }

    public void setInside(boolean inside) {
        this.inside = inside;
    }

    public void setField_no(int field_no) {
        this.field_no = field_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
