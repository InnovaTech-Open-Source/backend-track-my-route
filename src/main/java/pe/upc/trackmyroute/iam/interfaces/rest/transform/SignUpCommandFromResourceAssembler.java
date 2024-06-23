package pe.upc.trackmyroute.iam.interfaces.rest.transform;

import pe.upc.trackmyroute.iam.domain.model.commands.SignUpCommand;
import pe.upc.trackmyroute.iam.domain.model.entities.Role;
import pe.upc.trackmyroute.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {

    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles().stream().map(name -> Role.getRoleFromName(name)).toList();
        return new SignUpCommand(resource.username(), resource.password(), roles);
    }
}
