package com.spring.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.aop.aspectj.AspectJAdviceParameterNameDiscoverer.AmbiguousBindingException;
import org.springframework.jdbc.core.RowMapper;
import com.spring.model.Ambulance;
import com.spring.model.AmbulanceProvider;
 
public class AmbulanceProviderRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		AmbulanceProvider provider = new AmbulanceProvider();
		provider.setProviderId((Integer.parseInt(rs.getString("PROVIDERID").toString())));
		provider.setProviderName(rs.getString("PROVIDERNAME"));
		return provider;
	}
 
}