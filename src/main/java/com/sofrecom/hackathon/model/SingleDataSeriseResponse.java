//This is a common http response model for providing data series

package com.sofrecom.hackathon.model;

import lombok.*;
import java.util.*;

@Data
@EqualsAndHashCode(callSuper=false)
public class SingleDataSeriseResponse extends OperationResponse {
    private List<SingleSerise> items;

	public List<SingleSerise> getItems() {
		return items;
	}

	public void setItems(List<SingleSerise> items) {
		this.items = items;
	}
    
    
}
