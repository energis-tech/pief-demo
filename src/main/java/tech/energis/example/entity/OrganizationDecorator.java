/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.energis.example.entity;

import tech.energis.pief.EntityDecorator;

/**
 *
 * @author pokvalitov
 */
public class OrganizationDecorator
        extends EntityDecorator<Organization, OrganizationImpl>
        implements OrganizationEntity
{
    public OrganizationDecorator( Organization original )
    {
        super( original );
    }

    public OrganizationDecorator( OrganizationDecorator original )
    {
        super( original );
    }
    
    protected OrganizationEntity decoratedEntity()
    {
        return (OrganizationEntity) super.decorated();
    }
    
    @Override
    public String getShortName()
    {
        return decoratedEntity().getShortName();
    }

    @Override
    public String getFullName()
    {
        return decoratedEntity().getFullName();
    }

    @Override
    public String getTaxId()
    {
        return decoratedEntity().getTaxId();
    }
    
    @Override
    public String toString()
    {
        return decorated().toString();
    }

    @Override
    public void rename( String newShortName, String newFullName )
    {
        ((OrganizationEntity) decorated() ).rename( newShortName, newFullName );
    }
}
