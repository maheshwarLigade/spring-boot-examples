package com.techwasti.crud.postgresdemo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.EnumType;

public class PgSQLEnumType extends EnumType{

    public void nullSafeSet(
        PreparedStatement ps, Object value, int index,
        SharedSessionContractImplementor session
    ) throws HibernateException, SQLException{

        ps.setObject(index,value!=null? ((Enum)value).name():null,Types.OTHER);
    }
    
}
