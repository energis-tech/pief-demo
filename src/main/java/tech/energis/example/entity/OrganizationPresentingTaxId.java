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
public class OrganizationPresentingTaxId
        extends OrganizationDecorator
        implements OrganizationEntity
{
    public OrganizationPresentingTaxId( Organization original )
    {
        super( original );
    }

    public OrganizationPresentingTaxId( OrganizationDecorator original )
    {
        super( original );
    }
    
    @Override
    public String toString()
    {
        return String.format( "%s, ИНН %s", super.toString(), getTaxId() );
    }
}
