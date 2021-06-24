package com.strip.safetrip.domain;

import com.strip.safetrip.BooleanTo10Converter;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity(name = "Travel")
@Table(name = "travel", uniqueConstraints =
        {@UniqueConstraint(name = "NO_UNIQUE", columnNames = {"travel_no"})})
@Getter
@Setter //여기저기서 엔티티의 값이 변경될수 있음.
public class Travel implements Serializable {

    @Id //primary Key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long travel_no;

    @Column(name = "star")
    private float star;

    @Column(name = "ppl_no", nullable = false)
    private int ppl_no = 0;

    @Column(name = "field_no", nullable = false)
    private int field_no;

    @Column(name = "name", nullable = false) //title
    private String name;

    @Column(name = "inside", nullable = false)
    @Convert(converter = BooleanTo10Converter.class)
    private boolean inside;


//    public Long getTravel_no() {
//        return travel_no;
//    }
//
//    public void setTravel_no(Long travel_no) {
//        this.travel_no = travel_no;
//    }
//
//    public float getStar() {
//        return star;
//    }
//
//    public void setStar(float star) {
//        this.star = star;
//    }
//
//    public int getPpl_no() {
//        return ppl_no;
//    }
//
//    public void setPpl_no(int ppl_no) {
//        this.ppl_no = ppl_no;
//    }
//
//    public int getField_no() {
//        return field_no;
//    }
//
//    public boolean getInside() {
//        return inside;
//    }
//
//    public void setInside(boolean inside) {
//        this.inside = inside;
//    }
//
//    public void setField_no(int field_no) {
//        this.field_no = field_no;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
