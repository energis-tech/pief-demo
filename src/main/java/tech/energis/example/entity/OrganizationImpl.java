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
public interface OrganizationImpl
{
    Organization rename( Organization organization, String newShortName, String newFullName );
}
