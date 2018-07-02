/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.energis.example.exe;

import java.util.Collection;
import java.util.Optional;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.energis.example.entity.Organization;
import tech.energis.example.entity.OrganizationFinder;

/**
 *
 * @author pokvalitov
 */
public class OrganizationServiceImplSpring implements OrganizationService
{
    private Logger log = LoggerFactory.getLogger( getClass() );
    
    @Setter
    private OrganizationFinder organizationFinder;

    @Override
    public Collection<Organization> findAllOrganizations()
    {
        log.debug( "Select all" );
        return organizationFinder.findAll();
    }

    @Override
    public Optional<Organization> findOrganizationByTaxId( String taxId )
    {
        return organizationFinder.findByTaxId( taxId );
    }

    @Override
    public Organization findOrganizationObjectByTaxId( String taxId )
    {
        return organizationFinder.findObjectByTaxId( taxId );
    }

/*
    @Override
    public Collection<? super DecoratedOrganization> findAllOrganizationsEx()
    {
        return organizationFinder.findAllPresentable();
    }
*/
}
