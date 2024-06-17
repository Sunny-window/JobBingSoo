package com.bingsoo.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingsoo.job.entity.Member;
import com.bingsoo.job.entity.Posting;
import com.bingsoo.job.entity.Posting_skill;
import com.bingsoo.job.repository.PostingRepository;
import com.bingsoo.job.repository.Posting_skillRepository;

@Service
public class PostingService {
	@Autowired
    private PostingRepository postingRepository;
	
	@Autowired
    private Posting_skillRepository postingSkillRepository;

    public List<Posting> getPostingsByCid(Member cid) {
        return postingRepository.findByCid(cid);
    }

	public List<Posting_skill> getSkillsByPostCode(long post_code) {
		return postingSkillRepository.findByPostCode(post_code);
	}
}
