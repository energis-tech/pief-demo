/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.energis.example.exe;

import java.util.Collection;
import java.util.Optional;
import tech.energis.example.entity.Organization;

/**
 *
 * @author pokvalitov
 */
public interface OrganizationService
{
    Collection<Organization> findAllOrganizations();
    Optional<Organization> findOrganizationByTaxId( String taxId );
    Organization findOrganizationObjectByTaxId( String taxId );

/*
    Collection<? super DecoratedOrganization> findAllOrganizationsEx();
*/
}
