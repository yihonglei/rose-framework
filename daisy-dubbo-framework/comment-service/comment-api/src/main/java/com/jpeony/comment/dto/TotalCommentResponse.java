package com.jpeony.comment.dto;

import com.jpeony.commons.core.AbstractResponse;
import lombok.Data;

@Data
public class TotalCommentResponse extends AbstractResponse {

    private long total;
    
}