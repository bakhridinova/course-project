package com.epam.uni.repository;

import com.epam.uni.entity.Linen;
import com.epam.uni.util.filter.SearchFilter;

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
    default Predicate<Linen> getPredicate(SearchFilter filter) {
        List<Predicate<Linen>> predicates = new LinkedList<>();
        if (!filter.category().equalsIgnoreCase("s")) {
            predicates.add(linen -> linen.getCategory().toString()
                    .equals(filter.category()));
        }

        if (!filter.material().equalsIgnoreCase("s")) {
            predicates.add(linen -> linen.getMaterial().toString()
                    .equals(filter.material()));
        }

        if (!filter.description().equalsIgnoreCase("s")) {
            predicates.add(linen -> linen.getDescription()
                    .contains(filter.description()));
        }

        return predicates.stream().reduce(x -> true, Predicate::and);
    }
}
