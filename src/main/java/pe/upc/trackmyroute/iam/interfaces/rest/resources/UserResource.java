package pe.upc.trackmyroute.iam.interfaces.rest.resources;

import pe.upc.trackmyroute.iam.domain.model.valueobjects.Roles;

import java.util.List;

public record UserResource(String username, List<String> roles) {
}
