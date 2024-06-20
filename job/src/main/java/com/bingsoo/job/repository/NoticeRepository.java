package com.bingsoo.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findAllByReciever(Member reciever);

	List<Notice> findBySender(Member user);

	List<Notice> findByReciever(Member user);

	@Query(value="DELETE FROM notice WHERE reciever = :rec",nativeQuery = true)
	void deleteAllMyNotice (@Param("rec") String rec);
}
