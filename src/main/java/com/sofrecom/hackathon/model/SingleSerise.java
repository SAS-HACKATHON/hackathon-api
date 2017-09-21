package com.sofrecom.hackathon.model;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import javax.persistence.*;
import io.swagger.annotations.ApiModelProperty;

@Data
public class SingleSerise  {
    private String name;
    private BigDecimal value;

    public SingleSerise( String name, BigDecimal value){
        this.name  = name;
        this.value = value;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
    
    
}
