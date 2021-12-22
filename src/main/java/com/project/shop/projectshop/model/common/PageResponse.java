package com.project.shop.projectshop.model.common;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class PageResponse<T> {
    private PageInformation pageInformation;

    private boolean first;

    private boolean last;

    private int totalPages;

    private long totalElement;

    private long sequence = new Date().getTime();

    private List<T> entities;

    public static <T> PageResponse<T> create(Page<T> page, List<T> entities, Long totalElement) {
        PageResponse<T> pageResponse = new PageResponse<>();

        pageResponse.setPageInformation(new PageInformation(page.getNumber() + 1, page.getSize()));
        pageResponse.totalPages = page.getTotalPages();
        pageResponse.entities = entities;
        pageResponse.first = page.isFirst();
        pageResponse.last = page.isLast();
        pageResponse.totalElement = totalElement;

        return pageResponse;
    }
}
