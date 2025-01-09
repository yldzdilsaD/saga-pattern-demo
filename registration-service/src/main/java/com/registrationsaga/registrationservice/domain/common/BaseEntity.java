package com.registrationsaga.registrationservice.domain.common;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;

import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class BaseEntity implements Entity<UUID>, Serializable
{
	@Serial
	private static final long serialVersionUID = 1L;

	@Nonnull
	@Id
	@Column(name = "SID", unique = true, nullable = false, updatable = false, columnDefinition = "uuid")
	@EqualsAndHashCode.Include
	@JdbcTypeCode(SqlTypes.UUID) // JDBC'nin UUID türünü doğru işlemesi için
	private UUID id;

	@Column(name = "INSERT_TIME")
	@CreatedDate
	private Date insertTime;

	@Column(name = "UPDATE_TIME")
	@LastModifiedDate
	private Date updateTime;

	protected BaseEntity()
	{
		id = UUID.randomUUID();
	}

	public String getIdValue()
	{
		return id.toString();
	}

	@Override
	public boolean isPersistent()
	{
		return getInsertTime() != null;
	}

	@Override
	public boolean isNew()
	{
		return !isPersistent();
	}
}
