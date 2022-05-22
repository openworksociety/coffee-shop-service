package app.coffee.service.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import app.coffee.service.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

	@Query("SELECT o FROM Order o WHERE o.createdDate >= :fromDate and o.createdDate<=:toDate")
	List<Order> findAllBetweenDates(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

}
