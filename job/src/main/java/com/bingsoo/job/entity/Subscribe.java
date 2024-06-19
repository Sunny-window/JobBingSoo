package com.bingsoo.job.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Subscribe {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long subs_code;

	    @ManyToOne
	    @JoinColumn(name = "cid")
	    private Member cid;

	    @ManyToOne
	    @JoinColumn(name = "rid")
	    private Member rid;

	    public void setPostCode(Posting posting) {
	    	
	    	
	    }
	}