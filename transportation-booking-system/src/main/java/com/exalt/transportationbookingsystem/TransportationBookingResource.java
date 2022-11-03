package com.exalt.transportationbookingsystem;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/transportation-booking-system")
public class TransportationBookingResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, Transportation Application!";
    }
}