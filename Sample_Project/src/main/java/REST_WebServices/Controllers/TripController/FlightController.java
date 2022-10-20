package REST_WebServices.Controllers.TripController;

import Models.Trip.DTO.FlightDTO;
import REST_WebServices.Services.TripService.FlightService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/flight")
public class FlightController {
    FlightService flightService = new FlightService();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFlight(FlightDTO flight){
        try {
            flightService.AddFlight(flight);
            return Response.ok().build();
        }
        catch (Exception e)
        {
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateFlight(FlightDTO flight){
        try{
            String result = flightService.UpdateFlight(flight);
            if (result == "updated"){
                return Response.ok().build();
            }
            else if (result == "not found")
            {
                return Response.status(404,"Flight not found").build();
            }
        }
        catch (Exception e){
            return Response.serverError().build();
        }
        return null;
    }


    //Calling soap client at this method
    @DELETE
    @Path("/delete/{id}")
    public Response deleteFlight(@PathParam("id") int id){
        try {
            TripSoapClient.TripSoapClientServiceService service = new TripSoapClient.TripSoapClientServiceService();//class
            TripSoapClient.TripSoapClientService port = service.getTripSoapClientServicePort();//interface
            String result = port.deleteFlightById(id);
            return Response.ok(result).build();
        }
        catch (Exception e)
        {
            return Response.serverError().build();
        }
    }
}
