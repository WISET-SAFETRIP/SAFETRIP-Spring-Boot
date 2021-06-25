package com.strip.safetrip.domain;

import com.strip.safetrip.BooleanTo10Converter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Travel")
@Getter
@Setter
public class Travel {
    public Travel() {}

    @Id
    private Long travelNo;

    @Column(name = "star", nullable = true)
    private float star;

    @Column(name = "ppl_no", nullable = false)
    private int pplNo = 0;

    @Column(name = "field_no", nullable = false)
    private int fieldNo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "inside", nullable = false)
    @Convert(converter = BooleanTo10Converter.class)
    private boolean inside;

    @Column(name = "content_type_id", nullable = false)
    private int contentTypeId;

    public Long getTravelNo() {
        return travelNo;
    }

    public void setTravelNo(Long travelNo) {
        this.travelNo = travelNo;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public int getPplNo() {
        return pplNo;
    }

    public void setPplNo(int pplNo) {
        this.pplNo = pplNo;
    }

    public int getFieldNo() {
        return fieldNo;
    }

    public boolean getInside() {
        return inside;
    }

    public void setInside(boolean inside) {
        this.inside = inside;
    }

    public void setField_no(int fieldNo) {
        this.fieldNo = fieldNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(int contentTypeId) {
        this.contentTypeId = contentTypeId;
    }
}
