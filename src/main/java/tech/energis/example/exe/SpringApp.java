/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.energis.example.exe;

import java.util.Collection;
import java.util.Optional;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.energis.example.entity.Organization;
import tech.energis.example.entity.OrganizationDecorator;

public final class SpringApp
{
    private static final String CONTEXT_CONFIG_FILE = "applicationContext.xml";
    private static final String ORGANIZATION_SERVICE_BEAN_ID = "organizationService";
    private static final String ORGANIZATION_SERVICE_EX_BEAN_ID = "organizationServiceEx";

    private static ApplicationContext ctx;
    private static OrganizationService organizationService;
    private static OrganizationServiceEx organizationServiceEx;

    public static void main( String[] args )
    {
        ctx = new ClassPathXmlApplicationContext( CONTEXT_CONFIG_FILE );
        organizationService = getOrganizationService();
        organizationServiceEx = getOrganizationServiceEx();
        
        /// processOrganizations();
        processOrganizationsEx();
    }

    // =========================
    // =  processOrganizations
    // =========================

    private static void processOrganizationsEx()
    {
        selectOrganizationsEx();
        selectSingleOrganizationEx( "7722636278" );
        selectSingleOrganizationEx( "0001010101" );
        selectSingleOrganizationExAsObject( "7722636278" );
        selectSingleOrganizationExAsObject( "0001010101" );
    }
    
    /*
    private static void presentOrganizations()
    {
        Collection<? super DecoratedOrganization> organizations;
        organizations = organizationService.findAllOrganizationsEx();
        System.out.format( "Total: %d\n", organizations.size() );
        organizations.forEach( System.out::println );
    }
    */

    private static void selectOrganizationsEx()
    {
        /*
        Collection<Organization> organizations;
        organizations = organizationServiceEx.findAllOrganizations();
        System.out.format( "Total: %d\n", organizations.size() );
        organizations.forEach( SpringApp::printOrganization );
         */
        Collection<OrganizationDecorator> organizations;
        organizations = organizationServiceEx.findAllPresentable();
        System.out.format( "Total: %d\n", organizations.size() );
        organizations.forEach( o -> System.out.println(o) );
    }

    private static void selectSingleOrganizationEx( String taxId )
    {
        Optional<OrganizationDecorator> found = organizationServiceEx.findPresentableOrganizationByTaxId( taxId );
        String format;
        if ( found.isPresent() )
            format = found.get().toString();
        else
            format = String.format( "Организация с ИНН %s не найдена", taxId );
        System.out.println( format );
        }

    private static void selectSingleOrganizationExAsObject( String taxId )
    {
        OrganizationDecorator found = organizationServiceEx.findPresentableOrganizationObjectByTaxId( taxId );
        String format;
        if ( found == null )
            format = String.format( "Организация с ИНН %s не найдена, сущность не создана", taxId );
        else
            format = String.format( "Создана сущность для организации: %s", found.toString() );
        System.out.println( format );
    }

    // =========================


    /* ///
    // =========================
    // =  processOrganizations
    // =========================

    private static void processOrganizations()
    {
        selectOrganizations();
        selectSingleOrganization( "7722636278" );
        selectSingleOrganization( "0001010101" );
        selectSingleOrganizationAsObject( "7722636278" );
        selectSingleOrganizationAsObject( "0001010101" );
    }
    
    private static void selectOrganizations()
    {
        Collection<Organization> organizations;
        organizations = organizationService.findAllOrganizations();
        System.out.format( "Total: %d\n", organizations.size() );
        organizations.forEach( SpringApp::printOrganization );
    }

    private static void selectSingleOrganization( String taxId )
    {
        Optional<Organization> found = organizationService.findOrganizationByTaxId( taxId );
        String format = found.flatMap( SpringApp::formatOptionalOrganization )
                .orElse( String.format( "Организация с ИНН %s не найдена", taxId ));
        System.out.println( format );
        }

    private static void selectSingleOrganizationAsObject( String taxId )
    {
        Organization found = organizationService.findOrganizationObjectByTaxId( taxId );
        String format;
        if ( found == null )
            format = String.format( "Организация с ИНН %s не найдена, сущность не создана", taxId );
        else
            format = String.format( "Создана сущность для организации: %s", formatOrganization( found ));
        System.out.println( format );
    }
    
    // =========================
    */ ///

    private static Optional<String> formatOptionalOrganization( Organization org )
    {
        return Optional.of( formatOrganization( org ));
    }

    private static String formatOrganization( Organization organization )
    {
        return String.format( "%S: %s (%s)",
                        organization.getTaxId(), organization.getShortName(), organization.getFullName()
            );
    }
    
    public static void printOrganization( Organization organization )
    {
        System.out.println( formatOrganization( organization ));
    }
    
    private static OrganizationService getOrganizationService()
    {
        return (OrganizationService) ctx.getBean( ORGANIZATION_SERVICE_BEAN_ID );
    }

    private static OrganizationServiceEx getOrganizationServiceEx()
    {
        return (OrganizationServiceEx) ctx.getBean( ORGANIZATION_SERVICE_EX_BEAN_ID );
    }
}
