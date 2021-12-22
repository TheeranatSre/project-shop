package com.project.shop.projectshop.spec.product;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.project.shop.projectshop.model.product.ProductEntity;
import com.project.shop.projectshop.model.product.dto.FilterProductDto;
import com.project.shop.projectshop.utility.StringUtil;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductSpec {
  public Specification<ProductEntity> getSiteSpecificationByFilterDto(FilterProductDto filterProductDto) {
    return (root, query, cb) -> {
      List<Predicate> conditions = new LinkedList<>();

      conditions.add(cb.equal(root.get("isDeleted"), false));
      conditions = addConditionNameContains(root, conditions, cb, filterProductDto);

      query.distinct(true);
      return cb.and(conditions.toArray(new Predicate[conditions.size()]));
    };
  }

  private List<Predicate> addConditionNameContains(Root<ProductEntity> root, List<Predicate> conditions,
      CriteriaBuilder cb, FilterProductDto filterProductDto) {
    if (!StringUtil.isNullOrEmpty(filterProductDto.getName())) {
      conditions.add(cb.like(root.get("name"), "%" + filterProductDto.getName() + "%"));
    }
    return conditions;
  }
}
