package com.org.Movie_Ticket_Booking.repository;

import com.org.Movie_Ticket_Booking.dto.respone.UpgradeRqResponse;
import com.org.Movie_Ticket_Booking.entity.UpgradeRequest;
import com.org.Movie_Ticket_Booking.entity.enums.UpgradeRequestStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UpgradeRequestRepository extends JpaRepository<UpgradeRequest, Long> {
    Optional<UpgradeRequest> findByUser_IdAndCinemaNameAndAddress(Long userID, String name, String address);
    Optional<UpgradeRequest> findByCinemaNameAndAddress(String name, String address);

    @Query("""
       select new com.org.Movie_Ticket_Booking.dto.respone.UpgradeRqResponse(
           ur.id, u.name, u.email, ur.updatedAt, ur.status)
       from UpgradeRequest ur join ur.user u
       """)
    Page<UpgradeRqResponse> findAllRequest(Pageable pageable);

    @Query(""" 
            select new com.org.Movie_Ticket_Booking.dto.respone.UpgradeRqResponse(
            ur.id, u.name, u.email, ur.updatedAt, ur.status) 
            from UpgradeRequest ur join ur.user u 
            where (:status is null or ur.status = :status)
            """)
    Page<UpgradeRqResponse> findAllRequest(@Param("status") UpgradeRequestStatus status, Pageable pageable);

    @Query("""
            select new com.org.Movie_Ticket_Booking.dto.respone.UpgradeRqResponse(
            ur.id, u.name, u.email, ur.updatedAt, ur.cinemaName, ur.address, ur.description, ur.status)
            from UpgradeRequest ur join ur.user u
            where ur.id = :id
            """)
    UpgradeRqResponse findDetailById(Long id);
}
