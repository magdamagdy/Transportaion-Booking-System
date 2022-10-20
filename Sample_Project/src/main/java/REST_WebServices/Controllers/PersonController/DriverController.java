package REST_WebServices.Controllers.PersonController;

import Models.Person.DTO.DriverDTO;
import REST_WebServices.Services.PersonService.DriverService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/driver")
public class DriverController {
    DriverService driverService = new DriverService();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDriver(DriverDTO driver){
        try {
            driverService.AddDriver(driver);
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
    public Response updateDriver(DriverDTO driver){
        try{
            String result = driverService.UpdateDriver(driver);
            if (result == "updated"){
                return Response.ok().build();
            }
            else if (result == "not found")
            {
                return Response.status(404,"Driver not found").build();
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
    public Response deleteDriver(@PathParam("id") int id){
        try {
            PersonSoapClient.PersonSoapClientServiceService service = new PersonSoapClient.PersonSoapClientServiceService();//class
            PersonSoapClient.PersonSoapClientService port = service.getPersonSoapClientServicePort();//interface
            String result = port.deletDriverById(id);
            return Response.ok(result).build();
        }
        catch (Exception e)
        {
            return Response.serverError().build();
        }
    }

}
