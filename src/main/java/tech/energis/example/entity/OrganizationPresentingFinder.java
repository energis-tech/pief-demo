/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.energis.example.entity;

import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author pokvalitov
 */
public interface OrganizationPresentingFinder
{
    Collection<Organization> findAll();
    Optional<Organization> findByTaxId( String taxId );
    Organization findObjectByTaxId( String taxId );

    Collection<OrganizationDecorator> findAllPresentable();
    Optional<OrganizationDecorator> findPresentableByTaxId( String taxId );
    OrganizationDecorator findPresentableObjectByTaxId( String taxId );
}
