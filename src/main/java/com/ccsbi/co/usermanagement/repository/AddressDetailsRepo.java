package com.ccsbi.co.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.AddressDetails;

@Repository
public interface AddressDetailsRepo extends JpaRepository<AddressDetails, Long> {
	
	@Modifying
	@Query("update addressdetails ad set ad.flatNo=:flatNo, ad.houseName=:houseName,ad.addressLine1=:addressLine1,"
			+ "ad.addressLine2=:addressLine2,ad.addressLine3=:addressLine3,ad.cityTown=:cityTown,ad.stateProvince=:stateProvince,"
			+ "ad.country=:country,ad.pinPostCode=:pinPostCode,ad.type=:type,ad.active=:active,ad.mobile=:mobile,"
			+ "ad.landline=:landline,ad.email=:email where ad.users.userId=:userid")
	int update(@Param("flatNo") String flatNo,@Param("houseName") String houseName,@Param("addressLine1") String addressLine1,
			@Param("addressLine2") String addressLine2,@Param("addressLine3") String addressLine3,@Param("cityTown") String cityTown,
			@Param("stateProvince") String stateProvince,@Param("country") String country,@Param("pinPostCode") String pinPostCode,
			@Param("type") String type,@Param("active") String active,@Param("mobile") String mobile,@Param("landline") String landline,
			@Param("email") String email,@Param("userid") int userid);
	
	@Query("select ad from addressdetails ad where ad.users.userId=:userid")
	List<AddressDetails> getAddressDetailsList(@Param("userid") int userid);
	
}
