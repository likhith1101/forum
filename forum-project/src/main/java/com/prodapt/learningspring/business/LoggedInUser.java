package com.prodapt.learningspring.business;

import org.springframework.stereotype.Component;

import com.prodapt.learningspring.entity.User;

import lombok.Data;

@Data
public class LoggedInUser {
    private User loggedInUser;
}
