package com.epam.uni.controller;

import com.epam.uni.service.LinenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * controller for handling dish related inputs
 *
 * @author bakhridinova
 */

@Controller
@RequiredArgsConstructor
public class LinenController {
    private final LinenService linenService;
}
