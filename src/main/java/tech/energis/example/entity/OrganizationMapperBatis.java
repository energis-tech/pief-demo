/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.energis.example.entity;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author pokvalitov
 */
public interface OrganizationMapperBatis
{
    List<OrganizationDbDto> findAll();
    OrganizationDbDto findById( @Param("taxId") String taxId );
}
