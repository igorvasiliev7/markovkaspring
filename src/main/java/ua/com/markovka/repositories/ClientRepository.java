package ua.com.markovka.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.markovka.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
}

//    @Query("select new myserver.dto.OrderDTO(o.id, u.id, u.name,u.email,p.name,p.os,p.price,o.name, o.address, o.date) from Order o, User u, Phone p, UserOrder uo where u.id = :id and uo.userId = u.id and uo.orderId = o.id and o.phoneId = p.id")
//    Page<OrderDTO> findInUserId(@Param("id") Long id, Pageable pageable);
//
//    @Query("select new myserver.dto.OrderDTO(o.id, u.id, u.name,u.email,p.name,p.os,p.price,o.name, o.address, o.date) from Order o, User u, Phone p, UserOrder uo where uo.userId = u.id and uo.orderId = o.id and o.phoneId = p.id")
//    Page<OrderDTO> findOrders(Pageable pageable);
