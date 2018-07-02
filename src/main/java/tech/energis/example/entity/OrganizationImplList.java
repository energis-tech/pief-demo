/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.energis.example.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author pokvalitov
 */
public class OrganizationImplList implements OrganizationFinder, OrganizationImpl
{
    private Organization[] organizations =
    {
        new Organization( this, "СРО-19", "Ассоциация «Союз «Энергоэффективность»", "6675375312" ),
        new Organization( this, "ИнЭС", "Институт энергосбережения",                "6685296374" ),
        new Organization( this, "НПП УРМА", "АО НПП «УралМеталлургАвтоматика»",     "6657439542" ),
    };

    @Override
    public Collection<Organization> findAll()
    {
        return Arrays.asList( organizations );
    }

    @Override
    public Optional<Organization> findByTaxId( String taxId )
    {
        return Arrays.asList( organizations ).stream()
                .filter( org -> org.taxId.equals( taxId ) )
                .findAny();
    }

    @Override
    public Organization findObjectByTaxId( String taxId )
    {
        return findByTaxId( taxId ).orElse( null );
    }

    @Override
    public Organization rename( Organization organization, String newShortName, String newFullName )
    {
        organization.shortName = newShortName;
        organization.fullName = newFullName;
        return organization;
    }

/*
    @Override
    public Collection<? super OrganizationEntity> findAllPresentable()
    {
        return new ArrayList<>(0);                
    }
*/
}
