package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;
import org.springframework.stereotype.Component;

/**
 * Class StringEnumPersistenceType.
 * 
 * @author excilys
 * 
 * @param <T>
 */
@Component
public class StringEnumPersistenceType<T extends Enum<?>> implements UserType,
		ParameterizedType {
	private static final String DEFAULT_IDENTIFIER_METHOD_NAME = "codeValue";
	private static final String DEFAULT_FROM_VALUE_METHOD_NAME = "fromValue";
	private Method identifierMethod;
	private Method fromValueMethod;
	private Class<?> identifierType;
	private Class<T> enumClass;

	/**
	 * Constructeur par défaut.
	 */
	public StringEnumPersistenceType() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public final void setParameterValues(Properties parameters) {
		String enumClassName = parameters.getProperty("enumClass");
		try {
			enumClass = (Class<T>) Class.forName(enumClassName).asSubclass(
					Enum.class);
		} catch (ClassNotFoundException e) {
			throw new HibernateException("Enum class not found", e);
		}
		String identifierMethodName = parameters.getProperty(
				"identifierMethod", DEFAULT_IDENTIFIER_METHOD_NAME);
		try {
			identifierMethod = enumClass.getMethod(identifierMethodName,
					new Class[0]);
			identifierType = identifierMethod.getReturnType();
		} catch (Exception e) {
			throw new HibernateException("Failed to obtain identifier method. "
					+ "Setting default method name value", e);
		}
		String valueOfMethodName = parameters.getProperty("valueOfMethod",
				DEFAULT_FROM_VALUE_METHOD_NAME);
		try {
			fromValueMethod = enumClass.getMethod(valueOfMethodName,
					new Class[] { identifierType });
		} catch (Exception e) {
			throw new HibernateException("Failed to obtain fromValue method. "
					+ "Setting default method name value", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Object nullSafeGet(ResultSet resultSet, String[] names,
			SessionImplementor session, Object owner) throws SQLException {
		try {
			String propertyValue = resultSet.getString(names[0]);
			return fromValueMethod.invoke(enumClass, propertyValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw new HibernateException(
					"Exception while invoking valueOf method '"
							+ fromValueMethod.getName() + "' of "
							+ "enumeration class '" + enumClass + "'", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void nullSafeSet(PreparedStatement preparedStatement,
			Object value, int index, SessionImplementor session)
			throws SQLException {
		try {
			if (null == value) {
				preparedStatement.setNull(index, Types.VARCHAR);
			} else {
				Object identifier = identifierMethod.invoke(value,
						new Object[0]);
				preparedStatement.setString(index, (String) identifier);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new HibernateException(
					"Exception while invoking identifier method '"
							+ identifierMethod.getName() + "' of "
							+ "enumeration class '" + enumClass + "'", e);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Class<T> returnedClass() {
		return enumClass;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int[] sqlTypes() {
		return new int[] { Types.VARCHAR };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean isMutable() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean equals(Object x, Object y) {
		if (x != y) {
			return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode(Object x) {
		assert (x != null);
		return x.hashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Object deepCopy(Object value) {
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Object replace(Object original, Object target, Object owner) {
		return original;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Serializable disassemble(Object value) {
		return (Serializable) value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Object assemble(Serializable cached, Object owner) {
		return cached;
	}

}
