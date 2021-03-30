package com.jpeony.user.dto;

import com.jpeony.commons.core.AbstractRequest;
import com.jpeony.commons.tool.exception.ValidateException;
import com.jpeony.user.constants.SysRetCodeConstants;
import lombok.Data;

@Data
public class DeleteAddressRequest extends AbstractRequest {
    private Long addressId;

    @Override
    public void requestCheck() {
        if(addressId==null) {
            throw new ValidateException(
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getCode(),
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}
