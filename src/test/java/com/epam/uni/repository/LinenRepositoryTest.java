package com.epam.uni.repository;

import com.epam.uni.config.TestConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class LinenRepositoryTest {
    @Autowired
    private LinenRepository linenRepository;
}