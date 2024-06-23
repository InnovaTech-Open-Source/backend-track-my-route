package pe.upc.trackmyroute.iam.interfaces.rest.transform;

import pe.upc.trackmyroute.iam.domain.model.aggregates.User;
import pe.upc.trackmyroute.iam.domain.model.entities.Role;
import pe.upc.trackmyroute.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity){
        var roles = entity.getRoles().stream().map(role -> Role.getStringFromRole(role)).toList();
        return new UserResource(entity.getUsername(), roles);
    }
}
