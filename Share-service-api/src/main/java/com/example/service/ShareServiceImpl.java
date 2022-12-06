package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Share;
import com.example.persistence.ShareDao;

@Service
public class ShareServiceImpl implements ShareService {
    
	@Autowired
	private ShareDao shareDao;

	@Override
	public Share searchShareById(int shareId) {
		
		return shareDao.findById(shareId).orElse(null);
	}
}
