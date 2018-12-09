package ua.com.markovka.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.markovka.model.Client;
import ua.com.markovka.model.ClientDTO;

import javax.persistence.Tuple;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByPhone(String phone);


    @Query(value = "SELECT cl.id, cl.name, cl.phone, cl.status, cl.card, ca_date, ca.comment, vi_date, vi_sum, vi_master from clients cl LEFT JOIN " +
            "(SELECT client_id, Max(date) as ca_date, comment FROM calls GROUP BY client_id) as ca ON ca.client_id=cl.id JOIN " +
            "(SELECT client_id, Max(date) as vi_date, SUM(amount) as vi_sum, master as vi_master FROM visits GROUP BY client_id) AS vi ON vi.client_id=cl.id ORDER BY vi_date DESC", nativeQuery = true)
    List<Object[]> findAllDto();

    @Query(value = "SELECT cl.id, cl.name, cl.phone, cl.status, cl.card, ca_date, ca.comment, vi_date, vi_sum, vi_master from clients cl LEFT JOIN " +
            "(SELECT client_id, Max(date) as ca_date, comment FROM calls GROUP BY client_id) as ca ON ca.client_id=cl.id JOIN " +
            "(SELECT client_id, Max(date) as vi_date, SUM(amount) as vi_sum, master as vi_master FROM visits GROUP BY client_id) AS vi ON vi.client_id=cl.id WHERE cl.status = :status ORDER BY vi_date DESC", nativeQuery = true)
    List<Object[]> findByStatusDto(@Param("status") String status);

//    @Query("SELECT new ua.com.markovka.model.ClientDTO(cl.id, cl.name, cl.phone, cl.status, cl.card, ca_date, ca.comment, vi_date, vi_sum) from Client cl LEFT JOIN (SELECT client_id, date as ca_date, comment as com FROM calls GROUP BY client_id) as ca ON ca.client_id=cl.id JOIN " +
//            "(SELECT client_id, Max(date) as vi_date, SUM(amount) as vi_sum FROM visits GROUP BY client_id) AS vi ON vi.client_id=cl.id")
//    List<ClientDTO> findAllDto();
}


//    @Query("select new myserver.dto.OrderDTO(o.id, u.id, u.name,u.email,p.name,p.os,p.price,o.name, o.address, o.date) from Order o, User u, Phone p, UserOrder uo where u.id = :id and uo.userId = u.id and uo.orderId = o.id and o.phoneId = p.id")
////    Page<OrderDTO> findInUserId(@Param("id") Long id, Pageable pageable);
////
////    @Query("select new myserver.dto.OrderDTO(o.id, u.id, u.name,u.email,p.name,p.os,p.price,o.name, o.address, o.date) from Order o, User u, Phone p, UserOrder uo where uo.userId = u.id and uo.orderId = o.id and o.phoneId = p.id")
////    Page<OrderDTO> findOrders(Pageable pageable);