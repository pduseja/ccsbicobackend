package com.ccsbi.co.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.SystemParams;

@Repository
public interface SystemParamsRepo extends JpaRepository<SystemParams, Long> {
	
	@Query("select sp.param1 from systemparams sp where sp.keyVal1=:keyVal1 and sp.keyVal2=:keyVal2 and sp.keyVal3=:keyVal3")
	String getcontactUsDepatment(@Param("keyVal1") String keyVal1,@Param("keyVal2") String keyVal2,@Param("keyVal3") String keyVal3); 

	@Query("select sp.param2 from systemparams sp where sp.keyVal1=:keyVal1 and sp.keyVal2=:keyVal2 and sp.keyVal3=:keyVal3")
	String getcontactUsDepatment1(@Param("keyVal1") String keyVal1,@Param("keyVal2") String keyVal2,@Param("keyVal3") String keyVal3);
	
	@Query("select sp.param3 from systemparams sp where sp.keyVal1=:keyVal1 and sp.keyVal2=:keyVal2 and sp.keyVal3=:keyVal3")
	String getcontactUsDepatment2(@Param("keyVal1") String keyVal1,@Param("keyVal2") String keyVal2,@Param("keyVal3") String keyVal3);
			
	@Query("select sp.param1 from systemparams sp where sp.keyVal1=:keyVal1 and sp.keyVal2=:keyVal2 and sp.keyVal3=:keyVal3 and sp.columnOrderBy=:columnOrderBy")
	String getMsgAboutUs(@Param("keyVal1") String keyVal1,@Param("keyVal2") String keyVal2,@Param("keyVal3") String keyVal3,@Param("columnOrderBy") int columnOrderBy);
	
	@Query("select sp.param2 from systemparams sp where sp.keyVal1=:keyVal1 and sp.keyVal2=:keyVal2 and sp.keyVal3=:keyVal3 and sp.columnOrderBy=:columnOrderBy")
	String getMsgAboutUs1(@Param("keyVal1") String keyVal1,@Param("keyVal2") String keyVal2,@Param("keyVal3") String keyVal3,@Param("columnOrderBy") int columnOrderBy);
	
	@Query("select sp.param3 from systemparams sp where sp.keyVal1=:keyVal1 and sp.keyVal2=:keyVal2 and sp.keyVal3=:keyVal3 and sp.columnOrderBy=:columnOrderBy")
	String getMsgAboutUs2(@Param("keyVal1") String keyVal1,@Param("keyVal2") String keyVal2,@Param("keyVal3") String keyVal3,@Param("columnOrderBy") int columnOrderBy);
	
	@Query("select sp.param1 from systemparams sp where sp.keyVal1=:keyVal1 and sp.keyVal2=:keyVal2 and sp.keyVal3=:keyVal3 and substring(sp.param1,1,1)=:department ")
	String getcontactUsDepatmentValue(@Param("keyVal1") String keyVal1,@Param("keyVal2") String keyVal2,@Param("keyVal3") String keyVal3,@Param("department") String department);
}
