package com.registrationsaga.registrationservice.domain.common;

import org.springframework.data.domain.Persistable;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.io.Serializable;
import java.util.Date;

public interface Entity<K extends Serializable> extends Persistable<K>
{
	@Override
	@Nonnull
	K getId();

	@Nullable
	Date getInsertTime();

	@Nullable
	Date getUpdateTime();

	/**
	 * Indicates that the object has already been persisted before.
	 * @return true, if the object has been persisted before, otherwise false
	 */
	boolean isPersistent();

}
