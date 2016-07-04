package hyva.singularity.domain.repository;

import hyva.singularity.domain.model.BoxWorld.BoxWorld;
import hyva.singularity.domain.vo.OwnerKey;
import hyva.singularity.utility.ThisIsMock;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author by hyvaa on 2016. 6. 18..
 */
@ThisIsMock
@Repository
public interface BoxWorldRepository {

    void save(BoxWorld... boxWorld);

    BoxWorld findOne(OwnerKey ownerKey);

    List<BoxWorld> findAll();

    void delete(OwnerKey... ownerKey);

}
