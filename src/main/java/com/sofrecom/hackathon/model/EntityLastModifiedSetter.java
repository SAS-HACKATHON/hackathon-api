package com.sofrecom.hackathon.model;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * GenericEntity Class Listener. Sets the lastModified field upon persist and update operations
 * 
 */
public class EntityLastModifiedSetter {
	

	@PrePersist
	public void beforeNewEntity(GenericEntity genericEntity) {
		
		genericEntity.lastmodified = new Date();
	}

	@PreUpdate
	public void beforeUpdateEntity(GenericEntity genericEntity) {
		
		genericEntity.lastmodified = new Date();
	}

}
