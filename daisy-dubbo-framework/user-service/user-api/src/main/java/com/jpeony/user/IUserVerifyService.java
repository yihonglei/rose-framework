package com.jpeony.user;

import com.jpeony.user.dto.UserVerifyRequest;
import com.jpeony.user.dto.UserVerifyResponse;

public interface IUserVerifyService {
    
    /**
     * 激活邮件
     */
    UserVerifyResponse verifyMemer(UserVerifyRequest userVerifyRequest);
}
