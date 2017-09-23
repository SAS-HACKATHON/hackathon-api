package com.sofrecom.hackathon.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Generic Class for whole persistent model. Manage optimistic lock with version
 * field, name field and toString() method
 *
 */
@EntityListeners(EntityLastModifiedSetter.class)
@MappedSuperclass
public abstract class GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * last modified date : this field is updated by the EntityLastModifiedSetter
	 * class)
	 */
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastmodified;

	public GenericEntity() {
	}

	/**
	 * introspect all String/Date/int/float/double/boolean getters
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public Date getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified == null ? null : (Date) lastmodified.clone();
	}

}
