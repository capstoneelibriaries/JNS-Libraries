package capstone.elibraries.repositories;

import capstone.elibraries.models.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface Addresses extends CrudRepository<Address, Long> {

    @Modifying
    @Query("Update Address a " +
            "SET a.billing=:billing, " +
            "a.city=:city, " +
            "a.country=:country, " +
            "a.state=:state, " +
            "a.streetAddr=:streetAddr, " +
            "a.subAddr=:subAddr " +
            "WHERE a.id=:id")
    public void updateById(@Param("id") Long id,
                            @Param("billing") boolean billing,
                            @Param("city") String city,
                            @Param("country") String country,
                            @Param("state") String state,
                            @Param("streetAddr") String streetAddr,
                            @Param("subAddr") String subAddr);

}

