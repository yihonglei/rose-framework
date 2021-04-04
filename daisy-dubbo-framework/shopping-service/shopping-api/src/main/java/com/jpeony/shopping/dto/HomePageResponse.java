package com.jpeony.shopping.dto;

import com.jpeony.commons.core.AbstractResponse;
import lombok.Data;

import java.util.Set;

@Data
public class HomePageResponse extends AbstractResponse {

    private Set<PanelDto> panelContentItemDtos;
}