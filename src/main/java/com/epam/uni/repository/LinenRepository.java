package com.epam.uni.repository;

import com.epam.uni.entity.Linen;
import com.epam.uni.filter.SearchFilter;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * repository for handling CRUD operations on linens
 *
 * @author bakhridinova
 */

public interface LinenRepository extends BaseRepository<Linen> {
    @Override
    List<Linen> findAll();

    @Override
    Linen findById(Long id);

    @Override
    List<Linen> findByCategory(Enum<?> category);

    @Override
    List<Linen> findByFilter(SearchFilter filter);

    @Override
    default Predicate<Linen> getPredicate(SearchFilter filter) {
        List<Predicate<Linen>> predicates = new LinkedList<>();
        if (!filter.category().equals("skip".toUpperCase())) {
            predicates.add(linen -> linen.getCategory().name()
                    .equals(filter.category()));
        }

        if (!filter.material().equals("skip".toUpperCase())) {
            predicates.add(linen -> linen.getMaterial().name()
                    .equals(filter.material()));
        }

        if (filter.description() != null) {
            predicates.add(linen -> linen.getDescription()
                    .contains(filter.description()));
        }

        return predicates.stream().reduce(x -> true, Predicate::and);
    }
}
