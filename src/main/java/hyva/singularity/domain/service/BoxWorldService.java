package hyva.singularity.domain.service;

import hyva.singularity.domain.model.BoxWorld.BoxWorld;
import hyva.singularity.domain.repository.BoxWorldRepository;
import hyva.singularity.domain.vo.OwnerKey;
import hyva.singularity.exception.BaseRequesterException;
import hyva.singularity.utility.ForTest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by hyvaa on 2016. 6. 18..
 */
@Service
public class BoxWorldService {

    @Resource
    private BoxWorldRepository boxWorldRepository;

    public void create(OwnerKey ownerKey, BoxWorld boxWorld) {
        BoxWorld boxWorld0 = boxWorldRepository.findOne(ownerKey);
        if (null != boxWorld0) {
            throw new BaseRequesterException("This Owner already has the BoxWorld.");
        }
        boxWorldRepository.save(boxWorld);
    }

    public BoxWorld get(OwnerKey ownerKey) {
        if (null == ownerKey) {
            throw new BaseRequesterException("Invalid OwnerKey.");
        }
        return boxWorldRepository.findOne(ownerKey);
    }

    @ForTest
    public List<BoxWorld> getAllWorld() {
        return boxWorldRepository.findAll();
    }

    @ForTest
    public void delete(OwnerKey ownerKey) {
        boxWorldRepository.delete(ownerKey);
    }

}
