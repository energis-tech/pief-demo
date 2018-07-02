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
import tech.energis.example.entity.OrganizationDecorator;
import tech.energis.example.entity.OrganizationPresentingFinder;

/**
 *
 * @author pokvalitov
 */
public class OrganizationServiceExImplSpring implements OrganizationServiceEx
{
    private Logger log = LoggerFactory.getLogger( getClass() );
    
    @Setter
    private OrganizationPresentingFinder organizationPresentingFinder;

    @Override
    public Collection<Organization> findAllOrganizations()
    {
        log.debug( "Select all" );
        return organizationPresentingFinder.findAll();
    }

    @Override
    public Optional<Organization> findOrganizationByTaxId( String taxId )
    {
        return organizationPresentingFinder.findByTaxId( taxId );
    }

    @Override
    public Organization findOrganizationObjectByTaxId( String taxId )
    {
        return organizationPresentingFinder.findObjectByTaxId( taxId );
    }

    @Override
    public Collection<OrganizationDecorator> findAllPresentable()
    {
        return organizationPresentingFinder.findAllPresentable();
    }

    @Override
    public Optional<OrganizationDecorator> findPresentableOrganizationByTaxId( String taxId )
    {
        return organizationPresentingFinder.findPresentableByTaxId( taxId );
    }

    @Override
    public OrganizationDecorator findPresentableOrganizationObjectByTaxId( String taxId )
    {
        return organizationPresentingFinder.findPresentableObjectByTaxId( taxId );
    }
}
