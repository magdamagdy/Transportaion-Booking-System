package REST_WebServices.Controllers.VehicleController;

import Models.Vehicle.DTO.BusDTO;
import REST_WebServices.Services.VehicleService.BusService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/bus")
public class BusController {

    BusService busService = new BusService();
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
//    @JsonIgnoreProperties(ignoreUnknown = true)
    public Response addBus(BusDTO bus){
        try {
            busService.AddBus(bus);
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
    public Response updateBus(BusDTO bus){
        try{
            String result = busService.UpdateBus(bus);
            if (result == "updated"){
                return Response.ok().build();
            }
            else if (result == "not found")
            {
                return Response.status(404,"Bus not found").build();
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
    public Response deleteBus(@PathParam("id") int id){
        try {
            VehicleSoapClient.VehicleSoapClientServiceService service = new VehicleSoapClient.VehicleSoapClientServiceService();//class
            VehicleSoapClient.VehicleSoapClientService port = service.getVehicleSoapClientServicePort();//interface
            String result = port.deleteBusById(id);
                return Response.ok(result).build();
        }
        catch (Exception e)
        {
            return Response.serverError().build();
        }
    }

}
