package testorder.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import testorder.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "foods", path = "foods")
public interface FoodRepository
    extends PagingAndSortingRepository<Food, Long> {}
