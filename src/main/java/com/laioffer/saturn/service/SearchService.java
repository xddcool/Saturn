package com.laioffer.saturn.service;
//import

import java.time.LocalDate;


public class SearchService {
    //declare fields
    //constructors
    public List<Stay> search(int guestNumber, LocalDate checkinDate, LocalDate checkoutDate, double lat, double lon, String distance) {
        //corner case check

        //main logic

        for (Long stayId : stayIds) {
            if (!reservedStayIds.contains(stayId)) {
                filteredStayIds.add(stayId);
            }
        }
        return list;
    }
}
