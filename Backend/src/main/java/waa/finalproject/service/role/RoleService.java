package waa.finalproject.service.role;

import waa.finalproject.domain.Role;

public interface RoleService {

    Iterable<Role> getAllRoles();

    Role getRoleByName(String name);

}
