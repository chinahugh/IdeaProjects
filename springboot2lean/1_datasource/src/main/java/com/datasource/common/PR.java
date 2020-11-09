package com.datasource.common;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PR<T,ID> extends PagingAndSortingRepository<T,ID> {
}
