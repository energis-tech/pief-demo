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
public class OrganizationDbDto
{
    protected final String taxId;
    protected final String shortName;
    protected final String fullName;

    public OrganizationDbDto( String taxId, String shortName, String fullName )
    {
        this.shortName = shortName;
        this.fullName = fullName;
        this.taxId = taxId;
    }

    public String getShortName()
    {
        return shortName;
    }

    public String getFullName()
    {
        return fullName;
    }

    public String getTaxId()
    {
        return taxId;
    }

    
}
