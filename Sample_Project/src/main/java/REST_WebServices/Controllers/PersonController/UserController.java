package REST_WebServices.Controllers.PersonController;

import Models.Person.DTO.UserDTO;
import REST_WebServices.Services.PersonService.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/user")
public class UserController {
    UserService userService = new UserService();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(UserDTO user){
        try {
            userService.AddUser(user);
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
    public Response updateUser(UserDTO user){
        try{
            String result = userService.UpdateUser(user);
            if (result == "updated"){
                return Response.ok().build();
            }
            else if (result == "not found")
            {
                return Response.status(404,"User not found").build();
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
    public Response deleteUser(@PathParam("id") int id){
        try {
            PersonSoapClient.PersonSoapClientServiceService service = new PersonSoapClient.PersonSoapClientServiceService();//class
            PersonSoapClient.PersonSoapClientService port = service.getPersonSoapClientServicePort();//interface
            String result = port.deleteUserById(id);
            return Response.ok(result).build();
        }
        catch (Exception e)
        {
            return Response.serverError().build();
        }
    }
}
