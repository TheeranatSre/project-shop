package com.project.shop.projectshop.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageInformation {
  private static final long serialVersionUID = 1L;

    private int number;

    private int size;
}
