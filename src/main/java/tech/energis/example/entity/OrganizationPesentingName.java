/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.energis.example.entity;

/**
 *
 * @author pokvalitov
 */
public class OrganizationPesentingName
        extends OrganizationDecorator
        implements OrganizationEntity
{

    public OrganizationPesentingName( Organization original )
    {
        super( original );
    }

    public OrganizationPesentingName( OrganizationDecorator original )
    {
        super( original );
    }
    
    public String getName()
    {
        return String.format( "%s (%s)", getShortName(), getFullName() );
    }
 
    @Override
    public String toString()
    {
        return getName();
    }
}
