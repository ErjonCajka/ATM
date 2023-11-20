package com.ATMproject.ATM.utils;

import org.springframework.data.domain.Sort;
import org.springframework.util.MultiValueMap;

import java.util.List;

public class WebUtils {

    public static Sort buildSortFromRequestParams(MultiValueMap<String, String> params) {
        params.remove("page");
        params.remove("size");
        Sort.Order[] orders = params.entrySet().stream()
                .map(entry -> {
                    String property = entry.getKey();
                    List<String> values = entry.getValue();
                    Sort.Direction direction = Sort.Direction.fromString(values.get(0));
                    return new Sort.Order(direction, property);
                })
                .toArray(Sort.Order[]::new);

        return Sort.by(orders);
    }
}