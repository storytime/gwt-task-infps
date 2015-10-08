package org.example.api;

import org.example.model.User;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/api/user")
public interface UserClient extends RestService {
	
	@GET
	void getUsers(MethodCallback<List<User>> callback);
	
	@GET
	@Path("/{id}")
	void getUser(@PathParam("id") Integer id, MethodCallback<User> callback);
}
