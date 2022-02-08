package com.example.amq.service;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.example.amq.domain.dto.UserDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	@Transactional
	public void save(UserDTO userDTO) {

		logger.info(userDTO.toString());
	}
}