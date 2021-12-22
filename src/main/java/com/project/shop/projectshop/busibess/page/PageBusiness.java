package com.project.shop.projectshop.busibess.page;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PageBusiness {
    public <T> Page<T> getPageResponse(
            List<T> lists, Pageable pageable) {
        long totalElement = lists.size();
        long offSet = pageable.getOffset();
        long toIndex = (pageable.getOffset() + pageable.getPageSize() > lists.size())
                ? lists.size()
                : pageable.getOffset() + pageable.getPageSize();
        if (offSet > toIndex) {
            offSet = lists.size();
        }
        return new PageImpl<>(lists.subList((int) offSet, (int) toIndex), pageable, totalElement);
    }
}