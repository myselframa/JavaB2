package com.fmg.blog.service;

import com.fmg.blog.payloads.LoginDto;
import com.fmg.blog.payloads.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    
    String register(RegisterDto registerDto);

}
