package com.bingsoo.job.repository;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bingsoo.job.dto.RedBeanDto;
import com.bingsoo.job.entity.Application;
import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Posting;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByPostCode(Posting postCode);

    @Query(value = "SELECT r.name, r.address, r.birth, r.gender, a.result, a.app_code " +
        "FROM Application a " +
        "JOIN red_bean r ON r.rid = a.rid " +
        "WHERE a.post_code = :postcode", nativeQuery = true)
    List<Object[]> RedBeanByRid(@Param("postcode") Long postcode);

    default List<RedBeanDto> findRedBeanByRid(Long postcode){

        List<Object[]> db_result_list = RedBeanByRid(postcode);
        List<RedBeanDto> dtos = new ArrayList<>();

        for(Object[] db_result : db_result_list){

            RedBeanDto dto = new RedBeanDto();
            
            dto.setName((String) db_result[0]);
            dto.setAddress((String) db_result[1]);
            dto.setBirth((Date) db_result[2]);
            dto.setGender((String) db_result[3]);
            dto.setResult((String) db_result[4]);
            dto.setApp_code((Long) db_result[5]);

            dtos.add(dto);
        }
        
        return dtos;
    }

	

	List<Application> findByRid(Member member);

}

