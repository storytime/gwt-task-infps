package org.example.server;


import org.example.model.User;
import org.example.util.UserHelper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Collection;
import java.util.List;


@Path("user")
public class UserResource {

    final List<User> usersDb;

    public UserResource() {
        usersDb = UserHelper.generateUserList(15);
    }


    @GET
    @Produces("application/json")
    public Collection<User> getUsers() {
        return usersDb;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public User getUser(@PathParam("id") Integer id) {
        return usersDb.get(id);
    }
}
