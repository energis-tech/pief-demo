package tech.energis.example.entity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.ibatis.session.SqlSession;
import tech.energis.pief.ImplBatisOneEntityDecorated;

/**
 *
 * @author pokvalitov
 */
public class OrganizationPresentingImplBatis
        extends ImplBatisOneEntityDecorated<OrganizationMapperBatis, Organization>
        implements OrganizationPresentingFinder, OrganizationImpl
{

    @Override
    public Collection<Organization> findAll()
    {
        return selectList( () -> getMapper().findAll() );
    }

    @Override
    public Optional<Organization> findByTaxId( String taxId )
    {
        return selectOptional( () -> getMapper().findById( taxId ) );
    }

    @Override
    public Organization findObjectByTaxId( String taxId )
    {
        return selectEntity( () -> getMapper().findById( taxId ) );
    }

    @Override
    public Organization rename( Organization organization, String newShortName, String newFullName )
    {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    public OrganizationPresentingImplBatis()
    {
        super( OrganizationMapperBatis.class );
    }

    public OrganizationPresentingImplBatis( SqlSession sqlSession )
    {
        super( OrganizationMapperBatis.class, sqlSession );
    }

    @Override
    protected Organization newEntityInstance()
    {
        return new Organization( this );
    }
    
    @Override
    protected void refreshEntityFromDto( Organization entity, Object dbDto )
    {
        OrganizationDbDto dto = (OrganizationDbDto) dbDto;
        entity.shortName = dto.getShortName();
        entity.fullName = dto.getFullName();
        entity.taxId = dto.getTaxId();
    }

    @Override
    public Collection<OrganizationDecorator> findAllPresentable()
    {
        final Supplier<List<?>> selector = () -> getMapper().findAll();
        
        /// final Function<Organization, OrganizationPesentingName> decorator;
        /// decorator = (o) -> { return new OrganizationPesentingName( o ); };
        /// List<OrganizationPesentingName> selectList = selectList( selector, decorator );
        List<OrganizationDecorator> selectList = selectList( selector, PRESENTING_DECORATOR );
        return selectList;
    }

    @Override
    public Optional<OrganizationDecorator> findPresentableByTaxId( String taxId )
    {
        return selectOptional( () -> getMapper().findById( taxId ), PRESENTING_DECORATOR );
    }

    @Override
    public OrganizationDecorator findPresentableObjectByTaxId( String taxId )
    {
        return selectEntity( () -> getMapper().findById( taxId ), PRESENTING_DECORATOR );
    }

    /// final Function<Organization, OrganizationPesentingName> decorator;
    /// decorator = (o) -> { return new OrganizationPesentingName( o ); };
    /// final Function<Organization, OrganizationPesentingName> PRESENTING_NAME_DECORATOR = OrganizationPesentingName::new;
    final Function<Organization, OrganizationDecorator> PRESENTING_NAME_DECORATOR = OrganizationPesentingName::new;
    final Function<Organization, OrganizationDecorator> PRESENTING_TAXID_DECORATOR = OrganizationPresentingTaxId::new;

    final Function<Organization, OrganizationDecorator> PRESENTING_FULL_DECORATOR =
            (o) -> { return new OrganizationPresentingTaxId( new OrganizationPesentingName(o) ); };

    final Function<Organization, OrganizationDecorator> PRESENTING_DECORATOR = PRESENTING_FULL_DECORATOR;
}
