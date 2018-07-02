package tech.energis.example.entity;

import java.util.Collection;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;
import tech.energis.pief.ImplBatisOneEntity;

/**
 *
 * @author pokvalitov
 */
public class OrganizationImplBatis
        extends ImplBatisOneEntity<OrganizationMapperBatis, Organization>
        implements OrganizationFinder, OrganizationImpl
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

    public OrganizationImplBatis()
    {
        super( OrganizationMapperBatis.class );
    }

    public OrganizationImplBatis( SqlSession sqlSession )
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

/*
    @Override
    public Collection<? super OrganizationEntity> findAllPresentable()
    {
        final Supplier<List<?>> selector = () -> getMapper().findAll();
        final Function<Organization, ? super OrganizationEntity> decorator = 
                (o) -> { return new OrganizationPresentingTaxId( new OrganizationPesentingName(o) ); };
        return selectList(selector, decorator );
    }
*/
}
