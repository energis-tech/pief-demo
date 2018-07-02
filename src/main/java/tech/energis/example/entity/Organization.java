/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.energis.example.entity;

import tech.energis.pief.ImplementedEntity;

/**
 *
 * @author pokvalitov
 */
public class Organization
        extends ImplementedEntity<OrganizationImpl>
        implements OrganizationEntity
{
    protected String shortName;
    protected String fullName;
    protected String taxId;

    @Override
    public String getShortName()
    {
        return shortName;
    }

    @Override
    public String getFullName()
    {
        return fullName;
    }

    @Override
    public String getTaxId()
    {
        return taxId;
    }
    
    @Override
    public String toString()
    {
        return String.format( "Организация (%s)", getShortName() );
    }

    public Organization( OrganizationImpl impl, String shortName, String fullName, String taxId )
    {
        super( impl );
        this.shortName = shortName;
        this.fullName = fullName;
        this.taxId = taxId;
    }

    public Organization( OrganizationImpl impl )
    {
        super( impl );
    }
    
    @Override
    public void rename( String newShortName, String newFullName )
    {
        impl().rename( this, newShortName, newFullName );
    }
}
