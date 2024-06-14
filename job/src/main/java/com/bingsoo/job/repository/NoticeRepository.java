package com.bingsoo.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{
    public List<Notice> fingAllbyResiever(Member resiever);
}
